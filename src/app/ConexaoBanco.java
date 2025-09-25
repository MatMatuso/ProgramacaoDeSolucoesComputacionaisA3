package app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class ConexaoBanco {

	public static void main(String[] args) {
		ConexaoBanco start = new ConexaoBanco();
	
			
		
		
		  
	}
	
	private Connection conn;
	public ConexaoBanco() {
	   String url = "jdbc:mysql://localhost:3306/programaprojeto"; 
        String usuario = "root";
        String senha = "12345";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

           
            conn = DriverManager.getConnection(url, usuario, senha);
           

            System.out.println("Conexão bem-sucedida!");


        } catch (ClassNotFoundException e) {
            System.err.println("Driver do MySQL não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
	
	public void adicionaUsuario(String nome, String cpf, String email, String cargo, String login, String senha, String perfil)  {
		try{
			String sqlquery = "insert into Usuarios(nome,cpf,email,cargo,login,senha,perfil) values (?,?,?,?,?,?,?)";
			PreparedStatement busca =    conn.prepareStatement(sqlquery);
			
			busca.setString(1, nome);
			busca.setString(2, cpf);
			busca.setString(3, email);
			busca.setString(4, cargo);
			busca.setString(5, login);
			busca.setString(6, senha);
			busca.setString(7, perfil);
			busca.executeUpdate();
		
	    } catch (SQLException e) {
	    	System.out.println("Errou!!!");
	    }
	}

	public boolean validaUsuario(String login, String senha) {
		
		try{
			String sqlquery = "SELECT * FROM Usuarios WHERE login = " + "\"" + login + "\"" + " AND " + "senha = " + "\"" + senha + "\"";
			PreparedStatement busca =    conn.prepareStatement(sqlquery);
	        ResultSet resultado = busca.executeQuery();
	        boolean autenticado = resultado.next();
	        return autenticado;
		
	    } catch (SQLException e) {
	    	System.out.println("Errou!!!");
	    	return false;
	    }
       
	}







}
