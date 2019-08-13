package projeto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/dboficina?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private final static String USER = "root";
	private final static String PASS = "root";
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro na conexão "+e);
		}
	}
	
	public static void CloseConnection(Connection con) {
			try {
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void CloseConnection(Connection con, PreparedStatement stmt) {
		
		CloseConnection(con);
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
			
			CloseConnection(con, stmt);
			
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
