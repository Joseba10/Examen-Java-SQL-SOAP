package com.ipartek.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ipartek.model.UsuarioDAO;
import com.ipartek.pojo.Alert;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class PruebaController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
//Definimos las constantes que vamos a usar
	private static final String VIEW_LOGIN = "index.jsp";
	private static final String VIEW_BACKOFFICE = "backoffice/buscarcodigopostal.jsp";
	private static final int SESSION_EXPIRATION = -1; // No expira la sesion

	//Declaramos las variables
	private String view = "";
	private UsuarioDAO daoUsuario;
	private Alert alert = new Alert();

	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoUsuario = UsuarioDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoUsuario = null;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//En caso de que intenten acceder al servlet mediante la url,les llevara al index.jsp
		request.getRequestDispatcher(VIEW_LOGIN).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	//Recogida de los parametros introducidos en la pantalla de login
		
		String nombre = request.getParameter("usuario");
		String password = request.getParameter("password");
		
	//Comprobacion en la consola para ver que los datos recogidos,han sido exitosos
		System.out.println("Nombre " + nombre + " Contraseña " + password);
	//Llamamos al metodo que esta ubicado en el DAO
		Usuario usuario = daoUsuario.check(nombre, password);
	System.out.println(usuario);
	
		
		//Si no cumple los dos parametros te manda al login
			if(nombre!="" && password!="") {
			
			//Si se cumple 
				if (usuario != null) {

				// guardar usuario en session

				  HttpSession session = request.getSession();
				  session.setAttribute("usuario", usuario);
			
				  /*
				   * Tiempo expiracion session
				   */
				  session.setMaxInactiveInterval(SESSION_EXPIRATION);
				  view = VIEW_BACKOFFICE;
				} else {
						view = VIEW_LOGIN;
						alert = new Alert("Credenciales incorrectas, prueba de nuevo");
				} //Fin del segundo if
			}//Fin del primer if
	
		} catch (Exception e) {
				e.printStackTrace();
				view = VIEW_LOGIN;
				alert = new Alert("Datos vacios");
			
		}finally {
			//Como lo han sido pasamos a la siguiente pantalla
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		
		
	}
}

