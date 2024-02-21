
import java.text.DecimalFormat;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.FuncionarioComissionado;

/**
 *
 * @author 2D
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        FuncionarioHorista funcHor = new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978", 15.8);
        FuncionarioMensalista funcMen = new FuncionarioMensalista(2020, "Joaquim por enquanto", "22/09/1925", 600.0);
        FuncionarioComissionado funcCom = new FuncionarioComissionado(3030, "Alfonso Pereira", "30/12/2002", 10);

        funcHor.setQtdeHorTrab(90);
        funcHor.setCargo("Gerente");

        System.out.println("Registro => "+ funcHor.getRegistro());
        System.out.println("Nome => " + funcHor.getNome());
        System.out.println("Data de admissão => " + funcHor.getDtAdmissao());
        System.out.println("Cargo => " + funcHor.getCargo());
        System.out.println("Salário Bruto => " + df.format(funcHor.calcSalBruto()));
        System.out.println("Desconto => " + df.format(funcHor.calcDesconto()));
        System.out.println("Salário Líquido => " + df.format(funcHor.calcSalLiquido()));
        System.out.println("Gratificação => " + funcHor.calcGratificacao());


        System.out.println();

        funcMen.setNumSalMin(2.5);
        funcMen.setCargo("Aprendiz");
        
        System.out.println("Registro => "+ funcMen.getRegistro());
        System.out.println("Nome => " + funcMen.getNome());
        System.out.println("Salário Bruto => " + df.format(funcMen.calcSalBruto()));
        System.out.println("Desconto => " + df.format(funcMen.calcDesconto()));
        System.out.println("Salário Líquido => " + df.format(funcMen.calcSalLiquido()));
        System.out.println("Cargo => " + funcMen.getCargo());

        funcCom.setSalBase(900);
        funcCom.addVendas(1000);
        funcCom.addVendas(7000);
        System.out.println("\nRegistro => " + funcCom.getRegistro());
        System.out.println("Nome => " + funcCom.getNome());
        System.out.println("Salário Bruto => " + df.format(funcCom.calcSalBruto()));
        System.out.println("Desconto => " + df.format(funcCom.calcDesconto()));
        System.out.println("Taxa de comissão => " + funcCom.getTaxaComissao() * 100 + "%");
        System.out.println("Total de Vendas => " + df.format(funcCom.getTotalVendas()));
        System.out.println("Gratificação => " + df.format(funcCom.calcGratificacao()));
        System.out.println("Salário Líquido => " + df.format(funcCom.calcSalLiquido()));
        
    }
    
    
}
