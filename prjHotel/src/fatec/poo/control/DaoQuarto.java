
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Quarto;

/**
 *
 * @author caio
 */
public class DaoQuarto {
    private Connection conn;

    public DaoQuarto(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Quarto quarto){
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT INTO tbQuarto(Numero, "
                    + "Tipo_Qt, Situacao_Qt, valorDiaria_Qt, TotalFaturado_Qt, acessibilidade_Qt)"
                    + " VALUES(?,?,?,?,?,?)");
            ps.setInt(1, quarto.getNumero());
            ps.setString(2, quarto.getTipo());
            ps.setBoolean(3, quarto.getSituacao());
            ps.setDouble(4, quarto.getValorDiaria());
            ps.setDouble(5, quarto.getTotalFaturado());
            ps.setBoolean(6, quarto.getAcessibilidade());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbQuarto set Tipo_Qt = ?, "
                    + "Situacao_Qt = ?, "
                    + "ValorDiaria_Qt = ?, "
                    + "TotalFaturado_Qt = ?, "
                    + "acessibilidade_Qt = ? "
                    + "WHERE Numero = ?");
            
            
            ps.setString(1, quarto.getTipo());
            ps.setBoolean(2, quarto.getSituacao());
            ps.setDouble(3, quarto.getValorDiaria());
            ps.setDouble(4, quarto.getTotalFaturado());
            ps.setBoolean(5, quarto.getAcessibilidade());
            ps.setInt(6, quarto.getNumero());
            
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public  Quarto consultar (int numero) {
        Quarto q = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from tbQuarto where " +
                                                 "Numero = ?");
            
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
                q = new Quarto (numero, rs.getString("Tipo_Qt"), rs.getDouble("ValorDiaria_Qt"));
                q.setSituacao(rs.getBoolean("Situacao_Qt"));
                q.setAcessibilidade(rs.getBoolean("acessibilidade_Qt"));
                q.setTotalFaturado(rs.getDouble("totalfaturado_Qt"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (q);
    }    
     
     public void excluir(Quarto quarto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbQuarto where Numero = ?");
            
            ps.setInt(1, quarto.getNumero());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
