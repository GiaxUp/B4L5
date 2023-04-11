package controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import abbonamento.Abbonamento;
import abbonamento.AbbonamentoDAO;
import abbonamento.Tipologia_abbonamento;
import biglietto.Biglietto;
import biglietto.BigliettoDAO;
import parco_mezzi.Autobus;
import parco_mezzi.MezzoDAO;
import parco_mezzi.Tram;
import rivenditore.Distributore_Automatico;
import rivenditore.RivenditoreDAO;
import rivenditore.Rivenditore_autorizzato;
import tessera.Tessera;
import tessera.TesseraDAO;
import tratta.Tratta;
import utente.Utente;
import utente.UtenteDAO;
import utils.JpaUtil;

public class Main {
	EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static void main(String[] args) {

		// **Creazione nuovo utente**
		Utente u1 = new Utente();
		u1.setCognome("Rossi");
		u1.setNome("Mario");
		// **Scommentare sotto per creare utente**
		UtenteDAO.salvaUtente(u1);
		// System.out.println("L'utente salvato è: " + UtenteDAO.findUtente(1));

		// **Creazione nuova tessera**
		Tessera t1 = new Tessera();
		t1.setUtente(UtenteDAO.findUtente(1));
		t1.setData_inizio_abbonamento(LocalDate.of(2022, 8, 3));
		t1.setData_fine_abbonamento(LocalDate.of(2023, 8, 3)); // Aggiungere calcolo annualità automatica
		// **Scommentare sotto per creare una tessera**
		TesseraDAO.salvaTessera(t1);

		// **Creazione nuovi rivenditori**
		Rivenditore_autorizzato r1 = new Rivenditore_autorizzato();
		Distributore_Automatico da2 = new Distributore_Automatico();
		da2.setFuori_servizio(true);
		// RivenditoreDAO.salvaRivenditore(r1);
		// RivenditoreDAO.salvaDistributore(da2);

		// **Creazione nuovi abbonamenti**
		Abbonamento abb1 = new Abbonamento();
		abb1.setData_inizio_abbonamento(LocalDate.of(2023, 2, 15));
		abb1.setTipologia_abbonamento(Tipologia_abbonamento.Settimanale);
		abb1.setTessera(AbbonamentoDAO.findTessera(1));
		abb1.setRivenditore(RivenditoreDAO.findRivenditore(2));
		AbbonamentoDAO.calcolaFineAbb(abb1);
		// **Scommentare sotto per creare un abbonamento**
		AbbonamentoDAO.salvaAbbonamento(abb1);

		// **Creazione nuovi biglietti**
		Biglietto b2 = new Biglietto();
		b2.setData_emissione(LocalDate.of(2023, 4, 10));
		b2.setRivenditore(RivenditoreDAO.findRivenditore(2));
		b2.setMezzo(MezzoDAO.findMezzo(2l));
		// BigliettoDAO.updateTicket(4);
		BigliettoDAO.salvaBiglietto(b2);

		// **Creazione di un autobus e periodo di servizio/manutenzione**
		Autobus a1 = new Autobus();
		a1.setServizio(a1.getInServizio());
		a1.setInizio_servizio(LocalDate.of(2023, 2, 14));
		a1.setFine_servizio(LocalDate.of(2023, 2, 19));
		a1.setInizio_manutenzione(LocalDate.of(2023, 2, 25));
		a1.setFine_manutenzione(LocalDate.of(2023, 3, 28));
		// **Scommentare sotto per creare un abbonamento*
		MezzoDAO.salvaAutobus(a1);
		MezzoDAO.calcolaPeriodoServizio(a1);
		MezzoDAO.calcolaPeriodoManutenzione(a1);

		Tram tram1 = new Tram();
		tram1.setServizio(tram1.getInServizio());
		tram1.setInizio_servizio(LocalDate.of(2023, 1, 14));
		tram1.setFine_servizio(LocalDate.of(2023, 1, 19));
		tram1.setInizio_manutenzione(LocalDate.of(2023, 1, 25));
		tram1.setFine_manutenzione(LocalDate.of(2023, 2, 28));
		tram1.setServizio(true);
		// **Scommentare sotto per creare un abbonamento*
		MezzoDAO.salvaTram(tram1);

		// **Vidimazione dei biglietti**
		// a1.vidimaBiglietto(BigliettoDAO.findBiglietto(1), MezzoDAO.findMezzo(1l));

		

	}
	
	
	
	
	
	
	// DOBBIAMO PRENDERE L'ID DEL TRAM/AUTOBUS E METTERLO PER SALVARE I BIGLIETTI

			// tram1.vidimaBiglietto(BigliettoDAO.findBiglietto(1));

			// System.out.println(MezzoDAO.findMezzo(1l));

			// RivenditoreDAO.conta(RivenditoreDAO.findRivenditore(1));

			// tram1.vidimaBiglietto(BigliettoDAO.findBiglietto(2), MezzoDAO.findMezzo(2l));
//			 MezzoDAO.salvaAutobus(a1);
//			 MezzoDAO.salvaTram(tram1);

			// NON FUNZIONA
			// MezzoDAO.bigliettiVidimati(MezzoDAO.findMezzo(3l));

			// **Creo una tratta**
			Tratta tratta1 = new Tratta("Termini", "Ciampino", 120);
			// TrattaDAO.saveTratta(tratta1);

			// TrattaDAO.findTratta(8);
			// System.out.println(TrattaDAO.findTratta(10l));

			// AbbonamentoDAO.validitaAbb(AbbonamentoDAO.findTessera(1));

			// Mezzo.setPeriodoServizio(a1.getInizio_servizio(), a1.getFine_servizio());
			// Mezzo.setPeriodoManutenzione(a1.getInizio_manutenzione(),
			// a1.getFine_manutenzione());

}
