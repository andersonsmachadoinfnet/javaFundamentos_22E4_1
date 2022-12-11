package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class Cirurgia extends Procedimento {
	private String indicadoPara;
	
	public Cirurgia(ProcedimentoTipo pTipo, String pDescricao, float pValor, String pIndicadoPara) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
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

	@Override
	public String obterLinha() {
		return super.obterLinha() + Constantes.SEPARADOR +
				this.indicadoPara + Constantes.CRLF;
	}

	@Override
	public void setLinha(String pLinha) {
		// TODO Auto-generated method stub
		
	}

}
