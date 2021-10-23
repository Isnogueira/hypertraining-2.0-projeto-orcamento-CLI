package br.com.mirante.projetoOrcamento.view;

import java.util.Scanner;

import br.com.mirante.projetoOrcamento.service.ExcluirItemService;

public class ExcluirItemOrcamento implements Funcionalidade {
	
	private Scanner scanner = new Scanner(System.in);
	private ExcluirItemService service = new ExcluirItemService();

	@Override
	public void executar() {
		System.out.println("Digite o id do item que deseja excluir:");
		Integer idItem = scanner.nextInt();
		service.excluirItem(idItem);

		System.out.println();
		System.out.println("Item excluído com sucesso!");

		new MenuDetalharOrcamentoUI().executar();
	}

}
