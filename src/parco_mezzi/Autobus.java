package parco_mezzi;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue( "autobus")
@NamedQuery(name = "Autobus.findAll", query = "SELECT a FROM Autobus a")
public class Autobus extends Mezzo implements Serializable {

	private Integer capienza = 100;

	public Autobus() {
	}

	public Integer getCapienza() {
		return capienza;
	}

	@Override
	public String toString() {
		return "Autobus" + super.toString() + " [capienza=" + capienza + "]";
	}

}
