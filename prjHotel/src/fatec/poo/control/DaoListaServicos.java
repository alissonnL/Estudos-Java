
package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.*;

/**
 *
 * @author Caio Gomes Silva
 */
public class DaoListaServicos {
    private Connection conn;

    public DaoListaServicos(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Registro rg, ServicoQuarto sq){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbListaServicos (CodigoRegistro, CodigoServicoQuarto, Sequencia) VALUES (?, ?, Sequencia.Nextval)");
            ps.setInt(1, rg.getCodigo());
            ps.setInt(2, sq.getCodigo());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(ServicoQuarto sq){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbListaServicos SET Descricao_Sq = ?, Valor_Sq = ? WHERE Codigo = ?");
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
            ps = conn.prepareStatement("SELECT * FROM tbListaServicos WHERE Codigo = ?");
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
            ps = conn.prepareStatement("DELETE FROM tbListaServicos WHERE Codigo = ?");
            ps.setInt(1, sq.getCodigo());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }

}
