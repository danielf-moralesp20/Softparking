package dfm.softparking.database.entities;

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

@Entity
@Table(name = "automotores")
public class TAutomotor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_automotor")
	private int idAutomotor;
	
	@ManyToOne(targetEntity = TCliente.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_cliente", referencedColumnName = "PK_cliente")
	private TCliente cliente;
	
	@Column(length = 6, unique = true, nullable = false)
	private String placa;
	
	@ManyToOne(targetEntity = TTipoVehiculo.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_tipo_vehiculo", nullable = false, referencedColumnName = "PK_tipo_vehiculo")
	private TTipoVehiculo tipoVehiculo;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToOne(mappedBy = "automotor", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private TParkingAutomor automotorParking;
	
	@OneToMany(mappedBy = "automotor", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
			   fetch = FetchType.LAZY)
	private List<TTicket> tickets = new ArrayList<TTicket>();
	
	/*
	 * Constructores de clase
	 */
	public TAutomotor() {}
	
	public TAutomotor(TCliente cliente, String placa, TTipoVehiculo tipoVehiculo) {
		this.cliente = cliente;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
	}

	/*
	 * Metodos getter
	 */
	public int getIdAutomotor() {
		return idAutomotor;
	}

	public TCliente getCliente() {
		return cliente;
	}

	public String getPlaca() {
		return placa;
	}

	public TTipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public TParkingAutomor getAutomotorParking() {
		return automotorParking;
	}

	public List<TTicket> getTickets() {
		return tickets;
	}

	/*
	 * Metodos setter
	 */
	public void setCliente(TCliente cliente) {
		this.cliente = cliente;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipoVehiculo(TTipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public void setAutomotorParking(TParkingAutomor automotorParking) {
		this.automotorParking = automotorParking;
	}

	public void setTickets(List<TTicket> tickets) {
		this.tickets = tickets;
	}
	
	/*
	 * Otras funciones
	 */
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
