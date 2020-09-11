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

@Entity
@Table(name = "clientes")
public class TCliente implements Serializable {	
	private static final long serialVersionUID = -8296175137701161785L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_cliente")
	private int idCliente;
	
	@OneToOne(targetEntity = TInfoGeneral.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_info_general", nullable = false, unique = true, 
				referencedColumnName = "PK_info_general")
	private TInfoGeneral infoGeneral; 
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
			   fetch = FetchType.LAZY)
	private List<TAutomotor> automotores = new ArrayList<TAutomotor>();
	
	/*
	 * Constructores de clase
	 */
	public TCliente() {}
	
	public TCliente(TInfoGeneral infoGeneral) {
		this.infoGeneral = infoGeneral;
	}
	
	/*
	 * Metodos getter
	 */
	public int getIdCliente() {
		return idCliente;
	}

	public TInfoGeneral getInfoGeneral() {
		return infoGeneral;
	}

	public List<TAutomotor> getAutomotores() {
		return automotores;
	}

	/*
	 * Metodos setter
	 */
	public void setInfoGeneral(TInfoGeneral infoGeneral) {
		this.infoGeneral = infoGeneral;
	}

	public void setAutomotores(List<TAutomotor> automotores) {
		this.automotores = automotores;
	}
	
	/*
	 * Otras funciones
	 */
	public boolean addAutomotor(TAutomotor automotor) {
		return automotores.add(automotor);
	}
	
	public boolean isEmptyAutomotores() {
		return automotores.isEmpty();
	}

	public boolean removeAutomotor(TAutomotor automotor) {
		return automotores.remove(automotor);
	}
}
