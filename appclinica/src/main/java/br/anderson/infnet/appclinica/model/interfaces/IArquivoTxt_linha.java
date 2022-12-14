package br.anderson.infnet.appclinica.model.interfaces;

import java.util.List;

import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ProcedimentoTipoInvalidoException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public interface IArquivoTxt_linha {
	public abstract       String getPrefixo();
	public abstract      boolean isPrefixo(String pPrefixo);
	public abstract List<String> obterLinha();
	public abstract         void setLinha(String pLinha) throws ValorInvalidoException, DescricaoInvalidaException, ProcedimentoTipoInvalidoException, CampoRequeridoNaoInformado;
}
