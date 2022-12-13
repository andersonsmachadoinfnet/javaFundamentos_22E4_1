package br.anderson.infnet.appclinica.model.exceptions;

public class ProcedimentoTipoInvalidoException  extends Exception {
	private static final long serialVersionUID = 1L;

	public ProcedimentoTipoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
