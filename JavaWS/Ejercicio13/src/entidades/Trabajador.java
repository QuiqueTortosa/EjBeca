package src.entidades;

public class Trabajador extends Empleado {
	
	public int valoracion;
	
	public Trabajador(String nombre, int sueldo) {
		super(nombre, sueldo);
		this.valoracion = 0;
	}

	
	/*
	 * return sueldo actual + valoracion
	 */
	@Override
	public int getSueldo() {
		if(this.getValoracion() >= 5 && this.getValoracion() <= 6) {
			return this.sueldo + 50;
		}else if(this.getValoracion() >= 7 && this.getValoracion() <= 8) {
			return this.sueldo + 100;
		}else if(this.getValoracion() >= 9 && this.getValoracion() <= 10) {
			return this.sueldo + 200;
		}else {
			return this.sueldo;			
		}
	}
	
	
	/*
	 * Establece la valoracion del empleado, muestra mensaje por consola en caso de ser valor incorrecto
	 */
	public void setValoracion(int valoracion) {
		if(valoracion > 10 || valoracion < 0) {
			System.out.println("Estableza un valor entre 0 y 10");
		}else {
			this.valoracion = valoracion;
		}
	}
	
	/*
	 * return valoracion trabajador
	 */
	public int getValoracion() {
		return this.valoracion;
	}
	
	@Override
	public String toString() {
		return super.toString()+"trabajador es: "+this.getSueldo(); 
	}
}
