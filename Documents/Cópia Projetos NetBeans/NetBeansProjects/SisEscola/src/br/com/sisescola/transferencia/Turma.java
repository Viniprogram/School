package br.com.sisescola.transferencia;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codtur;
    private String nome;
        
    public Turma(){
        this(0,"");
    }
    
    public Turma(int codtur, String nome){
        setCodtur(codtur);
        setNome(nome);        
    } 
    
    public int getCodtur() {
        return codtur;
    }

    public String getNome() {
        return nome;
    }

    public void setCodtur(int codtur) {
        this.codtur = codtur;
    }
    
    public void setCodtur(String codtur){
        setCodtur(Integer.parseInt(codtur));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    
}
