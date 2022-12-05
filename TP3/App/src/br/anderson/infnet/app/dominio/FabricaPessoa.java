package br.anderson.infnet.app.dominio;

import br.anderson.infnet.app.auxiliar.*;
import br.anderson.infnet.app.exceptions.*;

public class FabricaPessoa {
	
	public Pessoa criar (int doTipo) throws PessoaTipoException, PessoaNomeException {
		Pessoa ret = null;
		switch (doTipo) {
		case Constantes.PROFESSOR_TP:
			ret = new Professor();
			break;
			
		case Constantes.ALUNO_TP:
			ret = new Aluno();
			break;
				
		default:
			throw new PessoaTipoException("\nTipo de pessoa passado no parâmetro é inválido!");
		}
		
		ret.entradaDados();		
		return ret;
	}
}
