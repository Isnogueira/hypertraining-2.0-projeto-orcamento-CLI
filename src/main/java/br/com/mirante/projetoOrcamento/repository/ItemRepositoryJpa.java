package br.com.mirante.projetoOrcamento.repository;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;
import jakarta.persistence.EntityManager;

public class ItemRepositoryJpa implements ItemRepository{

	private EntityManager entityManager;
	
	@Override
	public void excluir(Integer idItem) {
		
		entityManager = JpaUtils.getEntityManager();
		var itemrecuperado = entityManager.find(ItemOrcamento.class, idItem);
		
		if(itemrecuperado != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(itemrecuperado);
		entityManager.getTransaction().commit();
		}
		
	}

}
