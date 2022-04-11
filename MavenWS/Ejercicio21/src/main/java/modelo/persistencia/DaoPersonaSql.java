package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidad.Persona;


public class DaoPersonaSql {
	
	private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/persona";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addUser(Persona p) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into persona (gmail,name,passord) "+" values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getGmail());
			ps.setString(2, p.getName());
			ps.setString(3, p.getPassword());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("Error al dar de alta: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}
	
	public Persona findById(int id) {
		if(!abrirConexion()){
			return null;
		}
		Persona persona = new Persona();
		String query = "SELECT id,gmail,name,password from persona where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				persona.setId(rs.getInt(1));
				persona.setGmail(rs.getString(2));
				persona.setName(rs.getString(3));
				persona.setPassword(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener la"+persona);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return persona;
	}
	
	public Persona findByGmail(String gmail) {
        boolean st =false;
		if(!abrirConexion()){
			return null;
		}
		Persona persona = new Persona();
		String query = "SELECT id,gmail,name,password from persona where gmail = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, gmail);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				persona.setId(rs.getInt(1));
				persona.setGmail(rs.getString(2));
				persona.setName(rs.getString(3));
				persona.setPassword(rs.getString(4));
			}
            st = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener la"+persona);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return persona;
	}
	
}
