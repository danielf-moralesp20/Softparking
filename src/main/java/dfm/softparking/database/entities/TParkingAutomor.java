package dfm.softparking.database.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parking_automotores")
public class TParkingAutomor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_parking_automotor")
	private int idParkingAutomotor;
	
	@OneToOne(targetEntity = TAutomotor.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_automotor", unique = true, nullable = false, 
				referencedColumnName = "PK_automotor")
	private TAutomotor automotor;
	
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;
	
	/*
	 * Constructores de clase
	 */
	public TParkingAutomor() { }
	
	public TParkingAutomor(TAutomotor automotor, Date fechaIngreso) {
		this.automotor = automotor;
		this.fechaIngreso = fechaIngreso;
	}

	/*
	 * Metodos getter
	 */
	public int getIdParkingAutomotor() {
		return idParkingAutomotor;
	}

	public TAutomotor getAutomotor() {
		return automotor;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/*
	 * Metodos setter
	 */
	public void setAutomotor(TAutomotor automotor) {
		this.automotor = automotor;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
}
