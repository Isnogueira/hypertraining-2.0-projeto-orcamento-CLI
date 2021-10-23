package br.com.mirante.projetoOrcamento.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class MenuPrincipal extends Menu implements Funcionalidade{

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

	protected void imprimirMenu() {

		System.out.println("Digite o n�mero correspondente a op��o desejada:");
		Stream.of(OpcoesMenuPrincipal.values()).forEach(OpcoesMenuPrincipal::exibir);
	}

	

	protected void processarOpcaoSelecionada(String opcao) {
		
		System.out.println("A op�ao selecionada: " + opcao);

		OpcoesMenuPrincipal.get(opcao).executar();
	}

	@Override
	protected boolean existe(String opcaoSelecionada) {
		return OpcoesMenuPrincipal.existe(opcaoSelecionada);
	}

	
}
