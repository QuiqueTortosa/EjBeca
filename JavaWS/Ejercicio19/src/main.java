import java.util.Scanner;

interface InterfazGenerica <T>{
	public T operacion(T n1, T n2);
}

public class main {
	public static void main(String[] args) {
		InterfazGenerica <Integer> iGenerica = ( n1, n2 ) -> n1 + n2;	
		Scanner in = new Scanner(System.in);

		int num1,num2;
		
		System.out.println("Introduzca dos numeros");
		num1 = in.nextInt();
		System.out.println("Has introducido el numero: "+num1);
		num2 = in.nextInt();
		System.out.println("Has introducido el numero: "+num2);	
		
		System.out.println("\nLa suma de "+num1+" + "+num2+" es: "+iGenerica.operacion(num1,num2));	
		iGenerica = ( n1, n2 ) -> n1 - n2;
		System.out.println("La resta de "+num1+" - "+num2+" es: "+iGenerica.operacion(num1,num2));	
		iGenerica = ( n1, n2 ) -> n1 * n2;
		System.out.println("La multiplicacion de "+num1+" * "+num2+" es: "+iGenerica.operacion(num1,num2));	
		iGenerica = ( n1, n2 ) -> n1 / n2;
		System.out.println("La division de "+num1+" / "+num2+" es: "+iGenerica.operacion(num1,num2));	
		iGenerica = ( n1, n2 ) -> {
			System.out.println("Potencia de n1: " +n1*n1);
			System.out.println("Potencia de n1: " +n2*n2);
			return n1*n1 + n2*n2;
		};
		System.out.println("La suma de la potencia de "+num1+" + la potencia de "+num2+" es: "+iGenerica.operacion(num1,num2));	

	}
}
