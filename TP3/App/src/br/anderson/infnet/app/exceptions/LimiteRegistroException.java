package br.anderson.infnet.app.exceptions;

public class LimiteRegistroException extends Exception  {
	
	private static final long serialVersionUID = 1L;

	public LimiteRegistroException(String mensagem) {
		super(mensagem);
	}

}
