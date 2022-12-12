package br.anderson.infnet.appclinica.model.core;

import java.io.BufferedWriter;
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
		// TODO Auto-generated method stub
		
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
