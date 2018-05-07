package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LineaPedido;
import beans.Pedido;
import beans.Usuario;
import modelos.PedidoDAO;


/**
 * Servlet implementation class GestionCarrito
 */
@WebServlet("/GestionCarrito")
public class GestionCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession misesion = request.getSession();
		
		switch(request.getParameter("opcion")){
		case "dex":
			procDesxconn(request, response);		
			break;
		case "borrarCarrito":
			procVaciar(request, response);
			break;
		case "eliminar":
			procEliminar(request, response);
			break;
		case "comprar":
			procComprar(request, response);
			break;
			
		default:
			System.out.println("sale por gestion Carrito: "+ request.getParameter("opcion"));
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	@SuppressWarnings("unchecked")
	protected void procVaciar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion =request.getSession();
		List<LineaPedido> lista = (List<LineaPedido>)misesion.getAttribute("lista3");
		lista.clear();
		misesion.setAttribute("lista3", lista);
		request.getRequestDispatcher("Carrito.jsp").forward(request, response);
	}
	protected void procComprar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion =request.getSession();
		PedidoDAO pdao = new PedidoDAO();
		Usuario usuario = (Usuario)misesion.getAttribute("usuario");
		List<LineaPedido> lista3 = (List<LineaPedido>)misesion.getAttribute("lista3");
		
		Pedido pedido = new Pedido();
		pedido.setUsuario(usuario);
		pedido.setDireccionEntrega(usuario.getDireccion());
		pedido.setEstado("enviado");
		pedido.setFechaAlta(new java.util.Date());
		
		for (LineaPedido ele:lista3)
			ele.setPedido(pedido);
		pedido.setLineaPedidos(lista3);
		int i = pdao.insertar(pedido);
		request.getRequestDispatcher("MenuCliente.jsp").forward(request, response);
		
		System.out.println(i);
	}
	protected void procEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion =request.getSession();
		((List<LineaPedido>)misesion.getAttribute("lista3")).remove(Integer.parseInt(request.getParameter("isbn")));
		request.getRequestDispatcher("Carrito.jsp").forward(request, response);	
	}
	protected void procDesxconn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession misesion =request.getSession();
		misesion.removeAttribute("lista3");
		misesion.removeAttribute("usuario");
		misesion.invalidate();
		request.getRequestDispatcher("Index.jsp").forward(request, response);
		
	}
}
