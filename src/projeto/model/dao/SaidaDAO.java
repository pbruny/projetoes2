package projeto.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Saida;

public class SaidaDAO {
	
	public void Create(Saida saida) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO saida (cpf, codigoProduto, qtd, valorTotal, formaPag) VALUES (?, ?, ?, ?, ?)");
			stmt.setLong(1, saida.getCpf());
			stmt.setLong(2, saida.getCodigoProduto());
			stmt.setLong(3, saida.getQtd());
			stmt.setDouble(4, saida.getValorTotal());
			stmt.setString(5, saida.getFormaPag());
			
			
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
	
	public List<Saida> read() {
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    List<Saida> saidas = new ArrayList<>();
	    
	    try {
	        stmt = con.prepareStatement("SELECT * FROM saida");
	        rs = stmt.executeQuery();
	        while(rs.next()) {
	            Saida saida = new Saida();
	            saida.setCpf(rs.getLong("cpf"));
	            saida.setCodigoProduto(rs.getInt("codigoProduto"));
	            saida.setQtd(rs.getInt("qtd"));
	            saida.setValorTotal(rs.getDouble("valorTotal"));
	            saida.setFormaPag(rs.getString("formaPag"));
	        }
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } finally {
	        ConnectionFactory.CloseConnection(con, stmt, rs);
	    }
	    
	    return saidas;
	}

	public void Update(Saida saida) {
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    
	    try {
	        stmt = con.prepareStatement("UPDATE saida SET codigoProduto = ?, qtd = ?, valorTotal = ?, formaPag = ? WHERE cpf = ?");
	        stmt.setLong(1, saida.getCodigoProduto());
	        stmt.setLong(2, saida.getQtd());
	        stmt.setDouble(3, saida.getValorTotal());
	        stmt.setString(4, saida.getFormaPag());
	        stmt.setLong(5, saida.getCpf());
	        
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

	public void Delete(Saida saida) {
	    
	    Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    
	    try {
	        stmt = con.prepareStatement("DELETE FROM saida WHERE cpf = ?");
	        stmt.setLong(1, saida.getCpf());
	        
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
