package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Professor;
import java.sql.*;
import java.util.Vector;

public class ProfessorDAO {
    private ConexaoEscola ce;
    
    public ProfessorDAO()throws Exception{
        ce = new ConexaoEscola();
    }
    
    public void incluir(Professor p)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO PROFESSOR(NOME) " +
                 "VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, p.getNome());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) p.setCodpro(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Professor t)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE PROFESSOR SET NOME = ? WHERE CODPROP = ?");
        pst.setString(1, t.getNome());
        pst.setInt(2, t.getCodpro());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int codpro)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM PROFESSOR WHERE CODPROP = ?");
        pst.setInt(1, codpro);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODPROP, NOME FROM PROFESSOR ORDER BY NOME");
    }
    
    public Vector<Professor> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT CODPROP, NOME FROM PROFESSOR ORDER BY NOME");
        Vector<Professor> v = new Vector<Professor>();
        while(rs.next())
            v.add(new Professor(rs.getInt("CODPROP"), rs.getString("NOME")));
        return v;
    }
    
    public Professor pesquisar(int codpro)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM PROFESSOR WHERE CODPROP = ?");
        pst.setInt(1, codpro);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Professor(rs.getInt("CODPROP"), rs.getString("NOME"));
    }
    
    public Professor pesquisar(String codpro)throws Exception{
        return pesquisar(Integer.parseInt(codpro));
    }
}



