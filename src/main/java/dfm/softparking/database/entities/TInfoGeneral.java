package dfm.softparking.database.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "infos_generales")
@NoArgsConstructor
@ToString(callSuper = true)
public class TInfoGeneral implements Serializable {
	private static final long serialVersionUID = 226101105000684811L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_info_general")
	@Getter 
	private int idInfoGeneral = 3;
	
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
	
	@OneToOne(targetEntity = TDocumento.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(nullable = false, name = "FK_documento", referencedColumnName = "PK_documento")
	@Getter
	@Setter
	@NonNull
	private TDocumento documento;
	
	@Column()
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
	
	@Column(name = "ruta_foto")
	@Getter
	@Setter
	private String rutaFoto;
	
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
	
	public TInfoGeneral(String nombre, String apellido, TDocumento documento, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.correo = correo;
	}
}
