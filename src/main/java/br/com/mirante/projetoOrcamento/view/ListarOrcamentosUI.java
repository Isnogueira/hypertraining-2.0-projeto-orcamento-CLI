package br.com.mirante.projetoOrcamento.view;

import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.service.ListarOrcamentosService;

public class ListarOrcamentosUI implements Funcionalidade{

	private ListarOrcamentosService service = new ListarOrcamentosService();
	
	public void executar() {
		
		var orcamentos = service.listarOrcamentos();
		
		for(Orcamento orcamento : orcamentos) {
			
			UiUtils.imprimirOrcamento(orcamento);
		}
		
		new MenuPrincipal().executar();
	}

}
