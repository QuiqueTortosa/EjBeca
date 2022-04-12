package modelo.negocio;

import java.util.List;
import modelo.persistencia.DaoPersonaSql;
import modelo.entidad.Persona;

public class GestorPersona {
	
	private DaoPersonaSql daoPersona = new DaoPersonaSql();
	
	/**
	 * @param c el coche a dar de alta
	 * 
	 * @return 0 en caso de que falten parametros return 1 en caso de que
	 * el usuario ya exista return 2 en caso de que se de de alta
	 * return 4 en caso de que falle el alta
	 */
	public int addUser(Persona p) {
		if (p.getName() == null || p.getGmail() == null || p.getPassword() == null)
			return 0;
		else if (daoPersona.findByGmail(p.getGmail()) != null) {
			return 1;			
		}
		else {
			if (daoPersona.addUser(p))
				return 2;
			else
				return 3;
		}
	}
	
	/**
	 * 
	 * @param persona que queremos logear
	 * @return 0 en caso de que persona sea null, 1 en caso de que la contraseña o el usuario  coincidan
	 * 2 en caso contrario
	 */
	public int login(String gmail, String password) {
		if(gmail == null || password == null) 
			return 0;
		else {
			Persona pFind = daoPersona.findByGmail(gmail);
			if(pFind.getGmail().equals(gmail) && pFind.getPassword().equals(password)) {
				System.out.println("Usuario "+gmail+" logeado con exito");
				return 1;
			}
			else
				return 2;
		}
	}
	
	public Persona getById(int id) {
		return daoPersona.findById(id);
	}
	
	public Persona getByGmail(String gmail) {
		return daoPersona.findByGmail(gmail);
	}

}
