package projeto.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import projeto.connection.ConnectionFactory;
import projeto.model.bean.Entrada;

public class EntradaDAO {
	
	public void Create(Entrada entrada) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO entrada (codigoProduto, cnpj, qtd, valor) VALUES (?, ?, ?, ?)");
			stmt.setLong(1, entrada.getCodigoProduto());
			stmt.setLong(2, entrada.getCnpj());
			stmt.setLong(3, entrada.getQtd());
			stmt.setDouble(4, entrada.getValor());
			
			
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
	
	public List<Entrada> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Entrada> entradas = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM entrada");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Entrada entrada = new Entrada();
				entrada.setId(rs.getInt("id"));
				entrada.setCodigoProduto(rs.getInt("codigoProduto"));
				entrada.setCnpj(rs.getLong("cnpj"));
				entrada.setQtd(rs.getInt("qtd"));
				entrada.setValor(rs.getDouble("valor"));
				entradas.add(entrada);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.CloseConnection(con, stmt, rs);
		}
		
		return entradas;
	}
	
	public void Update(Entrada entrada) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE entrada SET qtd = ?, valor = ?, cnpj = ? WHERE codigoProduto = ?");
			
			stmt.setInt(1, entrada.getQtd());
			stmt.setDouble(2, entrada.getValor());
			stmt.setLong(3, entrada.getCnpj());
			stmt.setInt(4, entrada.getCodigoProduto());
			
			stmt.executeUpdate();
			
			//JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao atualizar, tente novamente");
			e.printStackTrace();
		} finally {
			ConnectionFactory.CloseConnection(con, stmt);
		}
	}
	
	public void Delete(Entrada entrada) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM entrada WHERE id = ?");
			stmt.setLong(1, entrada.getId());
			
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
