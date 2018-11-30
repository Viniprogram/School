package br.com.sisescola.transferencia;

import java.text.*;
import java.util.Date;

public class Aluno {
    private int codalu;
    private int idTurma;
    private String nome;
    private String sexo;
    private Date nascimento;
    private String nacionalidade;
    private String pai;
    private String mae;
    private String respFinanceiro;
    private String cpfRespFinan;
    private String nomeRespFinan;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String fone;
    private String celular;
    private String email;
    private String turno;
    private String bolsista;
    private String alergia;
    private String tipoAlergia;
    private String doenca;
    private String tipoDoenca;
    private String turma;
       
    public Aluno(){
        this(0,0,"","",new Date(),"","","","","","","",0,"","","","","","","","","","","","","","","");
    }
    
    public Aluno( int codalu, int idTurma, String nome, String sexo, Date nascimento, String nacionalidade,
                  String pai, String mae, String respFinanceiro, String cpfRespFinan, String nomeRespFinan,
                  String logradouro, int numero, String complemento, String bairro, String cep, String cidade,
                  String uf, String fone, String celular, String email, String turno, String bolsista,
                  String alergia, String tipoAlergia, String doenca, String tipoDoenca, String turma){
        setCodalu(codalu);
        setIdTurma(idTurma);
        setNome(nome);
        setSexo(sexo);
        setNascimento(nascimento);
        setNacionalidade(nacionalidade);
        setPai(pai); 
        setMae(mae);
        setRespFinanceiro(respFinanceiro);
        setCpfRespFinan(cpfRespFinan);
        setNomeRespFinan(nomeRespFinan);
        setLogradouro(logradouro);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setUf(uf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);
        setTurno(turno);
        setBolsista(bolsista);
        setAlergia(alergia);
        setTipoAlergia(tipoAlergia);
        setDoenca(doenca);
        setTipoDoenca(tipoDoenca);
        setTurma(turma);
    }
    
    public Aluno( int codalu, String nome, String sexo, String pai, Date nascimento, String nacionalidade,
                  String mae, String respFinanceiro, String cpfRespFinan, String nomeRespFinan, String email, 
                  String celular, String logradouro, int numero, String complemento, String bairro, String cep,
                  String cidade, String uf, String fone, String bolsista, String alergia, String tipoAlergia, 
                  String doenca, String tipoDoenca, String turno, String turma){
        setCodalu(codalu);
        setNome(nome);
        setSexo(sexo);
        setPai(pai);
        setNascimento(nascimento);
        setNacionalidade(nacionalidade);         
        setMae(mae);
        setRespFinanceiro(respFinanceiro);
        setCpfRespFinan(cpfRespFinan);
        setNomeRespFinan(nomeRespFinan);
        setEmail(email);
        setCelular(celular);
        setLogradouro(logradouro);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setUf(uf);
        setFone(fone);      
        setBolsista(bolsista);
        setAlergia(alergia);
        setTipoAlergia(tipoAlergia);
        setDoenca(doenca);
        setTipoDoenca(tipoDoenca);
        setTurno(turno);
        setTurma(turma);
    }
    
    public Aluno(int codalu, String nome, String turno, String turma){
        setCodalu(codalu);
        setNome(nome);
        setTurno(turno);
        setTurma(turma);
    }
    
    public Aluno(int codalu, String nome){
        setCodalu(codalu);
        setNome(nome);
    }

    public int getCodalu() {
        return codalu;
    }

    public int getIdTurma() {
        return idTurma;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public String getNascimentoFmt(){
        DateFormat df = DateFormat.getDateInstance();
        return df.format(nascimento);
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getPai() {
        return pai;
    }

    public String getMae() {
        return mae;
    }

    public String getRespFinanceiro() {
        return respFinanceiro;
    }

    public String getCpfRespFinan() {
        return cpfRespFinan;
    }

    public String getNomeRespFinan() {
        return nomeRespFinan;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getFone() {
        return fone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getTurno() {
        return turno;
    }

    public String getBolsista() {
        return bolsista;
    }

    public String getAlergia() {
        return alergia;
    }

    public String getTipoAlergia() {
        return tipoAlergia;
    }

    public String getDoenca() {
        return doenca;
    }

    public String getTipoDoenca() {
        return tipoDoenca;
    }

    public String getTurma() {
        return turma;
    }

    public void setCodalu(int codalu) {
        this.codalu = codalu;
    }
    
    public void setCodalu(String codalu){
        setCodalu(Integer.parseInt(codalu));
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
    
    public void setIdTurma(String idTurma) {
        setIdTurma(Integer.parseInt(idTurma));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    
    public void setNascimento(String nascimento){
        try {
            DateFormat df = DateFormat.getDateInstance();
            df.setLenient(false);
            setNascimento(df.parse(nascimento));
        } catch (ParseException pe) {
        }
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public void setRespFinanceiro(String respFinanceiro) {
        this.respFinanceiro = respFinanceiro;
    }

    public void setCpfRespFinan(String cpfRespFinan) {
        cpfRespFinan = cpfRespFinan.replaceAll("\\.", "").replaceAll("-", "");
        this.cpfRespFinan = cpfRespFinan;
    }

    public void setNomeRespFinan(String nomeRespFinan) {
        this.nomeRespFinan = nomeRespFinan;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public void setNumero(String numero){
        setNumero(Integer.parseInt(numero));
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        cep = cep.replaceAll("\\-","");
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setFone(String fone) {
        fone = fone.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");
        this.fone = fone;
    }

    public void setCelular(String celular) {
        celular = celular.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setBolsista(String bolsista) {
        this.bolsista = bolsista;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public void setTipoAlergia(String tipoAlergia) {
        this.tipoAlergia = tipoAlergia;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public void setTipoDoenca(String tipoDoenca) {
        this.tipoDoenca = tipoDoenca;
    }   

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codalu;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.codalu != other.codalu) {
            return false;
        }
        return true;
    }   
}
