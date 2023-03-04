package br.anderson.infnet.appclinica.model.dominio.faker;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.Faker;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.dominio.Exame;
import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

public class ProcedimentoFaker {
	public static Procedimento getCirurgia() throws ValorInvalidoException, DescricaoInvalidaException {
		return new Cirurgia(//ProcedimentoTipo.CIRURGIA,
				            Faker.getCIRURGIA(),
				            Faker.getVALOR(),
				            Faker.getTEXTO());
	}
	
	public static Procedimento getExame() throws ValorInvalidoException, DescricaoInvalidaException {
		return new Exame(//ProcedimentoTipo.EXAME,
				         Faker.getEXAME(),
				         Faker.getVALOR());
	}
	
	public static Procedimento getMedicamento() throws ValorInvalidoException, DescricaoInvalidaException {
		return new Medicamento(//ProcedimentoTipo.MEDICAMENTO,
				            Faker.getMEDICAMENTO(),
				            Faker.getVALOR(),
				            Faker.getTEXTO());
	}
}
