package dao;

import java.util.List;
import model.Usuario;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 363707
 */
public class UsuarioDAO {
    public List<Usuario> listarTodos() {
    	ArrayList lista = new ArrayList();
        
    	try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	Usuario u = new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getInt("acesso")
                );
            lista.add(u);
            }   
    	} 
        catch (SQLException e) {
            e.getMessage();
    	}
    	return lista;
    }

    public void inserir(Usuario usuario) throws SQLException {
    	try(Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into usuarios(nome,email,senha,acesso) values (?,?,?,?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getAcesso());
            ps.executeUpdate();
    	}
        catch(SQLException e) {
            e.getMessage();
    	}
    }

    public void atualizar(Usuario usuario) throws SQLException {
    	try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "update usuarios set nome=?,"
                    + "senha=?,acesso=?,email=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getAcesso());
            ps.setString(4, usuario.getEmail());
            ps.setInt(5, usuario.getId());
            ps.executeUpdate();
    	} catch (SQLException ex) {
        		System.out.println(ex.getMessage());
    	}
    }
    
    public Usuario buscarPorId(int id) {
    	Usuario usuario = null;
    	String sql = "SELECT * FROM usuarios WHERE id = ?";

    	try (Connection conexao = ConnectionFactory.getConnection();
            	PreparedStatement stmt = conexao.prepareStatement(sql)) {

        	stmt.setInt(1, id);
        	ResultSet rs = stmt.executeQuery();

        	if (rs.next()) {
            	usuario = new Usuario();
            	usuario.setId(rs.getInt("id"));
            	usuario.setNome(rs.getString("nome"));
            	usuario.setEmail(rs.getString("email"));
            	usuario.setSenha(rs.getString("senha"));
            	usuario.setAcesso(rs.getInt("acesso"));
        	}
    	} catch (SQLException e) {
        		System.out.println(e.getMessage());
    	}
    	return usuario;
    }
    
    public boolean login(String email, String senha){
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql= "select * from usuarios where email=? and senha=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            return rs.next();            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }


    public void deletar(int id) throws SQLException {
        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "delete from usuarios where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();            
    }catch(SQLException ex){
            System.out.println("ex.getMessage");
    }

}
}