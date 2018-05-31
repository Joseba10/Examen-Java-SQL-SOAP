package com.ipartek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.pojo.Consulta;
import com.ipartek.pojo.Usuario;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class ConsultasDAO {

	
	private static ConsultasDAO INSTANCE = null;

	public ConsultasDAO() {
	}

	public synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ConsultasDAO();
		}
	}

	public static ConsultasDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	public boolean crear(int id,String consulta) {
		boolean resul = false;
		String sql = "INSERT INTO consultas (id_usuarios,nombreconsulta,fecha) VALUES (?,?,CURDATE());";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

		//Insercion de los datos
			pst.setInt(1, id);
			pst.setString(2, consulta);
		

			int affectedRows = pst.executeUpdate();
		//Si la consulta ha sido exitosa
			
			if (affectedRows == 1) {
			
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						
						resul = true;
					}
				}
			}
		}catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return resul;

	}
	
//Creamos el mapper para que se mantentan los datos tanto en sql como en java
	public Consulta mapper(ResultSet rs) throws SQLException {
		Consulta u = new Consulta();
		
//Rellenamos el objeto usuario con los datos correspondientes	
		u.setNombre(rs.getString("nombre_consulta"));
		u.setId(rs.getInt("id_usuarios"));
		
		Usuario usuario = new Usuario();
		usuario.setNombre(rs.getString("usuario"));
		u.setUsuario(usuario);
	
		return u;
		}
	
	
	
}
