package br.com.geval.dao;

import br.com.geval.model.Estabelecimento;
import br.com.geval.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gutemberg
 */
public class EstabelecimentoDAO {
    
    public Connection con;
    
    public EstabelecimentoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean inserir(Estabelecimento e){
        try {
            String sql = "INSERT INTO estabelecimento (nome, telefone, rua, bairro,"
                    + " cidade, estado, proprietario_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getTelefone());
            stmt.setString(3, e.getEndereco().getRua());
            stmt.setString(4, e.getEndereco().getBairro());
            stmt.setString(5, e.getEndereco().getCidade());
            stmt.setString(6, e.getEndereco().getEstado());
            stmt.setInt(7, e.getProprietario().getId());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:EstabelecimentoDAO:inserir = " + ex);
        }
        return false;
    }
}
