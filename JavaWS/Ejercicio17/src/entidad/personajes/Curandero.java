package entidad.personajes;

import java.util.Random;
import java.lang.Math;
import entidad.armas.*;

public class Curandero extends Personaje{

	public void generateCurandero(String nombre) {
		Random v = new Random();
		int aleatorio = v.nextInt(100);
		this.setAtributo(aleatorio);
		this.setVida(100);
		this.setNombre(nombre);
	}

	@Override
	public void atacar(Personaje p) {
		int cura = cura();
		if (getArma() instanceof Arco) {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.5));
		} else if (getArma() instanceof Espada) {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.5));
		} else if (getArma() instanceof Hechizo) {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.8));
		} else {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 1));
			this.setVida(this.getVida() + cura);
		}
		int danio = getArma().usar();
		p.setVida(p.getVida() - danio);
		if (getArma() instanceof Rezo)
			System.out.println("El curandero ha inflingido " + danio + " y se ha curado " + cura());
		else
			System.out.println("El curandero ha inflingido " + danio);
		System.out.println("Vida de " + this.getEnemigo().getNombre() + ": " + this.getEnemigo().getVida());
		System.out.println("Vida de " + getNombre() + ": " + getVida());
	}

	/**
	 * @return la cantidad de vida que se cura en base a su inteligencia
	 */
	public int cura() {
		return (int) Math.round(40 * (getAtributo() * 0.01));
	}

	@Override
	public String toString() {
		return "El curandero " + getNombre() + " tiene un arma " + getArma().getClass().getSimpleName()
				+ " con una inteligencia de " + getAtributo() + " y una vida de " + getVida();
	}
}
