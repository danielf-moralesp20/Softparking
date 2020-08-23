package dfm.softparking.database.entities;

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
@Table(name = "operarios")
public class TOperario {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_operario")
	private int idOperario;
	
	@OneToOne(targetEntity = TInfoGeneral.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_info_general", unique = true, referencedColumnName = "PK_info_general")
	private TInfoGeneral infoGeneral;
	
	@Column(nullable = false)
	private String contrasenia;
	
	@Column(name = "is_accesible", nullable = false)
	private boolean isAccesible;

	/*
	 * Constructores de clase
	 */
	public TOperario() {}
	
	public TOperario(TInfoGeneral infoGeneral, String contrasenia, boolean isAccesible) {
		this.infoGeneral = infoGeneral;
		this.contrasenia = contrasenia;
		this.isAccesible = isAccesible;
	}
	
	/*
	 * Metodos getter
	 */
	public int getIdOperario() {
		return idOperario;
	}
	
	public TInfoGeneral getInfoGeneral() {
		return infoGeneral;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public boolean isAccesible() {
		return isAccesible;
	}
	
	/*
	 * Metodos setter
	 */
	public void setInfoGeneral(TInfoGeneral infoGeneral) {
		this.infoGeneral = infoGeneral;
	}

	public void setContrasenia(String contrasenia) throws Exception {
		this.contrasenia = contrasenia;
	}

	public void setAccesible(boolean isAccesible) {
		this.isAccesible = isAccesible;
	}
}
