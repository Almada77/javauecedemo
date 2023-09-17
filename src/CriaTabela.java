import java.sql.PreparedStatement;
import java.sql.SQLException;

import persistencia.Conexao;

public class CriaTabela {
	public static void main(String[] args) {
		String sql = "CREATE TABLE Tarefa ("
				+ "		 id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "		 titulo TEXT NOT NULL,"
				+ "		 descricao TEXT NOT NULL,"
				+ "		 fone TEXT NOT NULL,"
				+ "		 email TEXT NOT NULL"
				+ "		)";
		
		 try (PreparedStatement stmt = Conexao.obterConexao().prepareStatement(sql)) {
	         stmt.executeUpdate();
	         System.out.println("Tabela criada com sucesso");
	        } catch (SQLException e) {
	            // Tratar exceções aqui
	            e.printStackTrace();
	        }
	}
}

