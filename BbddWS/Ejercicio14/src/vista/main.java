package vista;

import modelo.entidad.Coche;
import modelo.negocio.GestorCoche;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		GestorCoche gc = new GestorCoche();

		while (flag) {
			System.out.println("Opciones: \n" + "1: Añadir coche \n" + "2: Eliminar coche insertando su id\n"
					+ "3: Buscar coche por id\n" + "4: Buscar coche por Matricula\n" + "5: Buscar coches por marca\n"
					+ "6: Buscar coches por modelo\n" + "7: Enseñar todos los coches\n" + "8: Salir");

			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduza los datos del coche:");
				System.out.println("Matricula:");
				String mat = sc.next();
				System.out.println("Marca:");
				String marca = sc.next();
				System.out.println("Modelo:");
				String modelo = sc.next();
				System.out.println("Kilometros:");
				double km = sc.nextDouble();

				Coche c = new Coche();
				c.setMatricula(mat);
				c.setMarca(marca);
				c.setModelo(modelo);
				c.setKm(km);
				int alta = gc.alta(c);
				if (alta == 0)
					System.out.println("La matricula debe tener 7 caracteres");
				else if (alta == 1)
					System.out.println("La matricula ya existe");
				else if (alta == 2)
					System.out.println("Los km no pueden ser negativos");
				else if (alta == 3)
					System.out.println("El coche se ha dado de alta satisfactoriamente");
				else
					System.out.println("No se ha podido dar de alta por problemas tecnicos, contacte con Felix");
				break;
			case 2:
				System.out.println("Introduzca el id del coche que desea eliminar");
				int id = sc.nextInt();
				if(gc.eliminar(id))
					System.out.println("Se ha eliminado correctamente");
				else
					System.out.println("El coche con id "+id+" no se ha encontrado");
				break;
			case 3:
				System.out.println("Inserta el id");
				int idF = sc.nextInt();
				System.out.println(gc.findById(idF));
				break;
			case 4:
				System.out.println("Inserta la matricula del coche");
				String idM = sc.next();
				System.out.println(gc.findByMatricula(idM));
				break;
			case 5:
				System.out.println("Inserta la marca del coche");
				String idMarca = sc.next();
				System.out.println(gc.findByMarca(idMarca));
				break;
			case 6:
				System.out.println("Inserta el modelo del coche");
				String idModel = sc.next();
				System.out.println(gc.findByModelo(idModel));
				break;
			case 7:
				System.out.println("Todos los coches del catalogo:");
				System.out.println(gc.findAll());
				break;
			case 8:
				System.out.println("Hasta pronto");
				flag = false;
			}
		}

	}

}
