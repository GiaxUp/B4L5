package parco_mezzi;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import biglietto.Biglietto;
import tratta.Tratta;
import utils.JpaUtil;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "Mezzi.findAll", query = "SELECT a FROM Mezzo a")
@DiscriminatorColumn(name = "Mezzi")

public abstract class Mezzo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean inServizio = true;
	private int periodo_servizio;
	private int periodo_manutenzione;
	private LocalDate inizio_manutenzione;
	private LocalDate fine_manutenzione;
	private LocalDate inizio_servizio;
	private LocalDate fine_servizio;

	@ManyToOne
	private Tratta tratta;

	// costruttore vuoto
	public Mezzo() {
	}

	// metodi tratta/mezzo

	public void setTratta(Tratta tra) {
		this.tratta = tra;
	}

	public Tratta getTratta() {
		return tratta;
	}

	// getters e setters

//	public Biglietto getBiglietto() {
//		return biglietto;
//	}
//
//	public void setBiglietto(Biglietto biglietto) {
//		this.biglietto = biglietto;
//	}

	public Boolean getInServizio() {
		return inServizio;
	}

	public LocalDate getInizio_manutenzione() {
		return inizio_manutenzione;
	}

	public void setInServizio(Boolean inServizio) {
		this.inServizio = inServizio;
	}

	public void setPeriodo_servizio(int periodo_servizio) {
		this.periodo_servizio = periodo_servizio;
	}

	public void setPeriodo_manutenzione(int periodo_manutenzione) {
		this.periodo_manutenzione = periodo_manutenzione;
	}

	public void setInizio_manutenzione(LocalDate inizio_manutenzione) {
		this.inizio_manutenzione = inizio_manutenzione;
	}

	public void setFine_manutenzione(LocalDate fine_manutenzione) {
		this.fine_manutenzione = fine_manutenzione;
	}

	public void setInizio_servizio(LocalDate inizio_servizio) {
		this.inizio_servizio = inizio_servizio;
	}

	public void setFine_servizio(LocalDate fine_servizio) {
		this.fine_servizio = fine_servizio;
	}

	public LocalDate getFine_manutenzione() {
		return fine_manutenzione;
	}

	public LocalDate getInizio_servizio() {
		return inizio_servizio;
	}

	public LocalDate getFine_servizio() {
		return fine_servizio;
	}

	public Long getId() {
		return id;
	}

	public Boolean getServizio() {
		return inServizio;
	}

//	public int getNumeroBigliettiVidimati() {
//		return numeroBigliettiVidimati;
//	}
//
//	public void setNumeroBigliettiVidimati(int numeroBigliettiVidimati) {
//		this.numeroBigliettiVidimati = numeroBigliettiVidimati;
//	}

	// cambio stato del servizio (in servizio - manutenzione)
	public void setServizio(Boolean servizio) {
		this.inServizio = servizio;
		// registro il giorno in cui entra in manutenzione
		registroDataManutenzione(servizio);
		// registro il giorno in cui entra in servizio
		registroDataServizio(servizio);
	}

	public int getPeriodo_servizio() {
		return periodo_servizio;
	}

	public int getPeriodo_manutenzione() {
		return periodo_manutenzione;
	}

	public void registroDataManutenzione(Boolean statServ) {
		LocalDate today;
		// ritorna in servizio
		if (statServ == false) {
			this.inizio_manutenzione = today = LocalDate.now(); // <--- data attuale
			// ritorna in manutenzione
		} else if (statServ == true) {
			this.fine_manutenzione = today = LocalDate.now(); // <--- data attuale
		}
	}

	public void registroDataServizio(Boolean statServ) {
		LocalDate today;
		// ritorna in servizio
		if (statServ == true) {
			this.inizio_servizio = today = LocalDate.now(); // <--- data attuale
			// ritorna in manutenzione
		} else if (statServ == false) {
			this.fine_servizio = today = LocalDate.now(); // <--- data attuale
		}
	}

	public void setPeriodoServizio(int p) {
		this.periodo_servizio = p;
	}

	public void setPeriodoManutenzione(int p) {
		this.periodo_manutenzione = p;
	}

	public void vidimaBiglietto(Biglietto b, Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

		b.setVidimato(!b.getVidimato());
		// m.getId();
		System.out.println(m);
		System.out.println(b);
		b.setMezzo(m);
		System.out.println("Biglietto vidimato");
		em.getTransaction().begin();
		em.merge(b);
		em.getTransaction().commit();
		// IncContatoreBiglietti();
	}

//	public void IncContatoreBiglietti() {
//		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//
//		this.numeroBigliettiVidimati++;
//		em.getTransaction().begin();
//		em.merge(this);
//		em.getTransaction().commit();
//	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", inServizio=" + inServizio + ", periodo_servizio=" + periodo_servizio
				+ ", periodo_manutenzione=" + periodo_manutenzione + ", inizio_manutenzione=" + inizio_manutenzione
				+ ", fine_manutenzione=" + fine_manutenzione + ", inizio_servizio=" + inizio_servizio
				+ ", fine_servizio=" + fine_servizio + ", tratta=" + tratta + "]";
	}
}