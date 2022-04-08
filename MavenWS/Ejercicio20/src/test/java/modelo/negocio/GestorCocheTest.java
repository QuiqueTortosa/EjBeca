package modelo.negocio;

import modelo.negocio.GestorCoche;
import modelo.entidad.Coche;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GestorCocheTest {

	@Test
	public void testGetById() {
		GestorCoche c = new GestorCoche();
		Coche coche = new Coche();
		coche.setKm(101.1);
		coche.setMatricula("1011011");
		coche.setMarca("101");
		coche.setModelo("101");
		
		c.alta(coche);
		assertEquals(coche.getKm(), (c.findByMatricula("1011011")).getKm());
	}
	
}
