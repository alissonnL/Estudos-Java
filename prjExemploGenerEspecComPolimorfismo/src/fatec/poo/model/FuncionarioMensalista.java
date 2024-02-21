package fatec.poo.model;

/**
 *
 * @author 2D
 */
public class FuncionarioMensalista extends Funcionario {
    private double valSalMin;
    private double numSalMin;
   
    
    public FuncionarioMensalista(int registro, String nome, String dtAdmissao, double valSalMin){
    super(registro, nome, dtAdmissao);
    this.valSalMin = valSalMin;
    }
    
    public void setNumSalMin(double numSalMin){
    this.numSalMin = numSalMin;
    }
    

    
    public double calcSalBruto(){
    return valSalMin * numSalMin;
    }
}
