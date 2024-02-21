/**
 *
 * @author Alisson
 */
public class Exemplo3 {
    public static void main(String[] args) {
        double numero;
        
        numero = Math.random() * 100;
        
        if(numero > 50){
            System.out.println("O número " + numero + " é maior que 50");
        }else{
            System.out.println("O número " + numero + " é menor ou igual a 50");
        }
    }
}
