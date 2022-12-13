package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

public abstract class Procedimento implements IArquivoTxt_linha  {

	private ProcedimentoTipo tipo;
	private           String descricao;
	private            float valor;
	
	public Procedimento(ProcedimentoTipo pTipo, String pDescricao, float pValor) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		this.tipo      = pTipo;
		this.descricao = pDescricao;
		this.valor     = pValor;
		
		checaSeValidoOuGeraErro();
	}
	
	protected Procedimento(String pLinha) 
			throws ValorInvalidoException, DescricaoInvalidaException {
		setLinha(pLinha);
		checaSeValidoOuGeraErro();
	};
	
	public abstract float calcularValorDoProcedimento(PacienteTipo pPacienteTp);
	
	public void checaSeValidoOuGeraErro() throws ValorInvalidoException, DescricaoInvalidaException {
		if (this.valor==0) {
			throw new ValorInvalidoException("Não foi informado um valor para o procedimento!");
		}
		if (this.valor<0) {
			throw new ValorInvalidoException("O valor do procedimento é inválido!");
		}
		if (this.descricao==null || this.descricao.trim()=="") {
			throw new DescricaoInvalidaException("Não foi informado um descritivo para o procedimento!");
		}
		
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(tipo).append(Constantes.SEPARADOR)
				                  .append(descricao).append(Constantes.SEPARADOR)
		                          .append(valor).append(Constantes.SEPARADOR)
		                          .toString();
	}
	
	
	public ProcedimentoTipo getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}
	
	@Override
	public String getPrefixo() {
		return this.tipo.getPrefixo();
	}

	@Override
	public boolean isPrefixo(String pPrefixo) {
		return getPrefixo().equals(pPrefixo);
	}
	
	@Override
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		lRet.add(this.getPrefixo() + Constantes.SEPARADOR +
				 this.descricao + Constantes.SEPARADOR +
		         this.valor);	
		return lRet;
	}
	
	@Override
	public void setLinha(String pLinha) {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.tipo = ProcedimentoTipo.setPrefixo(lCampos[0].toUpperCase());
		this.descricao  = lCampos[1];
		this.valor      = Float.valueOf(lCampos[2]);
	}
}
