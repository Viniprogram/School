package br.com.sisescola.transferencia;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;

public class Funcionario {
    private int codfun;
    private int idDpto;
    private String nome_dpto;
    private String nome;
    private String sexo;
    private Date nascimento;
    private String nacionalidade;
    private String cpf;
    private String rg;
    private String orgexp;
    private String ctps;
    private String serie;
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
    private String funcao;
    private double salario;
    
    public Funcionario(){
        this(0,0,"","","",new Date(),"","","","","","",new Date(),new Date(),"",0,"","","","","","","","",0);
    }
    
    public Funcionario( int codfun, int idDpto, String nome_dpto, String nome, String sexo, Date nascimento,
                        String nacionalidade, String cpf, String rg, String orgexp, String ctps, String serie,
                        Date admissao, Date demissao, String logradouro, int numero, String complemento,
                        String bairro, String cep, String cidade, String uf, String fone, String celular,
                        String funcao, double salario){
        setCodfun(codfun); 
        setIdDpto(idDpto);
        setNome_dpto(nome_dpto);
        setNome(nome);
        setSexo(sexo);
        setNascimento(nascimento);
        setNacionalidade(nacionalidade);
        setCpf(cpf);
        setRg(rg);
        setOrgexp(orgexp);
        setCtps(ctps);
        setSerie(serie);
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
        setFuncao(funcao);
        setSalario(salario);
    }    
    
    public Funcionario( int codfun, String nome, String sexo, Date nascimento, String nacionalidade, 
                        String cpf, String rg, String orgexp, String ctps, String serie, Date admissao,
                        Date demissao, String logradouro, int numero, String complemento, String bairro,
                        String cep, String cidade, String uf, String fone, String celular, String nome_dpto,
                        String funcao, double salario){
        setCodfun(codfun);        
        setNome(nome);
        setSexo(sexo);
        setNascimento(nascimento);
        setNacionalidade(nacionalidade);
        setCpf(cpf);
        setRg(rg);
        setOrgexp(orgexp);
        setCtps(ctps);
        setSerie(serie);
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
        setNome_dpto(nome_dpto);
        setFuncao(funcao);
        setSalario(salario);
    }
    
    public Funcionario(int codfun, String nome, String cpf, String funcao, String nome_dpto, double salario){
        setCodfun(codfun);        
        setNome(nome);
        setCpf(cpf);
        setFuncao(funcao);
        setNome_dpto(nome_dpto);
        setSalario(salario);
    }
    
    public Funcionario(int codfun, String nome){
        setCodfun(codfun);        
        setNome(nome);
    }

    public int getCodfun() {
        return codfun;
    }

    public int getIdDpto() {
        return idDpto;
    }

    public String getNome_dpto() {
        return nome_dpto;
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

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getOrgexp() {
        return orgexp;
    }

    public String getCtps() {
        return ctps;
    }

    public String getSerie() {
        return serie;
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

    public String getFuncao() {
        return funcao;
    }

    public double getSalario() {
        return salario;
    }
    
    public String getSalarioFmt(){
        DecimalFormat df = new DecimalFormat("##,##0.00"); 
        return df.format(salario);
    }

    public void setCodfun(int codfun) {
        this.codfun = codfun;
    }
    
    public void setCodfun(String codfun) {
        setCodfun(Integer.parseInt(codfun));
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }
    
    public void setIdDpto(String idDpto) {
        setIdDpto(Integer.parseInt(idDpto));
    }

    public void setNome_dpto(String nome_dpto) {
        this.nome_dpto = nome_dpto;
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

    public void setCpf(String cpf) {
        cpf = cpf.replaceAll("\\.", "").replaceAll("-", "");
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setOrgexp(String orgexp) {
        orgexp = orgexp.replaceAll("\\/", "");
        this.orgexp = orgexp;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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
    
    public void setNumero(String numero) {
        setNumero(Integer.parseInt(numero));
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(String cep) {
        cep = cep.replaceAll("-", "");
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setFone(String fone) {
        fone = fone.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "");
        this.fone = fone;
    }

    public void setCelular(String celular) {
        celular = celular.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "");
        this.celular = celular;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void setSalario(String salario){        
        salario = salario.replaceAll("\\.","").replace(",",".");
        this.salario = Double.parseDouble(salario);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codfun;
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
        final Funcionario other = (Funcionario) obj;
        if (this.codfun != other.codfun) {
            return false;
        }
        return true;
    }    
}
