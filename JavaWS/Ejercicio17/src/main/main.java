package main;

import entidad.armas.*;
import entidad.personajes.*;
import negocio.*;


public class main {

	public static void main(String[] args) {
		Curandero curandero = new Curandero();
		curandero.generateCurandero("Jesucristo");
		curandero.setArma(new Rezo());
		
		Curandero curandero2 = new Curandero();
		curandero2.generateCurandero("Jesucristo SUPERSTAR");
		curandero2.setArma(new Rezo());
		
		Guerrero guerrero = new Guerrero();
		guerrero.generateGuerrero("Garen");
		guerrero.setArma(new Espada());
	
		Mago mago = new Mago();
		mago.generateMago("Harry Potter");
		mago.setArma(new Hechizo());
		
		Jefe jefe = new Jefe();		
		jefe.generateJefe("SCAM");
		
		//Combate combate = new Combate(curandero, jefe);
		//combate.pelea();
		Fortaleza fortaleza = new Fortaleza("La fortaleza de la muerte",jefe);
		fortaleza.anadirPersonaje(guerrero);
		fortaleza.anadirPersonaje(curandero2);
		fortaleza.anadirPersonaje(mago);
		fortaleza.anadirPersonaje(curandero);
		fortaleza.entrar();

	}
	
	

}
