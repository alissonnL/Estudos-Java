package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author 2D
 */
public class Recepcionista extends Pessoa {

    private int regFunc;
    private String turno;
    private ArrayList<Registro> registros;

    public Recepcionista(int regFunc, String nome) {
        super(nome);
        this.regFunc = regFunc;
        this.registros = new ArrayList<Registro>();
    }

    public void addRegistro(Registro registro) {
        registros.add(registro);
        registro.setRecepcionista(this);
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getRegFunc() {
        return regFunc;
    }

    public String getTurno() {
        return turno;
    }
}
