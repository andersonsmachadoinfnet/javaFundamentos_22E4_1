package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;

public class Cirurgia extends Procedimento {
	private String indicadoPara;
	
	public Cirurgia(ProcedimentoTipo pTipo, String pDescricao, float pValor, String pIndicadoPara) {
		super(pTipo, pDescricao, pValor);
		this.indicadoPara = pIndicadoPara;
	}

	@Override
	public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
		return super.getValor()*pPacienteTp.ratio();
	}

	public String getIndicadoPara() {
		return indicadoPara;
	}

}
