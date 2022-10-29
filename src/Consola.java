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
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; //Para que el texto tenga un fondo verde
    public static final String ANSI_RESET = "\u001B[0m"; //Para devolver el texto a la normalidad

    /**
     * Inicia la interfaz de la consola.
     * Presenta el menú al usuario, lee sus entradas y realiza las operaciones necesarias
     */
    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; //Almacenará la opción del menú que introducirá el usuario
        int precision = 0; //Almacenará la precisión de los decimales que seleccione el usuario
        BigDecimal num1; //Primer número introducido por teclado
        BigDecimal num2; //Segundo número introducido por teclado
        BigDecimal resultado; //Instancia que contendrá el resultado final de la operación seleccionada

        System.out.println("Ejercicio 1:");

        imprimirMenu();

        while(opcion != OPCIONSALIR) {
            try {
                opcion = scanner.nextInt(); //Leemos la operación que quiere realizar el usuario

                switch(opcion) {
                    case OPCIONSUMA:
                        System.out.println("Operación de suma");
                        System.out.println("Inserte el primer sumando");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo sumando");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();

                        resultado = CalculadoraRedondeo.sumaRedondeo(num1,num2,precision);
                        System.out.println("El resultado de la suma es " + resultado.toString());


                        break;
                    case OPCIONRESTA:
                        System.out.println("Operación de resta");
                        System.out.println("Inserte el minuendo de la resta");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el sustraendo de la resta");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();

                        resultado = CalculadoraRedondeo.restaRedondeo(num1,num2,precision);
                        System.out.println("El resultado de la resta es " + resultado.toString());

                        break;
                    case OPCIONMULTIPLICACION:
                        System.out.println("Operación de multiplicación");
                        System.out.println("Inserte el primer número a multiplicar");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número a multiplicar");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();


                        resultado = CalculadoraRedondeo.multiplicacionRedondeo(num1,num2,precision);
                        System.out.println("El resultado de la multiplciacion es " + resultado.toString());
                        break;
                    case OPCIONDIVISION:
                        System.out.println("Operación de division");
                        System.out.println("Inserte el dividendo de la división");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el divisor de la multiplicación");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();

                        resultado = CalculadoraRedondeo.divisionRedondeo(num1,num2,precision);
                        System.out.println("El resultado de la resta es " + resultado.toString());
                        break;
                    case OPCIONMODULO:
                        System.out.println("Operación de módulo");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el número para el módulo de la operación");
                        num2 = new BigDecimal(scanner.next());

                        System.out.println(CalculadoraRedondeo.mensajeModuloBigDecimal(num1,num2));
                        break;

                    case OPCIONCOMPARACION:
                        int valorComparacion = -1;

                        System.out.println("Operación comparación de números");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número");
                        num2 = new BigDecimal(scanner.next());

                        valorComparacion = num1.compareTo(num2);
                        System.out.println(CalculadoraRedondeo.mensajeEsMayor(num1,num2));
                        break;


                    case OPCIONTODAS:
                        System.out.println("Realizar todas las operaciones");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();
                        System.out.println(this.recogerResultados(num1,num2,precision));

                        break;
                    case OPCIONSALIR:
                        System.out.println("Saliendo del programa");
                        break;
                    default:
                        this.clearConsola();
                        this.imprimirMenu();
                        System.out.println(ANSI_GREEN_BACKGROUND + "Opción tecleada incorrecta. Seleccione una opción con un número del 1 al 8" + ANSI_RESET);
                }

                this.imprimirMenu(); //Finalmente, volvemos a imprimir el menú

            } catch(InputMismatchException e) {
                System.out.println(ANSI_GREEN_BACKGROUND + "Opción tecleada incorrecta. Seleccione una de las opciones disponibles" + ANSI_RESET);
                scanner.nextLine();
                this.clearConsola();

            } catch(NumberFormatException e) { //Formato de los numeros decimales
                this.clearConsola();
                System.out.println(ANSI_GREEN_BACKGROUND + "Formato incorrecto del número. Volviendo al menú principal" + ANSI_RESET);
                this.imprimirMenu();
                scanner.nextLine();
            }
        }
    }

    /**
     * Imprime el menú de opciones
     */
    public void imprimirMenu() {
        System.out.println("_____________________________________________________________________");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.println("5) Modulo");
        System.out.println("6) Comparar 2 números");
        System.out.println("7) Realizar todas las operaciones");
        System.out.println("8) Salir");
        System.out.println("_____________________________________________________________________");
        System.out.println("Formato de los números: decimales separados por un '.' (Ej: 123.456)");
        System.out.println("Escriba un número para seleccionar la opción que desees:");
    }

    /**
     * Realiza todas las operaciones disponibles en la calculadora y devuelve su resultado en forma de texto.
     * @param num1
     * @param num2
     * @param precision
     * @return texto con el resultado de realizar todas las operaciones de la calculadora realizadas sobre sus parámetros
     */
    public static String recogerResultados(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        StringBuilder textoFinal = new StringBuilder();
        textoFinal.append("El resultado de la suma es ");
        textoFinal.append(CalculadoraRedondeo.sumaRedondeo(num1,num2,precision).toString());
        textoFinal.append("\nEl resultado de la resta es ");
        textoFinal.append(CalculadoraRedondeo.restaRedondeo(num1,num2,precision).toString());
        textoFinal.append("\nEl resultado de la multiplicación es ");
        textoFinal.append(CalculadoraRedondeo.multiplicacionRedondeo(num1,num2,precision).toString());
        textoFinal.append("\nEl resultado de la división es ");
        textoFinal.append(CalculadoraRedondeo.divisionRedondeo(num1,num2,precision).toString());
        textoFinal.append("\n");
        textoFinal.append(CalculadoraRedondeo.mensajeModuloBigDecimal(num1,num2));
        textoFinal.append("\n");
        textoFinal.append(CalculadoraRedondeo.mensajeEsMayor(num1,num2));

        return textoFinal.toString();
    }

    /**
     * Limpia el texto que aparece en la consola
     */
    public void clearConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
