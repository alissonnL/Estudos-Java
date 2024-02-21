package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Recepcionista;
import java.sql.ResultSet;

/**
 *
 * @author 0030482213033
 */
public class DaoRecepcionista {

    private Connection conn;

    public DaoRecepcionista(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbRecepcionista(RegFunc, Nome_Rp, Endereco_Rp, Telefone_Rp, Turno_Rp) VALUES(?,?,?,?,?)");
            ps.setInt(1, recepcionista.getRegFunc());
            ps.setString(2, recepcionista.getNome());
            ps.setString(3, recepcionista.getEndereco());
            ps.setString(4, recepcionista.getTelefone());
            ps.setString(5, recepcionista.getTurno());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbRecepcionista SET"
                    + " Nome_Rp = ?,"
                    + " Endereco_Rp = ?,"
                    + " Telefone_Rp = ?,"
                    + " Turno_Rp = ?"
                    + " WHERE RegFunc = ?");
            ps.setString(1, recepcionista.getNome());
            ps.setString(2, recepcionista.getEndereco());
            ps.setString(3, recepcionista.getTelefone());
            ps.setString(4, recepcionista.getTurno());
            ps.setInt(5, recepcionista.getRegFunc());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Recepcionista consultar(int RegFunc) {
        Recepcionista d = null;

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbRecepcionista where "
            + "RegFunc = ?");

            ps.setInt(1, RegFunc);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                d = new Recepcionista(RegFunc, rs.getString("Nome_Rp"));
                d.setEndereco(rs.getString("Endereco_Rp"));
                d.setTelefone(rs.getString("Telefone_Rp"));
                d.setTurno(rs.getString("Turno_Rp"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return (d);
    }

    public void excluir(Recepcionista recepcionista) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbRecepcionista where RegFunc = ?");

            ps.setInt(1, recepcionista.getRegFunc());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}