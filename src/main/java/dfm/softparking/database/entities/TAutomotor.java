package dfm.softparking.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "automotores")
@NoArgsConstructor
@ToString(callSuper = true)
public class TAutomotor implements Serializable {
	private static final long serialVersionUID = 268865280296387192L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_automotor")
	@Getter
	private int idAutomotor;
	
	@ManyToOne(targetEntity = TCliente.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_cliente", referencedColumnName = "PK_cliente")
	@Getter
	@Setter
	@NonNull
	private TCliente cliente;
	
	@Column(length = 6, unique = true, nullable = false)
	@Getter
	@Setter
	@NonNull
	private String placa;
	
	@ManyToOne(targetEntity = TTipoVehiculo.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_tipo_vehiculo", nullable = false, referencedColumnName = "PK_tipo_vehiculo")
	@Getter
	@Setter
	@NonNull
	private TTipoVehiculo tipoVehiculo;
	
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
	
	public TAutomotor(TCliente cliente, String placa, TTipoVehiculo tipoVehiculo) {
		this.cliente = cliente;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

	public boolean addTicket(TTicket ticket) {
		return tickets.add(ticket);
	}
	
	public boolean isEmptyTickets() {
		return tickets.isEmpty();
	}

	public boolean removeTicket(TTicket ticket) {
		return tickets.remove(ticket);
	}
}
