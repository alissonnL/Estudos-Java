import fatec.poo.model.Circulo;
import java.util.Scanner;

/**
 *
 * @author Alisson
 */
public class Aplic {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite a unidade de medida: ");
        Circulo circle = new Circulo(entrada.next());

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
                System.out.println(circle.calcArea() + " " + circle.getUnidadeMedida());
                break;
            case 2:
                System.out.println(circle.calcPerimetro() + " " + circle.getUnidadeMedida());
                break;
            case 3:
                System.out.println(circle.calcDiametro() + " " + circle.getUnidadeMedida());
                break;
        }
      }while(opcao != 4);
        
    }
    
}
