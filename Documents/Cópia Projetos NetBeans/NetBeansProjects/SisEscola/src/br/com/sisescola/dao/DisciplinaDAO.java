package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Disciplina;
import java.sql.*;
import java.util.Vector;

public class DisciplinaDAO {
    private ConexaoEscola ce;
    
    public DisciplinaDAO()throws Exception{
        ce = new ConexaoEscola();
    }
    
    public void incluir(Disciplina d)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO DISCIPLINA(NOME, CODPROE) " +
                 "VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, d.getNome());
        pst.setInt(2, d.getIdProfessor());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) d.setCoddis(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Disciplina d)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE DISCIPLINA SET NOME = ? WHERE CODDIS = ?");
        pst.setString(1, d.getNome());
        pst.setInt(2, d.getCoddis());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int coddis)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM DISCIPLINA WHERE CODDIS = ?");
        pst.setInt(1, coddis);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODDIS, NOME, CODPROE FROM DISCIPLINA ORDER BY NOME");
    }
    
    public Vector<Disciplina> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT CODDIS, NOME, CODPROE FROM DISCIPLINA ORDER BY NOME");
        Vector<Disciplina> v = new Vector<Disciplina>();
        while(rs.next())
            v.add(new Disciplina(rs.getInt("CODDIS"), rs.getString("NOME")));
        return v;
    }
    
    public Disciplina pesquisar(int coddis)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM DISCIPLINA WHERE CODDIS = ?");
        pst.setInt(1, coddis);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Disciplina(rs.getInt("CODDIS"), rs.getString("NOME"));
    }
    
    public Disciplina pesquisar(String coddis)throws Exception{
        return pesquisar(Integer.parseInt(coddis));
    }
}



