
package fatec.poo.model;

/**
 *
 * @author 2D
 */
public class Aluno {
    private int ra;
    private double ntPrv1;
    private double ntPrv2;
    private double ntTrab1;
    private double ntTrab2;
    
    public void setRA(int num){
    ra = num;
    }
    
    public void setNtPrv1(double nota){
    ntPrv1 = nota;
    }
    
    public void setNtPrv2(double nota){
    ntPrv2 = nota;
    }
    
    public void setNtTrab1(double nota){
    ntTrab1 = nota;
    }
    
    public void setNtTrab2(double nota){
    ntTrab2 = nota;
    }
    
    public int getRA(){
        return ra;
    }
    
    public double getNtPrv1(){
    return ntPrv1;
    }
    
    public double getNtPrv2(){
    return ntPrv2;
    }
    
    public double getNtTrab1(){
    return ntTrab1;
    }
    
    public double getNtTrab2(){
    return ntTrab2;
    }
    
    public double calcMediaProva(){
        return (0.75 * ntPrv1) + (2 * ntPrv2) / 3;
    }
    
    public double calcMediaTrab(){
        return 0.25 * (ntTrab1 + ntTrab2) / 2;
    }
    
    public double calcMediaFinal(){
    return calcMediaProva() + calcMediaTrab();
    }
}
