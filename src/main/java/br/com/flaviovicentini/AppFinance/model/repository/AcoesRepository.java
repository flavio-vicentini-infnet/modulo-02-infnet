package br.com.flaviovicentini.AppFinance.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.Acoes;

@Repository
public interface AcoesRepository extends CrudRepository<Acoes, Integer> {

}
