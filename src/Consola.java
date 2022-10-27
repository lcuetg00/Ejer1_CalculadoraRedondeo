import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Clase encargada de la interacción con el usuario
 * Lee las entradas del usuario para realizar las operacones necesarias
 */
public class Consola {
    //Opciones del menú
    public static final int OPCIONSUMA = 1;
    public static final int OPCIONRESTA = 2;
    public static final int OPCIONMULTIPLICACION = 3;
    public static final int OPCIONDIVISION = 4;
    public static final int OPCIONMODULO = 5;
    public static final int OPCIONCOMPARACION = 6;
    public static final int OPCIONTODAS = 7;
    public static final int OPCIONSALIR = 8;

    //Formato de texto
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Funcionalidad de la consola //definir mejor
     */
    public void iniciarConsola() {
        Scanner console = new Scanner(System.in);
        int opcion = -1; //Variable que alamacenará la opción que seleccionará el usuario
        BigDecimal num1;
        BigDecimal num2;
        BigDecimal resultado;
        int precision;

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

                this.clearConsola(); //Borramos el texto de las opciones

                switch(opcion) {
                    case OPCIONSUMA:
                        System.out.println("Operación de suma");
                        System.out.println("Inserte el primer sumando");
                        num1 = new BigDecimal(console.next());
                        System.out.println("Inserte el segundo sumando");
                        num2 = new BigDecimal(console.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = console.nextInt();

                        resultado = CalculadoraRedondeo.sumaRedondeo(num1,num2,precision);

                        System.out.println("El resultado de la operación es " + resultado.toString());


                        break;
                    case OPCIONRESTA:

                        break;
                    case OPCIONMULTIPLICACION:

                        break;
                    case OPCIONDIVISION:

                        break;
                    case OPCIONMODULO:

                        break;
                    case OPCIONCOMPARACION:

                        break;
                    case OPCIONTODAS:

                        break;
                    case OPCIONSALIR:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        this.clearConsola();
                        System.out.println(ANSI_GREEN_BACKGROUND + "Opción tecleada incorrecta. Seleccione una opción con un número del 1 al 8" + ANSI_RESET);

                }


            } catch(InputMismatchException e) {
                System.out.println(ANSI_GREEN_BACKGROUND + "Opción tecleada incorrecta. Seleccione una de las opciones disponibles" + ANSI_RESET);
                console.nextLine();
                this.clearConsola();

            } catch(NumberFormatException e) { //Formato de los numeros decimales
                System.out.println(ANSI_GREEN_BACKGROUND + "Formato incorrecto del número. Volviendo al menú principal" + ANSI_RESET);
                console.nextLine();
                this.clearConsola();
            }





        }
    }

    /**
     * Limpia todo el texto que aparece en la consola
     */
    public void clearConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
