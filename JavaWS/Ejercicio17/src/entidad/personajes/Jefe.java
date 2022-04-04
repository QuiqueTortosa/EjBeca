package entidad.personajes;

import java.util.Random;
import java.lang.Math;
import entidad.armas.*;

public class Jefe extends Personaje{
	
	public void generateJefe(String nombre) {
		Random v = new Random();
		int aleatorio = v.nextInt(100);
		this.setArma(new Espada());
		this.setAtributo(aleatorio);
		this.setVida(600);
		this.setNombre(nombre);
	}
	
	@Override
	public void atacar(Personaje p) {
		int danio = getArma().usar();
		int ira = ira();
		getArma().setDanio(getArma().getDanio()+ira);
		p.setVida(p.getVida()-danio);
		System.out.println("El jefe ha aumentado su daño en: "+ira+". Su daño actual es de: "+getArma().getDanio());
		System.out.println(getNombre()+" ha inflingido "+danio);
		System.out.println("\nVida de "+p.getNombre()+": " + p.getVida());
		System.out.println("Vida de "+getNombre()+": " + getVida());
	}

	/**
	 * @return 0 en caso de que no entre en ira, X en caso de que entre en ira
	 * 
	 */
	public int ira() {
		int prob = (int) Math.floor(Math.random() * (100 - getAtributo()/2 + 1) + getAtributo()/2);
		if (prob > 30) {
			return 0;
		} else {
			int danioExtra = (int) Math.floor(Math.random() * (30 - 5 + 1) + 5);
			System.out.println(getNombre()+" ha entrado en ira y ha aumentado su daño en "+ danioExtra);
			return danioExtra;
		}
	}

	@Override
	public String toString() {
		return "El Jefe " + getNombre() + " tiene una ira de " + getAtributo() + " y una vida de " + getVida();
	}

}
