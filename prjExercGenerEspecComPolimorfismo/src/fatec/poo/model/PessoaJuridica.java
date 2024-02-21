package fatec.poo.model;

/**
 *
 * @author máquina
 */
public class PessoaJuridica extends Pessoa {
    private String cgc;
    private double taxaIncentivo;
    
    public PessoaJuridica(String nome, int anoInscricao, String cgc){
    super(nome, anoInscricao);
    this.cgc = cgc;
    }
    
    public double calcBonus(int anoAtual){
        return (taxaIncentivo * getTotalCompras()) * (anoAtual - getAnoInscricao());
    }
    
    public void setTaxaIncentivo(double porcTaxa){
        this.taxaIncentivo = porcTaxa / 100;
    }
    
    public String getCGC(){
    return cgc;
    }
    
    public double getTaxaIncentivo(){
    return taxaIncentivo;
    }
}
