package entidad.personajes;

import entidad.armas.Arma;
import entidad.armas.*;


public abstract class Personaje {
	
	private Arma arma;
	private String nombre;
	private int vida;
	private int atributo;

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
	
	
	@Override
	public String toString() {
		return "Personaje [arma=" + arma + ", nombre=" + nombre + ", vida=" + vida + ", atributo=" + atributo + "]";
	}
	
}
