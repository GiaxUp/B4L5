package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Cards implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataEmissione;
	private LocalDate dataScadenza;
	
	private Period periodo;

	public Cards(LocalDate dataEmissione, LocalDate dataScadenza) {
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
	}

	public Cards() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Period getPeriodo() {
		return periodo;
	}

	@Override
	public String toString() {
		return "Biglietti [id=" + id + ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + "]";
	}

	//metodi custom
	
	//crea periodo in esame
	public  Period setPeriodo(LocalDate inizio, LocalDate fine) {
		this.periodo = Period.between(inizio, fine);
		System.out.println("The Period between the start and end date of service is: " + periodo.getDays() + " days and "
				+ periodo.getMonths() + " months.");
		return this.periodo;
	}
	
	//conto biglietti/abbonamenti nel periodo in esame
	
}
