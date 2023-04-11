package tratta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tratta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String zonaPartenza;
	private String capolinea;
	private double mediaTempoPercorrenza;
	private Integer nPercorrenzaTratta;
	

	public Tratta(String zonaPartenza, String capolinea, Integer nPercorrenzaTratta) {
		super();
		this.zonaPartenza = zonaPartenza;
		this.capolinea = capolinea;
		this.nPercorrenzaTratta = nPercorrenzaTratta;
	}

	public Tratta() {

	}

	//getters e setters
	
	public String getZonaPartenza() {
		return zonaPartenza;
	}

	public void setZonaPartenza(String zonaPartenza) {
		this.zonaPartenza = zonaPartenza;
	}
	public String getCapolinea() {
		return capolinea;
	}
	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}

	public double getMediaTempoPercorrenza() {
		return mediaTempoPercorrenza;
	}

	public void setMediaTempoPercorrenza(double mediaTempoPercorrenza) {
		this.mediaTempoPercorrenza = mediaTempoPercorrenza;
	}
	public Integer getnPercorrenzaTratta() {
		return nPercorrenzaTratta;
	}
	public void setnPercorrenzaTratta(Integer nPercorrenzaTratta) {
		this.nPercorrenzaTratta = nPercorrenzaTratta;
	}

	@Override
	public String toString() {
		return "Tratta [id=" + id + ", zonaPartenza=" + zonaPartenza + ", capolinea=" + capolinea
				+ ", mediaTempoPercorrenza=" + mediaTempoPercorrenza + ", nPercorrenzaTratta=" + nPercorrenzaTratta
				+ "]";
	}
	



}
