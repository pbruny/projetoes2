package projeto.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Cliente;

public class ClienteDAO {
	
	public void Create(Cliente cliente) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO cliente (cpf, nome, endereco, telefone) VALUES (?, ?, ?, ?)");
			stmt.setLong(1, cliente.getCpf());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getTelefone());
			
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
	
	public List<Cliente> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCpf(rs.getLong("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getLong("telefone"));
				clientes.add(cliente);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.CloseConnection(con, stmt, rs);
		}
		
		return clientes;
	}
	
	public void Update(Cliente cliente) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE cliente SET nome = ?, endereco = ?, telefone = ? WHERE cpf = ?");
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setLong(3, cliente.getTelefone());
			stmt.setLong(4, cliente.getCpf());
			
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
	
	public void Delete(Cliente cliente) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
			stmt.setLong(1, cliente.getCpf());
			
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
