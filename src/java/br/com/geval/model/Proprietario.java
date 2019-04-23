package br.com.geval.model;

/**
 *
 * @author Gutemberg
 */
public class Proprietario extends Pessoa {
    
    private Login login;
    
    public Proprietario(){
        
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
