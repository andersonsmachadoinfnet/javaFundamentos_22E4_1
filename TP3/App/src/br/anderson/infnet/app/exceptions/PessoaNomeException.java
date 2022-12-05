package br.anderson.infnet.app.exceptions;

public class PessoaNomeException extends Exception  {
	private static final long serialVersionUID = 1L;

	public PessoaNomeException(String mensagem) {
		super(mensagem);
	}

}
