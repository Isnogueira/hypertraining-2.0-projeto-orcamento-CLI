package br.com.mirante.projetoOrcamento.repository;

import java.util.List;

import br.com.mirante.projetoOrcamento.domain.Orcamento;

public interface OrcamentoRepository {

	int obterMaiorId();

	void salvar(Orcamento orcamento);

	List<Orcamento> listar();
	
	Orcamento recuperar(int id);


}
