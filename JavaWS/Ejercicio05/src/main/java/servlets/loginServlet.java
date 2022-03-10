package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import modelo.entidad.Persona;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personList=new ArrayList<Persona>();
	private Persona persona = new Persona();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        personList.add(new Persona("a", "a"));
        personList.add(new Persona("b", "b"));
        personList.add(new Persona("b", "b"));
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd = null;
		
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		
		for(Persona p : personList) {
			if(nombre.equals(p.getNombre()) && contraseña.equals(p.getContraseña())) {
				rd = request.getRequestDispatcher("welcome.jsp");
				break;
			}else {
				rd = request.getRequestDispatcher("error.html");
			}
		}		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
