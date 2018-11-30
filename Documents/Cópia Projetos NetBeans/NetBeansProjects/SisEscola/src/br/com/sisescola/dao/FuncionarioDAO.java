package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Funcionario;
import java.sql.*;
import java.text.DateFormat;
import java.util.Vector;

public class FuncionarioDAO {
    private ConexaoEscola ce;
    DateFormat df = DateFormat.getDateInstance();
        
    public FuncionarioDAO()throws Exception{
        ce = new ConexaoEscola(); 
        df.setLenient(false);
    }
    
    public void incluir(Funcionario f)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO FUNCIONARIO(NASCIMENTO,RG,ORG_EXP,CTPS,SERIE,ADMISSAO,LOGRADOURO,NUMERO," +
                "BAIRRO,CEP,CIDADE,UF,CELULAR,SALARIO,CPF,NOME,ID_DPTO,SEXO,NACIONALIDADE," +
                "NOME_DPTO,COMPLEMENTO,DEMISSAO,FONE,FUNCAO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setDate(1, new Date(f.getNascimento().getTime()));
        pst.setString(2, f.getRg());
        pst.setString(3, f.getOrgexp());
        pst.setString(4, f.getCtps());
        pst.setString(5, f.getSerie());
        pst.setDate(6, new Date(f.getAdmissao().getTime()));        
        pst.setString(7, f.getLogradouro());
        pst.setInt(8, f.getNumero());        
        pst.setString(9, f.getBairro());
        pst.setString(10, f.getCep());
        pst.setString(11, f.getCidade());
        pst.setString(12, f.getUf());        
        pst.setString(13, f.getCelular());        
        pst.setDouble(14, f.getSalario());
        pst.setString(15, f.getCpf());
        pst.setString(16, f.getNome());
        pst.setInt(17, f.getIdDpto());
        pst.setString(18, f.getSexo());
        pst.setString(19, f.getNacionalidade());
        pst.setString(20, f.getNome_dpto());
        pst.setString(21, f.getComplemento());     
        pst.setDate(22, new Date(f.getDemissao().getTime()));
        pst.setString(23, f.getFone());
        pst.setString(24, f.getFuncao());
        pst.executeUpdate();
        ce.confirmarTransacao();
        
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()) f.setCodfun(rs.getInt(1));
        rs.close();
        pst.close();
    }
    
    public void alterar(Funcionario f)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE FUNCIONARIO SET NASCIMENTO = ?,RG = ?,ORG_EXP = ?,CTPS = ?,SERIE = ?,ADMISSAO = ?," +
                "LOGRADOURO = ?,NUMERO = ?,BAIRRO = ?,CEP = ?,CIDADE = ?,UF = ?," +
                "CELULAR = ?,SALARIO = ?,CPF = ?,NOME = ?,SEXO = ?,NACIONALIDADE = ?,ID_DPTO = ?," +
                "NOME_DPTO = ?,COMPLEMENTO = ?,DEMISSAO = ?,FONE = ?,FUNCAO = ? WHERE CODFUN = ?");
        pst.setDate(1, new Date(f.getNascimento().getTime()));
        pst.setString(2, f.getRg());
        pst.setString(3, f.getOrgexp());
        pst.setString(4, f.getCtps());
        pst.setString(5, f.getSerie());
        pst.setDate(6, new Date(f.getAdmissao().getTime()));        
        pst.setString(7, f.getLogradouro());
        pst.setInt(8, f.getNumero());        
        pst.setString(9, f.getBairro());
        pst.setString(10, f.getCep());
        pst.setString(11, f.getCidade());
        pst.setString(12, f.getUf());        
        pst.setString(13, f.getCelular());        
        pst.setDouble(14, f.getSalario());
        pst.setString(15, f.getCpf());
        pst.setString(16, f.getNome());
        pst.setString(17, f.getSexo());
        pst.setString(18, f.getNacionalidade());
        pst.setInt(19, f.getIdDpto());
        pst.setString(20, f.getNome_dpto());
        pst.setString(21, f.getComplemento());
        pst.setDate(22, new Date(f.getDemissao().getTime()));
        pst.setString(23, f.getFone());
        pst.setString(24, f.getFuncao());
        pst.setInt(25, f.getCodfun());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();       
    }
    
    public void excluir(int codfun)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM FUNCIONARIO WHERE CODFUN = ?");
        pst.setInt(1, codfun);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }
    
    public ResultSet carregarGrade()throws Exception{   
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODFUN, NOME, CPF, FUNCAO, NOME_DPTO, SALARIO FROM FUNCIONARIO ORDER BY NOME");
    }
    
    public Vector<Funcionario> carregarCombo()throws Exception{
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT CODFUN, NOME FROM FUNCIONARIO ORDER BY NOME");
        Vector<Funcionario> v = new Vector<Funcionario>();
        while(rs.next())
            v.add(new Funcionario(rs.getInt("CODFUN"), rs.getString("NOME")));
        return v;
    }
    
    public Funcionario pesquisar(int codfun)throws Exception{
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM FUNCIONARIO WHERE CODFUN = ?");
        pst.setInt(1, codfun);
        ResultSet rs = pst.executeQuery();
        if(!rs.next())return null;
        return new Funcionario(rs.getInt("CODFUN"), rs.getString("NOME"), rs.getString("SEXO"), rs.getDate("NASCIMENTO"),
                               rs.getString("NACIONALIDADE"), rs.getString("CPF"), rs.getString("RG"), rs.getString("ORG_EXP"),
                               rs.getString("CTPS"), rs.getString("SERIE"), rs.getDate("ADMISSAO"), rs.getDate("DEMISSAO"),
                               rs.getString("LOGRADOURO"), rs.getInt("NUMERO"), rs.getString("COMPLEMENTO"), rs.getString("BAIRRO"),
                               rs.getString("CEP"), rs.getString("CIDADE"), rs.getString("UF"), rs.getString("FONE"), rs.getString("CELULAR"),
                               rs.getString("NOME_DPTO"), rs.getString("FUNCAO"), rs.getDouble("SALARIO"));
    }
    
    public Funcionario pesquisar(String codfun)throws Exception{
        return pesquisar(Integer.parseInt(codfun));
    }
}
