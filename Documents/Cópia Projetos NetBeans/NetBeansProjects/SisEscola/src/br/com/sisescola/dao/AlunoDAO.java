package br.com.sisescola.dao;

import br.com.sisescola.transferencia.Aluno;
import br.com.sisescola.accessories.ConexaoEscola;
import java.sql.*;
import java.util.Vector;

public class AlunoDAO {

    private ConexaoEscola ce;

    public AlunoDAO() throws Exception {
        ce = new ConexaoEscola();
    }

    public void incluir(Aluno a) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "INSERT INTO ALUNO(NOME,NASCIMENTO,PAI,MAE,LOGRADOURO,NUMERO,BAIRRO,CEP,CIDADE,"
                + "UF,CELULAR_RESP,ID_TURMA,BOLSISTA,SEXO,NACIONALIDADE,CPF,EMAIL_RESP,COMPLEMENTO,FONE,"
                + "ALERGIA,TIPO_ALERGIA,DOENCA,TIPO_DOENCA,RESP_FINANC,NOME_RESP_FINAN,TURMA,TURNO)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, a.getNome());
        pst.setDate(2, new Date(a.getNascimento().getTime()));
        pst.setString(3, a.getPai());
        pst.setString(4, a.getMae());
        pst.setString(5, a.getLogradouro());
        pst.setInt(6, a.getNumero());
        pst.setString(7, a.getBairro());
        pst.setString(8, a.getCep());
        pst.setString(9, a.getCidade());
        pst.setString(10, a.getUf());
        pst.setString(11, a.getCelular());
        pst.setInt(12, a.getIdTurma());
        pst.setString(13, a.getBolsista());
        pst.setString(14, a.getSexo());
        pst.setString(15, a.getNacionalidade());
        pst.setString(16, a.getCpfRespFinan());
        pst.setString(17, a.getEmail());
        pst.setString(18, a.getComplemento());
        pst.setString(19, a.getFone());
        pst.setString(20, a.getAlergia());
        pst.setString(21, a.getTipoAlergia());
        pst.setString(22, a.getDoenca());
        pst.setString(23, a.getTipoDoenca());
        pst.setString(24, a.getRespFinanceiro());
        pst.setString(25, a.getNomeRespFinan());
        pst.setString(26, a.getTurma());
        pst.setString(27, a.getTurno());
        pst.executeUpdate();
        ce.confirmarTransacao();

        ResultSet rs = pst.getGeneratedKeys();
        if (rs.next()) {
            a.setCodalu(rs.getInt(1));
        }
        rs.close();
        pst.close();
    }

    public void alterar(Aluno a) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "UPDATE ALUNO SET NOME = ?,NASCIMENTO = ?,PAI = ?,MAE = ?,LOGRADOURO = ?,NUMERO = ?,BAIRRO = ?,"
                + "CEP = ?,CIDADE = ?,UF = ?,CELULAR_RESP = ?,ID_TURMA = ?,BOLSISTA = ?,SEXO = ?,"
                + "NACIONALIDADE = ?,CPF = ?,EMAIL_RESP = ?,COMPLEMENTO = ?,FONE = ?,ALERGIA = ?,TIPO_ALERGIA = ?,"
                + "DOENCA = ?,TIPO_DOENCA = ?,RESP_FINANC = ?,NOME_RESP_FINAN = ?,TURMA = ?,TURNO = ? WHERE CODALU = ?");
        pst.setString(1, a.getNome());
        pst.setDate(2, new Date(a.getNascimento().getTime()));
        pst.setString(3, a.getPai());
        pst.setString(4, a.getMae());
        pst.setString(5, a.getLogradouro());
        pst.setInt(6, a.getNumero());
        pst.setString(7, a.getBairro());
        pst.setString(8, a.getCep());
        pst.setString(9, a.getCidade());
        pst.setString(10, a.getUf());
        pst.setString(11, a.getCelular());
        pst.setInt(12, a.getIdTurma());
        pst.setString(13, a.getBolsista());
        pst.setString(14, a.getSexo());
        pst.setString(15, a.getNacionalidade());
        pst.setString(16, a.getCpfRespFinan());
        pst.setString(17, a.getEmail());
        pst.setString(18, a.getComplemento());
        pst.setString(19, a.getFone());
        pst.setString(20, a.getAlergia());
        pst.setString(21, a.getTipoAlergia());
        pst.setString(22, a.getDoenca());
        pst.setString(23, a.getTipoDoenca());
        pst.setString(24, a.getRespFinanceiro());
        pst.setString(25, a.getNomeRespFinan());
        pst.setString(26, a.getTurma());
        pst.setString(27, a.getTurno());
        pst.setInt(28, a.getCodalu());
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }

    public void excluir(int codalu) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "DELETE FROM ALUNO WHERE CODALU = ?");
        pst.setInt(1, codalu);
        pst.executeUpdate();
        pst.close();
        ce.confirmarTransacao();
    }

    public ResultSet carregarGrade() throws Exception {
        Statement stm = ce.getConexao().createStatement();
        return stm.executeQuery(
                "SELECT CODALU, NOME, TURNO, TURMA FROM ALUNO ORDER BY NOME");
    }

    public Vector<Aluno> carregarCombo() throws Exception {
        Statement stm = ce.getConexao().createStatement();
        ResultSet rs = stm.executeQuery(
                "SELECT CODALU, NOME FROM ALUNO ORDER BY NOME");
        Vector<Aluno> v = new Vector<Aluno>();
        while (rs.next()) {
            v.add(new Aluno(rs.getInt("CODALU"), rs.getString("NOME")));
        }
        return v;
    }

    public Aluno pesquisar(int codalu) throws Exception {
        PreparedStatement pst = ce.getConexao().prepareStatement(
                "SELECT * FROM ALUNO WHERE CODALU = ?");
        pst.setInt(1, codalu);
        ResultSet rs = pst.executeQuery();
        if (!rs.next()) {
            return null;
        }
        return new Aluno(rs.getInt("CODALU"), rs.getString("NOME"), rs.getString("SEXO"), rs.getString("PAI"),
                rs.getDate("NASCIMENTO"), rs.getString("NACIONALIDADE"), rs.getString("MAE"),
                rs.getString("RESP_FINANC"), rs.getString("CPF"), rs.getString("NOME_RESP_FINAN"),
                rs.getString("EMAIL_RESP"), rs.getString("CELULAR_RESP"), rs.getString("LOGRADOURO"),
                rs.getInt("NUMERO"), rs.getString("COMPLEMENTO"), rs.getString("BAIRRO"), rs.getString("CEP"),
                rs.getString("CIDADE"), rs.getString("UF"), rs.getString("FONE"), rs.getString("BOLSISTA"),
                rs.getString("ALERGIA"), rs.getString("TIPO_ALERGIA"), rs.getString("DOENCA"),
                rs.getString("TIPO_DOENCA"), rs.getString("TURNO"), rs.getString("TURMA"));
    }

    public Aluno pesquisar(String codalu) throws Exception {
        return pesquisar(Integer.parseInt(codalu));
    }
}
