package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.internal.libraries.antlr.runtime.RecognizerSharedState;

import beans.Libro;
import beans.LineaPedido;
import beans.Pedido;
import beans.Tema;
import modelos.AddDAO;
import modelos.LibroDAO;
import modelos.TemaDAO;
import modelos.UsuarioDAO;
import beans.Usuario;

/**
 * Servlet implementation class ControlLibros
 */
@WebServlet("/ControlLibros")
public class ControlLibros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlLibros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		switch(request.getParameter("opcion")){
		case "temas":
			TemaDAO tdao = new TemaDAO();
			List<Tema> listatema = tdao.findall(); 
			 request.setAttribute("temas", listatema);
			 rd = request.getRequestDispatcher("VerTemas.jsp");
			 rd.forward(request, response);		
			 break;
			 
		case "libros":
//			LibroDAO ldao = new LibroDAO();
			TemaDAO tdao2 = new TemaDAO();
			List<Libro> listalibro = tdao2.findById(Long.valueOf(request.getParameter("idtema"))).getLibros();
			 request.setAttribute("libros", listalibro);
			 rd = request.getRequestDispatcher("ElegirLibros.jsp");
			 rd.forward(request, response);		
			 break;
			
		case "add":
			List<LineaPedido>linea3	= (List<LineaPedido>) request.getSession().getAttribute("lista3");
			LineaPedido linea = null;
			String[] lista3 = request.getParameterValues("titulo");
			Libro libro = null;
			LibroDAO ldao2 = null;
			
			for (String ele: lista3){
				ldao2 =new LibroDAO();
				libro = ldao2.findById(ele);
				linea = new LineaPedido();
				linea.setLibro(libro);
				linea.setCantidad(BigDecimal.valueOf(1));
				linea.setPrecioVenta(libro.getPrecioUnitario());
				if(!linea3.contains(linea))
				linea3.add(linea);
			}
			request.getSession().setAttribute("lista3", linea3);
			 rd = request.getRequestDispatcher("Carrito.jsp");
			 rd.forward(request, response);		
			 break;
		case "datoscliente":
			Usuario usuario = new Usuario();
			UsuarioDAO udao = null;
			String[] lista = request.getParameterValues("datoscliente");
			
				udao =new UsuarioDAO();
				usuario = udao.findById("usuario");
				usuario = new Usuario();
				usuario.setNombre(request.getParameter("nombre"));
				usuario.setApellido(request.getParameter("apellido"));
				usuario.setDireccion(request.getParameter("direccion"));
				usuario.setFechaAlta(request.getParameter("fechaAlta"));
				usuario.setPassword(request.getParameter("password"));
				usuario.setTipoUsuario(request.getParameter("tipoUsuario"));
				
			
			
			 request.setAttribute("datoscliente", usuario);
			 rd = request.getRequestDispatcher("Datoscliente.jsp");
			 rd.forward(request, response);	
			 break;
			
		default: 
			PrintWriter pw = response.getWriter();
			pw.println("html><head> <title>primera web</title> </head>");
			pw.println("<body><h3>se te ha ido el switch</h3></body></html>");
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
