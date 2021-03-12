package alunos;

import java.sql.*;

public class ConnMySQL {
	
	public PreparedStatement pstm;
	public Connection conn;
	private final static String user ="root";
	private final static String pass = "root";
	private final static String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false";
	private final static String driver = "com.mysql.jdbc.Driver";
	
	public void openDB(){
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException e){
			System.out.println("Erro ao carregaro DriverMYSQL");
		}
		catch(SQLException e){
			System.out.println("Erro na conexão com MYSQL");
			e.printStackTrace();
		}
		
			
		
	}
	
	public void criaPreparedStatement(Connection x,String declaracao){
		try {
				pstm = x.prepareStatement(declaracao);
		} catch (SQLException e) {
			System.out.println("Erro Statement no MYSQL");
			System.exit(1);;
		}
	}
}
