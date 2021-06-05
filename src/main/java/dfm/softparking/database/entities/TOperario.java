package dfm.softparking.database.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dfm.softparking.database.utils.TableQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_operario")
@NoArgsConstructor
@ToString
@NamedQuery(name = "login", query = "FROM TOperario WHERE infoGeneral.correo = :email AND contrasenia = :pass")
public class TOperario extends TableQuery<TOperario> implements Serializable {
	private static final long serialVersionUID = -7859750218945731026L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@Getter
	private int id;
	
	@OneToOne(targetEntity = TInfoGeneral.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "fk_info_general", nullable = false, unique = true, referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private TInfoGeneral infoGeneral;
	
	@Column(nullable = false)
	@Getter
	@Setter
	@NonNull
	private String contrasenia;
	
	@Column(name = "disabled", nullable = false)
	@Getter
	@Setter
	private boolean isDisabled;
	
	public TOperario(TInfoGeneral infoGeneral, String contrasenia, boolean isDisabled) {
		this.infoGeneral = infoGeneral;
		this.contrasenia = contrasenia;
		this.isDisabled = isDisabled;
	}
	
	@SuppressWarnings("unchecked")
	public static TableQuery<TOperario> of() {
		return (TableQuery<TOperario>) of(TOperario.class);
	}
}
