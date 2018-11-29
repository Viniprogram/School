package br.com.sisescola.transferencia;

public class Turma {
    private int codtur;
    private String nome;
    private String turno;
        
    public Turma(){
        this(0,"","");
    }
    
    public Turma(int codtur, String nome, String turno){
        setCodtur(codtur);
        setNome(nome);
        setTurno(turno);
    } 
    
    public int getCodtur() {
        return codtur;
    }

    public String getNome() {
        return nome;
    }

    public String getTurno() {
        return turno;
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

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Turma{" + "codtur=" + codtur + ", nome=" + nome + ", turno=" + turno + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codtur;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Turma other = (Turma) obj;
        if (this.codtur != other.codtur) {
            return false;
        }
        return true;
    }
}
