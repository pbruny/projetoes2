package projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Pecas;

public class PecasDAO {
	
	public void Create(Pecas peca) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO pecas (codigoPeca, nome) VALUES (?, ?)");
			stmt.setLong(1, peca.getCodigoPeca());
			stmt.setString(2, peca.getNome());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao salvar, tente novamente");
			e.printStackTrace();
		} finally {
			ConnectionFactory.CloseConnection(con, stmt);
		}
	}
	
	public List<Pecas> read() {
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    List<Pecas> pecas = new ArrayList<>();
	    
	    try {
	        stmt = con.prepareStatement("SELECT * FROM pecas");
	        rs = stmt.executeQuery();
	        while(rs.next()) {
	            Pecas peca = new Pecas();
	            peca.setCodigoPeca(rs.getInt("codigoPeca"));
	            peca.setNome(rs.getString("nome"));
	            pecas.add(peca);
	            
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        ConnectionFactory.CloseConnection(con, stmt, rs);
	    }
	    
	    return pecas;
	}

	public void Update(Pecas peca) {
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    
	    try {
	        stmt = con.prepareStatement("UPDATE pecas SET nome = ? WHERE codigoPeca = ?");
	        stmt.setString(1, peca.getNome());
	        stmt.setLong(2, peca.getCodigoPeca());
	        
	        stmt.executeUpdate();
	        
	        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar, tente novamente");
	        e.printStackTrace();
	    } finally {
	        ConnectionFactory.CloseConnection(con, stmt);
	    }
	}

	public void Delete(Pecas peca) {
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    
	    try {
	        stmt = con.prepareStatement("DELETE FROM pecas WHERE codigoPeca = ?");
	        stmt.setLong(1, peca.getCodigoPeca());
	        
	        stmt.executeUpdate();
	        
	        JOptionPane.showMessageDialog(null, "Removido com sucesso!");
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        JOptionPane.showMessageDialog(null, "Erro ao remover, tente novamente");
	        e.printStackTrace();
	    } finally {
	        ConnectionFactory.CloseConnection(con, stmt);
	    }
	}

}
