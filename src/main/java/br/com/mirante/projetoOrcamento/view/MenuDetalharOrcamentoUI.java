package br.com.mirante.projetoOrcamento.view;

import java.util.stream.Stream;

public class MenuDetalharOrcamentoUI extends Menu{

	@Override
	protected void imprimirMenu() {
		
		System.out.println("Digite o número correspondente à opção desejada");
		
		Stream.of(OpcoesMenuDetalharOrcamento.values()).forEach(OpcoesMenuDetalharOrcamento::exibir);
		
	}

	@Override
	protected boolean existe(String opcao) {
		
		return OpcoesMenuDetalharOrcamento.existe(opcao);
	}

	@Override
	protected void processarOpcaoSelecionada(String opcao) {
		
		System.out.println("A opção selecionada foi " + opcao);
		
		OpcoesMenuDetalharOrcamento.get(opcao).executar();
	}

}
