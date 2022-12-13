package br.anderson.infnet.appclinica.model.dominio;

import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class Exame extends Procedimento {
	private String resultado;
	
	public Exame(ProcedimentoTipo pTipo, String pDescricao, float pValor, String pResultado) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		super(pTipo, pDescricao, pValor);
		this.resultado = pResultado;
	}
	
	protected Exame(String pLinha) throws ValorInvalidoException, DescricaoInvalidaException {
		super(pLinha);
		setLinha(pLinha);
		checaSeValidoOuGeraErro();
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
	
	@Override
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		for (String lLinha : super.obterLinha()) {
			lRet.add(lLinha + Constantes.SEPARADOR + this.resultado);
		}
		return lRet;
	}

	@Override
	public void setLinha(String pLinha) {
		super.setLinha(pLinha);
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.resultado = lCampos[3];
	}

}
