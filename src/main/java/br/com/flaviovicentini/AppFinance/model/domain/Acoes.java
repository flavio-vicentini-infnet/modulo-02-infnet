package br.com.flaviovicentini.AppFinance.model.domain;

import javax.persistence.Entity;

@Entity
public class Acoes extends AtivoFinanceiro {

	private String simbolo;
	
	public Acoes() {
		
	}

	public Acoes(Integer id) {
		super(id);
	}
		
	public Acoes(String descricao, String simbolo) {
		super(descricao);
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
