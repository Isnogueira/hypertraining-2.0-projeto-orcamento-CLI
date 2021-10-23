package br.com.mirante.projetoOrcamento;

import java.sql.SQLException;

import jakarta.persistence.Entity;
//import br.com.mirante.projetoOrcamento.domain.Orcamento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

@Entity
class Aluno{
	@Id
	String nome;
	public String getNome() {
		return nome;
	}
}

public class Teste {
	
	public static void main(String[] args) throws SQLException {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("default");
		EntityManager entityManager = fabrica.createEntityManager();
		//entityManager.persist(new Orcamento());
	}

}
