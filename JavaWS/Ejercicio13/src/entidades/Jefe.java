package src.entidades;

public class Jefe extends Empleado{
	
	public int incentivo;
	
	public Jefe(String nombre, int sueldo) {
		super(nombre, sueldo);
		this.incentivo = 0;
	}

	
	/*
	 * return sueldo actual + incentivo
	 */
	@Override
	public int getSueldo() {
		return this.sueldo + this.getIncentivo();
	}
	
	@Override
	public String toString() {
		return super.toString()+"jefe es: "+this.getSueldo(); 
	}
	
	
	/*
	 * Establece el incentivo del jefe
	 */
	public void setIncentivo(int incentivo) {
		this.incentivo = incentivo;
	}
	
	/*
	 * return incentivo jefe
	 */
	public int getIncentivo() {
		return this.incentivo;
	}
}
