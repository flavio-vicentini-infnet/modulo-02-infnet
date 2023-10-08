package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Acoes;
import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.AcoesService;

@Controller
public class AcoesController {

	@Autowired
	private AcoesService service;

	@GetMapping(value = "/acoes/lista")
	public String telaAcoes(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		model.addAttribute("listaAcoes", service.listar());
	
		return "acoes/lista";
	}

	@GetMapping(value = "/acoes/cadastro")
	public String telaCadastraAcoes() {

		return "acoes/cadastro";
	}
	
	@PostMapping(value = "/acoes/incluir")
	public String incluir(Acoes acoes) {
		
		service.adicionar(acoes);

		return "redirect:/ativo-financeiro/lista";
	}
	
	@GetMapping(value = "/acoes/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		service.excluir(id);

		return "redirect:/acoes/lista";
	}
}
