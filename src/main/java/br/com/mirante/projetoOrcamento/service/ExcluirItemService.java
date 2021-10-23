package br.com.mirante.projetoOrcamento.service;

import br.com.mirante.projetoOrcamento.repository.ItemRepository;
import br.com.mirante.projetoOrcamento.repository.ItemRepositoryJdbc;
import br.com.mirante.projetoOrcamento.repository.ItemRepositoryJpa;

public class ExcluirItemService {

	private ItemRepository repository = new ItemRepositoryJpa();

	public void excluirItem(Integer idItem) {

		repository.excluir(idItem);
	}
}
