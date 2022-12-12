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

		try {
			FileReader file = new FileReader(pNomeDoArq);
			BufferedReader leitura = new BufferedReader(file);
			String   lLinha  = leitura.readLine();
			String[] lCampos = null;
			while (lLinha != null) {
				lCampos = lLinha.split(Constantes.SEPARADOR);
				if (lCampos[0]==Constantes.PREFIXO_CLASSE_PRONTUARIO) {
					lProntuarioAtual = new Prontuario();
					add(lProntuarioAtual);
				}
				
				lProntuarioAtual.setLinha(lLinha);
				lLinha  = leitura.readLine();
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
