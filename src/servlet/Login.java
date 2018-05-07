package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LineaPedido;
import beans.Usuario;
import modelos.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		RequestDispatcher rd = null;
		Usuario usuario=null;
		UsuarioDAO cdao = new UsuarioDAO();
		List<LineaPedido>lista3 = new ArrayList<>();
		
		
		switch(request.getParameter("opcion")){
		case "validar":
			usuario = cdao.findById(request.getParameter("usuario"));
			if(usuario != null && usuario.getPassword().equals(request.getParameter("password"))){
				if (usuario.getTipoUsuario().equals("admon")) {
					request.setAttribute("usuario", usuario);
					HttpSession misesion = request.getSession();
					misesion.setAttribute("usuario", usuario);
					rd = request.getRequestDispatcher("Admon.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("usuario", usuario);
					HttpSession misesion = request.getSession();
					misesion.setAttribute("usuario", usuario);
					request.getSession().setAttribute("lista3", lista3);
					rd = request.getRequestDispatcher("MenuCliente.jsp");
					rd.forward(request, response);
					
				}			
			}
			else{
				rd = request.getRequestDispatcher("ErrorLogin");
				rd.forward(request, response);
	}
			break;
		case "registro":
			usuario = new Usuario();
			usuario.setIdUsuario(request.getParameter("idUsuario"));
			usuario.setPassword(request.getParameter("password"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));
			usuario.setDireccion(request.getParameter("direccion"));
			usuario.setFechaAlta(new Date());
			usuario.setTipoUsuario("normal");
			
			if(cdao.insertar(usuario)==1){
				System.out.println("registrado: "+usuario);
				response.sendRedirect("Index.html");
			}
			else{
				System.out.println("insertar y existe");
				response.sendRedirect("Index.html");
			}
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
