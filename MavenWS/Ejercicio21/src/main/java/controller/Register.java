package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersona;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorPersona gp = new GestorPersona();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/JSON;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String gmail = request.getParameter("email");
		String password = request.getParameter("pass");
		response.addHeader("Access-Control-Allow-Origin", "*");
		JSONObject json = new JSONObject();
		Persona p = new Persona(gmail,name,password);
		switch (gp.addUser(p)) {
		case 0:
			json.put("message", "Faltan parametros");
			break;
		case 1:
			json.put("message", "El usuario ya existe");
			break;
		case 2:
			json.put("user", p.toString());
			break;
		default:
			json.put("error", "error");
		}
		response.getWriter().write(json.toString());;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
