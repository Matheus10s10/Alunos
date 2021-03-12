package alunos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AlunosDAO {
	private ConnMySQL bd;
	
	public AlunosDAO(){
		bd = new ConnMySQL();
		bd.openDB();
	}
	
	
	public void insert(String codigo,String nome,
				String idade,String cpf,String telefone,String endereco){
		String declaracao = "insert into alunos values(?,?,?,?,?,?)";
		bd.criaPreparedStatement(bd.conn, declaracao);
		try{
			bd.pstm.setString(1,codigo);
			bd.pstm.setString(2,nome);
			bd.pstm.setString(3,idade);
			bd.pstm.setString(4,cpf);
			bd.pstm.setString(5,telefone);
			bd.pstm.setString(6,endereco);
			System.out.println(bd.pstm.executeUpdate()+" foi inserido(a) com sucesso");
			bd.pstm.close();
		}catch(SQLException e){
			System.out.println("Erro no Isert:");
			e.printStackTrace();
			
		}
	}
	
	public void deleteCPF(String cpf){
		String declaracao = "delete from alunos where cpf = ?";
		bd.criaPreparedStatement(bd.conn, declaracao);
		try {
			bd.pstm.setString(1, cpf);
			System.out.println(bd.pstm.executeUpdate()+" foi deletado com sucesso: ");
			//bd.pstm.executeUpdate();
			bd.pstm.close();
		} catch (SQLException e) {
			System.out.println("Erro delete: ");
			e.printStackTrace();
		}
	}
	
	public void deleteCod(String codigo){
		String declaracao = "delete from alunos where codigo = ?";
		bd.criaPreparedStatement(bd.conn, declaracao);
		try {
			bd.pstm.setString(1, codigo);
			System.out.println(bd.pstm.executeUpdate()+1+" foi deletado com sucesso: ");
			bd.pstm.executeUpdate();
			bd.pstm.close();
		} catch (SQLException e) {
			System.out.println("Erro delete: ");
			e.printStackTrace();
		}
	}
	public void update(String codigo,String nome,String idade,
			String cpf,String telefone,String endereco){
		String declaracao="update alunos set codigo =?"+
							",nome=?"+
							",idade=?"+
							",telefone=?"+
							",endereco=?"+
							" where cpf = ?";
		bd.criaPreparedStatement(bd.conn, declaracao);
		try {
			bd.pstm.setString(1,codigo );
			bd.pstm.setString(2,nome );
			bd.pstm.setString(3,idade );
			bd.pstm.setString(4,telefone);
			bd.pstm.setString(5,endereco );
			bd.pstm.setString(6,cpf );
			
		} catch (SQLException e) {
			System.out.println("Erro update");
			e.printStackTrace();
		}
	}
	public AlunosTO consultaAlunos(String cpf){
		 ResultSet x;
		    int contador = 0, total = 0;
		    String declaracao = "select * from alunos where cpf = ? ";
		    bd.criaPreparedStatement(bd.conn,declaracao);
		    AlunosTO consulta   = new AlunosTO();
		    try {
		        bd.pstm.setString(1,cpf);
		        //System.out.println(declaracao);
		        x = bd.pstm.executeQuery();

		         while (x.next())
		        {
		            consulta.setCodigo(x.getString("codigo"));
		            consulta.setNome(x.getString("nome"));
		            consulta.setIdade(x.getString("idade"));
		            consulta.setCpf(x.getString("cpf"));
		            consulta.setTelefone(x.getString("telefone"));
		            consulta.setEndereco(x.getString("endereco"));
		        }
		        x.close();
		        bd.pstm.close();

		        return consulta;

		    }
		    catch (SQLException e ) {
		        System.out.println("ERRO SELECT: " );
		        e.printStackTrace();
		    }
		    return consulta;
	}
}
