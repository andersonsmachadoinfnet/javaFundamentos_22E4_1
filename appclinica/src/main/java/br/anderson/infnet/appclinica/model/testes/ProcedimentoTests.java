package br.anderson.infnet.appclinica.model.testes;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.faker.ProcedimentoFaker;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class ProcedimentoTests {
	
	public static void main(String[] args) {
		
		Procedimento p1;
		try {
			p1 = ProcedimentoFaker.getCirurgia();
			System.out.println( p1.toString() );
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		
		Procedimento p2;
		try {
			p2 = ProcedimentoFaker.getExame();
			System.out.println( p2.toString() );
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		
		Procedimento p3;
		try {
			p3 = ProcedimentoFaker.getMedicamento();
			System.out.println( p3.toString() );
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
	}

}
