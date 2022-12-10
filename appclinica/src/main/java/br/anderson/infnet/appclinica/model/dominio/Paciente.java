package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDate;
import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;

public class Paciente {
	private PacienteTipo tipo;
	private       String nome;
	private       String cpf;
	private       String email;
	private    LocalDate dtNasc;
	
	public Paciente(String pNome, String pCpf, String pEmail, LocalDate pDtNasc) {
		this.tipo   = PacienteTipo.PARTICULAR;
		this.nome   = pNome;
		this.cpf    = pCpf;
		this.email  = pEmail;
		this.dtNasc = pDtNasc;
		
		checaSeValidoOuGeraErro();
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(nome).append(Constantes.SEPARADOR)
				                  .append(cpf).append(Constantes.SEPARADOR)
		                          .append(email).append(Constantes.SEPARADOR)
		                          .append(dtNasc.format(Constantes.FMT_DATE_BR()))
		                          .toString();
	}
	
	public void checaSeValidoOuGeraErro() {
		/* Colocar aqui as validacoes da classe: isValido? */
		// TODO: Falta implementar
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public PacienteTipo getTipo() {
		return tipo;
	}
}
