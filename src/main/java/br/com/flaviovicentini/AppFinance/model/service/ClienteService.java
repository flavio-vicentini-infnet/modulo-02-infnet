package br.com.flaviovicentini.AppFinance.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flaviovicentini.AppFinance.model.domain.Cliente;
import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Collection<Cliente> listar() {
		return (Collection<Cliente>) clienteRepository.findAll();
	}
	
	public Collection<Cliente> listar(Funcionario funcionario) {
		return (Collection<Cliente>) clienteRepository.obterLista(funcionario.getId());
	}
	
	public void adicionar(Cliente cliente) {
		clienteRepository.save(cliente);
		System.out.println("Cliente incluída com sucesso: " + cliente);
	}

	public void excluir(Integer id) {
		System.out.println("Excluindo cliente: " + clienteRepository.findById(id));
		clienteRepository.deleteById(id);
	}
	
	public Optional<Cliente> findById(Integer id) {
		return clienteRepository.findById(id);
	}
}
