package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.Cliente;
import br.com.flaviovicentini.AppFinance.model.domain.Funcionario;
import br.com.flaviovicentini.AppFinance.model.service.ClienteService;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		var fr = new FileReader("arquivos/clientes.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();
		
		while (line != null) {
			String[] dados = line.split(",");
			
			String nome = dados[0];
			String email = dados[1];
			Funcionario funcionario = new Funcionario(Integer.parseInt(dados[2]));

			var cliente = new Cliente(nome, email);
			cliente.setFuncionario(funcionario);

			clienteService.adicionar(cliente);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
