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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tipos_vehiculos")
@NoArgsConstructor
@ToString(callSuper = true)
public class TTipoVehiculo implements Serializable {
	private static final long serialVersionUID = -6786305568497129376L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_tipo_vehiculo")
	@Getter 
	private int idTipoVehiculo;
	
	@Column(name = "cod_tipo_vehiculo", unique = true, nullable = false)
	@Getter 
	@Setter 
	private int codTipoVehiculo;
	
	@ManyToOne(targetEntity = TTarifa.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "FK_tarifa", nullable = false, referencedColumnName = "PK_tarifa")
	@Getter 
	@Setter 
	@NonNull
	private TTarifa tarifa;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "tipoVehiculo", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@Getter 
	@Setter 
	@NonNull
	private List<TAutomotor> automotores = new ArrayList<TAutomotor>();
	
	public TTipoVehiculo(int codTipoVehiculo, TTarifa tarifa) {
		this.codTipoVehiculo = codTipoVehiculo;
		this.tarifa = tarifa;
	}

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
