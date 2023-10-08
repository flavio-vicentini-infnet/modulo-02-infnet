package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.domain.Investimento;
import br.com.flaviovicentini.AppFinance.model.repository.InvestimentoRepository;

@Service
public class InvestimentoService {

	@Autowired
	private InvestimentoRepository repository;

	public Collection<Investimento> listar() {
		return (Collection<Investimento>) repository.findAll();
	}
	
	public Collection<Investimento> listar(Funcionario funcionario) {
		return (Collection<Investimento>) repository.obterLista(funcionario.getId());
	}
	
	public void adicionar(Investimento investimento) {
		repository.save(investimento);
		System.out.println("Cliente incluída com sucesso: " + investimento);
	}

	public void excluir(Integer id) {
		System.out.println("Excluindo cliente: " + repository.findById(id));
		repository.deleteById(id);
	}
	
}
