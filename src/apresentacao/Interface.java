package apresentacao;

import java.util.List;
import java.util.Scanner;

import negocio.Servico;
import negocio.Tarefa;
import persistencia.Repositorio;

public class Interface {
	
    private Servico servicoTarefa;

    public Interface(Servico servicoTarefa) {
        this.servicoTarefa = servicoTarefa;
    }

    public void iniciar() {
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirOpcoesMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (opcao) {
                case 1:
                	servicoTarefa.listarTarefas();
                    break;
                case 2:
                	servicoTarefa.criarTarefa(scanner);
                    break;
                case 3:
                	servicoTarefa.atualizarTarefa(scanner);
                    break;
                case 4:
                	servicoTarefa.removerTarefa(scanner);
                    break;
                case 5:
                    System.out.println("Saindo da aplicação.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void exibirOpcoesMenu() {
    	System.out.println("AGENDA DE CONTATOS");
        System.out.println("==== Menu ====");
        System.out.println("1. Consultar Contato");
        System.out.println("2. Incluir Contato");
        System.out.println("3. Editar Contato");
        System.out.println("4. Deletar Contato");
        System.out.println("5. Sair da Agenda");
        System.out.print("Escolha uma opção: ");
    }

}