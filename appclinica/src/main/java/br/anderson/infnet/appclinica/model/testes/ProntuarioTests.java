package br.anderson.infnet.appclinica.model.testes;

import br.anderson.infnet.appclinica.model.dominio.PacienteFaker;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;

public class ProntuarioTests {

	public static void main(String[] args) {
		
		Prontuario prontuario = new Prontuario();
		
		prontuario.setPaciente(PacienteFaker.getPaciente());
		System.out.println( prontuario.toString() );
		
		// TODO Auto-generated method stub

	}

}
