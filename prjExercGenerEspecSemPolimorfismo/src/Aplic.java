import fatec.poo.model.Instrutor;
import fatec.poo.model.Cliente;
import java.text.DecimalFormat;
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente objCliente = new Cliente("356.246.864-45", "Alfonso", "015");
        Instrutor objInstrutor = new Instrutor(583, "Joaquim", "011");
        DecimalFormat df = new DecimalFormat("0.00");
        
        objCliente.setAltura(1.81);
        objCliente.setPeso(65);
        objCliente.setEmail("Alfonso.Silva@algumemail.com");
        objInstrutor.setAreaAtuacao("Natação");
        objInstrutor.setEmail("JoaquimPorEnquanto@algumemail.com");
        
        
        
        System.out.println("Instrutor:\n" +
                "Identificacao: " + objInstrutor.getIdentificacao() +
                "\nNome: " + objInstrutor.getNome() +
                "\nÁrea de atuação: " + objInstrutor.getAreaAtuacao() +
                "\nTelefone: " + objInstrutor.getTelefone() +
                "\nEmail: " + objInstrutor.getEmail());
        
        System.out.println("\nCliente:" +
                "\nCPF: " + objCliente.getCpf() +
                "\nNome: " + objCliente.getNome() +
                "\nPeso: " + objCliente.getPeso() +
                "\nAltura: " + objCliente.getAltura() +
                "\nIMC: " + df.format(objCliente.calcImc()) +
                "\nTelefone: " + objCliente.getTelefone() +
                "\nEmail: " + objCliente.getEmail());
    }
    
}
