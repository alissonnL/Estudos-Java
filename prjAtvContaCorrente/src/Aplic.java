
import fatec.poo.model.ContaCorrente;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author 2D
 */
public class Aplic {

    public static void main(String[] args) {
        ContaCorrente[] contas = new ContaCorrente[15];
        Scanner entrada = new Scanner(System.in);
        byte opcao;
        DecimalFormat df = new DecimalFormat("#,##0.00");

        for (int i = 0; i < contas.length; i++) {
            int conta;
            double saldoInicial;

            System.out.print("Digite o número da conta " + (i + 1) + ": ");
            conta = entrada.nextInt();
            System.out.print("Digite o saldo inicial da conta " + (i + 1) + ": ");
            saldoInicial = entrada.nextDouble();

            contas[i] = new ContaCorrente(conta, saldoInicial);
        }

        do {
            System.out.println("\n\n1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Listar Contas");
            System.out.println("5 - Sair");
            System.out.print("\nDigite uma opção: ");
            opcao = entrada.nextByte();
            int conta;
            byte cont = 0;

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o número da conta: ");
                    conta = entrada.nextInt();

                    for (byte index = 0; index < contas.length; index++) {
                        if (conta == contas[index].getNumero()) {
                            System.out.print("Digite o valor de saque: ");
                            double valor = entrada.nextDouble();
                            if (!(valor > contas[index].getSaldo())) {
                                contas[index].sacar(valor);
                            } else {
                                System.out.println("\nSaldo Insuficiente.");
                            }
                        } else {
                            if (index == (contas.length - 1)) {
                                System.out.println("\nConta não cadastrada.");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nDigite o número da conta: ");
                    conta = entrada.nextInt();

                    for (byte index = 0; index < contas.length; index++) {
                        if (conta == contas[index].getNumero()) {
                            System.out.print("\nDigite o valor de depósito: ");
                            contas[index].depositar(entrada.nextDouble());
                        } else {
                            if (index == (contas.length - 1)) {
                                System.out.println("\nConta não cadastrada.");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nDigite o número da conta: ");
                    conta = entrada.nextInt();
                    for (byte index = 0; index < contas.length; index++) {
                        if (conta == contas[index].getNumero()) {
                            System.out.println(df.format(contas[index].getSaldo()));
                        } else {
                            if (index == (contas.length - 1)) {
                                System.out.println("\nConta não cadastrada.");

                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nNúmero da conta\tSaldo");
                    for (byte index = 0; index < contas.length; index++) {
                        System.out.println("    " + contas[index].getNumero() + "\t\t" + df.format(contas[index].getSaldo()));
                    }
            }
        } while (opcao != 5);
    }

}
