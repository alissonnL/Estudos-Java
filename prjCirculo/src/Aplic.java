import fatec.poo.model.Circulo;
import java.util.Scanner;

/**
 *
 * @author Alisson
 */
public class Aplic {
    public static void main(String[] args) {
        Circulo circle = new Circulo();
        Scanner entrada = new Scanner(System.in);
        

        int opcao;
        
        System.out.print("Digite a medida do raio: ");
        circle.setRaio(entrada.nextDouble());
        do{
        System.out.println("\n1-Calcular área do círculo.");
        System.out.println("2-Calcular o perímetro do círculo.");
        System.out.println("3-Calcular a medida do diâmetro do círculo.");
        System.out.println("4-Sair");
        System.out.print("Selecione uma opcao: ");
        opcao = entrada.nextInt();
        
        switch(opcao){
            case 1:
                System.out.println(circle.calcArea());
                break;
            case 2:
                System.out.println(circle.calcPerimetro());
                break;
            case 3:
                System.out.println(circle.calcDiametro());
                break;
        }
      }while(opcao != 4);
        
    }
    
}
