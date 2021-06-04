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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "parking_automotores")
@NoArgsConstructor
@ToString
public class TParkingAutomor extends TableQuery<TParkingAutomor> implements Serializable {
	private static final long serialVersionUID = -7653667211168471673L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_parking_automotor")
	@Getter
	private int idParkingAutomotor;
	
	@OneToOne(targetEntity = TAutomotor.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_automotor", unique = true, nullable = false, referencedColumnName = "PK_automotor")
	@Getter
	@Setter
	@NonNull
	private TAutomotor automotor;
	
	@Column(name = "fecha_ingreso", nullable = false)
	@Getter
	@Setter
	@NonNull
	private Date fechaIngreso;
	
	public TParkingAutomor(TAutomotor automotor, Date fechaIngreso) {
		this.automotor = automotor;
		this.fechaIngreso = fechaIngreso;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TParkingAutomor> of() {
		return (TableQuery<TParkingAutomor>) of(TParkingAutomor.class);
	}
}
