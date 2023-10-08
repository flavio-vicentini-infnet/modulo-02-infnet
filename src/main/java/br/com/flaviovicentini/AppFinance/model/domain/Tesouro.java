package br.com.flaviovicentini.AppFinance.model.domain;

import javax.persistence.Entity;

@Entity
public class Tesouro extends AtivoFinanceiro {

	private float taxa;

	public Tesouro() {

	}

	public Tesouro(Integer id) {
		super(id);
	}
	
	public Tesouro(String descricao, float taxa) {
		super(descricao);
		this.taxa = taxa;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
}
