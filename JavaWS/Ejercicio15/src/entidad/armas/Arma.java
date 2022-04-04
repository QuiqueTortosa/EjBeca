package entidad.armas;

import java.util.Random;
import java.lang.Math;

public abstract class Arma {
	
	private int danio = 30;

	public abstract int usar();
	
	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	public boolean critico() {
		Random number = new Random();
		int prob = number.nextInt(100);
		if(prob < 90) {
			return false;
		}else {
			return true;
		}
	}
}
