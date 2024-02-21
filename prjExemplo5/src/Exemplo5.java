
/**
 *
 * @author 0030482213017
 */
public class Exemplo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double numero, resultado;
        int x = 1;
        numero = Math.random() * 100;

        while (x <= 10) {
            resultado = numero * x;
            System.out.println(numero + " x " + x + " = " + resultado);
            x++;
        }
    }

}
