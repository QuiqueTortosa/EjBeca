package entidad.armas;

public class Espada extends Arma {

	@Override
	public int usar() {
		System.out.println("Swang!");
		if (critico()) {
			System.out.println("Critico!!!");
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15) * 2;
		} else {
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15);
		}
	}
}
