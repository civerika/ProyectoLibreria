package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import beans.Pedido;
import beans.PedidoFecha;
import beans.Tema;
import beans.Usuario;
import modelos.LibroDAO;
import modelos.PedidoDAO;
import modelos.TemaDAO;
import modelos.UsuarioDAO;

/**
 * Servlet implementation class GestionAdmon
 */
@WebServlet("/GestionAdmon")
public class GestionAdmon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Date Date = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionAdmon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		Tema tema=null;
		Libro libro=null;
		TemaDAO tdao = new TemaDAO();
		LibroDAO ldao = new LibroDAO();
		PedidoFecha pedidofecha=null;
		
		switch(request.getParameter("opcion")){
		case "registrotema":
			tema = new Tema();
			tema.setDescTema(request.getParameter("descTema"));
			tema.setAbreviatura(request.getParameter("abreviatura"));
			if(tdao.insertar(tema)==1){
				System.out.println("registrado: "+tema);
				response.sendRedirect("Admon.jsp");
			}
			else{
				System.out.println("insertar y existe");
				response.sendRedirect("Admon.jsp");
			}
			break;
		
		case "registrolibro":
			libro = new Libro();
			libro.setIsbn(request.getParameter("isbn"));
			libro.setTitulo(request.getParameter("titulo"));
			libro.setAutor(request.getParameter("autor"));
			libro.setPrecioUnitario(BigDecimal.valueOf(Long.parseLong(request.getParameter("precioUnitario"))));
			libro.setStock(Integer.parseInt(request.getParameter("stock")));
			libro.setTema(tdao.findById(new Long(request.getParameter("tema"))));
			if(ldao.insertar(libro)==1){
				System.out.println("registrado: "+libro);
				response.sendRedirect("Admon.jsp");
			}
			else{
				System.out.println("insertar y existe");
				response.sendRedirect("Admon.jsp");
			}
			break;
			
		case "pedidosfecha":
			PedidoDAO pdao2 = new PedidoDAO();
			List<Pedido> listapedidofecha = pdao2.findPedidosPorFecha(Date);
			 request.setAttribute("pedidos", listapedidofecha);
			 rd = request.getRequestDispatcher("PedidosFecha.jsp");
			 rd.forward(request, response);
			 break;
			 
		case "estadisticas":
			PedidoDAO pdao = new PedidoDAO();
			Object[] estadisticas = pdao.findPedidoByUsuario(request.getParameter("idUsuario"));
			request.setAttribute("estadisticas", estadisticas);
			request.getRequestDispatcher("Estadisticas.jsp").forward(request, response);
			
		default: 
			PrintWriter pw = response.getWriter();
			pw.println("html><head> <title>primera web</title> </head>");
			pw.println("<body><h3>FALLA EL SWITCH</h3></body></html>");
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

}
