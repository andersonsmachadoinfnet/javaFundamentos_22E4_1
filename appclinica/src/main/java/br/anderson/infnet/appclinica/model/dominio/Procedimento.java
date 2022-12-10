package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;

public abstract class Procedimento {

	private ProcedimentoTipo tipo;
	private           String descricao;
	private            float valor;
	
	public Procedimento(ProcedimentoTipo pTipo, String pDescricao, float pValor) {
		this.tipo      = pTipo;
		this.descricao = pDescricao;
		this.valor     = pValor;
		
		checaSeValidoOuGeraErro();
	}
	
	public abstract float calcularValorDoProcedimento(PacienteTipo pPacienteTp);
	
	public void checaSeValidoOuGeraErro() {
		// TODO: Falta implementar
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
}
