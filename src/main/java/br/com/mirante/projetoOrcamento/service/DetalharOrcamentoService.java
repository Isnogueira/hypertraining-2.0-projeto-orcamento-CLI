package br.com.mirante.projetoOrcamento.service;

import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepository;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepositoryJpa;

public class DetalharOrcamentoService {
	
	OrcamentoRepository repository = new OrcamentoRepositoryJpa();

	public Orcamento recuperar(int id) {
	
		return repository.recuperar(id);
	}


}
