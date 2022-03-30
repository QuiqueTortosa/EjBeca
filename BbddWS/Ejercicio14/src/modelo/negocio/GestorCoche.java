package modelo.negocio;

import java.util.List;
import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheSql;

public class GestorCoche {

	private DaoCocheSql daoCoche = new DaoCocheSql();

	/*
	 * @param c el coche a dar de alta
	 * 
	 * @return 0 en caso de que la matricula sea incorrecta return 1 en caso de que
	 * la matricula exista return 2 en caso de que los km sean negativos return 3 en
	 * caso de que se de de alta return 4 en caso de que falle el alta
	 */
	public int alta(Coche c) {
		if (c.getMatricula().length() != 7)
			return 0;
		else if (daoCoche.findByMatricula(c.getMatricula()) != null) {
			System.out.println("AAAAA"+daoCoche.findByMatricula(c.getMatricula()));
			return 1;			
		}
		else if (c.getKm() < 0)
			return 2;
		else {
			if (daoCoche.alta(c))
				return 3;
			else
				return 4;
		}
	}

	/*
	 * @param id para buscar el coche a eliminar
	 * 
	 * @return true si es eliminado false si no es encontrado
	 */
	public boolean eliminar(int id) {
		if (daoCoche.eliminar(id))
			return true;
		else
			return false;
	}

	/*
	 * @param c el coche a dar de alta
	 * 
	 * @return 0 en caso de que el id ya exista return 1 en caso de que la matricula
	 * sea incorrecta return 2 en caso de que la matricula exista return 3 en caso
	 * de que los km sean negativos return 4 en caso de que se de de alta return 5
	 * en caso de que no se de de alta
	 */
	public int editar(Coche c) {
		if (daoCoche.findById(c.getId()) == null)
			return 0;
		else if (c.getMatricula().length() != 7)
			return 1;
		else if (daoCoche.findByMatricula(c.getMatricula()) != null && (daoCoche.findByMatricula(c.getMatricula()) == daoCoche.findById(c.getId())))
			return 2;
		else if (c.getKm() < 0)
			return 3;
		else {
			if (daoCoche.editar(c))
				return 4;
			else
				return 5;
		}

	}

	/*
	 * @param id para buscar el coche
	 * 
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	public Coche findById(int id) {
		return daoCoche.findById(id);
	}

	/*
	 * @param matricula para buscar el coche
	 * 
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	public Coche findByMatricula(String matricula) {
		if (matricula.length() != 7)
			return null;
		else
			return daoCoche.findByMatricula(matricula);
	}

	/*
	 * @param marca para buscar los coches
	 * 
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	public List<Coche> findByMarca(String marca) {
		return daoCoche.findByMarca(marca);
	}

	/*
	 * @param modelo para buscar los coches
	 * 
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	public List<Coche> findByModelo(String modelo) {
		return daoCoche.findByModelo(modelo);
	}

	/*
	 * @return Lista de todos los coches
	 */
	public List<Coche> findAll() {
		return daoCoche.findAll();
	}
}
