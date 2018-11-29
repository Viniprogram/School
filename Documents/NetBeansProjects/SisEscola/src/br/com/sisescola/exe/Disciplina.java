package br.com.sisescola.exe;

public class Disciplina {
    private int coddis;
    private String nome;
    private int idProfessor;    
        
    public Disciplina(){
        this(0,"",0);
    }
    
    public Disciplina(int coddis, String nome){
        setCoddis(coddis);
        setNome(nome);
    }
    
    public Disciplina(int coddis, String nome, int idProfessor){
        setCoddis(coddis);        
        setNome(nome);  
        setIdProfessor(idProfessor);
    }

    public int getCoddis() {
        return coddis;
    }    

    public String getNome() {
        return nome;
    }    
    
    public int getIdProfessor() {
        return idProfessor;
    }

    public void setCoddis(int coddis) {
        this.coddis = coddis;
    }
    
    public void setCoddis(String coddis){
        setCoddis(Integer.parseInt(coddis));        
    }    

    public void setNome(String nome) {
        this.nome = nome;
    }  
    
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    
    public void setIdProfessor(String idProfessor) {
        setIdProfessor(Integer.parseInt(idProfessor));
    }

    @Override
    public String toString() {
        return "Disciplina{" + "coddis=" + coddis + ", nome=" + nome + ", idProfessor=" + idProfessor + '}';
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
