package biglietto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import parco_mezzi.Mezzo;
import rivenditore.Rivenditore_autorizzato;
import utente.Utente;

@Entity
@NamedQuery(name = "Biglietto.findAll", query = "SELECT a FROM Biglietto a")
public class Biglietto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Rivenditore_autorizzato rivenditore;
	private LocalDate data_emissione;
	private boolean bigliettoVidimato = false;
	@ManyToOne
	private Mezzo mezzo;

	public Biglietto() {

	}

	public Integer getId() {
		return id;
	}

	public Rivenditore_autorizzato getRivenditore() {
		return rivenditore;
	}

	public void setRivenditore(Rivenditore_autorizzato rivenditore) {
		this.rivenditore = rivenditore;
	}

	public LocalDate getData_emissione() {
		return data_emissione;
	}

	public void setData_emissione(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}

	public Mezzo getMezzo() {
		return mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public void setVidimato(boolean vidimato) {
		this.bigliettoVidimato = vidimato;
	}

	public Boolean getVidimato() {
		return bigliettoVidimato;
	}

	@Override
	public String toString() {
		return "Biglietto [id=" + id + ", rivenditore=" + rivenditore
				+ ", data_emissione=" + data_emissione + ", bigliettoVidimato=" + bigliettoVidimato + ", mezzo=" + mezzo
				+ "]";
	}

}