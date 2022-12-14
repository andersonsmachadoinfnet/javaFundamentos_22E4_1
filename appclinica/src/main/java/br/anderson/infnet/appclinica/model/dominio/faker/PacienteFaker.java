package br.anderson.infnet.appclinica.model.dominio.faker;

import br.anderson.infnet.appclinica.model.auxiliar.Faker;
import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;

public class PacienteFaker {
	public static Paciente getPaciente() throws CampoRequeridoNaoInformado {
		String lNome = Faker.getNome();
		return new Paciente(lNome, 
				            Faker.getCPF(),
				            Faker.getEmail(lNome),
				            Faker.getDtNasc());
	}
}
