package br.anderson.infnet.appclinica.model.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ProcedimentoTipoInvalidoException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt;

public class ProntuarioContainer implements IArquivoTxt {
	private List<Prontuario> prontuarios;
	
	public ProntuarioContainer() {
		prontuarios = new ArrayList<Prontuario>();
	}
	
	public void add(Prontuario pItem) {
		prontuarios.add(pItem);
	}
	
	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	@Override
	public void lerDoArq(String pNomeDoArq) {
		prontuarios.clear();
		Prontuario lProntuarioAtual = new Prontuario();
		int lLinhaNo = 1;

		try {
			FileReader file = new FileReader(pNomeDoArq);
			BufferedReader leitura = new BufferedReader(file);
			String   lLinha  = leitura.readLine();
			String[] lCampos = null;
			while (lLinha != null) {
				lCampos = lLinha.split(Constantes.SEPARADOR);
				if (Constantes.PREFIXO_CLASSE_PRONTUARIO.equals(lCampos[0])) {
					lProntuarioAtual = new Prontuario();
					add(lProntuarioAtual);
				}
				
				try {
					lProntuarioAtual.setLinha(lLinha);
				} catch (ValorInvalidoException | DescricaoInvalidaException | ProcedimentoTipoInvalidoException e) {
					System.out.println(String.format("[ERROR] Lin: %d; %s", lLinhaNo, e.getMessage()));
				}
				lLinha  = leitura.readLine();
				lLinhaNo++;
			}
			leitura.close();
			file.close();
			
		} catch (IOException e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		
	}

	@Override
	public void salvarNoArq(String pNomeDoArq) {
		try {
	 		FileWriter fileW = new FileWriter(pNomeDoArq);
	 		BufferedWriter escrita = new BufferedWriter(fileW);
	 		
	 		for(Prontuario lProntuario : this.prontuarios) {
				for (String lLinha : lProntuario.obterLinha()) {
					escrita.write(lLinha+Constantes.CRLF);
				}
	 		}
	 		escrita.close();
			
	 	} catch (IOException e) {
	 		System.out.println("[ERRO] " + e.getMessage());
	 	} 
	}
}
