package br.com.sisescola.transferencia;

public class Departamento {
    private int coddep;
    private String nome;
    
    public Departamento(){
        this(0,"");
    }
    
    public Departamento(int coddep, String nome){
        setCoddep(coddep);
        setNome(nome);
    }
    
    public Departamento(String nome){
        setNome(nome);
    }

    public int getCoddep() {
        return coddep;
    }

    public String getNome() {
        return nome;
    }

    public void setCoddep(int coddep) {
        this.coddep = coddep;
    }
    
    public void setCoddep(String coddep) {
        setCoddep(Integer.parseInt(coddep)) ;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
