package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ProcedimentoTipoInvalidoException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class ProcedimentoFabrica {
	public Procedimento getProcedimento(String pLinhaArq) throws ValorInvalidoException, DescricaoInvalidaException, ProcedimentoTipoInvalidoException {
		String[] lCampos = pLinhaArq.split(Constantes.SEPARADOR);
		Procedimento lProcedimento;
		
		switch (lCampos[0]) {
		case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_CIRUR:
			lProcedimento = new Cirurgia(pLinhaArq);
			break;
			
		case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_EXAME:
			lProcedimento = new Exame(pLinhaArq);
			break;
			
		case Constantes.PREFIXO_CLASSE_PROCEDIMENTO_MEDIC:
			lProcedimento = new Medicamento(pLinhaArq);
			break;
			
		default:
			throw new ProcedimentoTipoInvalidoException("Tipo de procedimento é inválido!");
		}
		
		return lProcedimento;
	}
}
