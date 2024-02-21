package fatec.poo.control;

import fatec.poo.model.Hospede;
import fatec.poo.model.Quarto;
import fatec.poo.model.Recepcionista;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Registro;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author Caio Gomes Silva
 */
public class DaoRegistro {

    private Connection conn;
      
    public DaoRegistro(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbRegistro(Codigo, dataEntrada_Rg, "
                    + "RegFuncRecepcionista, CPFHospede, NumeroQuarto) VALUES(?,?,?,?,?)");
            ps.setInt(1, registro.getCodigo());
            ps.setDate(2, Date.valueOf(registro.getDataEntrada()));
            ps.setInt(3, registro.getRecepcionista().getRegFunc());
            ps.setString(4, registro.getHospede().getCpf());
            ps.setInt(5, registro.getQuarto().getNumero());

            ps.execute();
                        
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbRegistro SET"
                    + " DataSaida_Rg = ?,"
                    + " ValorHospedagem_Rg = ?"
                    + " WHERE Codigo = ?");
            ps.setDate(1, Date.valueOf(registro.getDataSaida()));
            ps.setDouble(2, registro.getValorHospedagem());
            ps.setInt(3, registro.getCodigo());

            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Registro consultar(int codigo) {
        Registro d = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbRegistro WHERE "
                    + "Codigo = ?");

            ps.setInt(1, codigo);

            Conexao conexao = new Conexao("BD2213017", "BD2213017");
            conexao.setDriver("oracle.jdbc.driver.OracleDriver");
            conexao.setConnectionString("jdbc:oracle:thin:@ 192.168.1.6:1521:xe");
            DaoRecepcionista daoRecepcionista = new DaoRecepcionista(conexao.conectar());
            DaoQuarto daoQuarto = new DaoQuarto(conexao.conectar());
            DaoHospede daoHospede = new DaoHospede(conexao.conectar());

            ResultSet rs = ps.executeQuery();

            Recepcionista rp;
            Hospede hp;
            Quarto qt;

            if (rs.next() == true) {

                rp = daoRecepcionista.consultar(rs.getInt("RegFuncRecepcionista"));
                hp = daoHospede.consultar(rs.getString("CPFHospede"));
                qt = daoQuarto.consultar(rs.getInt("NumeroQuarto"));

                d = new Registro(codigo, (rs.getDate("DataEntrada_Rg").toLocalDate()), rp);
                d.setHospede(hp);
                d.setQuarto(qt);
                
                if(rs.getDate("DataSaida_Rg") != null && rs.getDouble("valorHospedagem_Rg") != 0){
                    d.setDataSaida(rs.getDate("DataSaida_Rg").toLocalDate());
                    d.setValorHospedagem(rs.getDouble("valorHospedagem_Rg"));
                }
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (d);
    }

    public void excluir(Registro registro) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbRegistro WHERE Codigo = ?");

            ps.setInt(1, registro.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
