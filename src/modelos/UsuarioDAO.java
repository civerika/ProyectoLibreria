package modelos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import beans.DatosUsuario;
import beans.Usuario;

public class UsuarioDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private String sql;
	private Usuario usuario;

	
	public UsuarioDAO(){
		emf = Persistence.createEntityManagerFactory("Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();	
	}
		public Usuario findById(String clave){
			tx.begin();
			try{
			usuario = em.find(Usuario.class, clave);
			tx.commit();
			}catch(PersistenceException e){
				tx.rollback();
				System.out.println("traza de find cliente");
				e.printStackTrace();
			}
			return usuario;
		}

		public int insertar(Usuario cliente){
			int filas = -1;
			tx.begin();
			try{
				em.persist(cliente);
				filas = 1;
			tx.commit();
			}catch(PersistenceException e){
//				tx.rollback();
				System.out.println("traza de inset cliente");
				filas = -1;
				e.printStackTrace();
			}
			return filas;
		}
	
}
