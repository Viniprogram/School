package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Departamento;
import java.sql.*;
import java.util.Vector;

public class DepartamentoDAO {
    private ConexaoEscola ce;
    
    public DepartamentoDAO()throws Exception{
        ce = new ConexaoEscola();
    }
    
    public void incluir(Departamento d)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO DEPTO(NOME) " +
                 "VALUES(?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, d.getNome());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) d.setCoddep(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Departamento d)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE DEPTO SET NOME = ? WHERE CODDEP = ?");
        pst.setString(1, d.getNome());
        pst.setInt(2, d.getCoddep());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int coddep)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM DEPTO WHERE CODDEP = ?");
        pst.setInt(1, coddep);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODDEP, NOME FROM DEPTO ORDER BY NOME");
    }
    
    public Vector<Departamento> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT * FROM DEPTO ORDER BY NOME");
        Vector<Departamento> v = new Vector<Departamento>();
        while(rs.next())
            v.add(new Departamento(rs.getString("NOME")));
        return v;
    } 
    
    public Departamento pesquisar(int coddep)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM DEPTO WHERE CODDEP = ?");
        pst.setInt(1, coddep);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Departamento(rs.getInt("CODDEP"), rs.getString("NOME"));
    }
    
    public Departamento pesquisar(String coddep)throws Exception{
        return pesquisar(Integer.parseInt(coddep));
    }
}




