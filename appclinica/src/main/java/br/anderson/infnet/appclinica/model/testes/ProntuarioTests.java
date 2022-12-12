package br.anderson.infnet.appclinica.model.testes;

import java.util.Random;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.core.ProntuarioContainer;
import br.anderson.infnet.appclinica.model.dominio.faker.ProntuarioFaker;
import br.anderson.infnet.appclinica.model.interfaces.IRelatorio;
import br.anderson.infnet.appclinica.model.report.ProntuarioReport;

public class ProntuarioTests {

	public static void main(String[] args) {
		gerarArquivoTestePopulado();
	}

	private static void gerarArquivoTestePopulado() {
		ProntuarioContainer prontuarios = new ProntuarioContainer();
		for(int i=0;i<new Random().nextInt(Constantes.TESTE_ARQ_CLASSEMAE_QTD)+1;i++) {
			prontuarios.add(ProntuarioFaker.getProntuario());
		}
		
		IRelatorio relatorio = new ProntuarioReport(prontuarios.getProntuarios().get(0));
		relatorio.imprimir();
		
		prontuarios.salvarNoArq(Constantes.TESTE_ARQ_NOME);
	}

}
