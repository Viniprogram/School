package br.com.sisescola.transferencia;

public class Professor {
    private int codpro;
    private String nome;
    
    public Professor(){
        this(0,"");
    }
    
    public Professor(int codpro, String nome){
        setCodpro(codpro);
        setNome(nome);
    }   

    public int getCodpro() {
        return codpro;
    }

    public String getNome() {
        return nome;
    }

    public void setCodpro(int codpro) {
        this.codpro = codpro;
    }
    
    public void setCodpro(String codpro){
        setCodpro(Integer.parseInt(codpro));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    @Override
    public String toString() {
        return nome ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codpro;
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
        if (this.codpro != other.codpro) {
            return false;
        }
        return true;
    }
}
