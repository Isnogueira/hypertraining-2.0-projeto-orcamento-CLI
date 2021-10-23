package br.com.mirante.projetoOrcamento.view;

import java.util.Scanner;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;
import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.service.DetalharOrcamentoService;

public class DetalharOrcamentoUI implements Funcionalidade{

	DetalharOrcamentoService service = new DetalharOrcamentoService();
	
	Scanner scanner = new Scanner(System.in);
	
	public void executar() {
		
		System.out.println("Informe o código do orçamento");
		int id = scanner.nextInt();
		
		Orcamento orcamentoRecuperado = service.recuperar(id);
		
		if (orcamentoRecuperado == null) {
			
			System.out.println("Não há um orçamento com o código " + id);
			
		} else {
			
			UiUtils.imprimirOrcamento(orcamentoRecuperado);
			System.out.println("Itens: " );
			System.out.println("--------------------------------------------");
			
			for (ItemOrcamento item : orcamentoRecuperado.getItensOrcamento()) {
				
				UiUtils.imprimirItensOrcamento(item);
			}
		}
		
		new MenuDetalharOrcamentoUI().executar();
	}

	
}
