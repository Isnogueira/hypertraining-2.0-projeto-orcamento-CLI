package br.com.mirante.projetoOrcamento.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.mirante.projetoOrcamento.domain.ItemOrcamento;
import br.com.mirante.projetoOrcamento.domain.Orcamento;

public class OrcamentoRepositoryJdbc implements OrcamentoRepository {
	
	private static final String URL = "jdbc:mysql://localhost/orcamento";
	private static final String USER = "root";
	private static final String PASSWORD = System.getenv().get("SISTEMA_ORCAMENTO_PASSWORD");

	@Override
	public int obterMaiorId() {

		Integer maiorId = null;

		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conexao.createStatement()) {

			ResultSet result = statement.executeQuery("SELECT MAX(ID) AS ID FROM ORCAMENTO");
			result.next();
			maiorId = result.getInt("ID");

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}

		return maiorId;

	}

	@Override
	public void salvar(Orcamento orcamento) {

		String insertOrcamento = "INSERT INTO ORCAMENTO (ID, DESCRICAO, MES, ANO, VALOR_TOTAL_INFORMADO) VALUES (?,?,?,?,?)";
		String insertItem = "INSERT INTO ITEM_ORCAMENTO (ORIGEM, CODIGO, DESCRICAO, UNIDADE, VALOR_UNITARIO, QUANTIDADE, VALOR_TOTAL_INFORMADO, ID_ORCAMENTO)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				var statementOrcamento = conexao.prepareStatement(insertOrcamento);
				var statementItem = conexao.prepareStatement(insertItem)) {

			statementOrcamento.setInt(1, orcamento.getId());
			statementOrcamento.setString(2, orcamento.getDescricao());
			statementOrcamento.setInt(3, orcamento.getMes());
			statementOrcamento.setInt(4, orcamento.getAno());
			statementOrcamento.setFloat(5, orcamento.getValorTotalInformado());

			statementOrcamento.executeUpdate();

			for (var item : orcamento.getItensOrcamento()) {

				statementItem.setString(1, item.getOrigem());
				statementItem.setString(2, item.getCodigo());
				statementItem.setString(3, item.getDescricao());
				statementItem.setString(4, item.getUnidade());
				statementItem.setFloat(5, item.getValorUnitario());
				statementItem.setFloat(6, item.getQuantidade());
				statementItem.setFloat(7, item.getValorTotalInformado());
				statementItem.setInt(8, orcamento.getId());
				
				statementItem.executeUpdate();
			}
			
			

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}

	}

	@Override
	public List<Orcamento> listar() {

		List<Orcamento> orcamentos = new ArrayList<>();

		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conexao.createStatement()) {

			ResultSet result = statement
					.executeQuery("SELECT ID, DESCRICAO, MES, ANO, VALOR_TOTAL_INFORMADO FROM ORCAMENTO");

			while (result.next()) {
				Integer id = result.getInt("ID");
				String descricao = result.getString("DESCRICAO");
				Integer mes = result.getInt("MES");
				Integer ano = result.getInt("ANO");
				Float valorTotalInformado = result.getFloat("VALOR_TOTAL_INFORMADO");
				Orcamento orcamento = new Orcamento(descricao, mes, ano, valorTotalInformado, new ArrayList<>());
				orcamento.setId(id);
				orcamentos.add(orcamento);

			}

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}
		return orcamentos;
	}

	@Override
	public Orcamento recuperar(int id) {
		Orcamento orcamento = null;
		String query = "SELECT ID, DESCRICAO, MES, ANO, VALOR_TOTAL_INFORMADO FROM ORCAMENTO WHERE ID = ?";

		try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conexao.prepareStatement(query)) {

			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				Integer idOrcamento = result.getInt("ID");
				String descricao = result.getString("DESCRICAO");
				Integer mes = result.getInt("MES");
				Integer ano = result.getInt("ANO");
				Float valorTotalInformado = result.getFloat("VALOR_TOTAL_INFORMADO");

				List<ItemOrcamento> itens = recuperarItensOrcamento(conexao, idOrcamento);

				orcamento = new Orcamento(descricao, mes, ano, valorTotalInformado, itens);
				orcamento.setId(idOrcamento);
			}

		} catch (SQLException exception) {
			System.out.println("Erro ao conectar ao servidor");
			exception.printStackTrace();
		}
		return orcamento;
	}
	
	private List<ItemOrcamento> recuperarItensOrcamento(Connection conexao, Integer idOrcamento) throws SQLException {
		String query = "SELECT ID, ORIGEM, CODIGO, DESCRICAO, VALOR_UNITARIO, UNIDADE, QUANTIDADE, VALOR_TOTAL_INFORMADO FROM ITEM_ORCAMENTO WHERE ID_ORCAMENTO = ?";
		
		List<ItemOrcamento> itens = new ArrayList<>();

		try (PreparedStatement statement = conexao.prepareStatement(query)) {
			
			statement.setInt(1, idOrcamento);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				Integer id = result.getInt("ID");
				String origem = result.getString("ORIGEM");
				String codigo = result.getString("CODIGO");
				String descricao = result.getString("DESCRICAO");
				Float valorUnitario = result.getFloat("VALOR_UNITARIO");
				String unidade = result.getString("UNIDADE");
				Float quantidade = result.getFloat("QUANTIDADE");
				Float valorTotalInformado = result.getFloat("VALOR_TOTAL_INFORMADO");
				itens.add(new ItemOrcamento(id, origem, codigo, descricao, valorUnitario, unidade, quantidade,
						valorTotalInformado));
			}
		}
		return itens;
	}

}
