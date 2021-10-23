package br.com.mirante.projetoOrcamento.service;

import java.util.List;

import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepository;
import br.com.mirante.projetoOrcamento.repository.OrcamentoRepositoryJpa;

public class ListarOrcamentosService {
	
	private OrcamentoRepository repository = new OrcamentoRepositoryJpa();
	
	public List<Orcamento> listarOrcamentos(){
		
		return repository.listar();
	}

}
