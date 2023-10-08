package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.Acoes;
import br.com.flaviovicentini.AppFinance.model.repository.AcoesRepository;

@Service
public class AcoesService {

	@Autowired
	private AcoesRepository repository;

	public Collection<Acoes> listar() {
		return (Collection<Acoes>) repository.findAll();
	}
	
//	public Collection<Acoes> listar(Usuario usuario) {
//		return (Collection<Acoes>) repository.obterLista(usuario.getId());
//	}
	
	public void adicionar(Acoes acoes) {
		repository.save(acoes);
		System.out.println("Acoes incluída com sucesso: " + acoes);
	}

	public void excluir(Integer id) {
		System.out.println("Acoes bebida: " + repository.findById(id));
		repository.deleteById(id);
	}
	
}
