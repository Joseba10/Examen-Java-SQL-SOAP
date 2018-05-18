package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.pojo.Usuario;

public class UsuarioDAO {

	//Patron Singleton
	private static UsuarioDAO INSTANCE = null;

	public UsuarioDAO() {
	}

	public synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	//Comprobar si el usuario existe en la base de datos
	public Usuario check(String nombre, String pass) {
		
		Usuario resul = null;
		String sql = "Select nombre as 'nombre_usuario',contrasena as 'password' from usuarios where nombre=? and contrasena=?;";
		
		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			
			//Añadimos los datos
			pst.setString(1, nombre);
			pst.setString(2, pass);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					resul = mapper(rs);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	//Creamos el mapper para que se mantentan los datos tanto en sql como en java
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = new Usuario();
		
	//Rellenamos el objeto usuario con los datos correspondientes
		u.setNombre(rs.getString("nombre_usuario"));
		u.setPass(rs.getString("password"));
		return u;
		}
	
}
