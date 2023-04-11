package parco_mezzi;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("tram")
@NamedQuery(name = "Tram.findAll", query = "SELECT a FROM Tram a")
public class Tram extends Mezzo implements Serializable {
	
	private Integer capienza = 200;

	public Tram() {		
	}

	public Integer getCapienza() {
		return capienza;
	}

	@Override
	public String toString() {
		return "Tram " + super.toString() + "[capienza=" + capienza + "]";
	}

}
