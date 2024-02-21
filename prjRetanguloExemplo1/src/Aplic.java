import fatec.poo.model.Retangulo;

/**
 *
 * @author Alisson
 */
public class Aplic {
    public static void main(String[] args) {
        Retangulo objRet; //criação do ponteiro
        
        objRet = new Retangulo(); //instanciação do objeto da classe Retangulo
        
        //passagem de mensagens
        
        objRet.setAltura(3.0);
        objRet.setBase(4.0);
        System.out.println("Medida da altura do retângulo: " + objRet.getAltura());
        System.out.println("Medida da base do retângulo: " + objRet.getBase());
        System.out.println("Medida da área: " + objRet.calcArea());
        System.out.println("Medida do perímetro " + objRet.calcPerimetro());
        System.out.println("Medida da diagonal do quadrado: " + objRet.calcDiagonal());
    }
}