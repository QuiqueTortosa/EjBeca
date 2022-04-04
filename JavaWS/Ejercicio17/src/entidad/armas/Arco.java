package entidad.armas;

public class Arco extends Arma{
	
	@Override
	public int usar() {
		System.out.println("En la diana!!");
		if (critico()) {
			System.out.println("Critico!!!");
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15) * 2;
		} else {
			return (int) Math.floor(Math.random() * (getDanio() - 15 + 1) + 15);
		}
	}
}
