import java.util.InputMismatchException;
import java.util.Scanner;



public class Consola {
    public static final int OPCIONSALIR = 8;
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void iniciarConsola() {
        Scanner console = new Scanner(System.in);
        int opcion = -1;

        System.out.println("Ejercicio 1:");

        while(opcion != OPCIONSALIR) {
            try {
                System.out.println("1) Sumar");
                System.out.println("2) Restar");
                System.out.println("3) Multiplicar");
                System.out.println("4) Dividir");
                System.out.println("5) Modulo");
                System.out.println("6) Comparar 2 números");
                System.out.println("7) Realizar todas las operaciones");
                System.out.println("8) Salir");
                System.out.println("Escriba un número para seleccionar la opción que desees:");
                opcion = console.nextInt();

                if((opcion < 1) || (opcion > 8)) {
                    throw new InputMismatchException();
                }

            } catch(InputMismatchException e) {
                System.out.println(ANSI_GREEN_BACKGROUND + "Opción tecleada incorrecta. Seleccione una de las opciones disponibles" + ANSI_RESET);
                console.nextLine();
                this.clearConsola();

            }





        }
    }

    public void clearConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
