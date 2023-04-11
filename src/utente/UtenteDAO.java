package utente;

import javax.persistence.EntityManager;

import utils.JpaUtil;


public class UtenteDAO {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static Utente salvaUtente(Utente u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("Utente Salvato");
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().rollback();
		} 
		return u;
	}


	public static Utente findUtente(Integer id) {
		em.getTransaction().begin();
		Utente e = em.find(Utente.class, id);
		em.getTransaction().commit();
		return e;
	}

	public static void removeUtente(Utente e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Utente eliminato!");
	};
}
