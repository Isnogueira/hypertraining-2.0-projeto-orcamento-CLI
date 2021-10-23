package br.com.mirante.projetoOrcamento.repository;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;

public class ItemRepositoryJpa implements ItemRepository{

	@Override
	public void excluir(Integer idItem) {
		
		var entityManager = JpaUtils.getEntityManager();
		var itemrecuperado = entityManager.find(ItemOrcamento.class, idItem);
		
		if(itemrecuperado != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(itemrecuperado);
		entityManager.getTransaction().commit();
		}
		
	}

}
