package src.entidades;

import java.util.ArrayList;

public class Directivo extends Empleado{

	private ArrayList<Empleado> empleadoL=new ArrayList<Empleado>();

	public Directivo(String nombre, int sueldo) {
		super(nombre, sueldo);
	}

	public void addEmpleado(Empleado empleado) {
		empleadoL.add(empleado);
	}
	
	
	/*
	 * return sueldo actual + nm 
	 */
	@Override
	public int getSueldo() {
		return this.sueldo + this.getNmEmpleados()*100;
	}
	
	public int getNmEmpleados() {
		return this.empleadoL.size();
	}
	
	@Override
	public String toString() {
		return super.toString()+"directivo es: "+this.getSueldo(); 
	}
	
}
