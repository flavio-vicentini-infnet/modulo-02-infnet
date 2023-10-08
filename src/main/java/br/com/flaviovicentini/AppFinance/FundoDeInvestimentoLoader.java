package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.FundoDeInvestimento;
import br.com.flaviovicentini.AppFinance.model.service.FundoDeInvestimentoService;

@Order(4)
@Component
public class FundoDeInvestimentoLoader implements ApplicationRunner {

	@Autowired
	private FundoDeInvestimentoService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		var fr = new FileReader("arquivos/fundos-de-investimento.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();
		
		while (line != null) {
			String[] dados = line.split(",");
			
			String descricao = dados[0];
			String cnpj = dados[1];

			var fundo = new FundoDeInvestimento(descricao, cnpj);

			service.adicionar(fundo);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
