package ativ3;

import ativ3.Interface;
import ativ3.Servico;
import ativ3.Repositorio;
import ativ3.RepositorioJdbc;

public class AgendaContato {
	
	public static void main(String[] args) {

		try {
			
						// Acesso  a camada de Persitência
						Repositorio repositorioTarefa = new RepositorioJdbc();

						// Acesso a camada de serviços/Negócio
						Servico servicoTarefa = new Servico(repositorioTarefa);

						// Acesso a interface de usuário (console, linha de comando, etc.)
						Interface interfaceUsuario = new Interface(servicoTarefa);

						interfaceUsuario.iniciar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}