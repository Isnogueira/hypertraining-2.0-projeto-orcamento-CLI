package br.com.mirante.projetoOrcamento.view;

import java.util.Scanner;

public abstract class Menu {
	
	Scanner scanner = new Scanner(System.in);

	public void executar() {

		imprimirMenu();
		String opcao = scanner.next();

		while(!OpcoesMenuPrincipal.existe(opcao)) {
			System.out.println("A op�ao est� inv�lida, tente novamente");
			imprimirMenu();
			opcao = scanner.next();
		}

		processarOpcaoSelecionada(opcao);

	}
	
	protected abstract void imprimirMenu();
	
	protected abstract boolean existe(String opcao);
	
	protected abstract void processarOpcaoSelecionada(String opcao);

}
