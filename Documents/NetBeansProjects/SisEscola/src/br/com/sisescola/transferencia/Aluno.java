package br.com.sisescola.transferencia;

import java.text.*;
import java.util.Date;

public class Aluno {
    private int matricula;
    private byte[] foto;
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
    private String bolsista;
    private String alergia;
    private String tipoAlergia;
    private String doenca;
    private String tipoDoenca;
    private int idTurma;
           
    public Aluno(){
        this(0,new byte[100],"","",new Date(),"","","","","","","",0,"","","","","","","","","","","","","",0);
    }
    
    public Aluno( int matricula, byte[] foto, String nome, String sexo, Date nascimento, String nacionalidade,
                  String pai, String mae, String respFinanceiro, String cpfRespFinan, String nomeRespFinan,
                  String logradouro, int numero, String complemento, String bairro, String cep, String cidade,
                  String uf, String fone, String celular, String email, String bolsista,
                  String alergia, String tipoAlergia, String doenca, String tipoDoenca, int idTurma){
        setMatricula(matricula); 
        setFoto(foto);
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
        setBolsista(bolsista);
        setAlergia(alergia);
        setTipoAlergia(tipoAlergia);
        setDoenca(doenca);
        setTipoDoenca(tipoDoenca);
        setIdTurma(idTurma);        
    }
    
    public Aluno(int matricula, String nome, int idTurma){
        setMatricula(matricula);
        setNome(nome);
        setIdTurma(idTurma);
    }
    
    public Aluno(int matricula, String nome){
        setMatricula(matricula);
        setNome(nome);
    }

    public int getMatricula() {
        return matricula;
    }    

    public byte[] getFoto() {
        return foto;
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

    public int getIdTurma() {
        return idTurma;
    }    

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public void setMatricula(String matricula){
        setMatricula(Integer.parseInt(matricula));
    }   

    public void setFoto(byte[] foto) {
        this.foto = foto;
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
    
    public void setIdTurma(int idTurma){
        this.idTurma = idTurma;
    }

    public void setIdTurma(String idTurma) {
        setIdTurma(Integer.parseInt(idTurma));
    }    

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.matricula;
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
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }   
}
