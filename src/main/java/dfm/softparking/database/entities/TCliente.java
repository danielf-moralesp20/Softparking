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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@NoArgsConstructor
@ToString(exclude = {"automotores"})
public class TCliente extends TableQuery<TCliente> implements Serializable {	
	private static final long serialVersionUID = -8296175137701161785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_cliente")
	@Getter
	private int idCliente;
	
	@OneToOne(targetEntity = TInfoGeneral.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_info_general", nullable = false, unique = true, referencedColumnName = "PK_info_general")
	@Getter
	@Setter
	@NonNull
	private TInfoGeneral infoGeneral; 
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@Getter
	@Setter
	@NonNull
	private List<TAutomotor> automotores = new ArrayList<TAutomotor>();
	
	public TCliente(TInfoGeneral infoGeneral) {
		this.infoGeneral = infoGeneral;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TCliente> of() {
		return (TableQuery<TCliente>) of(TCliente.class);
	}
}
