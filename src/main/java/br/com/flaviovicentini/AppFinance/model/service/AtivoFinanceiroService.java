package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.AtivoFinanceiro;
import br.com.flaviovicentini.AppFinance.model.repository.AtivoFinanceiroRepository;

@Service
public class AtivoFinanceiroService {

	@Autowired
	private AtivoFinanceiroRepository repository;

	public Collection<AtivoFinanceiro> listar() {
		return (Collection<AtivoFinanceiro>) repository.findAll();
	}

	public void excluir(Integer id) {
		System.out.println("Investimento excluído: " + repository.findById(id));
		repository.deleteById(id);
	}
	
}
