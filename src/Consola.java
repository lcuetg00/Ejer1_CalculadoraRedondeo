import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;

/**
 * Clase encargada de la interacción con el usuario
 * Lee las entradas del usuario para realizar las operacones necesarias
 */
public class Consola {
    //Opciones del menú
    /**
     * Representa la opción de sumar en el menú
     */
    public static final int OPCIONSUMA = 1;
    /**
     * Representa la opción de restar en el menú
     */
    public static final int OPCIONRESTA = 2;
    /**
     * Representa la opción de multiplicar en el menú
     */
    public static final int OPCIONMULTIPLICACION = 3;
    /**
     * Representa la opción de dividir en el menú
     */
    public static final int OPCIONDIVISION = 4;
    /**
     * Representa la opción de comprobar el módulo de dos números en el menú
     */
    public static final int OPCIONMODULO = 5;
    /**
     * Representa la opción de comparar dos números en el menú
     */
    public static final int OPCIONCOMPARACION = 6;
    /**
     * Representa la opción de realizar todas las operaciones que puede realizar la calculadora en el menú
     */
    public static final int OPCIONTODAS = 7;
    /**
     * Representa la opción de salir de la aplicación en el menú
     */
    public static final int OPCIONSALIR = 8;

    //Formato de texto
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que el texto escrito tengan un fondo verde.
     */
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tengan un fondo amarillo.
     */
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; //Para que el texto tenga un fondo amarillo
    /**
     * Utilizada al imprimir por pantalla caracteres.
     * Hace que texto escrito tenga el formato por defecto.
     */
    public static final String ANSI_RESET = "\u001B[0m"; //Para devolver el texto a la normalidad
    /**
     * Retorno de carro proporcionado por el sistema que se esté utilizando
     */
    public static final String RETORNO_CARRO = System.getProperty("line.separator");

    /**
     * Inicia la interfaz de la consola.
     * Presenta el menú al usuario, lee sus entradas y realiza las operaciones necesarias
     */
    public void iniciarConsola() {
        Scanner scanner = new Scanner(System.in);
        //Almacenará la opción del menú que introducirá el usuario
        int opcion = 0;
        //Almacenará la precisión de los decimales que seleccione el usuario
        int precision = 0;
        //Primer número introducido por teclado
        BigDecimal num1;
        //Segundo número introducido por teclado
        BigDecimal num2;
        //Instancia que contendrá el número final de la operación seleccionada en suma,resta,multiplicacion y division
        BigDecimal resultado;

        System.out.println("Ejercicio 1:");
        imprimirMenu();

        while (opcion != OPCIONSALIR) {
            try {
                //Leemos la operación que quiere realizar el usuario
                opcion = scanner.nextInt();

                switch (opcion) {
                    case OPCIONSUMA:
                        System.out.println("Operación de suma");
                        System.out.println("Inserte el primer sumando");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo sumando");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();
                        resultado = CalculadoraRedondeo.sumaRedondeo(precision, num1, num2);

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + "El resultado de la suma es " + resultado.toString() + ANSI_RESET);
                        break;

                    case OPCIONRESTA:
                        System.out.println("Operación de resta");
                        System.out.println("Inserte el minuendo de la resta");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el sustraendo de la resta");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();
                        resultado = CalculadoraRedondeo.restaRedondeo(num1, num2, precision);

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + "El resultado de la resta es " + resultado.toString() + ANSI_RESET);
                        break;

                    case OPCIONMULTIPLICACION:
                        System.out.println("Operación de multiplicación");
                        System.out.println("Inserte el primer número a multiplicar");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número a multiplicar");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();
                        resultado = CalculadoraRedondeo.multiplicacionRedondeo(num1, num2, precision);

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + "El resultado de la multiplicación es " + resultado.toString() + ANSI_RESET);
                        break;

                    case OPCIONDIVISION:
                        System.out.println("Operación de division");
                        System.out.println("Inserte el dividendo de la división");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el divisor de la multiplicación");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();
                        resultado = CalculadoraRedondeo.divisionRedondeo(num1, num2, precision);

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + "El resultado de la división es " + resultado.toString() + ANSI_RESET);
                        break;

                    case OPCIONMODULO:
                        System.out.println("Operación de módulo");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el número para el módulo de la operación");
                        num2 = new BigDecimal(scanner.next());

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + this.mensajeModuloBigDecimal(num1, num2) + ANSI_RESET);
                        break;

                    case OPCIONCOMPARACION:
                        System.out.println("Operación comparación de números");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número");
                        num2 = new BigDecimal(scanner.next());

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + this.mensajeEsMayor(num1, num2) + ANSI_RESET);
                        break;


                    case OPCIONTODAS:
                        System.out.println("Realizar todas las operaciones");
                        System.out.println("Inserte el primer número");
                        num1 = new BigDecimal(scanner.next());
                        System.out.println("Inserte el segundo número");
                        num2 = new BigDecimal(scanner.next());
                        System.out.println("Inserte la precisión de los decimales");
                        precision = scanner.nextInt();

                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_GREEN_BACKGROUND + this.recogerResultados(num1, num2, precision) + ANSI_RESET);
                        break;

                    case OPCIONSALIR:
                        System.out.println(ANSI_GREEN_BACKGROUND + "Saliendo del programa" + ANSI_RESET);
                        break;

                    default:
                        this.escribirMensajeFinalConsolaYVolverMenu(ANSI_YELLOW_BACKGROUND + "Opción tecleada incorrecta. Seleccione una opción con un número del 1 al 8" + ANSI_RESET);

                }
            //Ocurre cuando metemos un caracter dierente a un número
            } catch (InputMismatchException e) {
                this.escribirMensajeFinalConsolaYVolverMenu(ANSI_YELLOW_BACKGROUND + "Opción tecleada incorrecta. Seleccione una de las opciones disponibles" + ANSI_RESET);
                scanner.nextLine();

             //Formato de los numeros decimales
            } catch (NumberFormatException e) {
                this.escribirMensajeFinalConsolaYVolverMenu(ANSI_YELLOW_BACKGROUND + "Formato incorrecto del número. Se ha vuelto al menú principal" + ANSI_RESET);
                scanner.nextLine();
            } catch (InvalidParameterException e){
                System.out.println(e.toString());
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
     * Limpia la pantalla, escribe el menú inicial y añade un último mensaje a continuación
     * @param mensajeFinal mensaje de texto
     * @throws NullPointerException si mensajeFinal es null
     */
    public void escribirMensajeFinalConsolaYVolverMenu(final String mensajeFinal) throws NullPointerException{
        if(mensajeFinal == null) {
            throw new NullPointerException("En el método escribirMensajeFinalConsolaYVolverMenu de la clase consola el String argumentado es null");
        }
        this.clearConsola();
        this.imprimirMenu();
        System.out.println(mensajeFinal);
        System.out.println("Seleccione otra opción del menú");
    }

    /**
     * Realiza todas las operaciones disponibles en la calculadora y devuelve su resultado en forma de texto.
     * @param num1
     * @param num2
     * @param precision
     * @return texto con el resultado de realizar todas las operaciones de la calculadora realizadas sobre sus parámetros
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public String recogerResultados(final BigDecimal num1, final BigDecimal num2, final int precision) throws NullPointerException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException();
        }

        StringBuilder textoFinal = new StringBuilder();
        textoFinal.append("El resultado de la suma es " + CalculadoraRedondeo.sumaRedondeo(num1,num2,precision) + RETORNO_CARRO);
        textoFinal.append("El resultado de la resta es " +CalculadoraRedondeo.restaRedondeo(num1,num2,precision) + RETORNO_CARRO);
        textoFinal.append("El resultado de la multiplicación es " + CalculadoraRedondeo.multiplicacionRedondeo(num1,num2,precision) + RETORNO_CARRO);
        textoFinal.append("El resultado de la división es " + CalculadoraRedondeo.divisionRedondeo(num1,num2,precision) + RETORNO_CARRO);
        textoFinal.append(this.mensajeModuloBigDecimal(num1,num2) + RETORNO_CARRO);
        textoFinal.append(this.mensajeEsMayor(num1,num2) + RETORNO_CARRO);

        return textoFinal.toString();
    }

    /**
     * Limpia el texto que aparece en la consola
     */
    public void clearConsola() {
        try {
            final String os = System.getProperty("os.name");

            if(os.contains("Windows")) { //Para sistemas de Windows
                //Para windos, ejecutamos el interpretador de lineas 'cmd'
                //Luego le decimos que ejecute el comando '/c cls'
                //Conectamos el output de ese comando con inheritIO() para limpiar la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            //Probarlo en otros sistemas operativos
            //else { //Para cualquier otro sistema operativo
            //    Runtime.getRuntime().exec("clear");
            //}

        //Error producido en la entrada o salida
        } catch (final Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Crea un String describiendo si num1 es módulo de num2
     * @param num1
     * @param num2
     * @return mensajeEsModulo: String que contiene en forma de texto si num1 es módulo de num2
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static String mensajeModuloBigDecimal(final BigDecimal num1, final BigDecimal num2) throws InvalidParameterException {
        return (CalculadoraRedondeo.moduloBigDecimal(num1,num2)) ?  num1 + " es módulo de " + num2 : num1 + " no es módulo de " + num2;
    }

    /**
     * Crea un String describiendo si num1 es mayor, menos o de igual valor que num2
     * @param num1
     * @param num2
     * @return mensajeMayorMenorIgual: String que contiene en forma de texto si num1 es mayor, menor o de igual valor de num2
     * @throws NullPointerException alguno de sus parámetros es null
     */
    public static String mensajeEsMayor(final BigDecimal num1, final BigDecimal num2) throws InvalidParameterException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException();
        }
        int valorComparacion = num1.compareTo(num2);
        String mensajeMayorMenorIgual = "";

        if(valorComparacion == 1) {
            mensajeMayorMenorIgual = num1 + " es mayor que " + num2;
        } else if (valorComparacion == -1) {
            mensajeMayorMenorIgual = num2 + " es mayor que " + num1;
        } else {
            mensajeMayorMenorIgual = num1 + " es igual que " + num2;
        }

        return mensajeMayorMenorIgual;
    }

}
