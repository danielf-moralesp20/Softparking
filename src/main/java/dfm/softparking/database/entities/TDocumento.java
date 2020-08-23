package dfm.softparking.database.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class TDocumento {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_documento")
	private int idDocumento;

	@Column(name = "cod_tipo_documento", nullable = false)
	private int codTipoDocumento;
	
	@Column(name = "numero_documento", nullable = false, unique = true)
	private	Long numeroDocumento;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "documento", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private List<TInfoGeneral> infoGenerales = new ArrayList<TInfoGeneral>();
	
	/*
	 * Constructores de clase
	 */
	public TDocumento() {}
	
	public TDocumento(int codTipoDocumento, Long numeroDocumento) {
		this.codTipoDocumento = codTipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	/*
	 * Metodos getter
	 */
	public int getIdDocumento() {
		return idDocumento;
	}
	
	public int getCodTipoDocumento() {
		return codTipoDocumento;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public List<TInfoGeneral> getInfoGenerales() {
		return infoGenerales;
	}

	/*
	 * Metodos setter
	 */
	public void setCodTipoDocumento(int codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setInfoGenerales(List<TInfoGeneral> infoGenerales) {
		this.infoGenerales = infoGenerales;
	}
	
	/*
	 * Otras funciones
	 */
	public boolean addInfoGeneral(TInfoGeneral infoGeneral) {
		return this.infoGenerales.add(infoGeneral);
	}
	
	public boolean isEmptyInfoGenerales() {
		return this.infoGenerales.isEmpty();
	}

	public boolean removeInfoGeneral(TInfoGeneral infoGeneral) {
		return this.infoGenerales.remove(infoGeneral);
	}
}
