package br.anderson.infnet.appclinica.model.report;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.interfaces.IRelatorio;

public class ProntuarioReport implements IRelatorio {
	private Prontuario prontuario;
	
	public ProntuarioReport(Prontuario pProntuario) {
		this.prontuario = pProntuario;
	}
	
	public void imprimir() {
		System.out.println("Prontuário        : " + prontuario);
		System.out.println("Paciente          : " + prontuario.getPaciente());
		System.out.println("Qtde procedimentos: " + prontuario.getProcedimentos().size());
		System.out.println("Procedimentos     :");
		for(Procedimento p : prontuario.getProcedimentos()) {
			System.out.println(" - " + p.getDescricao());
		}
	} 

}
