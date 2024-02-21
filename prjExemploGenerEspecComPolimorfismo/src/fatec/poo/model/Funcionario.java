package fatec.poo.model;

/**
 *
 * @author 2D
 */
public abstract class Funcionario {

    private int registro;
    private String nome;
    private String dtAdmissao;
    private String cargo;

    public Funcionario(int registro, String nome, String dtAdmissao) {
        this.registro = registro;
        this.nome = nome;
        this.dtAdmissao = dtAdmissao;
    }

    abstract public double calcSalBruto(); //abstract significa que o método não vai ter corpo

    public double calcDesconto() {
        return 0.1 * calcSalBruto();
    }

    public double calcSalLiquido() {
        return calcSalBruto() - calcDesconto();
    }

    public int getRegistro() {
        return this.registro;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDtAdmissao() {
        return this.dtAdmissao;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }
}
