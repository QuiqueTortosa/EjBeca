package src;

import java.util.ArrayList;

import src.entidades.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Empleado> empleadoL=new ArrayList<Empleado>();
		
		Trabajador t1 = new Trabajador("t1", 1000);
		System.out.println("Trabajador "+t1.getNombre()+"con valoracion "+t1.getValoracion()+": "+t1.getSueldo());
		Trabajador t2 = new Trabajador("t2", 1000);
		t2.setValoracion(5);
		System.out.println("Trabajador "+t2.getNombre()+"con valoracion "+t2.getValoracion()+": "+t2.getSueldo());
		Trabajador t3 = new Trabajador("t3", 1000);
		t3.setValoracion(7);
		System.out.println("Trabajador "+t3.getNombre()+"con valoracion "+t3.getValoracion()+": "+t3.getSueldo());
		Trabajador t4 = new Trabajador("t4", 1000);
		t4.setValoracion(9);
		System.out.println("Trabajador "+t4.getNombre()+"con valoracion "+t4.getValoracion()+": "+t4.getSueldo());

		System.out.println("-----------------------------------------------------------------------");
		Jefe carlos = new Jefe("carlos",1000);
		System.out.println("Creando al Jefe Carlos con un sueldo base de: "+carlos.getSueldo());
		carlos.setIncentivo(100);
		System.out.println("Añadiendo incentivo: "+ carlos.getIncentivo()+"\nSueldo actual: "+carlos.getSueldo());
		System.out.println("-----------------------------------------------------------------------");
		Directivo pep2 = new Directivo("Pepe", 1000);
		System.out.println("Creando al directivo pep2 con un sueldo base de: "+pep2.getSueldo());
		pep2.addEmpleado(t1);
		pep2.addEmpleado(t2);
		pep2.addEmpleado(t3);
		pep2.addEmpleado(t4);
		pep2.addEmpleado(carlos);
		System.out.println("Añadiendo a los 4 trabajadores y al jefe Carlos al directivo pep2");
		System.out.println("Sueldo base de pep2: 1000 \nSueldo base + trabajadores: "+pep2.getSueldo());
		System.out.println("-----------------------------------------------------------------------");
		
		empleadoL.add(t1);
		empleadoL.add(t2);
		empleadoL.add(t3);
		empleadoL.add(t4);
		empleadoL.add(carlos);
		empleadoL.add(pep2);
		
		for(Empleado e: empleadoL) {
			System.out.println(e.toString());
		}
	}
}
