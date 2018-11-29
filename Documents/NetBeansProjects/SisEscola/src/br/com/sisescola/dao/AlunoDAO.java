package br.com.sisescola.dao;

import br.com.sisescola.accessories.ConexaoEscola;
import br.com.sisescola.transferencia.Aluno;
import java.sql.*;
import java.util.Vector;

public class AlunoDAO {

    private ConexaoEscola ce;

    public AlunoDAO() throws Exception {
        ce = new ConexaoEscola();
    }

    public void incluir(Aluno a) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                  "INSERT INTO ALUNO(FOTO,NOME,SEXO,NASCIMENTO,NACIONALIDADE,PAI,MAE,RESP_FINANC,CPF_RESP_FINANC,"
                + "NOME_OUTRO,LOGRADOURO,NUMERO,COMPLEMENTO,BAIRRO,CEP,CIDADE,UF,FONE,CELULAR_RESP,EMAIL_RESP,"
                + "BOLSISTA,ALERGIA,TIPO_ALERGIA,DOENCA,TIPO_DOENCA,ID_TURMA,FALTAS)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);              
        pst.setBytes(1, a.getFoto());
        pst.setString(2, a.getNome());
        pst.setString(3, a.getSexo());
        pst.setDate(4, new Date(a.getNascimento().getTime()));
        pst.setString(5, a.getNacionalidade());
        pst.setString(6, a.getPai());
        pst.setString(7, a.getMae());
        pst.setString(8, a.getRespFinanceiro());
        pst.setString(9, a.getCpfRespFinan());
        pst.setString(10, a.getNomeRespFinan());
        pst.setString(11, a.getLogradouro());
        pst.setInt(12, a.getNumero());
        pst.setString(13, a.getComplemento());
        pst.setString(14, a.getBairro());
        pst.setString(15, a.getCep());
        pst.setString(16, a.getCidade());
        pst.setString(17, a.getUf());
        pst.setString(18, a.getFone());
        pst.setString(19, a.getCelular());
        pst.setString(20, a.getEmail());
        pst.setString(21, a.getBolsista());
        pst.setString(22, a.getAlergia());
        pst.setString(23, a.getTipoAlergia());
        pst.setString(24, a.getDoenca());
        pst.setString(25, a.getTipoDoenca());
        pst.setInt(26, a.getIdTurma());        
        pst.executeUpdate();
        ce.confirmarTransacao();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            a.setMatricula(rs.getInt(1));
        }
        rs.close();
        pst.close();
    }

    public void alterar(Aluno a) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                  "UPDATE ALUNO SET FOTO = ?,NOME = ?,SEXO = ?,NASCIMENTO = ?,NACIONALIDADE = ?, PAI = ?,MAE = ?,"
                + "RESP_FINANC = ?,CPF_RESP_FINANC = ?,NOME_OUTRO = ?,LOGRADOURO = ?,NUMERO = ?,COMPLEMENTO = ?,"
                + "BAIRRO = ?,CEP = ?,CIDADE = ?,UF = ?,FONE = ?,CELULAR_RESP = ?,EMAIL_RESP = ?,BOLSISTA = ?,"
                + "ALERGIA = ?,TIPO_ALERGIA = ?,DOENCA = ?,TIPO_DOENCA = ?,ID_TURMA = ? WHERE MATRICULA = ?");
       
        pst.setBytes(1, a.getFoto());
        pst.setString(2, a.getNome());
        pst.setString(3, a.getSexo());
        pst.setDate(4, new Date(a.getNascimento().getTime()));
        pst.setString(5, a.getNacionalidade());
        pst.setString(6, a.getPai());
        pst.setString(7, a.getMae());
        pst.setString(8, a.getRespFinanceiro());
        pst.setString(9, a.getCpfRespFinan());
        pst.setString(10, a.getNomeRespFinan());
        pst.setString(11, a.getLogradouro());
        pst.setInt(12, a.getNumero());
        pst.setString(13, a.getComplemento());
        pst.setString(14, a.getBairro());
        pst.setString(15, a.getCep());
        pst.setString(16, a.getCidade());
        pst.setString(17, a.getUf());
        pst.setString(18, a.getFone());
        pst.setString(19, a.getCelular());
        pst.setString(20, a.getEmail());
        pst.setString(21, a.getBolsista());
        pst.setString(22, a.getAlergia());
        pst.setString(23, a.getTipoAlergia());
        pst.setString(24, a.getDoenca());
        pst.setString(25, a.getTipoDoenca());
        pst.setInt(26, a.getIdTurma()); 
        pst.setInt(27, a.getMatricula());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }

    public void excluir(int matricula) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM ALUNO WHERE MATRICULA = ?");
        pst.setInt(1, matricula);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }

    public ResultSet carregarGrade() throws Exception {
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT MATRICULA, NOME, ID_TURMA FROM ALUNO ORDER BY NOME");
    }

    public Vector<Aluno> carregarCombo() throws Exception {
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT MATRICULA, NOME FROM ALUNO ORDER BY NOME");
        Vector<Aluno> v = new Vector<Aluno>();
        while (rs.next()) {
            v.add(new Aluno(rs.getInt("MATRICULA"), rs.getString("NOME")));
        }
        return v;
    }

    public Aluno pesquisar(int matricula) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM ALUNO WHERE MATRICULA = ?");
        pst.setInt(1, matricula);
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Aluno(rs.getInt("MATRICULA"), rs.getBytes("FOTO"),rs.getString("NOME"), rs.getString("SEXO"), 
                rs.getDate("NASCIMENTO"), rs.getString("NACIONALIDADE"), rs.getString("PAI"), rs.getString("MAE"),
                rs.getString("RESP_FINANC"), rs.getString("CPF_RESP_FINANC"), rs.getString("NOME_OUTRO"),
                rs.getString("LOGRADOURO"), rs.getInt("NUMERO"),rs.getString("COMPLEMENTO"), rs.getString("BAIRRO"),
                rs.getString("CEP"), rs.getString("CIDADE"), rs.getString("UF"), rs.getString("FONE"), 
                rs.getString("CELULAR_RESP"), rs.getString("EMAIL_RESP"), rs.getString("BOLSISTA"),
                rs.getString("ALERGIA"), rs.getString("TIPO_ALERGIA"), rs.getString("DOENCA"),
                rs.getString("TIPO_DOENCA"), rs.getInt("ID_TURMA"));
    }

    public Aluno pesquisar(String codalu) throws Exception {
        return pesquisar(Integer.parseInt(codalu));
    }
}
