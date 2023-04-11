package parco_mezzi;

import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JpaUtil;

public class MezzoDAO {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static void salvaAutobus(Autobus m) {
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			System.out.println("Autobus Salvato");
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {

		}
	}

	public static void salvaTram(Tram m) {
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			System.out.println("Tram Salvato");
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} finally {

		}
	}

	public static void removeTram(Tram e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Tram eliminato!");
	};

	public static void removeAutobus(Autobus e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Autobus eliminato!");
	};

	public static Mezzo findMezzo(Long id) {
		em.getTransaction().begin();
		Mezzo e = em.find(Mezzo.class, id);
		em.getTransaction().commit();
		return e;
	}

	public static void bigliettiVidimati(Mezzo mezzo) {
		Query q = em.createQuery("SELECT b FROM Biglietto WHERE b.mezzo = :mezzo");
		q.setParameter("mezzo", mezzo);
		q.getResultList().forEach(b -> System.out.println(b));
	}

	public static void calcolaPeriodoServizio(Mezzo m) {
		// EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Period p = Period.between(m.getInizio_servizio(), m.getFine_servizio());
		// System.out.println(p);
		int buffer = p.getDays();
		// System.out.println(buffer);
		int buffer2 = p.getMonths();
		// System.out.println(buffer2);
		int total = buffer + (buffer2 * 30);
		m.setPeriodo_servizio(total);
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
	}

	public static void calcolaPeriodoManutenzione(Mezzo m) {
		// EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Period p = Period.between(m.getInizio_manutenzione(), m.getFine_manutenzione());
		// System.out.println(p);
		int buffer = p.getDays();
		// System.out.println(buffer);
		int buffer2 = p.getMonths();
		// System.out.println(buffer2);
		int total = buffer + (buffer2 * 30);
		m.setPeriodo_manutenzione(total);
		em.getTransaction().begin();
		em.merge(m);
		em.getTransaction().commit();
	}
}
