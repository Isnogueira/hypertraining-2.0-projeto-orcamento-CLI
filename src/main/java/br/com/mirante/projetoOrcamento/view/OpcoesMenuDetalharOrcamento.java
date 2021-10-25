package br.com.mirante.projetoOrcamento.view;

import java.util.stream.Stream;

public enum OpcoesMenuDetalharOrcamento {

	EDITAR_ITEM("1", "Editar item", null), 
	EXCLUIR_ITEM("2", "Excluir item", new ExcluirItemOrcamento()),
	MENU_PRINCIPAL("3", "Detalhar Orçamento", new MenuPrincipal()),
	SAIR("4","Sair", new Sair());

	private String numero;
	private String descricao;
	private Funcionalidade executor;
	
	private OpcoesMenuDetalharOrcamento(String numero, String descricao, Funcionalidade executor) {
		this.numero = numero;
		this.descricao = descricao;
		this.executor = executor;
	}
	
	void exibir() {
		
		System.out.println("[" + numero + "]" + " - " + descricao);
	}
	
	public void executar() {
		
		executor.executar();
	}

	static OpcoesMenuDetalharOrcamento get(String numero) {
	
		return Stream.of(values()).filter(m -> m.numero.equals(numero)).findFirst().orElse(null);
	}

	static boolean existe(String opcao) {
		
		return Stream.of(values()).anyMatch(m -> m.numero.equals(opcao));
	}

}
