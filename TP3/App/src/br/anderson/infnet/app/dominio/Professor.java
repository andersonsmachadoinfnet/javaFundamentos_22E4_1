package br.anderson.infnet.app.dominio;

import java.util.Scanner;

import br.anderson.infnet.app.exceptions.*;

public class Professor extends Pessoa {
	private String disciplina;

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String consultarSituacao() {
		return String.format("Prof(a) %s da diciplina de %s", super.getNomeCompleto(), this.disciplina);
	}
	
	@Override
	public Pessoa entradaDados() throws PessoaNomeException {
		super.metodoSeparaNomeViaSplit = false;
		super.entradaDados();
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Informe sua disciplina: ");	
			this.disciplina = in.nextLine();
		} finally {
			//in.close();
		}
		
		return this;
	}
}
