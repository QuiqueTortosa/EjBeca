package entidad;

import entidad.armas.*;
import entidad.personajes.*;


public class main {

	public static void main(String[] args) {
		Curandero curandero = new Curandero();
		curandero.generateCurandero("Jesucristo");
		curandero.setArma(new Rezo());
		
		Guerrero guerrero = new Guerrero();
		guerrero.generateGuerrero("Garen");
		guerrero.setArma(new Espada());
	
		Mago mago = new Mago();
		mago.generateMago("Harry Potter");
		mago.setArma(new Hechizo());
		
		Combate combate = new Combate(curandero, mago);
		combate.pelea();
	}

}
