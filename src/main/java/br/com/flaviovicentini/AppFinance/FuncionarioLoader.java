package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.FuncionarioService;

@Order(1)
@Component
public class FuncionarioLoader implements ApplicationRunner {

	@Autowired
	private FuncionarioService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		var fr = new FileReader("arquivos/funcionarios.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();
		
		while (line != null) {
			String[] dados = line.split(",");
			
			String nome = dados[0];
			String email = dados[1];
			String senha = dados[2];
			int cargo = Integer.parseInt(dados[3]);

			var funcionario = new Funcionario(nome, email, senha);
			
			funcionario.setCargo(cargo);
			
			service.adicionar(funcionario);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
