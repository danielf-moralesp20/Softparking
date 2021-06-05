package dfm.softparking.database.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_info_general")
@NoArgsConstructor
@ToString(exclude = {"operario", "cliente"})
public class TInfoGeneral extends TableQuery<TInfoGeneral> implements Serializable {
	public enum TipoDocumento {
		CEDULA_CIUDADANIA,
		CEDULA_EXTRANJERIA
	}
	
	private static final long serialVersionUID = 226101105000684811L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter 
	private int id;
	
	@Column(length = 30, nullable = false)
	@Getter
	@Setter
	@NonNull
	private String nombre;
	
	@Column(length = 30, nullable = false)
	@Getter
	@Setter
	@NonNull
	private String apellido;
	
	@Column(name = "cod_tipo_documento", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	@Getter
	@Setter
	private TipoDocumento tipoDocumento;
	
	@Column(name = "numero_documento", nullable = false, unique = true)
	@Getter
	@Setter
	@NonNull
	private	Long numeroDocumento;
	
	@Column
	@Getter
	@Setter
	private Long celular;
	
	@Column(length = 40)
	@Getter
	@Setter
	private String direccion;
	
	@Column(length = 70, nullable = false, unique = true)
	@Getter
	@Setter
	@NonNull
	private String correo;
	
	@Column(name = "url_foto")
	@Getter
	@Setter
	private String urlFoto;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToOne(mappedBy = "infoGeneral", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@Getter
	@Setter
	@NonNull
	private TCliente cliente;
	
	@OneToOne(mappedBy = "infoGeneral", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	@Getter
	@Setter
	@NonNull
	private TOperario operario;
	
	public TInfoGeneral(String nombre, String apellido, TipoDocumento tipoDocumento, Long numeroDocumento, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.correo = correo;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TInfoGeneral> of() {
		return (TableQuery<TInfoGeneral>) of(TInfoGeneral.class);
	}
}
