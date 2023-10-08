package br.com.flaviovicentini.AppFinance.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.Tesouro;

@Repository
public interface TesouroRepository extends CrudRepository<Tesouro, Integer> {

}
