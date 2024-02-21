/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author 0030482213017
 */
public class Circulo {
    private double raio;
    
    public void setRaio(double r){
        raio = r;
    }
    
    public double getRaio(){
    return raio;
    }
    
    public double calcArea(){
    System.out.print("A medida da área é: ");
    return (Math.PI * Math.pow(raio, 2));
    }
    
    public double calcPerimetro(){
        System.out.print("A medida do perímetro é: ");
    return (2 * (Math.PI * raio));
    }
    
    public double calcDiametro(){
        System.out.print("A medida do diâmetro é: ");
    return (2*raio);
    }
    
}
