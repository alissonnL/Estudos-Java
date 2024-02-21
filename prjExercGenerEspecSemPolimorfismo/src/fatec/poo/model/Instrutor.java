package fatec.poo.model;

/**
 *
 * @author 2D
 */
public class Instrutor extends Pessoa{
    private int identificacao;
    private String areaAtuacao;
    
    public Instrutor(int identificacao, String nome, String telefone){
    super(nome, telefone);
    this.identificacao = identificacao;
    }
    
    public void setAreaAtuacao(String areaAtuacao){
    this.areaAtuacao = areaAtuacao;
    }
    
    public int getIdentificacao(){
    return this.identificacao;
    }
    
    public String getAreaAtuacao(){
    return areaAtuacao;
    }
}
