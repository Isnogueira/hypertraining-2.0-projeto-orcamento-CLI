package br.com.mirante.projetoOrcamento.view;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;
import br.com.mirante.projetoOrcamento.domain.Orcamento;

public class UiUtils {
	
	static void imprimirOrcamento(Orcamento orcamento) {
		System.out.print(orcamento.getId());
		System.out.print("   |");
		System.out.print(orcamento.getDescricao());
		System.out.print("   |");
		System.out.print(orcamento.getMes() + "/" + orcamento.getAno());
		System.out.print("   |");
		System.out.println(orcamento.getValorTotalInformado());
		System.out.println("==============================================");

	}
	
	static void imprimirItensOrcamento(ItemOrcamento item) {
		System.out.print(item.getId());
		System.out.print("\nOrigem: " + item.getOrigem());
		System.out.print("\nCódigo: " + item.getCodigo());
		System.out.print("\nDescrição: " + item.getDescricao());
		System.out.print("\nValor unitário: " + item.getValorUnitario());
		System.out.print("\nUnidade: " + item.getUnidade());
		System.out.print("\nQuantidade: " + item.getQuantidade());
		System.out.println("\nValor total: R$" + item.getValorTotalInformado());
		System.out.println("Possui inconsistencia?");
		System.out.println(item.possuiInconsistencia() ? "Sim" : "Não");
		System.out.println("==============================================");
		
		
	}

}
