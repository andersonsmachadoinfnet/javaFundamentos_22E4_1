package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class Exame extends Procedimento {
	private String resultado;
	
	public Exame(ProcedimentoTipo pTipo, String pDescricao, float pValor) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		super(pTipo, pDescricao, pValor);
	}

	@Override
	public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
		return super.getValor()*pPacienteTp.ratio();
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
