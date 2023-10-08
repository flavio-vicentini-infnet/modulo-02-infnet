package br.com.flaviovicentini.AppFinance.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.Investimento;

@Repository
public interface InvestimentoRepository extends CrudRepository<Investimento, Integer> {
	
	@Query("from Investimento i where i.cliente.funcionario.id =:funcionarioid")
	public List<Investimento> obterLista(Integer funcionarioid);

}
