package br.com.flaviovicentini.AppFinance.model.domain;

import javax.persistence.Entity;

@Entity
public class FundoDeInvestimento extends AtivoFinanceiro {

	private String cnpj;

	public FundoDeInvestimento() {
		
	}
	
	public FundoDeInvestimento(Integer id) {
		super(id);
	}
	
	public FundoDeInvestimento(String descricao, String cnpj) {
		super(descricao);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
