package br.com.mirante.projetoOrcamento.service;

import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepository;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepositoryEmJava;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepositoryJdbc;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepositoryJpa;

public class CadastrarOrcamentoService {
	
	public OrcamentoRepository repository = new OrcamentoRepositoryJpa();
	
	public void cadastrar(Orcamento orcamento) {
		
		int maiorId = repository.obterMaiorId();
		orcamento.setId(maiorId + 1);
		repository.salvar(orcamento);
		
	}

}
