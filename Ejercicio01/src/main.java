import java.util.Scanner;

public class main {
    // Main driver method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cambio en la rama restar");
        System.out.println("Cambio en la rama master");
        System.out.println("Cambio en la rama restar2");
        System.out.println("Cambio desde repositorio local 1");
        Suma su = new Suma(0);
        Resta r = new Resta(0);
        int opcion, n1, n2, suma, sumAc, resta, restAc;
        boolean flag = true;
        while (flag) {
            System.out.println("Escoja una de las dos opciones \n1: Suma \n2: Resta \n3: Finalizar programa");
            opcion = sc.nextInt();
            if (opcion == 1) {
                int sumaTipo;
                System.out.println("Escoja una de las dos opciones \n1: Suma \n2: Suma Acumulada");
                sumaTipo = sc.nextInt();
                if (sumaTipo == 1) {
                    System.out.println("Introduzca n1");
                    n1 = sc.nextInt();
                    System.out.println("Introduzca n2");
                    n2 = sc.nextInt();
                    suma = Suma.sumar(n1, n2);
                    System.out.println("Suma: " + suma);
                } else if (sumaTipo == 2) {
                    System.out.println("Suma acumulada:");
                    System.out.println("Introduzca un nm:");
                    sumAc = sc.nextInt();
                    System.out.println("El resultado es:" + su.sumA(sumAc));
                    System.out.println("Introduzca otro nm:");
                    sumAc = sc.nextInt();
                    System.out.println("El resultado es:" + su.sumA(sumAc));
                } else {
                    System.out.println("Eleccion incorrecta");
                }
            } else if (opcion == 2) {
                int restaTipo;
                System.out.println("Escoja una de las dos opciones \n1: Resta \n2: Resta Acumulada");
                restaTipo = sc.nextInt();
                if (restaTipo == 1) {
                    System.out.println("Introduzca n1");
                    n1 = sc.nextInt();
                    System.out.println("Introduzca n2");
                    n2 = sc.nextInt();
                    resta = Resta.restar(n1, n2);
                    System.out.println("Resta: " + resta);
                } else if (restaTipo == 2) {
                    System.out.println("Resta acumulada:");
                    System.out.println("Introduzca un nm:");
                    restAc = sc.nextInt();
                    System.out.println("El resultado es:" + r.restA(restAc));
                    System.out.println("Introduzca otro nm:");
                    restAc = sc.nextInt();
                    System.out.println("El resultado es:" + r.restA(restAc));
                } else {
                    System.out.println("Eleccion incorrecta");
                }
            } else {
                System.out.println("Programa finalizado");
                flag = false;
            }
        }


    }

}

