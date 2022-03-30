package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheSql implements DaoCoche{

	private Connection conexion;
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/coche";
		String usuario = "root";
		String password = "";
		try {
			conexion = DriverManager.getConnection(url,usuario,password);
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
	
	@Override
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into coche (matricula,marca,modelo,km) "+" values(?,?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("Error al dar de alta: " + c);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean eliminar(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean flag = true;
		String query = "delete from coche where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				flag = false;
		} catch (SQLException e) {
			System.out.println("El coche con"+id+"no se ha podido eliminar");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return flag;
	}

	@Override
	public boolean editar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean flag = true;
		String query = "update coche set matricula=?, marca=?, modelo=?,km=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMatricula());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setDouble(4, c.getKm());
			ps.setInt(5, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				flag = false;
			else
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al modificar al coche"+c);
			flag = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return flag;
	}

	@Override
	public Coche findById(int id) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = new Coche();
		String query = "SELECT id,matricula,marca,modelo,km from coche where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener al coche"+coche);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return coche;
	}

	@Override
	public Coche findByMatricula(String matricula) {
		if(!abrirConexion()){
			return null;
		}
		Coche coche = new Coche();
		String query = "SELECT id,matricula,marca,modelo,km from coche where matricula = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, matricula);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener al coche con matricula: "+matricula);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		if(coche.getMatricula() == null) {
			return null;
		}else {
			return coche;
		}
	}

	@Override
	public List<Coche> findByMarca(String marca) {
		if(!abrirConexion()){
			return null;
		}
		List<Coche> cocheList = new ArrayList<>();
		Coche coche = null;
		String query = "SELECT id,matricula,marca,modelo,km from coche where marca = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, marca);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				cocheList.add(coche);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener los coches de la marca: "+marca);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return cocheList;
	}

	@Override
	public List<Coche> findByModelo(String modelo) {
		if(!abrirConexion()){
			return null;
		}
		List<Coche> cocheList = new ArrayList<>();
		Coche coche = null;
		String query = "SELECT id,matricula,marca,modelo,km from coche where modelo = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, modelo);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				cocheList.add(coche);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener los coches del modelo: "+modelo);
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return cocheList;
	}

	@Override
	public List<Coche> findAll() {
		if(!abrirConexion()){
			return null;
		}
		List<Coche> cocheList = new ArrayList<>();
		Coche coche = null;
		String query = "SELECT id,matricula,marca,modelo,km from coche";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMatricula(rs.getString(2));
				coche.setMarca(rs.getString(3));
				coche.setModelo(rs.getString(4));
				coche.setKm(rs.getDouble(5));
				cocheList.add(coche);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al obtener los coches");
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		return cocheList;
	}

}
