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
@Table(name = "operarios")
@NoArgsConstructor
@ToString(callSuper = true)
public class TOperario implements Serializable {
	private static final long serialVersionUID = -7859750218945731026L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_operario")
	@Getter
	private int idOperario;
	
	@OneToOne(targetEntity = TInfoGeneral.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "FK_info_general", nullable = false, unique = true, referencedColumnName = "PK_info_general")
	@Getter
	@Setter
	@NonNull
	private TInfoGeneral infoGeneral;
	
	@Column(nullable = false)
	@Getter
	@Setter
	@NonNull
	private String contrasenia;
	
	@Column(name = "is_accesible", nullable = false)
	@Getter
	@Setter
	private boolean isAccesible;
	
	public TOperario(TInfoGeneral infoGeneral, String contrasenia, boolean isAccesible) {
		this.infoGeneral = infoGeneral;
		this.contrasenia = contrasenia;
		this.isAccesible = isAccesible;
	}
}
