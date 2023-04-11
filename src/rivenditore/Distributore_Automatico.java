package rivenditore;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Distributore_Automatico.findAll", query = "SELECT a FROM Distributore_Automatico a")
public class Distributore_Automatico extends Rivenditore_autorizzato implements Serializable {
	private boolean fuori_servizio;

	public boolean isFuori_servizio() {
		return fuori_servizio;
	}

	public void setFuori_servizio(boolean fuori_servizio) {
		this.fuori_servizio = fuori_servizio;
	}

	public Distributore_Automatico() {
		super();
	}

	@Override
	public String toString() {
		return "Distributore_Automatico [fuori_servizio=" + fuori_servizio + "]";
	}

}
