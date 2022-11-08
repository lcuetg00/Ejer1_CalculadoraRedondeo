import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;

/**
 * Clase que contiene métodos estáticos para implementar las operaciones de la calculadora:
 * -Suma, resta, división, multiplicación con redondeo
 * -Módulo de la primera cantidad con la segunda
 * -Identificar cual de los dos números pasados por parámetro es mayor o menor
 */

public class CalculadoraRedondeo {

    /**
     * Constructor privado
     * Creado para prevenir que se creen instancias de esta clase ya que todos los métodos que la componen son estáticos
     */
    private CalculadoraRedondeo() {
    }


    /**
     * Devuelve la suma de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 sumando número 1
     * @param num2 sumando número 2
     * @param precision número de decimales a redondear
     * @return suma de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static BigDecimal sumaRedondeo(final BigDecimal num1, final BigDecimal num2, final int precision) throws InvalidParameterException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo alguno de sus parámetros es null");
        }
        return num1.add(num2).setScale(precision, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve la suma de números decimales contenidos en un array de string. Redondea el resultado utilizando el parámetro 'precision'
     * @param valores array de string con los números decimales
     * @param precision número de decimales a redondear
     * @throws InvalidParameterException si 'valores' es null
     *                                   si el tamaño de 'valores' tamaño es 1 o menos que 1
     *                                   si alguno de los elementos de 'valores' es null
     * @return
     */
    public static BigDecimal sumaRedondeo(final int precision, final BigDecimal ... valores) throws InvalidParameterException {
        if((valores == null) || (valores.length <=1)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo(int precision, BigDecimal ...) la lista no puede contener 1 o menos de 1 valor");
        }
        BigDecimal resultado = BigDecimal.ZERO;

        for(BigDecimal valoresDecimales : valores) {
            if(valoresDecimales == null) { //Si alguno de sus valores es null
                throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo(int precision, BigDecimal ...) valores puede contener valores null");
            }
            resultado = resultado.add(valoresDecimales);
        }

        return resultado.setScale(precision, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve la resta de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 número al que se le va a realizar la resta
     * @param num2 sustraendo de la resta
     * @param precision número de decimales a redondear
     * @return resta de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static BigDecimal restaRedondeo(final BigDecimal num1, final BigDecimal num2, final int precision) throws InvalidParameterException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo alguno de sus parámetros es null");
        }
        return num1.subtract(num2).setScale(precision, RoundingMode.HALF_UP);
    }

    /**
     * Devuelve la multiplicación de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 factor 1
     * @param num2 factor 2
     * @param precision número de decimales a redondear
     * @return multiplicación de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static BigDecimal multiplicacionRedondeo(final BigDecimal num1, final BigDecimal num2, final int precision) throws InvalidParameterException{
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo alguno de sus parámetros es null");
        }
        return num1.multiply(num2).setScale(precision, RoundingMode.HALF_UP);
    }
    /**
     * Devuelve la división de dos BigDecimal redondeados al número de decimales especificado en el parámetro 'precision'
     * @param num1 dividendo
     * @param num2 dividor
     * @param precision número de decimales a redondear
     * @return división de num1 y num2 redondeado al número de decimales especificado en el parámetro 'precision'
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static BigDecimal divisionRedondeo(final BigDecimal num1, final BigDecimal num2, final int precision) throws InvalidParameterException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo alguno de sus parámetros es null");
        }
        return num1.divide(num2, precision, RoundingMode.HALF_UP);
    }

    /**
     * Comprueba si num1 es módulo de num2
     * @param num1 número a realizar el módulo
     * @param num2 módulo
     * @return esModulo = true: si num1 módulo num2 == 0
     *         esModulo = false: si num1 módulo num2 != 0
     * @throws InvalidParameterException alguno de sus parámetros es null
     */
    public static boolean moduloBigDecimal(final BigDecimal num1, final BigDecimal num2) throws  InvalidParameterException {
        //Comprobación de parámetros de entrada
        if((num1==null) || (num2 == null)) {
            throw new InvalidParameterException("Clase CalculadoraRedondeo: sumaRedondeo alguno de sus parámetros es null");
        }
        return (num1.remainder(num2).compareTo(BigDecimal.ZERO) == 0);
    }



}
