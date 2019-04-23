/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.geval.teste.dao;

import br.com.geval.dao.ProprietarioDAO;

/**
 *
 * @author Gutemberg
 */
public class ProprietarioTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProprietarioDAO pDAO = new ProprietarioDAO();
        System.out.println(pDAO.retornaProprietario(1).getNome());
    }
    
}
