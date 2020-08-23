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
@Table(name = "infos_generales")
public class TInfoGeneral {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_info_general")
	private int idInfoGeneral;
	
	@Column(length = 30, nullable = false)
	private String nombre;
	
	@Column(length = 30, nullable = false)
	private String apellido;
	
	@OneToOne(targetEntity = TDocumento.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(nullable = false, name = "FK_documento", referencedColumnName = "PK_documento")
	private TDocumento documento;
	
	@Column()
	private Long celular;
	
	@Column(length = 40)
	private String direccion;
	
	@Column(length = 70, nullable = false, unique = true)
	private String correo;
	
	@Column(name = "ruta_foto")
	private String rutaFoto;
	
	/*
	 * Inicio de relaciones mapeadas
	 */
	@OneToOne(mappedBy = "infoGeneral", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private TCliente cliente;
	
	@OneToOne(mappedBy = "infoGeneral", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private TOperario operario;
	
	/*
	 * Constructores
	 */
	public TInfoGeneral() {}
	
	public TInfoGeneral(String nombre, String apellido, TDocumento documento, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.correo = correo;
	}

	/*
	 * Metodos getters
	 */
	public int getIdInfoGeneral() {
		return idInfoGeneral;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public TDocumento getDocumento() {
		return documento;
	}

	public Long getCelular() {
		return celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public TCliente getCliente() {
		return cliente;
	}

	public TOperario getOperario() {
		return operario;
	}

	/*
	 * Metodos setters
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDocumento(TDocumento documento) {
		this.documento = documento;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	public void setCliente(TCliente cliente) {
		this.cliente = cliente;
	}

	public void setOperario(TOperario operario) {
		this.operario = operario;
	}	
}
