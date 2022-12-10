package br.anderson.infnet.appclinica.model.testes;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.ProcedimentoFaker;

public class ProcedimentoTests {
	
	public static void main(String[] args) {
		
		Procedimento p1 = ProcedimentoFaker.getCirurgia();
		System.out.println( p1.toString() );
		
		// TODO Auto-generated method stub

	}

}
