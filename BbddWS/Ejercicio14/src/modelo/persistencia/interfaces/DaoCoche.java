package modelo.persistencia.interfaces;
import modelo.entidad.Coche;
import java.util.List;
public interface DaoCoche {

	/*
	 * @param c Coche a dar de alta
	 * @return true en caso de exito, falso en caso de error
	 */
	boolean alta(Coche c);
	
	/*
	 * @param id para buscar el coche a eliminar
	 * @return true si es eliminado false si no es encontrado
	 */
	boolean eliminar(int id);
	
	/*
	 * @param coche para buscarlo y editarlo
	 * @return true si es editado false si no es encontrado
	 */
	boolean editar(Coche c);
	
	/*
	 * @param id para buscar el coche
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	Coche findById(int id);
	
	/*
	 * @param matricula para buscar el coche
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	Coche findByMatricula(String matricula);
	
	/*
	 * @param marca para buscar los coches
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	List<Coche> findByMarca(String marca);
	
	/*
	 * @param modelo para buscar los coches
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	List<Coche> findByModelo(String modelo);
	
	/*
	 * @return Lista de todos los coches
	 */
	List<Coche> findAll();
	
}
