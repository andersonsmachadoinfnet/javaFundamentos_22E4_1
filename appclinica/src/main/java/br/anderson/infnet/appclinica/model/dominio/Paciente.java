package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

public class Paciente implements IArquivoTxt_linha {
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
	
	protected Paciente(String pLinha) {
		setLinha(pLinha);
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

	@Override
	public String getPrefixo() {
		return Constantes.PREFIXO_CLASSE_PACIENTE;
	}

	@Override
	public boolean isPrefixo(String pPrefixo) {
		return getPrefixo().equals(pPrefixo);
	}

	@Override
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		lRet.add(this.getPrefixo() + Constantes.SEPARADOR +
				 this.tipo + Constantes.SEPARADOR +
				 this.nome + Constantes.SEPARADOR +
				 this.cpf + Constantes.SEPARADOR +
				 this.email + Constantes.SEPARADOR +
				 this.dtNasc.format(Constantes.FMT_DATE_BR())); 
		return lRet;
	}

	@Override
	public void setLinha(String pLinha) {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.tipo = PacienteTipo.valueOf(lCampos[1].toUpperCase());
		this.nome  = lCampos[2];
		this.cpf   = lCampos[3];
		this.email = lCampos[4];
		this.dtNasc= LocalDate.parse(lCampos[5], Constantes.FMT_DATE_BR());
	}
}
