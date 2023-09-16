package ativ3;

import java.util.List;

public interface Repositorio {//Porta de Saída
    void salvarTarefa(Tarefa tarefa);
    Tarefa buscarTarefaPorId(int id);
    List<Tarefa> listarTarefas();
    void atualizarTarefa(Tarefa tarefa);
    void excluirTarefa(int id);
}