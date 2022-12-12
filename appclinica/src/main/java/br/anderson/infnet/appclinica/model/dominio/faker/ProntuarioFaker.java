package br.anderson.infnet.appclinica.model.dominio.faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.anderson.infnet.appclinica.model.auxiliar.Faker;
import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.dominio.Procedimento;

public class ProntuarioFaker {
    public static Prontuario getProntuario() {
        Prontuario prontuario = new Prontuario();
		List<Procedimento> procedimentos = new ArrayList<Procedimento>();
		
		// Criando o prontuário...
		prontuario.setPaciente(PacienteFaker.getPaciente());
		System.out.println( prontuario.toString() );
		
		// Adicionando procedimentos
		try {
            for(int i=0;i<new Random().nextInt(5);i++) {
			    procedimentos.add(ProcedimentoFaker.getCirurgia());
            }
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
            for(int i=0;i<new Random().nextInt(5);i++) {
			    procedimentos.add(ProcedimentoFaker.getExame());
            }
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		try {
            for(int i=0;i<new Random().nextInt(5);i++) {
			    procedimentos.add(ProcedimentoFaker.getMedicamento());
            }
		} catch (ValorInvalidoException | DescricaoInvalidaException e) {
			System.out.println("[ERRO] " + e.getMessage());
		}
		
		prontuario.setProcedimentos(procedimentos);
		return prontuario;
	}

}
