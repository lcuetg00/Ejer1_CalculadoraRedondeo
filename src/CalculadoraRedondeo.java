import java.lang.Math;
import java.math.BigDecimal;
import java.math.MathContext;

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
     * Devuelve la suma de dos double redondeados al número de decimales especificado en el parámetro 'redondeo'
     * @param num1 sumando número 1
     * @param num2 sumando número 2
     * @param redondeo número de decimales a redondear
     * @return suma de num1 y num2 redondeado al número de decimales del parámetro 'redondeo'
     */
    public static BigDecimal sumaRedondeo(BigDecimal num1, BigDecimal num2, MathContext redondeo) {
        BigDecimal resultado = num1.add(num2,redondeo);
        return resultado;
    }

    public static BigDecimal restaRedondeo(BigDecimal num1, BigDecimal num2, MathContext redondeo) {
        BigDecimal resultado = num1.subtract(num2,redondeo);
        return resultado;
    }

    public static BigDecimal multiplicacionRedondeo(BigDecimal num1, BigDecimal num2, MathContext redondeo) {
        BigDecimal resultado = num1.multiply(num2,redondeo);
        return resultado;
    }

    public static BigDecimal divisionRedondeo(BigDecimal num1, BigDecimal num2, MathContext redondeo) {
        BigDecimal resultado = num1.divide(num2,redondeo);
        return resultado;
    }

    //public static BigDecimal modulo(BigDecimal num1, BigDecimal num2) {

    //}

    public static String recogerResultados(BigDecimal num1, BigDecimal num2, MathContext redondeo) {
        return "";
    }

}
