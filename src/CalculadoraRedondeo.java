/**
 * Clase que contiene métodos estáticos para implementar las operaciones:
 * -Suma, resta, división, multiplicación con redondeo
 * -Módulo de la primera cantidad con la segunda
 * -Identificar cual de los dos números pasados por parámetro es mayor o menor
 */

public class CalculadoraRedondeo {

    /**
     * Constructor privado
     * Creado para preveer que el usuario cree instancias de esta clase ya que todos los métodos que la componen son estáticos
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
    public static double sumaRedondeo(Double num1, Double num2, Integer redondeo) {
        //Comprobación de null en los parámetros
        if((num1 == null) || (num2 == null) || (redondeo == null)) {
            throw new NullPointerException("Error en método sumaRedondeo de la clase CalculadoraRedondeo: Uno de los parámetros es null");
        }
        double resultado = 0; //Variable que almacenará el resultado de la suma
        System.out.println("Sumando");
        return resultado;
    }

    public static double restaRedondeo(Double num1, Double num2, Integer redondeo) {
        //Comprobación de null en los parámetros
        if((num1 == null) || (num2 == null) || (redondeo == null)) {
            throw new NullPointerException("Error en método restaRedondeo de la clase CalculadoraRedondeo: Uno de los parámetros es null");
        }
        double resultado = 0;
        System.out.println("Restando");
        return resultado;
    }


    public static String recogerResultados(Double num1, Double num2, Integer redondeo) {
        return "";
    }

}
