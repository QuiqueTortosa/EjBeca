package entidad.personajes;
import java.util.Random;

import entidad.armas.*;

public class Guerrero extends Personaje{

	public void generateGuerrero(String nombre) {
		Random v = new Random();
		int aleatorio = v.nextInt(100);
		this.setAtributo(aleatorio);
		this.setVida(120);
		this.setNombre(nombre);
	}
	
	@Override
	public String toString() {
		return "El guerrero "+getNombre()+" tiene un arma "+getArma().getClass().getSimpleName()+" con una fuerza de "+getAtributo()+" y una vida de "+getVida();
	}
	
	public void atacar(Personaje p) {
		if(getArma() instanceof Arco) {
			getArma().setDanio((int)Math.round(getArma().getDanio()+habilidadEspecial()));
		}else if(getArma() instanceof Espada) {
			getArma().setDanio((int)Math.round(getArma().getDanio()+habilidadEspecial()));
		}else if(getArma() instanceof Hechizo) {
			getArma().setDanio((int)Math.round((getArma().getDanio()+habilidadEspecial())*0.5));
		}else {
			getArma().setDanio((int)Math.round((getArma().getDanio()+habilidadEspecial())*0.5));
		}
		int danio = getArma().usar();
		p.setVida(p.getVida()-danio);
		System.out.println(getNombre()+" ha inflingido "+danio);
		System.out.println("Vida de "+p.getNombre()+": " + p.getVida());
	}
	
	/*
	 * Aumenta el daño con todas las armas
	 */
	public int habilidadEspecial() {
		return (int)Math.round(getAtributo()*0.1);
	}

	
}