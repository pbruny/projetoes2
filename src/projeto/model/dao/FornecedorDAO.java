package projeto.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Fornecedor;

public class FornecedorDAO {
	
	public void Create(Fornecedor fornecedor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO fornecedor (cnpj, nome) VALUES (?, ?)");
			stmt.setLong(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getNome());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao salvar, tente novamente");
		} finally {
			ConnectionFactory.CloseConnection(con, stmt);
		}
	}
	
	public List<Fornecedor> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM fornecedor");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCnpj(rs.getLong("cnpj"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedores.add(fornecedor);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.CloseConnection(con, stmt, rs);
		}
		
		return fornecedores;
	}
	
	public void Update(Fornecedor fornecedor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE fornecedor SET nome = ? WHERE cnpj = ?");
			stmt.setString(1, fornecedor.getNome());
			stmt.setLong(2, fornecedor.getCnpj());
			
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
	
	public void Delete(Fornecedor fornecedor) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM fornecedor WHERE cnpj = ?");
			stmt.setLong(1, fornecedor.getCnpj());
			
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
