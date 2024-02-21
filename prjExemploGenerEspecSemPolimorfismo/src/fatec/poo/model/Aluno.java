package fatec.poo.model;

/**
 *
 * @author 2D
 */
public class Aluno extends Pessoa{
    private int regEscolar;
    private double mensalidade;

    public Aluno(int regEscolar, String nome, String dataNascimento) {
        super(nome, dataNascimento);
        this.regEscolar = regEscolar;
    }

    public int getRegEscolar() {
        return regEscolar;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setRegEscolar(int regEscolar) {
        this.regEscolar = regEscolar;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
    
    
}
