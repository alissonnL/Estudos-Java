
import fatec.poo.model.Aluno;
import fatec.poo.model.Professor;
import java.text.DecimalFormat;

/**
 *
 * @author 2D
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        Aluno objAluno = new Aluno(1010, "Carlos Silveira", "15/03/1978");
        
        objAluno.setMensalidade(1500);
        System.out.println("Registro escolar: " + objAluno.getRegEscolar());
        System.out.println("Nome: " + objAluno.getNome());
        System.out.println("Data Nascimento: " + objAluno.getDataNascimento());
        System.out.println("Mensalidade: " + df.format(objAluno.getMensalidade()));
        
        System.out.println("\n\n");
        
        Professor objProfessor = new Professor(123321, "Alfonso", "01/06/1932");
        objProfessor.setSalario(2);
        
        System.out.println("Registro funcional: " + objProfessor.getRegFuncional());
        System.out.println("Nome: " + objProfessor.getNome());
        System.out.println("Data Nascimento: " + objProfessor.getDataNascimento());
        System.out.println("Salário: " + df.format(objProfessor.getSalario()));
        
    }
    
}
