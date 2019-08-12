package projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Entrada;

public class EntradaDAO {
	
	public void Create(Entrada entrada) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO entrada (id, codigoProduto, cnpj, qtd, valor) VALUES (?, ?, ?, ?, ?)");
			stmt.setLong(1, entrada.getId());
			stmt.setLong(2, entrada.getCodigoProduto());
			stmt.setLong(3, entrada.getCnpj());
			stmt.setLong(4, entrada.getQtd());
			stmt.setDouble(5, entrada.getValor());
			
			
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
	
}
