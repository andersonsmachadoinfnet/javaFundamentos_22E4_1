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
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;
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
	
	public void processar(String pNomeDoArq) {
		lerDoArq(pNomeDoArq);
		
		try {
			int   lQtd   = 0;
			float lVrTot = (float) 0.00;
			FileWriter fileW = new FileWriter(Constantes.TESTE_ARQ_PROCESSADO_PREFIXO+pNomeDoArq);
	 		BufferedWriter escrita = new BufferedWriter(fileW);
	 		
	 		for(Prontuario lProntuario : this.prontuarios) {
	 			escrita.write(processar_gerarLinha(lProntuario));
	 			
	 			lQtd++;
	 			lVrTot = lVrTot + lProntuario.getValorTotal();
	 		}
	 		escrita.close();
	 		processar_relatorio(lQtd, lVrTot);
	 	} catch (IOException e) {
	 		System.out.println("[ERRO] " + e.getMessage());
	 	}
	}
	
	private void processar_relatorio(int pQtd, float pVrTotal) {
		System.out.println("Relatório de Processamento de Prontuários");
 		System.out.println("----------------------------------------------------");
 		System.out.println("Prontuários processados: "+pQtd);
 		System.out.println("Valor total processado : "+pVrTotal);
	}
	
	private String processar_gerarLinha(Prontuario pProntuario) {
		return	pProntuario.getData().format(Constantes.FMT_DATE_MES_BR()) + Constantes.SEPARADOR +
				pProntuario.getDescricao() + Constantes.SEPARADOR +
				pProntuario.getPaciente().getNome() + Constantes.SEPARADOR +
				pProntuario.getValorTotal() + Constantes.SEPARADOR +
				pProntuario.getProcedimentos().size();
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
				} catch (ValorInvalidoException | DescricaoInvalidaException | 
						 ProcedimentoTipoInvalidoException | CampoRequeridoNaoInformado  e) {
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
