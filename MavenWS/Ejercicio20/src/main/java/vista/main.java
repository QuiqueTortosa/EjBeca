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
			System.out.println("Opciones: \n" + "1: A?adir coche \n" + "2: Eliminar coche insertando su id\n"
					+ "3: Editar coche\n" + "4: Buscar coche por id\n" + "5: Buscar coche por Matricula\n"
					+ "6: Buscar coches por marca\n" + "7: Buscar coches por modelo\n" + "8: Ense?ar todos los coches\n"
					+ "9: Guardar la bdd en formato JSON en un fichero\n" + "10: Guardar la bdd en un PDF\n" + "11: Salir");

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
				if (gc.eliminar(id))
					System.out.println("Se ha eliminado correctamente");
				else
					System.out.println("El coche con id " + id + " no se ha encontrado");
				break;
			case 3:
				System.out.println("Introduza el id del coche que sea editar");
				int idE = sc.nextInt();
				System.out.println(
						"Introduza los datos que desea editiar\nEn caso de no querer editar algun elemento introduzca no o -1 en caso de los km");
				System.out.println("Matricula:");
				String matE = sc.next();
				System.out.println("Marca:");
				String marcaE = sc.next();
				System.out.println("Modelo:");
				String modeloE = sc.next();
				System.out.println("Kilometros:");
				double kmE = sc.nextDouble();
				Coche cEditarFind = gc.findById(idE);
				if (matE.equals("no"))
					matE = cEditarFind.getMatricula();
				if (marcaE.equals("no"))
					marcaE = cEditarFind.getMarca();
				if (modeloE.equals("no"))
					modeloE = cEditarFind.getModelo();
				if (kmE == -1)
					kmE = cEditarFind.getKm();
				Coche cE = new Coche();
				cE.setId(cEditarFind.getId());
				cE.setMatricula(matE);
				cE.setMarca(marcaE);
				cE.setModelo(modeloE);
				cE.setKm(kmE);
				int editar = gc.editar(cE);
				if (editar == 0)
					System.out.println("El coche no se ha encontrado");
				else if (editar == 1)
					System.out.println("La matricula debe tener al menos 7 caracteres");
				else if (editar == 2)
					System.out.println("La matricula ya existe");
				else if (editar == 3)
					System.out.println("Los km no pueden ser negativos");
				else if (editar == 4)
					System.out.println("El coche se ha editado correctamente");
				else
					System.out.println("No se ha podido dar de alta por problemas tecnicos, contacte con Felix");
				break;
			case 4:
				System.out.println("Inserta el id del coche que desea encontrar");
				int idF = sc.nextInt();
				System.out.println(gc.findById(idF));
				break;
			case 5:
				System.out.println("Inserta la matricula del coche  del coche que desea encontrar");
				String idM = sc.next();
				System.out.println(gc.findByMatricula(idM));
				break;
			case 6:
				System.out.println("Inserta la marca del coche  del coche que desea encontrar");
				String idMarca = sc.next();
				System.out.println(gc.findByMarca(idMarca));
				break;
			case 7:
				System.out.println("Inserta el modelo del coche");
				String idModel = sc.next();
				System.out.println(gc.findByModelo(idModel));
				break;
			case 8:
				System.out.println("Todos los coches del catalogo:");
				System.out.println(gc.findAll());
				break;
			case 9:
				gc.writeInTxt();
				break;
			case 10:
				gc.writeInPDF();
				break;
			case 11:
				System.out.println("Hasta pronto");
				flag = false;
			}
		}

	}

}
