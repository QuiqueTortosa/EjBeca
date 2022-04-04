import java.util.*;

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

		Primo primo1 = new Primo(n1);
		Primo primo2 = new Primo(n2);
		Primo primo3 = new Primo(n3);
		Thread hilo1 = new Thread(primo1);
		Thread hilo2 = new Thread(primo2);	
		Thread hilo3 = new Thread(primo3);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		
	}

}
