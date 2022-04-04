
public class Primo implements Runnable{
	
	private int numero;
	
	public Primo(int numero) {
		this.numero = numero;
	}
	

	@Override
	public void run() {
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=this.numero)){
		    if (this.numero % contador == 0) {
			      primo = false;
		    }
		    contador++;
		  }
		  if(primo)
			  System.out.println("El numero "+ this.numero+" es primo");
		  else
			  System.out.println("El numero "+ this.numero+" no es primo");
	}
	
}
