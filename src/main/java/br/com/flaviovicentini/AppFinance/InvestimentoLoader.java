package br.com.flaviovicentini.AppFinance;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.flaviovicentini.AppFinance.model.domain.Acoes;
import br.com.flaviovicentini.AppFinance.model.domain.AtivoFinanceiro;
import br.com.flaviovicentini.AppFinance.model.domain.Cliente;
import br.com.flaviovicentini.AppFinance.model.domain.FundoDeInvestimento;
import br.com.flaviovicentini.AppFinance.model.domain.Investimento;
import br.com.flaviovicentini.AppFinance.model.domain.Tesouro;
import br.com.flaviovicentini.AppFinance.model.service.InvestimentoService;

@Order(6)
@Component
public class InvestimentoLoader implements ApplicationRunner {

	@Autowired
	private InvestimentoService investimentoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		var fr = new FileReader("arquivos/investimentos.txt");
		var br = new BufferedReader(fr);

		var line = br.readLine();

		while (line != null) {
			String[] dados = line.split(",");

			String tipoAtivo = dados[0];
			Integer idAtivo = Integer.parseInt(dados[1]);
			float precoCompra = Float.parseFloat(dados[2]);
			float quantidade = Float.parseFloat(dados[3]);
			Cliente cliente = new Cliente(Integer.parseInt(dados[4]));

			AtivoFinanceiro ativoFinanceiro;

			switch (tipoAtivo) {
			case "a":
				ativoFinanceiro = new Acoes(idAtivo);
				break;
			case "f":
				ativoFinanceiro = new FundoDeInvestimento(idAtivo);
				break;
			case "t":
				ativoFinanceiro = new Tesouro(idAtivo);
				break;
			default:
				ativoFinanceiro = null;
				break;
			}

			var investimento = new Investimento(cliente, ativoFinanceiro, quantidade, precoCompra);

			investimentoService.adicionar(investimento);

			line = br.readLine();
		}

		br.close();
		fr.close();
	}
}
