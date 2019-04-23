/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.geval.teste.dao;

import br.com.geval.dao.LoginDAO;
import br.com.geval.model.Login;

/**
 *
 * @author Gutemberg
 */
public class LoginTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Login l = new Login();
        l.setUsuario("admin");
        l.setSenha("admin");
        
        LoginDAO lDAO = new LoginDAO();
        System.out.println(lDAO.validarLogin(l));
    }
    
}
