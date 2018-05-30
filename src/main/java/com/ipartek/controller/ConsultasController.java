package com.ipartek.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.model.ConsultasDAO;
import com.ipartek.pojo.Alert;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class ConsultasController
 */
@WebServlet("/consultas")
public class ConsultasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ConsultasDAO daoConsultas;
	private Alert alert = new Alert();

	private static final String VIEW_BACKOFFICE = "backoffice/verconsulta.jsp";


	private String localidad="";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoConsultas = ConsultasDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		daoConsultas = null;
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = (HttpSession) request.getSession();
	
		//Recogida de los parametros introducidos en la pantalla de consulta
	
		  String codigo = request.getParameter("codigo");
		  Usuario usuario = (Usuario) session.getAttribute("usuario");
		  
		
		  System.out.println(codigo);
		  
		  boolean consulta = daoConsultas.crear(usuario, codigo);
	try {
			
			if (consulta ==true) {
			
				if(codigo!="") {
				//Parseo para poder hacer el el switch
					int nombreconsulta = Integer.parseInt(codigo);
				
				//Asigno un resultado a la variable
					switch (nombreconsulta) {
						case 1:  localidad = "Bizkaia";
			                 break;
						case 2:  localidad = "Teruel";
			                 break;
						case 3:  localidad = "Soy una tetera";
			                 break; 
						default: localidad = "No existe";
			                 break;
					}
					
					System.out.println("Localidad  "+ localidad);
			
				}else {
					System.out.println("No esta,esa consulta");
					localidad="No esta, esa consulta";
							}
		
			} 
		} catch(NumberFormatException e) { 
			System.out.println("El formato no es correcto");
		
			
			localidad="El formato no es correcto";
	    }
	
		
		catch (Exception e) {
		
			alert = new Alert("Rellena el campo de la consulta");
			localidad="Rellena el campo de la consulta";
		}finally {
			request.setAttribute("localidad", localidad);
			request.getRequestDispatcher(VIEW_BACKOFFICE).forward(request, response);
		}

	}
}
