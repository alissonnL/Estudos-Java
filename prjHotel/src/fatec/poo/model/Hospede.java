package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author 2D
 */
public class Hospede extends Pessoa {

    private String cpf;
    private double taxaDesconto;
    private ArrayList<Registro> registros;

    public Hospede(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;

        registros = new ArrayList<Registro>();
    }

    public void addRegistro(Registro registro) {
        registros.add(registro);
        registro.setHospede(this);
    }

    public void setTaxaDesconto(double taxaDesconto) {
        this.taxaDesconto = taxaDesconto / 100;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTaxaDesconto() {
        return taxaDesconto * 100;
    }
    
    public static boolean validarCPF(String cpf){
        int pVerificador = 0;
        for(int i = 0; i < 9; i++){
            pVerificador += Character.getNumericValue(cpf.charAt(i)) * (i + 1);
        }
        pVerificador = pVerificador % 11;
        if (pVerificador == 10){
            pVerificador = 0;
        }
        
        int aux = 0;
        int sVerificador = 0;
        for(int i = 11; i >= 2; i--){
            if(i == 2){
                sVerificador += pVerificador * 2;
            }else{
            sVerificador += Character.getNumericValue(cpf.charAt(aux)) * i;
            aux++;
            }
        }
        sVerificador = (sVerificador * 10) % 11;
        if(sVerificador == 10){
            sVerificador = 0;
        }
        
        if(Character.getNumericValue(cpf.charAt(9)) == pVerificador && Character.getNumericValue(cpf.charAt(10)) == sVerificador){
            return true;
        }else{
            return false;
        }
        
    }
}
