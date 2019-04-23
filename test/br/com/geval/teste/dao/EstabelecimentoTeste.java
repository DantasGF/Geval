/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.geval.teste.dao;

import br.com.geval.dao.EstabelecimentoDAO;
import br.com.geval.dao.ProprietarioDAO;
import br.com.geval.model.Endereco;
import br.com.geval.model.Estabelecimento;
import br.com.geval.model.Proprietario;

/**
 *
 * @author Gutemberg
 */
public class EstabelecimentoTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EstabelecimentoDAO eDAO = new EstabelecimentoDAO();
        Estabelecimento e = new Estabelecimento();
        e.setNome("Bar do Gutim");
        Proprietario p = new ProprietarioDAO().retornaProprietario(1);
        System.out.println(p.getNome());
        Endereco endereco = new Endereco();
        endereco.setRua("TesteRua");
        endereco.setBairro("TesteBairro");
        endereco.setCidade("TesteCidade");
        endereco.setEstado("TesteEstado");
        e.setProprietario(p);
        e.setEndereco(endereco);
        e.setTelefone("83900000000");
        
        System.out.println(eDAO.inserir(e));
        
    }
    
}
