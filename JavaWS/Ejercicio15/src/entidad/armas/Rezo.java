package entidad.armas;

public class Rezo extends Arma {

	@Override
	public int usar() {
		System.out.println("AVE MARIA PURISIMA!");
		if (critico()) {
			System.out.println("Critico!!!");
			return (int) Math.round(Math.random() * (getDanio() - 15 + 1) + 15) * 2;
		} else {
			return (int) Math.round(Math.random() * (getDanio() - 15 + 1) + 15);
		}
	}

}
