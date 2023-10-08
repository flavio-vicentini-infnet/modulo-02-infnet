package br.com.flaviovicentini.AppFinance.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	
//	@Query("from Acoes b where b.funcionario.id =:funcionarioid")
//	public List<Acoes> obterLista(Integer funcionarioid);
	
	Funcionario findByEmail(String email);
	
}
