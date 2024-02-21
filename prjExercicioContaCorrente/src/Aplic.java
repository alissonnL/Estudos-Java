
import fatec.poo.model.ContaCorrente;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author 0030482213017
 */
public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("###0.00");
        int numConta;
        double saldo;
        byte opcao;

        System.out.print("Digite o número da conta: ");
        numConta = entrada.nextInt();
        System.out.print("Digite o saldo inicial: ");
        saldo = entrada.nextDouble();

        ContaCorrente conta = new ContaCorrente(numConta, saldo);

        do {
            System.out.print("\n1-Depositar"
                    + "\n2-Sacar"
                    + "\n3-Consultar Saldo"
                    + "\n4-Sair"
                    + "\n\nDigite a opção: "
            );
            opcao = entrada.nextByte();

            switch (opcao) {
                case 1:
                    System.out.println("Conta: " + conta.getNumero());
                    System.out.print("Valor de depósito: ");
                    conta.depositar(entrada.nextDouble());
                    break;
                case 2:
                    System.out.println("Conta: " + conta.getNumero());
                    System.out.print("Valor de saque: ");
                    conta.sacar(entrada.nextDouble());
                    break;
                case 3:
                    System.out.println("Conta: " + conta.getNumero());
                    System.out.println("Saldo: " + df.format(conta.getSaldo()));
                    break;
            }
        } while (opcao != 4);
    }

}
