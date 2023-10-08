package br.com.flaviovicentini.AppFinance.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.AtivoFinanceiro;

@Repository
public interface AtivoFinanceiroRepository extends CrudRepository<AtivoFinanceiro, Integer> {

}
