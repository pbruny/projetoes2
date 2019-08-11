package projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}
