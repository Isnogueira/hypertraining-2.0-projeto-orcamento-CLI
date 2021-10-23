package br.com.mirante.projetoOrcamento.view;

import java.util.stream.Stream;

public enum OpcoesMenuPrincipal {

	CADASTRAR_ORCAMENTO("1", "Cadastrar orçamento",new CadastrarOrcamentoUI()), 
	LISTAR_ORCAMENTO("2", "Listar Orçamento", new ListarOrcamentosUI()),
	DETALHAR_ORCAMENTO("3", "Detalhar Orçamento", new DetalharOrcamentoUI()),
	SAIR("4","Sair", new Sair());
	
	private String numero;
	private String descricao;
	private Funcionalidade executor;
	
	private OpcoesMenuPrincipal(String numero, String descricao, Funcionalidade executor) {
		
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

	static OpcoesMenuPrincipal get(String numero) {
	
		return Stream.of(values()).filter(m -> m.numero.equals(numero)).findFirst().orElse(null);
	}

	static boolean existe(String opcao) {
		
		return Stream.of(values()).anyMatch(m -> m.numero.equals(opcao));
	}

}
