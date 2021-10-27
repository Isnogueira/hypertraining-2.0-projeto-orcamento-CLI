package br.com.mirante.projetoOrcamento.repository;

import java.util.List;

import br.com.mirante.projetoOrcamento.domain.Orcamento;
import jakarta.persistence.EntityManager;

public class OrcamentoRepositoryJpa implements OrcamentoRepository{

	private EntityManager entityManager = JpaUtils.getEntityManager();

	@Override
	public Integer obterMaiorId() {

		var maiorId = entityManager.createQuery("select max(o.id) from Orcamento o").getSingleResult();
		return maiorId == null? 0 : (Integer) maiorId;
	}

	@Override
	public void salvar(Orcamento orcamento) {
		entityManager.getTransaction().begin();
		entityManager.persist(orcamento);
		var itens = orcamento.getItensOrcamento().stream().map(i -> {
			i.setOrcamento(orcamento);
			return i;
		});
		itens.forEach(entityManager::persist);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Orcamento> listar() {
		return entityManager.createQuery("from Orcamento", Orcamento.class).getResultList();

	}

	@Override
	public Orcamento recuperar(int id) {
		return entityManager.find(Orcamento.class, id);
	}


}
