package fatec.poo.model;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author 2D
 */
public class Registro {

    private int codigo;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorHospedagem;
    private Recepcionista recepcionista;
    private Hospede hospede;
    private ArrayList<ServicoQuarto> servicosDeQuarto;
    private Quarto quarto;

    public Registro(int codigo, LocalDate dataEntrada, Recepcionista recepcionista) {
        this.codigo = codigo;
        this.dataEntrada = dataEntrada;
        this.recepcionista = recepcionista;

        servicosDeQuarto = new ArrayList<ServicoQuarto>();
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setValorHospedagem(double valorHospedagem) {
        this.valorHospedagem = valorHospedagem;
    }

    public void addServicoDeQuarto(ServicoQuarto servico) {
        servicosDeQuarto.add(servico);
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public double getValorHospedagem() {
        return valorHospedagem;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void reservarQuarto(Hospede hospede, Quarto quarto) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.quarto.reservar();
    }

    public double liberarQuarto() {
        double totalServicos = 0;

        for (int i = 0; i < servicosDeQuarto.size(); i++) {
            totalServicos += servicosDeQuarto.get(i).getValor();
        }

        double valorHospedagem = quarto.liberar(dataEntrada.until(dataSaida).getDays());
        
        this.valorHospedagem = valorHospedagem - valorHospedagem * (hospede.getTaxaDesconto() / 100) + totalServicos;

        return this.valorHospedagem;
    }

}
