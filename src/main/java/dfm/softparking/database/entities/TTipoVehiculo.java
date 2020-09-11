package dfm.softparking.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_vehiculos")
public class TTipoVehiculo implements Serializable {
	private static final long serialVersionUID = -6786305568497129376L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_tipo_vehiculo")
	private int idTipoVehiculo;
	
	@Column(name = "cod_tipo_vehiculo", unique = true, nullable = false)
	private int codTipoVehiculo;
	
	@ManyToOne(targetEntity = TTarifa.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "FK_tarifa", nullable = false, referencedColumnName = "PK_tarifa")
	private TTarifa tarifa;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "tipoVehiculo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<TAutomotor> automotores = new ArrayList<TAutomotor>();
	
	/*
	 * Constructores de clase
	 */
	public TTipoVehiculo() {}
	
	public TTipoVehiculo(int codTipoVehiculo, TTarifa tarifa) {
		this.codTipoVehiculo = codTipoVehiculo;
		this.tarifa = tarifa;
	}

	/*
	 * Metodos getter
	 */
	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public int getCodTipoVehiculo() {
		return codTipoVehiculo;
	}

	public TTarifa getTarifa() {
		return tarifa;
	}

	public List<TAutomotor> getAutomotores() {
		return automotores;
	}

	/*
	 * Metodos setter
	 */
	public void setCodTipoVehiculo(int codTipoVehiculo) {
		this.codTipoVehiculo = codTipoVehiculo;
	}

	public void setTarifa(TTarifa tarifa) {
		this.tarifa = tarifa;
	}

	public void setAutomotores(List<TAutomotor> automotores) {
		this.automotores = automotores;
	}
	
	/*
	 * Otras funciones
	 */
	public boolean addAutomotor(TAutomotor e) {
		return automotores.add(e);
	}
	
	public boolean isEmptyAutomotores() {
		return automotores.isEmpty();
	}

	public boolean removeAutomotor(TAutomotor automotor) {
		return automotores.remove(automotor);
	}
}
