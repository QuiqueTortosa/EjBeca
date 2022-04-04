package entidad.personajes;

import entidad.armas.Arma;
import entidad.armas.*;
import negocio.*;


public abstract class Personaje implements Runnable{
	
	private Arma arma;
	private String nombre;
	private int vida;
	private int atributo;
	private Personaje enemigo;
	private Thread hiloP;
	public Fortaleza fortaleza;

	public abstract void atacar(Personaje P);
	
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int getAtributo() {
		return atributo;
	}
	public void setAtributo(int atributo) {
		this.atributo = atributo;
	}
	
	public Personaje getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Personaje enemigo) {
		this.enemigo = enemigo;
	}

	public Thread getHiloP() {
		return hiloP;
	}
	public void setHiloP(Thread hiloP) {
		this.hiloP = hiloP;
	}
	
	@Override
	public String toString() {
		return "Personaje [arma=" + arma + ", nombre=" + nombre + ", vida=" + vida + ", atributo=" + atributo + "]";
	}
	
	public void fortaleza() {
		System.out.println("  ----------------------------------------------"
				+"\n                                                 "
				+"\n       "+getNombre()+" entra a la fortaleza               "
				+"\n                                                 "
				+"\n  ----------------------------------------------");
		System.out.println(toString() +"\n"+this.getEnemigo().toString());
		boolean fin = false;
		String ganador = "";
		while(!fin) {
			System.out.println("\n*****************************************");
			System.out.println("Turno de "+getNombre()+"\n-----------------------");
			atacar(this.getEnemigo());
			if(this.getEnemigo().getVida() <= 0) {
				ganador = getNombre();
				System.out.println("\nEl ganador es "+ganador+"\nLos espectadores aplauden!!!! CLAP CLAP CLAP");		
				fin = true;
			}else {
				System.out.println("\nTurno de "+this.getEnemigo().getNombre()+"\n-----------------------");
				this.getEnemigo().atacar(this.getEnemigo().getEnemigo());
				System.out.println();
				if(getVida() <=0) {
					ganador = this.getEnemigo().getNombre();
					System.out.println("El ganador es "+ganador);		
					fin = true;
				}
			}
		}
	}
	
	@Override
	public void run() {
		fortaleza();
	}
	
	
}
