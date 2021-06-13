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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dfm.softparking.database.entities.TAutomotor.TipoVehiculo;
import com.dfm.softparking.database.utils.TableQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_tarifa")
@NoArgsConstructor
@ToString(exclude = {"tipoVehiculos"})
public class TTarifa extends TableQuery<TTarifa> implements Serializable {
	private static final long serialVersionUID = -1277817548266165623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter
	private int id;
	
	@Column(name = "cod_tipo_vehiculo", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@Getter 
	@Setter 
	private TipoVehiculo tipoVehiculo;
	
	@Column(name = "valor_fraccion", nullable = false)
	@Getter
	@Setter
	private float valorFraccion;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "tarifa", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@Getter
	@Setter
	@NonNull
	private List<TTipoVehiculo> tipoVehiculos = new ArrayList<TTipoVehiculo>();
	
	public TTarifa(TipoVehiculo tipoVehiculo, float valorFraccion) {
		this.tipoVehiculo = tipoVehiculo;
		this.valorFraccion = valorFraccion;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TTarifa> of() {
		return (TableQuery<TTarifa>) of(TTarifa.class);
	}
}
