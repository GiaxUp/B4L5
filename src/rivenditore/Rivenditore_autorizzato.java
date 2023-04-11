package rivenditore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Rivenditore_autorizzato.findAll", query = "SELECT a FROM Rivenditore_autorizzato a")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Rivenditore_autorizzato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Rivenditore_autorizzato() {
		super();

	}

	@Override
	public String toString() {
		return "Rivenditore_autorizzato [id=" + id + "]";
	}
	

}
