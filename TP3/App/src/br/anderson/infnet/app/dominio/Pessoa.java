package br.anderson.infnet.app.dominio;

import java.util.Scanner;
import br.anderson.infnet.app.exceptions.*;

public abstract class Pessoa {
	private String primeiroNome;
	private String sobreNome;
	private String ultimoNome;
	protected boolean metodoSeparaNomeViaSplit;

	public Pessoa() {
		metodoSeparaNomeViaSplit = true;
		limparDados();
	}
	
	@Override
	public String toString() {
		return getNomeCompleto() + ";";
	}
	
	public abstract String consultarSituacao();
	public Pessoa entradaDados() throws PessoaNomeException {
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Informe o seu nome completo: ");	
			setNomeCompleto(in.nextLine());
		} finally {
			//in.close();
		}
		
		return this;
	};
	
	public void limparDados() {
		this.primeiroNome = "";
		this.sobreNome    = "";
		this.ultimoNome   = "";
	}
	
	public boolean isNomeValido() {
		return !((this.primeiroNome.trim().isBlank()) ||
			     (this.sobreNome.trim().isBlank()) ||
			     (this.ultimoNome.trim().isBlank()));
	}
	
	private void separaNomeViaSplit(String nome) {
		String[] nomes = null;
		nomes = nome.split(" ");
		int idx;
		this.limparDados();
		for (idx=0;idx<nomes.length;idx++) {
			if (idx==0) { this.primeiroNome = nomes[idx]; }
			else if (idx==nomes.length-1) { this.ultimoNome = nomes[idx]; }
			else {
				this.sobreNome = String.format("%s %s", this.sobreNome, nomes[idx]).trim();
			}
		}
	}
	
	private void separaNomeViaSubstring(String nome) {
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");
		
		try	{
			this.primeiroNome = nome.substring(0, posInicial);
			this.sobreNome = nome.substring(posInicial, posFinal).trim();
			this.ultimoNome = nome.substring(posFinal).trim();
		} catch (Exception e) {
			// não é necessário validar o erro aqui, já que a função
			// isNomeValido() será invocada no fluxo.
			this.limparDados();
		}
	}
	
	public void setNomeCompleto(String nome) throws PessoaNomeException {
		if(nome == null) {
			throw new PessoaNomeException("O preenchimento do campo 'nome' está incorreto");
		}
		
		if (this.metodoSeparaNomeViaSplit) {
			this.separaNomeViaSplit(nome);
		} else {
			this.separaNomeViaSubstring(nome);
		}
		
		if (!this.isNomeValido()) {
			throw new PessoaNomeException("\nNome incompleto! Por favor informe um nome, nome do meio e último nome.");
		}
	}
	
	public String getNomeCompleto () {
		StringBuilder sb = new StringBuilder();
		sb.append(this.primeiroNome);
		sb.append(" ");
		sb.append(this.sobreNome);
		sb.append(" ");
		sb.append(this.ultimoNome);
		return sb.toString();
	}
}
