package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.Acoes;
import br.com.flaviovicentini.AppFinance.model.service.AcoesService;

@Order(3)
@Component
public class AcoesLoader implements ApplicationRunner {

	@Autowired
	private AcoesService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		var fr = new FileReader("arquivos/acoes.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();
		
		while (line != null) {
			String[] dados = line.split(",");
			
			String descricao = dados[0];
			String simbolo = dados[1];

			var acoes = new Acoes(descricao, simbolo);

			service.adicionar(acoes);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
