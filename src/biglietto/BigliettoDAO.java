package biglietto;

import javax.persistence.EntityManager;

import utils.JpaUtil;

public class BigliettoDAO {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static void salvaBiglietto(Biglietto b) {
		try {
			em.getTransaction().begin();
			em.persist(b);
			em.getTransaction().commit();
			System.out.println("Biglietto Salvato");
		} catch (Exception e) {
			System.out.println("errore Biglietto");
			System.out.println(e);
			em.getTransaction().rollback();
		} 
	}

	public static void removeBiglietto(Biglietto e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("Biglietto eliminato!");
	};
	
	public static Biglietto findBiglietto(Integer m) {
        em.getTransaction().begin();
        Biglietto e = em.find(Biglietto.class, m);
        em.getTransaction().commit();
        return e;
    }
	
	public static Biglietto updateTicket(Integer id) {
		em.getTransaction().begin();
		Biglietto e = em.find(Biglietto.class, id);
		// em.merge(tp);
		em.getTransaction().commit();
		System.out.println("Biglietto aggiornato");
		return e;
	}



	/*public static int findBigliettiVidimati() {
		   	
	    Query q = em.createQuery("SELECT COUNT b FROM Biglietto b WHERE b.bigliettoVidimato = :t ");
		q.setParameter ("t", true);
		System.out.println(q);
		return (int) q.getSingleResult();
			
		}*/
		

	
}
