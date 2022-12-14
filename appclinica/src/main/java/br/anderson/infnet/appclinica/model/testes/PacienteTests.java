package br.anderson.infnet.appclinica.model.testes;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.faker.PacienteFaker;
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;

public class PacienteTests {

	public static void main(String[] args) {
		try {
			Paciente p = PacienteFaker.getPaciente();
			System.out.println( p.toString() );
		} catch (CampoRequeridoNaoInformado e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		

	}

}
