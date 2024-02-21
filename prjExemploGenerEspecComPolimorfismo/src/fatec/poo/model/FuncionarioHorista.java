package fatec.poo.model;
/**
 *
 * @author 2D
 */
public class FuncionarioHorista extends Funcionario {
    private double valHorTrab;
    private int qtdHorTrab;
    
    public FuncionarioHorista(int registro, String nome, String dtAdmissao, double valorHorTrab){
    super(registro, nome, dtAdmissao); // construtor da superclasse Funcionario;
    this.valHorTrab = valorHorTrab;
    }
    
    public void setQtdeHorTrab(int qtdHorTrab){
    this.qtdHorTrab = qtdHorTrab;
    }
    
    public double calcSalBruto(){
        return valHorTrab * qtdHorTrab;
    }
    
    public double calcGratificacao(){
    return calcSalBruto() * 0.075;
    }
    
    //aplicação do polimorfismo alterando o método
    public double calcSalLiquido(){
    return super.calcSalLiquido() + calcGratificacao();
    }
}

