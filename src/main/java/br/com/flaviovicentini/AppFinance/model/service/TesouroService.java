package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.Tesouro;
import br.com.flaviovicentini.AppFinance.model.repository.TesouroRepository;

@Service
public class TesouroService {

	@Autowired
	private TesouroRepository repository;

	public Collection<Tesouro> listar() {
		return (Collection<Tesouro>) repository.findAll();
	}
	
//	public Collection<Tesouro> listar(Usuario usuario) {
//		return (Collection<Acoes>) repository.obterLista(usuario.getId());
//	}
	
	public void adicionar(Tesouro tesouro) {
		repository.save(tesouro);
		System.out.println("Tesouro incluída com sucesso: " + tesouro);
	}

	public void excluir(Integer id) {
		System.out.println("Acoes bebida: " + repository.findById(id));
		repository.deleteById(id);
	}
	
}
