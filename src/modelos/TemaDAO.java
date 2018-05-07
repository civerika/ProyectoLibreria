package modelos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import beans.Tema;
import beans.Usuario;

public class TemaDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private String sql;
	private Tema tema;
	
	public TemaDAO(){
		emf = Persistence.createEntityManagerFactory("Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();	
	}
	
	public Tema findById(Long long1){
		tx.begin();
		try{
		tema = em.find(Tema.class, long1);
		tx.commit();
		}catch(PersistenceException e){
			tx.rollback();
			System.out.println("traza de find cliente");
			e.printStackTrace();
		}
		return tema;
	}
	
	public List<Tema>findall(){
		List<Tema> listatema = null;
		tx.begin();
		Query q = null;
		try{
			q = em.createNamedQuery("Tema.findAll",Tema.class);
			listatema = q.getResultList();
			tx.commit();
		} catch (PersistenceException e){
			e.printStackTrace();
			System.out.println("Traza del find usuario");
			tx.rollback();		
		}
		return listatema;
	}
	
	public int insertar(Tema tema){
		int filas = -1;
		tx.begin();
		try{
			em.persist(tema);
			filas = 1;
		tx.commit();
		}catch(PersistenceException e){
			System.out.println("traza de inset cliente");
			filas = -1;
			e.printStackTrace();
		}
		return filas;
	}
}
