package br.anderson.infnet.appclinica.model.dominio;

import br.anderson.infnet.appclinica.model.auxiliar.Faker;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;

public class ProcedimentoFaker {
	public static Procedimento getCirurgia() {
		return new Cirurgia(ProcedimentoTipo.CIRURGIA,
				            Faker.getCIRURGIA(),
				            Faker.getVALOR(),
				            Faker.getTEXTO());
	}
}
