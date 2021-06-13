package com.dfm.softparking.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.dfm.softparking.database.utils.TableQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_automotor")
@NoArgsConstructor
@ToString(exclude = {"automotorParking", "tickets"})
public class TAutomotor extends TableQuery<TAutomotor> implements Serializable {
	public enum TipoVehiculo {
		CARRO,
		MOTOCICLETA
	}
	
	private static final long serialVersionUID = 268865280296387192L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter 
	private int id;
	
	@ManyToOne(targetEntity = TCliente.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "fk_cliente", referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private TCliente cliente;
	
	@Column(length = 6, unique = true, nullable = false)
	@Getter
	@Setter
	@NonNull
	private String placa;
	
	@Column(name = "cod_tipo_vehiculo", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@Getter 
	@Setter 
	private TipoVehiculo tipoVehiculo;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToOne(mappedBy = "automotor", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@Getter
	@Setter
	@NonNull
	private TParkingAutomor automotorParking;
	
	@OneToMany(mappedBy = "automotor", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@Getter
	@Setter
	@NonNull
	private List<TTicket> tickets = new ArrayList<TTicket>();
	
	public TAutomotor(TCliente cliente, String placa, TipoVehiculo tipoVehiculo) {
		this.cliente = cliente;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TAutomotor> of() {
		return (TableQuery<TAutomotor>) of(TAutomotor.class);
	}
}
