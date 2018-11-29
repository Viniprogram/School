package br.com.sisescola.transferencia;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Professor {
    private int codprof;
    private byte[] foto;
    private String nome;
    private Date nascimento;
    private String cpf;
    private String rg;
    private Date admissao;
    private Date demissao;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String fone;
    private String celular;
    
    public Professor(){
        this(0,new byte[100],"",new Date(),"","",new Date(),new Date(),"",0,"","","","","","","");
    }
    
    public Professor(int codprof, byte[] foto, String nome, Date nascimento, String cpf, String rg, Date admissao,
                        Date demissao, String logradouro, int numero, String complemento, String bairro, String cep,
                        String cidade, String uf, String fone, String celular){
        setCodprof(codprof);
        setFoto(foto);
        setNome(nome);
        setNascimento(nascimento);
        setCpf(cpf);
        setRg(rg);
        setAdmissao(admissao);
        setDemissao(demissao);
        setLogradouro(logradouro);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCep(cep);
        setCidade(cidade);
        setUf(uf);
        setFone(fone);
        setCelular(celular);
    }  
    
    public Professor(String nome){
        setNome(nome);
    }

    public int getCodprof() {
        return codprof;
    }
    
    public String getNome() {
        return nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public String getNascimentoFmt(){
        DateFormat df = DateFormat.getDateInstance();
        return df.format(nascimento);
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public Date getAdmissao() {
        return admissao;
    }
    
    public String getAdmissaoFmt(){
        DateFormat df = DateFormat.getDateInstance();
        return df.format(admissao);
    }

    public Date getDemissao() {
        return demissao;
    }
    
    public String getDemissaoFmt(){
        DateFormat df = DateFormat.getDateInstance();
        return df.format(demissao);
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

    public void setCodprof(int codprof) {
        this.codprof = codprof;
    }
    
    public void setCodprof(String codprof){
        setCodprof(Integer.parseInt(codprof));
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
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

    public void setCpf(String cpf) {
        cpf = cpf.replaceAll("\\.", "").replaceAll("-", "");
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }
    
    public void setAdmissao(String admissao){
        try {
            DateFormat df = DateFormat.getDateInstance();
            df.setLenient(false);
            setAdmissao(df.parse(admissao));
        } catch (ParseException pe) {
        }
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }
    
    public void setDemissao(String demissao){
        try {
            DateFormat df = DateFormat.getDateInstance();
            df.setLenient(false);
            setDemissao(df.parse(demissao));
        } catch (ParseException pe) {
        }
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
        cep = cep.replaceAll("\\-", "");
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + '}';
    }    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codprof;
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
        final Professor other = (Professor) obj;
        if (this.codprof != other.codprof) {
            return false;
        }
        return true;
    }
}
