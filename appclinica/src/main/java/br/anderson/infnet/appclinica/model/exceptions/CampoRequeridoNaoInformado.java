package br.anderson.infnet.appclinica.model.exceptions;

public class CampoRequeridoNaoInformado  extends Exception {
	private static final long serialVersionUID = 1L;

	public CampoRequeridoNaoInformado(String pCampo) {
		super(String.format("O campo [%s] não foi informado ou está inválido!", pCampo));
	}
}
