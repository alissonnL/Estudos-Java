package fatec.poo.model;

/**
 *
 * @author 0030482213017
 */
public class FuncionarioComissionado extends Funcionario {

    private double salBase;
    private double taxaComissao;
    private double totalVendas;

    public FuncionarioComissionado(int registro, String nome, String dtAdmissao, double taxaComissao) {
        super(registro, nome, dtAdmissao);
        this.taxaComissao = taxaComissao / 100;
    }

    public void setSalBase(double salBase) {
        this.salBase = salBase;
    }

    public double getSalBase() {
        return salBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void addVendas(double valorVendas) {
        this.totalVendas += valorVendas;
    }

    public double calcSalBruto() {
        return salBase + taxaComissao * totalVendas;
    }

    public double calcGratificacao() {
        if (totalVendas > 5000 && totalVendas <= 10000) {
            return calcSalBruto() + calcSalBruto() * 0.03;
        } else {
            if (totalVendas > 10000) {
                return calcSalBruto() + calcSalBruto() * 0.05;
            }
        }
        return 0;
    }

    public double calcSalLiquido() {
        return calcSalBruto() - calcDesconto() + calcGratificacao();
    }
}
