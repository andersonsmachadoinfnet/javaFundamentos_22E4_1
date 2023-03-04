package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDateTime;
import java.util.List;

import java.util.ArrayList;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ProcedimentoTipoInvalidoException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

public class Prontuario implements IArquivoTxt_linha {

	private                int id;
	private             String descricao;
	private            boolean web;
	private      LocalDateTime data;
	private           Paciente paciente;
	private List<Procedimento> procedimentos;
	
	public Prontuario() {
		data      = LocalDateTime.now();
		descricao = Constantes.PRONTUARIO_DESCRICAO;
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
	
	// Refatorei essa funcao para o pacote model.report: 
	// public void imprimir() {}
	
	
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
	
	public float getValorTotal() {
		float lVrTot = (float) 0.00;
		for(Procedimento p : this.procedimentos) {
			lVrTot = lVrTot + p.getValor();
		}

		return lVrTot;
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
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		// Dados do cabecalho
		lRet.add(this.getPrefixo() + Constantes.SEPARADOR +
				 this.getData().format(Constantes.FMT_DATETIME_BR()) + Constantes.SEPARADOR +
				 this.getDescricao() + Constantes.SEPARADOR +
				 (this.web ? "Web": "Loja") + Constantes.SEPARADOR +
				 this.getPaciente().getNome() + Constantes.SEPARADOR +
				 this.getProcedimentos().size());

		// Dados do paciente
		for (String lLinha : this.paciente.obterLinha()) {
			lRet.add(lLinha);
		}

		// Dados dos procedimentos
		for(Procedimento p : this.procedimentos) {
			for (String lLinha : p.obterLinha()) {
				lRet.add(lLinha);
			}
		}

		return lRet;
	}

	@Override
	public void setLinha(String pLinha) 
			throws ValorInvalidoException, DescricaoInvalidaException, ProcedimentoTipoInvalidoException, CampoRequeridoNaoInformado {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		
		switch (lCampos[0]) {
		case Constantes.PREFIXO_CLASSE_PRONTUARIO:
			this.data      = LocalDateTime.parse(lCampos[1], Constantes.FMT_DATETIME_BR());
			this.descricao = lCampos[2];
			this.web       = ("Web".equals(lCampos[3]));
			this.procedimentos = new ArrayList<Procedimento>();
			break;
			
		case Constantes.PREFIXO_CLASSE_PACIENTE:
			this.paciente = new Paciente(pLinha);
			break;
			
		default:
			this.procedimentos.add(new ProcedimentoFabrica().getProcedimento(pLinha));
			break;
		}
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int pId) {
		this.id = pId;
	}
}
