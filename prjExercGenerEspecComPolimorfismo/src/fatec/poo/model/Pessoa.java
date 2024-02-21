package fatec.poo.model;

/**
 *
 * @author máquina
 */
abstract public class Pessoa {
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    
    public Pessoa(String nome, int anoInscricao){
    this.nome = nome;
    this.anoInscricao = anoInscricao;
    }
    
    abstract public double calcBonus(int bonus);
    
    public void addCompras(double compras){
    this.totalCompras += totalCompras;
    }
    
    public String getNome(){
    return nome;
    }
    
    public int getAnoInscricao(){
    return anoInscricao;
    }
    
    public double getTotalCompras(){
    return totalCompras;
    }
}
