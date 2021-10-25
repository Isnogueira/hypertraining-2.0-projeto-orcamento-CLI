package br.com.mirante.projetoOrcamento.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Orcamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String descricao;
	private int mes;
	private int ano;
	
	@Column(name="VALOR_TOTAL_INFORMADO")
	private float valorTotalInformado;
	
	@OneToMany(mappedBy = "orcamento")
	List<ItemOrcamento> itensOrcamento;
	
	protected Orcamento() {}

	public Orcamento(String descricao, int mes, int ano, float valorTotalInformado,
			List<ItemOrcamento> itensOrcamento) {
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
		this.valorTotalInformado = valorTotalInformado;
		this.itensOrcamento = itensOrcamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

	}

	public String getDescricao() {
		return descricao;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public float getValorTotalInformado() {
		return valorTotalInformado;
	}

	public List<ItemOrcamento> getItensOrcamento() {
		return itensOrcamento;
	}


	public List<ItemOrcamento> detalharInconsistencia() {

		var itensComInconsistencia = new ArrayList<ItemOrcamento>();

		for (var itemOrcamento : itensOrcamento) {

			if (itemOrcamento.possuiInconsistencia()) {
				itensComInconsistencia.add(itemOrcamento);
			}

		}

		return itensComInconsistencia;
	}
	

	}


