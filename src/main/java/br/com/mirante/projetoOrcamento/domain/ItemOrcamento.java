package br.com.mirante.projetoOrcamento.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ITEM_ORCAMENTO")
public class ItemOrcamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String origem;
	private String codigo;
	private String descricao;
	
	@Column(name="VALOR_UNITARIO")
	private float valorUnitario;
	private String unidade;
	private float quantidade;
	
	@Column(name="VALOR_TOTAL_INFORMADO")
	private float valorTotalInformado;

	@ManyToOne
	@JoinColumn(name="ID_ORCAMENTO")
	private Orcamento orcamento;
	
	protected ItemOrcamento() {}

	public ItemOrcamento(Integer id, String origem, String codigo, String descricao, float valorUnitario, String unidade,
			float quantidade, float valorTotalInformado) {
		this(origem, codigo, descricao, valorUnitario, unidade, quantidade, valorTotalInformado);
		this.id = id;
	}
	
	public ItemOrcamento(String origem, String codigo, String descricao, float valorUnitario, String unidade,
			float quantidade, float valorTotalInformado) {
		this.origem = origem;
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.unidade = unidade;
		this.quantidade = quantidade;
		this.valorTotalInformado = valorTotalInformado;
	}
	
	
	public Integer getId() {
		return id;
	}

	public String getOrigem() {
		return origem;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public String getUnidade() {
		return unidade;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public float getValorTotalInformado() {
		return valorTotalInformado;
	}
	
	public Orcamento getOrcamento() {
		return orcamento;
	}

	public boolean possuiInconsistencia() {
		
		return valorUnitario * quantidade != valorTotalInformado;
	}
}
