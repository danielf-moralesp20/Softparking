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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "documentos")
@NoArgsConstructor
@ToString(callSuper = true)
public class TDocumento implements Serializable {
	private static final long serialVersionUID = -7187166201076355055L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_documento")
	@Getter
	private int idDocumento;

	@Column(name = "cod_tipo_documento", nullable = false)
	@Getter
	@Setter
	private int codTipoDocumento;
	
	@Column(name = "numero_documento", nullable = false, unique = true)
	@Getter
	@Setter
	@NonNull
	private	Long numeroDocumento;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToMany(mappedBy = "documento", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@Getter
	@Setter
	@NonNull
	private List<TInfoGeneral> infoGenerales = new ArrayList<TInfoGeneral>();

	public TDocumento(int codTipoDocumento, Long numeroDocumento) {
		this.codTipoDocumento = codTipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

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
