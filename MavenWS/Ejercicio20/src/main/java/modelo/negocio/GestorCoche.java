package modelo.negocio;

import java.util.List;
import com.google.gson.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheSql;

public class GestorCoche {

	private DaoCocheSql daoCoche = new DaoCocheSql();

	/**
	 * @param c el coche a dar de alta
	 * 
	 * @return 0 en caso de que la matricula sea incorrecta return 1 en caso de que
	 *         la matricula exista return 2 en caso de que los km sean negativos
	 *         return 3 en caso de que se de de alta return 4 en caso de que falle
	 *         el alta
	 */
	public int alta(Coche c) {
		if (c.getMatricula().length() != 7)
			return 0;
		else if (daoCoche.findByMatricula(c.getMatricula()) != null) {
			System.out.println(daoCoche.findByMatricula(c.getMatricula()));
			return 1;
		} else if (c.getKm() < 0)
			return 2;
		else {
			if (daoCoche.alta(c))
				return 3;
			else
				return 4;
		}
	}

	/**
	 * @param id para buscar el coche a eliminar
	 * 
	 * @return true si es eliminado false si no es encontrado
	 */
	public boolean eliminar(int id) {
		if (daoCoche.eliminar(id))
			return true;
		else
			return false;
	}

	/**
	 * @param c el coche a dar de alta
	 * 
	 * @return 0 en caso de que el id ya exista return 1 en caso de que la matricula
	 *         sea incorrecta return 2 en caso de que la matricula exista return 3
	 *         en caso de que los km sean negativos return 4 en caso de que se de de
	 *         alta return 5 en caso de que no se de de alta
	 */
	public int editar(Coche c) {
		if (daoCoche.findById(c.getId()) == null)
			return 0;
		else if (c.getMatricula().length() != 7)
			return 1;
		else if (daoCoche.findByMatricula(c.getMatricula()) != null
				&& (daoCoche.findByMatricula(c.getMatricula()) == daoCoche.findById(c.getId())))
			return 2;
		else if (c.getKm() < 0)
			return 3;
		else {
			if (daoCoche.editar(c))
				return 4;
			else
				return 5;
		}

	}

	/**
	 * @param id para buscar el coche
	 * 
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	public Coche findById(int id) {
		return daoCoche.findById(id);
	}

	/**
	 * @param matricula para buscar el coche
	 * 
	 * @return coche encontrado o null en caso de no encontrarse
	 */
	public Coche findByMatricula(String matricula) {
		if (matricula.length() != 7)
			return null;
		else
			return daoCoche.findByMatricula(matricula);
	}

	/**
	 * @param marca para buscar los coches
	 * 
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	public List<Coche> findByMarca(String marca) {
		return daoCoche.findByMarca(marca);
	}

	/**
	 * @param modelo para buscar los coches
	 * 
	 * @return lista de coches encontrados o null en caso de no encontrarse
	 */
	public List<Coche> findByModelo(String modelo) {
		return daoCoche.findByModelo(modelo);
	}

	/**
	 * @return Lista de todos los coches
	 */
	public List<Coche> findAll() {
		return daoCoche.findAll();
	}

	/**
	 * Escribe todos los datos de la bdd en formato JSON en un fichero txt
	 */
	public void writeInTxt() {
		try {
			FileWriter myWriter = new FileWriter(
					"C:\\Users\\usuario\\Desktop\\BabelBeca\\MavenWS\\Ejercicio20\\src\\main\\resources\\coches.txt");
			List<Coche> coches = daoCoche.findAll();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(coches);
			myWriter.write(json);
			myWriter.close();
			System.out.println("Se escribieron todos los datos en el fichero");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Escribe todos los datos de la bdd en un pdf
	 */
	public void writeInPDF() {
		try (PDDocument doc = new PDDocument()) {
			List<Coche> coches = daoCoche.findAll();
			PDPage myPage = new PDPage();
			doc.addPage(myPage);
			
			try (PDPageContentStream cont = new PDPageContentStream(doc, myPage)) {
				cont.beginText();
				cont.setFont(PDType1Font.COURIER, 12);
				cont.setLeading(14.5f);
				cont.newLineAtOffset(25, 700);
				
				for(Coche c: coches) {
					cont.showText(c.toPdf());
					cont.newLine();
				}
				cont.endText();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

			doc.save("C:\\Users\\usuario\\Desktop\\BabelBeca\\MavenWS\\Ejercicio20\\src\\main\\resources\\coche.pdf");
			System.out.println("Los datos han sido guardados en el PDF");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
//"C:\\Users\\usuario\\Desktop\\BabelBeca\\MavenWS\\Ejercicio20\\src\\main\\resources\\coches.pdf"

	}
}
