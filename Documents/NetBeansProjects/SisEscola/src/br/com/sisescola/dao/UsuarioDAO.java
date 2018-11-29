/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisescola.dao;
    
import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinic
 */
public class UsuarioDAO {
    private ConexaoEscola ce;
    
    public UsuarioDAO()throws Exception{
        ce = new ConexaoEscola();
}
    
    public void incluir(Usuario u) throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement("INSERT INTO usuario (login, senha) VALUES (?,?)",
                Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, u.getLogin());
        pst.setString(2, u.getSenha());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            u.setIdUsuario(rs.getInt(1));
        }
        rs.close();
        pst.close();
    }
    
    public void alterar(Usuario u)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement("UPDATE usuario SET senha WHERE id_usuario = ?");
        
        pst.setString(1, u.getSenha());
        pst.setInt(2, u.getIdUsuario());
        pst.executeUpdate();        
        pst.close();
        ce.confirmarTransacao();
    }
    
    public void excluir(int idUsuario)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM usuario WHERE id_usuario = ?");
        pst.setInt(1, idUsuario);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public List<Usuario> listar() throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement("SELECT id, login FROM usuario");
        List<Usuario> usuarios = new ArrayList<Usuario>();
        
        ResultSet rs = pst.executeQuery();
        
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("id_usuario"));
            usuario.setLogin(rs.getString("login"));
            
            usuarios.add(usuario);
        }
        return usuarios;
    }
}
