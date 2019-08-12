package projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			stmt.setLong(5, saida.getFormaPag());
			
			
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
