package br.anderson.infnet.appclinica.model.report;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;

public class ProntuarioReport {
	private Prontuario obj;
	
	public ProntuarioReport(Prontuario pObjDecorator) {
		this.obj = pObjDecorator;
	}
	
	public void imprimir() {
		System.out.println("Prontuário        : " + obj);
		System.out.println("Paciente          : " + obj.getPaciente());
		System.out.println("Qtde procedimentos: " + obj.getProcedimentos().size());
		System.out.println("Procedimentos     :");
		for(Procedimento p : obj.getProcedimentos()) {
			System.out.println(" - " + p.getDescricao());
		}
	} 

}
