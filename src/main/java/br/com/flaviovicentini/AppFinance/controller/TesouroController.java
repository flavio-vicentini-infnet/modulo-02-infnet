package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.domain.Tesouro;
import br.com.flaviovicentini.AppFinance.model.service.TesouroService;

@Controller
public class TesouroController {

	@Autowired
	private TesouroService service;

	@GetMapping(value = "/tesouro/lista")
	public String telaTesouro(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		model.addAttribute("listaTesouro", service.listar());
	
		return "tesouro/lista";
	}

	@GetMapping(value = "/tesouro/cadastro")
	public String telaCadastraTesouro() {

		return "tesouro/cadastro";
	}
	
	@PostMapping(value = "/tesouro/incluir")
	public String incluir(Tesouro tesouro) {
		
		service.adicionar(tesouro);

		return "redirect:/ativo-financeiro/lista";
	}
	
	@GetMapping(value = "/tesouro/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		service.excluir(id);

		return "redirect:/tesouro/lista";
	}
}
