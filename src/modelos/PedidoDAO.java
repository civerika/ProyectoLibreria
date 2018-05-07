package modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import beans.LineaPedido;
import beans.Pedido;

public class PedidoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	private String sql;
	private Pedido pedido;
	
	
	public PedidoDAO(){
		emf = Persistence.createEntityManagerFactory("Libreria");
		em = emf.createEntityManager();
		tx = em.getTransaction();	
	}
	
	public Pedido findById(Long long1){
		tx.begin();
		try{
		pedido = em.find(Pedido.class, long1);
		tx.commit();
		}catch(PersistenceException e){
			tx.rollback();
			System.out.println("traza de find cliente");
			e.printStackTrace();
		}
		return pedido;
	}
	public List<Pedido>findall(){
		List<Pedido> lista = null;
		tx.begin();
		Query q = null;
		try{
			q = em.createNamedQuery("Pedido.findAll",Pedido.class);
			lista = q.getResultList();
			tx.commit();
		} catch (PersistenceException e){
			e.printStackTrace();
			System.out.println("Traza del find usuario");
			tx.rollback();		
		}
		return lista;
	}
	
	public int insertar(Pedido pedido){
		int filas = -1;
		tx.begin();
		try{
			em.persist(pedido);
			filas = 1;
		tx.commit();
		}catch(PersistenceException e){
			System.out.println("traza de inset cliente");
			filas = -1;
			e.printStackTrace();
		}
		return filas;
	}
	public List<Pedido> findPedidosPorFecha(Date fecha){
		sql = "select p from Pedido p where p.fechaAlta =?1";
		tx.begin();
		Object query = em.createQuery(sql).setParameter(1, fecha);
		return ((Query) query).getResultList();
		
	}
	
	public Object[] findPedidoByUsuario(String idUsuario){
		sql="select count(*),count(distinct lib.id_tema), sum(lp.cantidad *lp.precio_venta)"
				+"from Pedidos p join linea_pedidos lp"
				+"on p.id_pedido = lp.id_pedido"
				+"join Libros lib on lp.isbn = lib.isbn"
				+"where p.id_usuario = ?";
		Query query = em.createNativeQuery(sql).setParameter(1, idUsuario);
		return (Object[])query.getSingleResult();
	}
}
