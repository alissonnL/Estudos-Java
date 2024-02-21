package fatec.poo.model;

/**
 *
 * @author máquina
 */
public class PessoaFisica extends Pessoa {
    private String cpf;
    private double base;
    
    public PessoaFisica(String nome, int anoInscricao, String cpf){
    super(nome, anoInscricao);
    this.cpf = cpf;
    }
    
    public double calcBonus(int anoAtual){
        if(super.getTotalCompras() > 12000){
            return (anoAtual - super.getAnoInscricao()) * base;
        }else{
        return 0;
        }
    }
    
    public String getCPF(){
    return cpf;
    }
    
    public void setBase(double base){
    this.base = base;
    }
    
    public double getBase(){
    return base;
    }
}
