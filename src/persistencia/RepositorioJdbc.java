package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import negocio.Tarefa;

/**
 * Implementação da Porta de Saída, no caso saída para o banco de dados
 */
public class RepositorioJdbc implements Repositorio {
	
    private Connection conexao;

    public RepositorioJdbc() {
		
        try {
        	
			this.conexao = Conexao.obterConexao();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (titulo, descricao, fone, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getFone());
            stmt.setString(4, tarefa.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    @Override
    public Tarefa buscarTarefaPorId(int id) {
        String sql = "SELECT * FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return mapearResultadoParaTarefa(resultado);
            }
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefa";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                tarefas.add(mapearResultadoParaTarefa(resultado));
            }
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
        return tarefas;
    }

    @Override
    public void atualizarTarefa(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET titulo = ?, descricao = ?, fone = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getFone());
            stmt.setString(4, tarefa.getEmail());
            stmt.setInt(5, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    @Override
    public void excluirTarefa(int id) {
        String sql = "DELETE FROM tarefa WHERE id = ?";
        try (PreparedStatement stmt = prepararInstrucaoSQL(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Tratar exceções aqui
            e.printStackTrace();
        }
    }

    /*
     *  A partir daqui seguem os Métodos privados para auxiliar nas operações com o banco de dados
     */
    
    private Tarefa mapearResultadoParaTarefa(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String titulo = resultado.getString("titulo");
        String descricao = resultado.getString("descricao");
        String fone = resultado.getString("fone");
        String email = resultado.getString("email");
        return new Tarefa(id, titulo, descricao, fone, email);
    }

    private PreparedStatement prepararInstrucaoSQL(String sql) throws SQLException {
        return conexao.prepareStatement(sql);
    }
    
}