package modelos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import beans.Libro;
import beans.Tema;


public class LibroDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private String sql;
	private Libro libro;
	
	public LibroDAO(){
		emf = Persistence.createEntityManagerFactory("Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();	
	}
	
	public Libro findById(String clave){
		tx.begin();
		try{
		libro = em.find(Libro.class, clave);
		tx.commit();
		}catch(PersistenceException e){
			tx.rollback();
			System.out.println("traza de find cliente");
			e.printStackTrace();
		}
		return libro;
	}
	
	public List<Libro>findall(){
		List<Libro> listalibro = null;
		tx.begin();
		Query q = null;
		try{
			q = em.createNamedQuery("Libro.findAll",Libro.class);
			listalibro = q.getResultList();
			tx.commit();
		} catch (PersistenceException e){
			e.printStackTrace();
			System.out.println("Traza del find usuario");
			tx.rollback();		
		}
		return listalibro;
	}
	public int insertar(Libro libro){
		int filas = -1;
		tx.begin();
		try{
			em.persist(libro);
			filas = 1;
		tx.commit();
		}catch(PersistenceException e){
//			tx.rollback();
			System.out.println("traza de inset cliente");
			filas = -1;
			e.printStackTrace();
		}
		return filas;
	}

	
}
