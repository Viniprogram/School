package br.com.sisescola.transferencia;

/**
 *
 * @author vinic
 */
public class Usuario {
    private int idUsuario;
    private String login;
    private String senha;

    public int getIdUsuario() {
        return idUsuario;
    }    
    
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }    

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }    
}
