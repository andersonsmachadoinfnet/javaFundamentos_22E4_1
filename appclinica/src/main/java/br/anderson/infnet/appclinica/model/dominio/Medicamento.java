package br.anderson.infnet.appclinica.model.dominio;

import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class Medicamento  extends Procedimento {
	private String bula;
	
	public Medicamento(ProcedimentoTipo pTipo, String pDescricao, float pValor, String pBula) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		super(pTipo, pDescricao, pValor);
		this.bula = pBula;
	}

	@Override
	public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
		return super.getValor()*pPacienteTp.ratio();
	}

	public String getBula() {
		return bula;
	}
	
	@Override
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		for (String lLinha : super.obterLinha()) {
			lRet.add(lLinha + Constantes.SEPARADOR + this.bula);
		}
		return lRet;
	}

	@Override
	public void setLinha(String pLinha) {
		// TODO Auto-generated method stub
		
	}

}