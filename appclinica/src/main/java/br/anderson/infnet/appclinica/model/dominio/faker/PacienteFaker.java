package br.anderson.infnet.appclinica.model.dominio.faker;

import br.anderson.infnet.appclinica.model.auxiliar.Faker;
import br.anderson.infnet.appclinica.model.dominio.Paciente;

public class PacienteFaker {
	public static Paciente getPaciente() {
		String lNome = Faker.getNome();
		return new Paciente(lNome, 
				            Faker.getCPF(),
				            Faker.getEmail(lNome),
				            Faker.getDtNasc());
	}
}
