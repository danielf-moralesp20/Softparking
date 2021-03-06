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

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_ticket")
@NoArgsConstructor
@ToString
public class TTicket extends TableQuery<TTicket> implements Serializable {
	private static final long serialVersionUID = -7397844107084396195L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter
	private int id;
	
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
	@JoinColumn(nullable = false, name = "fk_automotor", referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private TAutomotor automotor;
	
	@ManyToOne(targetEntity = TTarifa.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(nullable = false, name = "fk_tarifa", referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private TTarifa tarifa;
	
	@Column(name = "valor_total", nullable = false)
	@Getter
	@Setter
	private float valorTotal;
	
	@Column(length = 300)
	@Getter
	@Setter
	private String observaciones;
	
	public TTicket(Date fechaIngreso, Date fechaSalida, TAutomotor automotor, float valorTotal) {
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.automotor = automotor;
		this.valorTotal = valorTotal;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TTicket> of() {
		return (TableQuery<TTicket>) of(TTicket.class);
	}
}