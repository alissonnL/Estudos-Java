package fatec.poo.model;

/**
 *
 * @author 2D
 */
public class Quarto {

    private int numero;
    private String tipo;
    private boolean situacao;
    private double valorDiaria;
    private double totalFaturado;
    private boolean acessibilidade;

    public Quarto(int numero, String tipo, double valorDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
        this.situacao = false;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setTotalFaturado(double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public void reservar() {
        this.situacao = true;
    }

    public double liberar(int qtdeDias) {
        situacao = false;
        totalFaturado += qtdeDias * valorDiaria;
        return qtdeDias * valorDiaria;
    }

    public int getNumero() {
        return numero;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setValorDiaria(Double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    
    public void setAcessibilidade(boolean acessibilidade){
        this.acessibilidade = acessibilidade;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double getTotalFaturado() {
        return totalFaturado;
    }
    
    public boolean getAcessibilidade(){
        return acessibilidade;
    }

}
