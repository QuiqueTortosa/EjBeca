package entidad;

import entidad.personajes.*;

public class Combate {
	
	private Personaje pj1;
	private Personaje pj2;
	
	public Combate(Personaje pj1, Personaje pj2) {
		this.pj1 = pj1;
		this.pj2 = pj2;
	}
	
	public void pelea() {
		System.out.println(pj1.toString() +"\n"+pj2.toString());
		
		boolean fin = false;
		Personaje ganador = null;
		while(!fin) {
			System.out.println("*****************************************");
			System.out.println("Turno de "+pj1.getNombre()+"\n-----------------------");
			pj1.atacar(pj2);
			System.out.println("\nTurno de "+pj2.getNombre()+"\n-----------------------");
			pj2.atacar(pj1);
			System.out.println();
			if(pj1.getVida() <= 0) {
				ganador = pj2;
				fin = true;
			}else if(pj2.getVida() <= 0) {
				ganador = pj1;
				fin = true;
			}
		}
		System.out.println("El ganador es "+ganador.getNombre());
	}
	
}
