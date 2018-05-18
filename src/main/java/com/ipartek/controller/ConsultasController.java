package com.ipartek.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.web_service_soap.CodigoPostal;
import com.ipartek.formacion.web_service_soap.UniveridadPortProxy;
import com.ipartek.model.ConsultasDAO;
import com.ipartek.model.UsuarioDAO;
import com.ipartek.pojo.Alert;
import com.ipartek.pojo.Consulta;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class ConsultasController
 */
@WebServlet("/consultas")
public class ConsultasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ConsultasDAO daoConsultas;
	private Alert alert = new Alert();
	
	//Definicion de Constantes
	private static final String VIEW_LOGIN = "index.jsp";
	private static final String VIEW_BACKOFFICE = "backoffice/buscarcodigopostal.jsp";
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
		  
		//Conexion con el servicio
		  UniveridadPortProxy client = new UniveridadPortProxy();
		 
		
		//  CodigoPostal codigopostal= client.getAlumno(getAlumnoRequest);
		  System.out.println(codigo);
		  
		  Consulta consulta = daoConsultas.crear(usuario, codigo);
	try {
		
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
			}
		
		}catch (Exception e) {
		
			alert = new Alert("Rellena el campo de la consulta");
		}finally {
			request.setAttribute("localidad", localidad);
			request.getRequestDispatcher("backoffice/verconsulta.jsp").forward(request, response);
		}

	}
}
