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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@ToString(callSuper = true)
public class TTicket implements Serializable {
	private static final long serialVersionUID = -7397844107084396195L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_ticket")
	@Getter
	private int idTicket;
	
	@Column(name = "fecha_ingreso", nullable = false)
	@Getter
	@Setter
	@NonNull
	private Date fechaIngreso;
	
	@Column(name = "fecha_salida", nullable = false)
	@Getter
	@Setter
	@NonNull
	private Date fechaSalida;
	
	@ManyToOne(targetEntity = TAutomotor.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(nullable = false, name = "FK_automotor", referencedColumnName = "PK_automotor")
	@Getter
	@Setter
	@NonNull
	private TAutomotor automotor;
	
	@Column(name = "valor_total_servicio", nullable = false)
	@Getter
	@Setter
	private float valorTotalServicio;
	
	@Column(length = 300)
	@Getter
	@Setter
	private String comentario;
	
	public TTicket(Date fechaIngreso, Date fechaSalida, TAutomotor automotor, float valorTotalServicio) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.automotor = automotor;
		this.valorTotalServicio = valorTotalServicio;
	}
}