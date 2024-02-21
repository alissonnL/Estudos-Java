package fatec.poo.control;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import fatec.poo.model.Hospede;
/**
 *
 * @author 2D
 */
public class DaoHospede {
    private Connection conn;
    
    public DaoHospede(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Hospede hospede){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbHospede(CPF, Nome_Hp, Endereco_Hp, Telefone_Hp, TaxaDesconto_Hp) VALUES(?,?,?,?,?)");
            ps.setString(1, hospede.getCpf());
            ps.setString(2, hospede.getNome());
            ps.setString(3, hospede.getEndereco());
            ps.setString(4, hospede.getTelefone());
            ps.setDouble(5, hospede.getTaxaDesconto());
            
            ps.execute();
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Hospede hospede){
        PreparedStatement ps = null;
        try{
        ps = conn.prepareStatement("UPDATE tbHospede set Nome_Hp = ?, Endereco_Hp = ?, Telefone_Hp = ?, TaxaDesconto_Hp = ? " + 
                "WHERE CPF = ?");
        ps.setString(1, hospede.getNome());
        ps.setString(2, hospede.getEndereco());
        ps.setString(3, hospede.getTelefone());
        ps.setDouble(4, hospede.getTaxaDesconto());
        ps.setString(5, hospede.getCpf());
        
        ps.execute();
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Hospede consultar(String cpf){
        Hospede h = null;
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("SELECT  * FROM tbHospede WHERE CPF = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next() == true){
                h = new Hospede(cpf, rs.getString("Nome_Hp"));
                h.setEndereco(rs.getString("Endereco_Hp"));
                h.setTelefone(rs.getString("Telefone_Hp"));
                h.setTaxaDesconto(rs.getDouble("TaxaDesconto_Hp"));
                
            }
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return h;
    }
    
    public void excluir(Hospede hospede){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbHospede WHERE CPF = ?");
            ps.setString(1, hospede.getCpf());
            
            ps.execute();
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
