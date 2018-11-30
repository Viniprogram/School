package br.com.sisescola.transferencia;

public class Disciplina {
    private int coddis;
    private int idProfessor;
    private String nome;
        
    public Disciplina(){
        this(0,0,"");
    }
    
    public Disciplina(int coddis, String nome){
        setCoddis(coddis);
        setNome(nome);
    }
    
    public Disciplina(int coddis,int idProfessor, String nome){
        setCoddis(coddis);
        setIdProfessor(idProfessor);
        setNome(nome);        
    }

    public int getCoddis() {
        return coddis;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public String getNome() {
        return nome;
    }    

    public void setCoddis(int coddis) {
        this.coddis = coddis;
    }
    
    public void setCoddis(String coddis){
        setCoddis(Integer.parseInt(coddis));        
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    
    public void setIdProfessor(String idProfessor) {
        setIdProfessor(Integer.parseInt(idProfessor));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.coddis;
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
        final Disciplina other = (Disciplina) obj;
        if (this.coddis != other.coddis) {
            return false;
        }
        return true;
    }    
}
