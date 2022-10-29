import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase que contiene métodos estáticos para implementar las operaciones de la calculadora:
 * -Suma, resta, división, multiplicación con redondeo
 * -Módulo de la primera cantidad con la segunda
 * -Identificar cual de los dos números pasados por parámetro es mayor o menor
 */

public class CalculadoraRedondeo {

    /**
     * Constructor privado
     * Creado para preveer que se creen instancias de esta clase ya que todos los métodos que la componen son estáticos
     */
    private CalculadoraRedondeo() {
    }

    /**
     * Devuelve la suma de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 sumando número 1
     * @param num2 sumando número 2
     * @param precision número de decimales a redondear
     * @return suma de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     */
    public static BigDecimal sumaRedondeo(BigDecimal num1, BigDecimal num2, int precision) throws NullPointerException {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        BigDecimal resultado = num1.add(num2);
        resultado = resultado.setScale(precision, RoundingMode.HALF_UP);
        return resultado;
    }

    /**
     * Devuelve la resta de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 número al que se le va a realizar la resta
     * @param num2 sustraendo de la resta
     * @param precision número de decimales a redondear
     * @return resta de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     */
    public static BigDecimal restaRedondeo(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        BigDecimal resultado = num1.subtract(num2);
        resultado = resultado.setScale(precision, RoundingMode.HALF_UP);
        return resultado;
    }

    /**
     * Devuelve la multiplicación de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 factor 1
     * @param num2 factor 2
     * @param precision número de decimales a redondear
     * @return multiplicación de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     */
    public static BigDecimal multiplicacionRedondeo(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        BigDecimal resultado = num1.multiply(num2);
        resultado = resultado.setScale(precision, RoundingMode.HALF_UP);
        return resultado;
    }
    /**
     * Devuelve la división de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 dividendo
     * @param num2 dividor
     * @param precision número de decimales a redondear
     * @return división de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     */
    public static BigDecimal divisionRedondeo(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        BigDecimal resultado = num1.divide(num2, precision, RoundingMode.HALF_UP);
        return resultado;
    }

    /**
     * Comprueba si num1 es módulo de num2
     * @param num1 número a realizar el módulo
     * @param num2 módulo
     * @return esModulo = true: si num1 módulo num2 == 0
     *         esModulo = false: si num1 módulo num2 != 0
     */
    public static boolean moduloBigDecimal(BigDecimal num1, BigDecimal num2) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        boolean esModulo = false;
        if(num1.remainder(num2).compareTo(BigDecimal.ZERO) == 0 ) {
            esModulo = true;
        }

        return esModulo;
    }

    /**
     * Crea un String describiendo si num1 es módulo de num2
     * @param num1
     * @param num2
     * @return mensajeEsModulo: String que contiene en forma de texto si num1 es módulo de num2
     */
    public static String mensajeModuloBigDecimal(BigDecimal num1, BigDecimal num2) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        String mensajeEsModulo = "";

        if(CalculadoraRedondeo.moduloBigDecimal(num1,num2)) {
            mensajeEsModulo = num1.toString() + " es módulo de " + num2.toString();
        } else {
            mensajeEsModulo = num1.toString() + " no es módulo de " + num2.toString();
        }

        return mensajeEsModulo;
    }

    /**
     * Crea un String describiendo si num1 es mayor, menos o de igual valor que num2
     * @param num1
     * @param num2
     * @return mensajeMayorMenorIgual: String que contiene en forma de texto si num1 es mayor, menor o de igual valor de num2
     */
    public static String mensajeEsMayor(BigDecimal num1, BigDecimal num2) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        int valorComparacion = -1;
        String mensajeMayorMenorIgual = "";

        valorComparacion = num1.compareTo(num2);
        if(valorComparacion == 1) {
            mensajeMayorMenorIgual = num1.toString() + " es mayor que " + num2.toString();
        } else if (valorComparacion == -1) {
            mensajeMayorMenorIgual = num2.toString() + " es mayor que " + num1.toString();
        } else {
            mensajeMayorMenorIgual = num1.toString() + " es igual que " + num2.toString();
        }

        return mensajeMayorMenorIgual;
    }

}
