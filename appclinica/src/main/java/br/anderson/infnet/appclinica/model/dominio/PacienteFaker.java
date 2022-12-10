package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.Faker;

public class PacienteFaker {
	public static Paciente getPaciente() {
		String lNome = Faker.getNome();
		return new Paciente(lNome, 
				            Faker.getCPF(),
				            Faker.getEmail(lNome),
				            Faker.getDtNasc());
	}
}
