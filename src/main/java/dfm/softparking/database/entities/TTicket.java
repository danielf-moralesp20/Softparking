package dfm.softparking.database.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class TTicket implements Serializable {
	private static final long serialVersionUID = -7397844107084396195L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ticket")
	private int idTicket;
	
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;
	
	@Column(name = "fecha_salida", nullable = false)
	private Date fechaSalida;
	
	@ManyToOne(targetEntity = TAutomotor.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(nullable = false, name = "FK_automotor", referencedColumnName = "PK_automotor")
	private TAutomotor automotor;
	
	@Column(name = "valor_total_servicio", nullable = false)
	private float valorTotalServicio;
	
	@Column(length = 300)
	private String comentario;

	/*
	 * Constructores de clase
	 */
	public TTicket() {}
	
	public TTicket(Date fechaIngreso, Date fechaSalida, TAutomotor automotor, float valorTotalServicio) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.automotor = automotor;
		this.valorTotalServicio = valorTotalServicio;
	}

	/*
	 * Metodos getter
	 */
	public int getIdTicket() {
		return idTicket;
	}
	
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public TAutomotor getAutomotor() {
		return automotor;
	}
	
	public float getValorTotalServicio() {
		return valorTotalServicio;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	/*
	 * Metodos setter
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setAutomotor(TAutomotor automotor) {
		this.automotor = automotor;
	}

	public void setValorTotalServicio(float valorTotalServicio) {
		this.valorTotalServicio = valorTotalServicio;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}	
}