package br.anderson.infnet.appclinica.model.dominio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

public class Prontuario implements IArquivoTxt, IArquivoTxt_linha {

	private String descricao;
	private boolean web;
	private LocalDateTime data;
	private Paciente paciente;
	private List<Procedimento> procedimentos;
	
	public Prontuario() {
		data = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return
			String.format("%s%s%s%s%s%s", 
				descricao, Constantes.SEPARADOR,
				web ? "Web": "Loja", Constantes.SEPARADOR,
				data.format(Constantes.FMT_DATETIME_BR()), Constantes.SEPARADOR
			);
	}
	
	// Refatorei essa funcao para o pacote model.report: public void imprimir() {}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isWeb() {
		return web;
	}

	public void setWeb(boolean web) {
		this.web = web;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public LocalDateTime getData() {
		return data;
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
			
			escrita.write(this.obterLinha());
			escrita.write(this.paciente.obterLinha());
			for(Procedimento p : this.procedimentos) {
				escrita.write(p.obterLinha());
			}
			escrita.close();
			
		} catch (IOException e) {
			System.out.println("[ERRO] " + e.getMessage());
		} 
		
	}

	@Override
	public String getPrefixo() {
		return Constantes.PREFIXO_CLASSE_PRONTUARIO;
	}

	@Override
	public boolean isPrefixo(String pPrefixo) {
		return getPrefixo().equals(pPrefixo);
	}

	@Override
	public String obterLinha() {
		return this.getPrefixo() + Constantes.SEPARADOR +
			   this.getData().format(Constantes.FMT_DATETIME_BR()) + Constantes.SEPARADOR +
			   this.getDescricao() + Constantes.SEPARADOR +
			   this.getPaciente().getNome() + Constantes.SEPARADOR +
			   this.getProcedimentos().size() + Constantes.CRLF;
	}

	@Override
	public void setLinha(String pLinha) {
		// TODO Auto-generated method stub
		
	}

}
