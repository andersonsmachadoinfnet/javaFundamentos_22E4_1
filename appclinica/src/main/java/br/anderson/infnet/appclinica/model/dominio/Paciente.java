package br.anderson.infnet.appclinica.model.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;

public class Paciente implements IArquivoTxt_linha {
	private          int id;
	private PacienteTipo tipo;
	private       String nome;
	private       String cpf;
	private       String email;
	private    LocalDate dtNasc;
	
	public Paciente(String nome, String cpf, String email, String dtNasc) throws CampoRequeridoNaoInformado  {
		this.tipo   = PacienteTipo.PARTICULAR;
		this.nome   = nome;
		this.cpf    = cpf;
		this.email  = email;
		this.dtNasc = LocalDate.parse(dtNasc);
		
		checaSeValidoOuGeraErro();
	}
	
	protected Paciente(String pLinha) throws CampoRequeridoNaoInformado  {
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
	
	public void checaSeValidoOuGeraErro() throws CampoRequeridoNaoInformado {
		if (this.nome == null || this.nome.isEmpty()) {
			throw new CampoRequeridoNaoInformado("Nome");
		}
		if (this.cpf == null || this.cpf.isEmpty()) {
			throw new CampoRequeridoNaoInformado("CPF");
		}
		if (this.email == null || this.email.isEmpty() || this.email.indexOf("@")<1|| this.email.indexOf(".")<1) {
			throw new CampoRequeridoNaoInformado("E-mail");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int pId) {
		this.id = pId;
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
