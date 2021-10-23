package br.com.mirante.projetoOrcamento.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;
import br.com.mirante.projetoOrcamento.domain.Orcamento;
import br.com.mirante.projetoOrcamento.service.CadastrarOrcamentoService;

public class CadastrarOrcamentoUI implements Funcionalidade{

	private CadastrarOrcamentoService service = new CadastrarOrcamentoService();

	Scanner scanner = new Scanner(System.in);

	public void executar() {

		System.out.println("Informe a Descrição: ");
		String descricao = scanner.nextLine();

		System.out.println("Informe o mes: ");
		int mes = scanner.nextInt();

		System.out.println("Informe o ano: ");
		int ano = scanner.nextInt();

		System.out.println("Informe o valor total do orcamento: ");
		float valorTotal = scanner.nextInt();

		scanner.nextLine();

		System.out.println("Informe um item de orçamento: ");
		var item = scanner.nextLine();

		List<String> itens = new ArrayList<>();

		itens.add(item);

		System.out.println("Deseja incluir um novo item? [S]/[N]");
		var resp = scanner.nextLine();

		while (resp.equalsIgnoreCase("S")) {

			System.out.println("Informe um item de orçamento: ");
			item = scanner.nextLine();

			itens.add(item);

			System.out.println("Deseja incluir um novo item? S/N");
			resp = scanner.nextLine();
		}

		List<ItemOrcamento> itensOrcamento = itens.stream().map(this::converter).toList();

		var orcamento = new Orcamento(descricao, mes, ano, valorTotal, itensOrcamento);

		service.cadastrar(orcamento);

		System.out.println("=============================================");
		System.out.println("Orçamento cadastrado com sucesso!");
		System.out.println("=============================================");

		/*
		 * IMPUT DE TESTE
		 * IBGE;1234;Arroz;10;KG;8;80
		 * IBGE;4567;Feijão;5;KG;10;50
		 * IBGE;9876;Carne;30;KG;50;150
		 */

		new MenuPrincipal().executar();
	}

	private ItemOrcamento converter(String item) {

		String atributos[] = item.split(";");

		String origem = atributos[0];
		String codigo = atributos[1];
		String descricao = atributos[2];
		float valorUnitario = Float.parseFloat(atributos[3]);
		String unidade = atributos[4];
		float quantidade = Float.parseFloat(atributos[5]);
		float valorTotalInformado = Float.parseFloat(atributos[6]);

		return new ItemOrcamento(origem, codigo, descricao, valorUnitario, unidade, quantidade, valorTotalInformado);
	}
}
