import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Clase que contiene métodos estáticos para implementar las operaciones:
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
     * @param num1 multiplicante 1
     * @param num2 multiplicante 2
     * @param precision número de decimales a redondear
     * @return multiplicación de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     */
    public static BigDecimal multiplicacionRedondeo(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        BigDecimal resultado = num1.multiply(num2);
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
        BigDecimal resultado = num1.divide(num2,precision);
        resultado = resultado.setScale(precision, RoundingMode.HALF_UP);
        return resultado;
    }

    public static boolean modulo(BigDecimal num1, BigDecimal num2) {
        boolean esModulo = false;
        if(num1.remainder(num2).compareTo(BigDecimal.ZERO) == 0 ) {
            esModulo = true;
        }

        return esModulo;
    }

    public static String recogerResultados(BigDecimal num1, BigDecimal num2, int precision) {
        if((num1==null) || (num2 == null)) { //Comprobación de parámetros de entrada
            throw new NullPointerException();
        }
        StringBuilder textoFinal = new StringBuilder();
        return textoFinal.toString();
    }

}
