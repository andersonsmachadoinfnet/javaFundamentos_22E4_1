package br.anderson.infnet.appclinica.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.dominio.faker.PacienteFaker;
import br.anderson.infnet.appclinica.model.dominio.faker.ProcedimentoFaker;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.report.ProntuarioReport;

public class ProntuarioTests {

	public static void main(String[] args) {
		
		Prontuario prontuario = new Prontuario();
		List<Procedimento> procedimentos = new ArrayList<Procedimento>();
		
		// Criando o prontuário...
		prontuario.setPaciente(PacienteFaker.getPaciente());
		System.out.println( prontuario.toString() );
		
		// Adicionando procedimentos
		try {
			procedimentos.add(ProcedimentoFaker.getCirurgia());
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
			procedimentos.add(ProcedimentoFaker.getExame());
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
			procedimentos.add(ProcedimentoFaker.getMedicamento());
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		prontuario.setProcedimentos(procedimentos);
		
		new ProntuarioReport(prontuario).imprimir();
		
		
		
		
		// TODO Auto-generated method stub

	}

}
