package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.Tesouro;
import br.com.flaviovicentini.AppFinance.model.service.TesouroService;

@Order(5)
@Component
public class TesouroLoader implements ApplicationRunner {

	@Autowired
	private TesouroService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		var fr = new FileReader("arquivos/tesouro.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();
		
		while (line != null) {
			String[] dados = line.split(",");
			
			String descricao = dados[0];
			float taxa = Float.parseFloat(dados[1]);

			var tesouro = new Tesouro(descricao, taxa);

			service.adicionar(tesouro);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
