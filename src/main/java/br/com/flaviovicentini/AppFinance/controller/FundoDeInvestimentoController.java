package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.domain.FundoDeInvestimento;
import br.com.flaviovicentini.AppFinance.model.service.FundoDeInvestimentoService;

@Controller
public class FundoDeInvestimentoController {

	@Autowired
	private FundoDeInvestimentoService service;

	@GetMapping(value = "/fundo-de-investimento/lista")
	public String telaFundoDeInvestimento(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		model.addAttribute("listaFundoDeInvestimento", service.listar());
	
		return "fundo-de-investimento/lista";
	}

	@GetMapping(value = "/fundo-de-investimento/cadastro")
	public String telaCadastraFundoDeInvestimento() {

		return "fundo-de-investimento/cadastro";
	}
	
	@PostMapping(value = "/fundo-de-investimento/incluir")
	public String incluir(FundoDeInvestimento fundoDeInvestimento) {
		
		service.adicionar(fundoDeInvestimento);

		return "redirect:/ativo-financeiro/lista";
	}
	
	@GetMapping(value = "/fundo-de-investimento/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		service.excluir(id);

		return "redirect:/fundo-de-investimento/lista";
	}
}
