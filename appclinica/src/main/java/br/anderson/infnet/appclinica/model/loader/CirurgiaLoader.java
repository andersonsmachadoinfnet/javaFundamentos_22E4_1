package br.anderson.infnet.appclinica.model.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt;
import br.anderson.infnet.appclinica.model.service.CirurgiaService;


@Component
public class CirurgiaLoader  implements ApplicationRunner, IArquivoTxt{
	@Autowired
	private CirurgiaService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		lerDoArq(Constantes.LOADER_ARQ_CIRURGIA);
	}

	@Override
	public void lerDoArq(String pNomeDoArq)  {
		// TODO Refatorar codigo depois, para evitar duplicidades
		try {
			FileReader file = new FileReader(pNomeDoArq);
			BufferedReader leitura = new BufferedReader(file);
			String   lLinha  = leitura.readLine();
			String[] lCampos = null;
			while (lLinha != null) {
				lCampos = lLinha.split(Constantes.SEPARADOR);
				if (Constantes.PREFIXO_CLASSE_PROCEDIMENTO_CIRUR.equals(lCampos[0])) {
					Cirurgia item = new Cirurgia(lLinha);
					service.incluir(item);
				}
				
				lLinha  = leitura.readLine();
			}
			leitura.close();
			file.close();
			
		} catch (ValorInvalidoException | DescricaoInvalidaException | IOException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
	}

	@Override
	public void salvarNoArq(String pNomeDoArq) {
		// TODO Refatorar codigo depois, para evitar duplicidades
		try {
	 		FileWriter fileW = new FileWriter(pNomeDoArq);
	 		BufferedWriter escrita = new BufferedWriter(fileW);
	 		
	 		for(Cirurgia lItem : service.obterLista()) {
				for (String lLinha : lItem.obterLinha()) {
					escrita.write(lLinha+Constantes.CRLF);
				}
	 		}
	 		escrita.close();
			
	 	} catch (IOException e) {
	 		System.out.println("[ERRO] " + e.getMessage());
	 	} 
	}
}
