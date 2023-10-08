package br.com.flaviovicentini.AppFinance.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.FundoDeInvestimento;

@Repository
public interface FundoDeInvestimentoRepository extends CrudRepository<FundoDeInvestimento, Integer> {
	
//	@Query("from FundoDeInvestimento b where b.funcionario.id =:funcionarioid")
//	public List<FundoDeInvestimento> obterLista(Integer funcionarioid);
	
}
