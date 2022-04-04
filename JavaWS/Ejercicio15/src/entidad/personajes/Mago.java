package entidad.personajes;

import java.util.Random;
import java.lang.Math;
import entidad.armas.*;

public class Mago extends Personaje {

	public void generateMago(String nombre) {
		Random v = new Random();
		int aleatorio = v.nextInt(100);
		this.setAtributo(aleatorio);
		this.setVida(100);
		this.setNombre(nombre);
	}

	@Override
	public String toString() {
		return "El mago " + getNombre() + " tiene un arma " + getArma().getClass().getSimpleName()
				+ " con una inteligencia de " + getAtributo() + " y una vida de " + getVida();
	}

	public void atacar(Personaje p) {
		if (getArma() instanceof Arco) {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.5));
		} else if (getArma() instanceof Espada) {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.5));
		} else if (getArma() instanceof Hechizo) {
			getArma().setDanio((int) Math.round(getArma().getDanio()));
			p.setVida(p.getVida() - quemar());
		} else {
			getArma().setDanio((int) Math.round(getArma().getDanio() * 0.8));
		}
		int danio = getArma().usar();
		p.setVida(p.getVida()-danio);
		System.out.println(getNombre()+" ha inflingido "+danio);
		System.out.println("Vida de "+p.getNombre()+": " + p.getVida());
	}

	/*
	 * Devuelve el daño del quemado Cuanto mas atributo especial tiene mas
	 * probabilidade tiene de quemar
	 */
	public int quemar() {
		int prob = (int) Math.floor(Math.random() * (100 - getAtributo()/2 + 1) + getAtributo()/2);
		if (prob > 50) {
			return 0;
		} else {
			int danioQuemado = (int) Math.floor(Math.random() * (30 - 5 + 1) + 5);
			System.out.println(getNombre()+" ha quemado a su oponente inflinguiendo "+ danioQuemado+ " de daño extra");
			return danioQuemado;
		}
	}

}
