package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.FundoDeInvestimento;
import br.com.flaviovicentini.AppFinance.model.repository.FundoDeInvestimentoRepository;

@Service
public class FundoDeInvestimentoService {

	@Autowired
	private FundoDeInvestimentoRepository repository;

	public Collection<FundoDeInvestimento> listar() {
		return (Collection<FundoDeInvestimento>) repository.findAll();
	}

//	public Collection<Acoes> listar(Usuario usuario) {
//		return (Collection<Acoes>) repository.obterLista(usuario.getId());
//	}

	public void adicionar(FundoDeInvestimento fundoDeInvestimento) {
		repository.save(fundoDeInvestimento);
		System.out.println("Fundo de Investimento incluído com sucesso: " + fundoDeInvestimento);
	}

	public void excluir(Integer id) {
		System.out.println("Fundo de Investimento excluído: " + repository.findById(id));
		repository.deleteById(id);
	}

}
