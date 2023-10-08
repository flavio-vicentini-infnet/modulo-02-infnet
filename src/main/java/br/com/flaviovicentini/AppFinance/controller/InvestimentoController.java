package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.domain.Investimento;
import br.com.flaviovicentini.AppFinance.model.service.AtivoFinanceiroService;
import br.com.flaviovicentini.AppFinance.model.service.ClienteService;
import br.com.flaviovicentini.AppFinance.model.service.InvestimentoService;

@Controller
public class InvestimentoController {

	@Autowired
	private InvestimentoService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private AtivoFinanceiroService ativoFinanceiroService;

	@GetMapping(value = "/investimento/lista")
	public String telaInvestimento(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		if (funcionario.getCargo().equalsIgnoreCase("admin")) {
			model.addAttribute("listaInvestimento", service.listar());
		} else {
			model.addAttribute("listaInvestimento", service.listar(funcionario));
		}

		return "investimento/lista";
	}

	@GetMapping(value = "/investimento/cadastro")
	public String telaCadastraInvestimento(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		model.addAttribute("clientes", clienteService.listar(funcionario));
		model.addAttribute("ativos", ativoFinanceiroService.listar());

		return "investimento/cadastro";
	}

	@PostMapping(value = "/investimento/incluir")
	public String incluir(Investimento investimento, @SessionAttribute("funcionario") Funcionario funcionario) {

		service.adicionar(investimento);

		return "redirect:/investimento/lista";
	}

	@GetMapping(value = "/investimento/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		service.excluir(id);

		return "redirect:/investimento/lista";
	}
}
