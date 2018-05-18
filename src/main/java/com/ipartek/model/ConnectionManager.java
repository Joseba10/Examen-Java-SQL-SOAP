package com.ipartek.model;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	
	private static Connection conn;

	public static Connection getConnection() {

		conn = null;

		try {
			InitialContext ctx = new InitialContext();
			
		//Definimos el dataSource cogiendo donde esta la base de datos
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
	    //Si la conexion no es exitosa saldra el mensaje de no encontrado
			if (ds == null) {
				throw new Exception("Data source no encontrado!");
			}
		//Si la conexion es exitosa coge la direccion para su posterior uso
			conn = ds.getConnection();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return conn;

	}

}
