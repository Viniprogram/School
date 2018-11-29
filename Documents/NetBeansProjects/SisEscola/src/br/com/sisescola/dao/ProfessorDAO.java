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
                "INSERT INTO professor(foto, nome, nascimento, cpf, rg, admissao, demissao, logradouro, numero,"
              + "complemento, bairro, cep, cidade, uf, fone, celular) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        pst.setBytes(1, p.getFoto());
        pst.setString(2, p.getNome());
        pst.setDate(3, new Date(p.getNascimento().getTime()));
        pst.setString(4, p.getCpf());
        pst.setString(5, p.getRg());
        pst.setDate(6, new Date(p.getAdmissao().getTime()));
        pst.setDate(7, new Date(p.getDemissao().getTime()));
        pst.setString(8, p.getLogradouro());
        pst.setInt(9, p.getNumero());
        pst.setString(10, p.getComplemento());
        pst.setString(11, p.getBairro());
        pst.setString(12, p.getCep());
        pst.setString(13, p.getCidade());
        pst.setString(14, p.getUf());
        pst.setString(15, p.getFone());
        pst.setString(16, p.getCelular());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) p.setCodprof(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Professor p)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE professor SET foto = ?, nome = ?, nascimento = ?, cpf = ?, rg = ?, admissao = ?,"
              + " demissao = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?,"
              + " uf = ?, fone = ?, celular = ? WHERE codprof = ?");
        pst.setBytes(1, p.getFoto());
        pst.setString(2, p.getNome());
        pst.setDate(3, new Date(p.getNascimento().getTime()));
        pst.setString(4, p.getCpf());
        pst.setString(5, p.getRg());
        pst.setDate(6, new Date(p.getAdmissao().getTime()));
        pst.setDate(7, new Date(p.getDemissao().getTime()));
        pst.setString(8, p.getLogradouro());
        pst.setInt(9, p.getNumero());
        pst.setString(10, p.getComplemento());
        pst.setString(11, p.getBairro());
        pst.setString(12, p.getCep());
        pst.setString(13, p.getCidade());
        pst.setString(14, p.getUf());
        pst.setString(15, p.getFone());
        pst.setString(16, p.getCelular());
        pst.setInt(17, p.getCodprof());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int codprof)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM professor WHERE codprof = ?");
        pst.setInt(1, codprof);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT codprof, nome FROM professor ORDER BY nome");
    }
    
    public Vector<Professor> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT nome FROM professor ORDER BY nome");
        Vector<Professor> v = new Vector<Professor>();
        while(rs.next())
            v.add(new Professor(rs.getString("NOME")));
        return v;
    }
    
    public Professor pesquisar(int codprof)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM professor WHERE codprof = ?");
        pst.setInt(1, codprof);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Professor(rs.getInt("codprof"), rs.getBytes("foto"), rs.getString("nome"),
                rs.getDate("nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getDate("admissao"),
                rs.getDate("demissao"), rs.getString("logradouro"), rs.getInt("numero"), rs.getString("complemento"),
                rs.getString("bairro"), rs.getString("cep"), rs.getString("cidade"), rs.getString("uf"),
                rs.getString("fone"), rs.getString("celular"));
    }
    
    public Professor pesquisar(String codprof)throws Exception{
        return pesquisar(Integer.parseInt(codprof));
    }
}



