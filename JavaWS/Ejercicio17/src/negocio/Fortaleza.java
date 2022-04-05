package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.personajes.*;

public class Fortaleza {

	private List<Personaje> personajeL = new ArrayList<Personaje>();
	private String nombre;
	private Personaje jefe;

	public Fortaleza(String nombre, Personaje jefe) {
		this.nombre = nombre;
		this.jefe = jefe;
	}

	/**
	 * Crea un hilo a todos los personajes de la lista, y van entrando a la fortaleza 
	 * 1 a 1, si el jefe tiene menos de 0 de vida dejan de entrar
	 */
	public void entrar() {
		for(Personaje p: personajeL) {	
			try {
				if(this.jefe.getVida() <= 0)
					break;
				else {
					this.jefe.setEnemigo(p);
					p.setHiloP(new Thread((Runnable) p));
					p.getHiloP().start();
					p.getHiloP().join();	
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void anadirPersonaje(Personaje personaje) {
		personaje.setEnemigo(jefe);
		personajeL.add(personaje);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Personaje getJefe() {
		return jefe;
	}

	public void setJefe(Personaje jefe) {
		this.jefe = jefe;
	}

}
