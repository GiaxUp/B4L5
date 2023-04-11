package rivenditore;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JpaUtil;

public class RivenditoreDAO {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static void salvaRivenditore(Rivenditore_autorizzato r) {
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			System.out.println("Rivenditore autorizzato Salvato");
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}
	}

	public static void salvaDistributore(Distributore_Automatico da) {
		try {
			em.getTransaction().begin();
			em.persist(da);
			em.getTransaction().commit();
			System.out.println("Distributore Automatico Salvato");
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		}
	}


	public static void removeRivenditore(Rivenditore_autorizzato e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Rivenditore autorizzato eliminato!");
	};

	public static void removeDistributore(Distributore_Automatico e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Distributore Automatico eliminato!");
	};

	public static Rivenditore_autorizzato findRivenditore(Integer id) {
		em.getTransaction().begin();
		Rivenditore_autorizzato e = em.find(Rivenditore_autorizzato.class, id);
		em.getTransaction().commit();
		return e;
	}


	public static void conta(Rivenditore_autorizzato id) {
		Query q = em.createQuery("SELECT COUNT(b) FROM Biglietto b Where b.rivenditore = :id ");
		// Query q = em.createNamedQuery("Biglietto.findAll");
		q.setParameter("id", id);
		//System.out.println("Biglietti e abbonamenti emessi " + q.getSingleResult());
		q.getResultList().forEach(b -> System.out.println(b));
			
	}

}
