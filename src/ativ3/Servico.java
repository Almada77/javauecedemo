package ativ3;

import java.util.List;
import java.util.Scanner;

import ativ3.Repositorio;

public class Servico {

	private Repositorio servicoTarefa;

	public Servico(Repositorio servicoTarefa) {
		this.servicoTarefa = servicoTarefa;
	}

	public void listarTarefas() {
		List<Tarefa> tarefas = servicoTarefa.listarTarefas();
		if (tarefas.isEmpty()) {
			System.out.println("Nenhum dado encontrado.");
		} else {
			System.out.println("==== Tarefas ====");
			for (Tarefa tarefa : tarefas) {
				System.out.println("ID: " + tarefa.getId());
				System.out.println("Nome: " + tarefa.getTitulo());
				System.out.println("Endereço: " + tarefa.getDescricao());
				System.out.println("Telefone: " + tarefa.getFone());
				System.out.println("Email: " + tarefa.getEmail());
				System.out.println("-----------------");
			}
		}
	}

	public void criarTarefa(Scanner scanner) {
		System.out.print("Digite o nome do contato: ");
		String titulo = scanner.nextLine();
		System.out.print("Digite o endereço do contato: ");
		String descricao = scanner.nextLine();
		System.out.print("Digite o telefone do contato: ");
		String fone = scanner.nextLine();
		System.out.print("Digite o email do contato: ");
		String email = scanner.nextLine();

		Tarefa novaTarefa = new Tarefa(0, titulo, descricao, fone, email);
		servicoTarefa.salvarTarefa(novaTarefa);
		System.out.println("Dados criados com sucesso!");
	}

	public void atualizarTarefa(Scanner scanner) {
		System.out.print("Digite o ID do contato da Agenda que deseja editar: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		Tarefa tarefaExistente = servicoTarefa.buscarTarefaPorId(id);

		if (tarefaExistente == null) {
			System.out.println("Dados não encontrados.");
			return;
		}

		System.out.print("Digite o novo nome do contato: ");
		String novoTitulo = scanner.nextLine();
		System.out.print("Digite o novo endereço do contato: ");
		String novaDescricao = scanner.nextLine();
		System.out.print("Digite o novo telefone do contato: ");
		String novoFone = scanner.nextLine();
		System.out.print("Digite o novo email do contato: ");
		String novoEmail = scanner.nextLine();

		Tarefa tarefaAtualizada = new Tarefa(id, novoTitulo, novaDescricao, novoFone, novoEmail);
		servicoTarefa.atualizarTarefa(tarefaAtualizada);
		System.out.println("Contato atualizado com sucesso!");
	}

	public void removerTarefa(Scanner scanner) {
		System.out.print("Digite o ID do contato que deseja remover: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		Tarefa tarefaExistente = servicoTarefa.buscarTarefaPorId(id);

		if (tarefaExistente == null) {
			System.out.println("Contato não encontrado.");
			return;
		}

		servicoTarefa.excluirTarefa(id);
		System.out.println("Contato removido com sucesso!");
	}
}