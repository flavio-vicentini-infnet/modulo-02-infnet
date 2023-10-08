package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Cliente;
import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping(value = "/cliente/lista")
	public String telaCliente(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		if (funcionario.getCargo().equalsIgnoreCase("admin")) {
			model.addAttribute("listaClientes", service.listar());
		} else {
			model.addAttribute("listaClientes", service.listar(funcionario));
		}
		return "cliente/lista";
	}

	@GetMapping(value = "/cliente/cadastro")
	public String telaCadastraCliente() {

		return "cliente/cadastro";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente, @SessionAttribute("funcionario") Funcionario funcionario) {

		cliente.setFuncionario(funcionario);

		service.adicionar(cliente);

		return "redirect:/cliente/lista";
	}

	@GetMapping(value = "/cliente/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			service.excluir(id);
		} catch (Exception e) {
			System.out.println("Exceção ocorreu...");
			return "cliente/aviso";
		}

		return "redirect:/cliente/lista";
	}
}
