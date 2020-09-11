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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarifas")
public class TTarifa implements Serializable {
	private static final long serialVersionUID = -1277817548266165623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_tarifa")
	private int idTarifa;
	
	@Column(name = "valor_fraccion", nullable = false)
	private float valorFraccion;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "tarifa", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, 
			   fetch = FetchType.LAZY)
	private List<TTipoVehiculo> tipoVehiculos = new ArrayList<TTipoVehiculo>();
	
	/*
	 * Constructores de clase
	 */
	public TTarifa() {}
	
	public TTarifa(float valorFraccion) {
		this.valorFraccion = valorFraccion;
	}

	/*
	 * Metodos getter
	 */
	public int getIdTarifa() {
		return idTarifa;
	}

	public float getValorFraccion() {
		return valorFraccion;
	}

	public List<TTipoVehiculo> getTipoVehiculos() {
		return tipoVehiculos;
	}

	/*
	 * Metodos setter
	 */
	public void setValorFraccion(float valorFraccion) {
		this.valorFraccion = valorFraccion;
	}

	public void setTipoVehiculos(List<TTipoVehiculo> tipoVehiculos) {
		this.tipoVehiculos = tipoVehiculos;
	}
	
	/*
	 * Otras funciones
	 */
	public boolean addTipoVehiculo(TTipoVehiculo tipoVehiculo) {
		return tipoVehiculos.add(tipoVehiculo);
	}
	
	public boolean isEmptyTipoVehiculos() {
		return tipoVehiculos.isEmpty();
	}

	public boolean removeTipoVehiculo(TTipoVehiculo tipoVehiculo) {
		return tipoVehiculos.remove(tipoVehiculo);
	}
}
