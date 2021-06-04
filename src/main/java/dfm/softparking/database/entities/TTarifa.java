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

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tarifas")
@NoArgsConstructor
@ToString(exclude = {"tipoVehiculos"})
public class TTarifa extends TableQuery<TTarifa> implements Serializable {
	private static final long serialVersionUID = -1277817548266165623L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_tarifa")
	@Getter
	private int idTarifa;
	
	@Column(name = "valor_fraccion", nullable = false)
	@Getter
	@Setter
	private float valorFraccion;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "tarifa", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@Getter
	@Setter
	@NonNull
	private List<TTipoVehiculo> tipoVehiculos = new ArrayList<TTipoVehiculo>();
	
	public TTarifa(float valorFraccion) {
		this.valorFraccion = valorFraccion;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TTarifa> of() {
		return (TableQuery<TTarifa>) of(TTarifa.class);
	}
}
