import java.util.*;

interface esPrimo {
	
	public Runnable operacion(Integer a);
	
}

public class main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n1,n2,n3;
		
		System.out.println("Introduzca tres numeros para saber si son primos o no");
		n1 = in.nextInt();
		System.out.println("Has introducido el numero: "+n1);
		n2 = in.nextInt();
		System.out.println("Has introducido el numero: "+n2);		
		n3 = in.nextInt();
		System.out.println("Has introducido el numero: "+n3);
		
		esPrimo p = numero -> {
			  int contador = 2;
			  boolean primo=true;               
			  while ((primo) && (contador!=numero)){
			    if (numero % contador == 0) {
				      primo = false;
			    }
			    contador++;
			  }
			  if(primo)
				  System.out.println("El numero "+ numero+" es primo");
			  else
				  System.out.println("El numero "+ numero+" no es primo");
			return null;
		};
		
		
		Thread h1 = new Thread(p.operacion(n1));
		Thread h2 = new Thread(p.operacion(n2));
		Thread h3 = new Thread(p.operacion(n3));

		h1.start();
		h2.start();
		h3.start();

		
	}

}
