package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDateTime;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;

public class Prontuario {

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

}
