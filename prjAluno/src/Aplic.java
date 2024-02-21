import fatec.poo.model.Aluno;
import java.util.Scanner;

/**
 *
 * @author 2D
 */
public class Aplic {

    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        Scanner entrada = new Scanner(System.in);
        int ra, opcao;
        
        System.out.print("Digite o RA: ");
        ra = entrada.nextInt();
        aluno.setRA(ra);
        System.out.print("Digite a nota da primeira prova: ");
        aluno.setNtPrv1(entrada.nextDouble());
        System.out.print("Digite a nota da segunda prova: ");
        aluno.setNtPrv2(entrada.nextDouble());

        System.out.print("Digite a nota do primeiro trabalho: ");
        aluno.setNtTrab1(entrada.nextDouble());
        System.out.print("Digite a nota do segundo trabalho: ");
        aluno.setNtTrab2(entrada.nextDouble());
        
        do{
            System.out.print("\n1-Exibir Nota das Provas/Trabalhos" +
                    "\n2-Exibir Média dos Trabalhos/Provas" +
                    "\n3-Exibir Média Final" +
                    "\n4-Sair" +
                    "\n\nDigite uma opção: "
                    );
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 1:
                System.out.println(
                  "\nNota da prova 1: " + aluno.getNtPrv1()
                + "\nNota da prova 2: " + aluno.getNtPrv2()
                + "\nNota do trabalho 1: " + aluno.getNtTrab1()
                + "\nNota do trabalho 2: " + aluno.getNtTrab2()
                );
                break;
            case 2:
                System.out.println(
                  "\nNota da prova 1: " + aluno.getNtPrv1()
                + "\nNota da prova 2: " + aluno.getNtPrv2()
        }
        }while(opcao != 4);
    }
    
    
}
 