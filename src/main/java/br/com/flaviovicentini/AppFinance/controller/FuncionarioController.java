package br.com.flaviovicentini.AppFinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.FuncionarioService;

@SessionAttributes("funcionario")
@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@GetMapping(value = "/funcionario/lista")
	public String telaFuncionarios(Model model) {

		model.addAttribute("listaFuncionarios", service.listar());

		return "funcionario/lista";
	}

	@GetMapping(value = "/funcionario/cadastro")
	public String telaCadastraFuncionario() {

		return "funcionario/cadastro";
	}

	@PostMapping(value = "/funcionario/incluir")
	public String inclusao(Funcionario funcionario) {

		funcionario.setCargo(2);

		service.adicionar(funcionario);

		return "redirect:/login";
	}

	@PostMapping(value = "/valida")
	public String validaLogin(Model model, @RequestParam String email, @RequestParam String senha) {
		System.out.println("Credenciais: " + email + " - " + senha);

		Funcionario funcionario = service.validar(email, senha);

		if (funcionario != null) {

			System.out.println("Funcionario validado: " + funcionario.getNome());

			model.addAttribute("funcionario", funcionario);

			return "home";
		}

		return "redirect:/login";
	}

	@GetMapping(value = "/funcionario/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		try {
			service.excluir(id);
		} catch (Exception e) {
			System.out.println("Exceção ocorreu...");
			return "funcionario/aviso";
		}

		return "redirect:/funcionario/lista";
	}

}
