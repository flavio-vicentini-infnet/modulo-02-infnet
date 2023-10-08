package br.com.flaviovicentini.AppFinance.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	@Query("from Cliente b where b.funcionario.id =:funcionarioid")
	public List<Cliente> obterLista(Integer funcionarioid);
	
}
