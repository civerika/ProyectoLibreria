package modelos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import beans.LineaPedido;
import beans.Tema;

public class AddDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private String sql;
	private LineaPedido add;
	
	public AddDAO(){
		emf = Persistence.createEntityManagerFactory("Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();	
	}
	public LineaPedido findById(Long long1){
		tx.begin();
		try{
		add = em.find(LineaPedido.class, long1);
		tx.commit();
		}catch(PersistenceException e){
			tx.rollback();
			System.out.println("traza de find cliente");
			e.printStackTrace();
		}
		return add;
	}
	public List<LineaPedido>findall(){
		List<LineaPedido> lista = null;
		tx.begin();
		Query q = null;
		try{
			q = em.createNamedQuery("LineaPedido.findAll",LineaPedido.class);
			lista = q.getResultList();
			tx.commit();
		} catch (PersistenceException e){
			e.printStackTrace();
			System.out.println("Traza del find usuario");
			tx.rollback();		
		}
		return lista;
	}
	
	public int insertar(LineaPedido add){
		int filas = -1;
		tx.begin();
		try{
			em.persist(add);
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
