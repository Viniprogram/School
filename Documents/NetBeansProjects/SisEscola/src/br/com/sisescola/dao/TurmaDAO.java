package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Turma;
import java.sql.*;
import java.util.Vector;

public class TurmaDAO {
    private ConexaoEscola ce;
    
    public TurmaDAO()throws Exception{
        ce = new ConexaoEscola();
    }
    
    public void incluir(Turma t)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO TURMA(NOME, TURNO) " +
                 "VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, t.getNome());
        pst.setString(2, t.getTurno());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) t.setCodtur(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Turma t)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE TURMA SET NOME = ?, TURNO = ? WHERE CODTUR = ?");
        pst.setString(1, t.getNome());
        pst.setString(2, t.getTurno());
        pst.setInt(3, t.getCodtur());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int codtur)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM TURMA WHERE CODTUR = ?");
        pst.setInt(1, codtur);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODTUR, NOME, TURNO FROM TURMA ORDER BY NOME");
    }
    
    public Vector<Turma> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT CODTUR, NOME, TURNO FROM TURMA ORDER BY NOME");
        Vector<Turma> v = new Vector<Turma>();
        while(rs.next())
            v.add(new Turma(rs.getInt("CODTUR"), rs.getString("NOME"), rs.getString("TURNO")));
        return v;
    }
    
    public Turma pesquisar(int codtur)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM TURMA WHERE CODTUR = ?");
        pst.setInt(1, codtur);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Turma(rs.getInt("CODTUR"), rs.getString("NOME"), rs.getString("TURNO"));
    }
    
    public Turma pesquisar(String codtur)throws Exception{
        return pesquisar(Integer.parseInt(codtur));
    }    
}



