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

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tipos_vehiculos")
@NoArgsConstructor
@ToString(exclude = {"automotores"})
public class TTipoVehiculo extends TableQuery<TTipoVehiculo> implements Serializable {
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
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TTipoVehiculo> of() {
		return (TableQuery<TTipoVehiculo>) of(TTipoVehiculo.class);
	}
}
