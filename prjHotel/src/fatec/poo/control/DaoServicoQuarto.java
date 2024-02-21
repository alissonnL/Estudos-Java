package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.ServicoQuarto;

/**
 *
 * @author 2D
 */
public class DaoServicoQuarto {
    private Connection conn;
    
    public DaoServicoQuarto(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(ServicoQuarto sq){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbServicoQuarto (Codigo, Descricao_Sq, Valor_Sq) VALUES (?,?,?)");
            ps.setInt(1, sq.getCodigo());
            ps.setString(2, sq.getDescricao());
            ps.setDouble(3, sq.getValor());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(ServicoQuarto sq){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbServicoQuarto SET Descricao_Sq = ?, Valor_Sq = ? WHERE Codigo = ?");
            ps.setString(1, sq.getDescricao());
            ps.setDouble(2, sq.getValor());
            ps.setInt(3, sq.getCodigo());
            
            ps.execute();
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public ServicoQuarto consultar(int codigo){
        ServicoQuarto sq = null;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM tbServicoQuarto WHERE Codigo = ?");
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true){
                sq = new ServicoQuarto(codigo, rs.getString("Descricao_Sq"));
                sq.setValor(rs.getDouble("Valor_Sq"));
            }
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return sq;
    }
    
    public void excluir(ServicoQuarto sq){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbServicoQuarto WHERE Codigo = ?");
            ps.setInt(1, sq.getCodigo());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
