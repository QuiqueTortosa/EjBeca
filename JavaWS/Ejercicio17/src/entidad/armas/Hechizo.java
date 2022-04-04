package entidad.armas;

public class Hechizo extends Arma{

	@Override
	public int usar() {
		System.out.println("FUUUUUUUUUUUU!");
		if (critico()) {
			System.out.println("Critico!!!");
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15) * 2;
		} else {
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15);
		}
	}
	
}
