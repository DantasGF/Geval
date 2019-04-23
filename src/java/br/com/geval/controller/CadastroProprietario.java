package br.com.geval.controller;

import br.com.geval.dao.ProprietarioDAO;
import br.com.geval.model.Endereco;
import br.com.geval.model.Login;
import br.com.geval.model.Proprietario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gutemberg
 */
public class CadastroProprietario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone= request.getParameter("telefone");
        String email = request.getParameter("email");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String rua = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        Login login = new Login();
        login.setUsuario(usuario);
        login.setSenha(senha);
        
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(nome);
        proprietario.setSobrenome(sobrenome);
        proprietario.setTelefone(telefone);
        proprietario.setEmail(email);
        proprietario.setLogin(login);
        proprietario.setEndereco(endereco);
        proprietario.setSexo(sexo);
        
        ProprietarioDAO proprietarioDAO = new ProprietarioDAO();
        proprietarioDAO.inserir(proprietario);
        
        String urlRedirecionamento = "http://localhost:8080/Geval/index.jsp";
        response.sendRedirect(urlRedirecionamento);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
