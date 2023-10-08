package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Collection<Funcionario> listar() {
		return (Collection<Funcionario>) repository.findAll();
	}
	
//	public Collection<Cliente> listar(Usuario usuario) {
//		return (Collection<Cliente>) clienteRepository.obterLista(usuario.getId());
//	}
	
	public Funcionario validar(String email, String senha) {

		Funcionario funcionario = repository.findByEmail(email);

		if (funcionario != null) {
			if (senha.equalsIgnoreCase(funcionario.getSenha())) {
				return funcionario;
			}
		}

		return null;
	}
	
	public void adicionar(Funcionario funcionario) {
		repository.save(funcionario);
		System.out.println("Funcionário incluído com sucesso: " + funcionario);
	}

	public void excluir(Integer id) {
		System.out.println("Funcionário gerente: " + repository.findById(id));
		repository.deleteById(id);
	}
	
}
