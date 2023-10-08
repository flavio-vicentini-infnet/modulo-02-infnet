package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.AcoesService;
import br.com.flaviovicentini.AppFinance.model.service.AtivoFinanceiroService;
import br.com.flaviovicentini.AppFinance.model.service.FundoDeInvestimentoService;
import br.com.flaviovicentini.AppFinance.model.service.TesouroService;

@Controller
public class AtivoFinanceiroController {

	@Autowired
	private AtivoFinanceiroService ativoFinanceiroService;

	@Autowired
	private AcoesService acoesService;
	
	@Autowired
	private FundoDeInvestimentoService fundoDeInvestimentoService;
	
	@Autowired
	private TesouroService tesouroService;
	
	@GetMapping(value = "/ativo-financeiro/lista")
	public String telaTesouro(Model model, @SessionAttribute("funcionario") Funcionario funcionario) {

		model.addAttribute("listaAcoes", acoesService.listar());
		model.addAttribute("listaFundos", fundoDeInvestimentoService.listar());
		model.addAttribute("listaTesouro", tesouroService.listar());
		return "ativo-financeiro/lista";
	}
	
	@GetMapping(value = "/ativo-financeiro/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			ativoFinanceiroService.excluir(id);
		} catch (Exception e) {
			System.out.println("Exceção ocorreu...");
			return "ativo-financeiro/aviso";
		}

		return "redirect:/ativo-financeiro/lista";
	}
}
