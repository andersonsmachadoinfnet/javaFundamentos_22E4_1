package br.anderson.infnet.appclinica.model.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.exceptions.CampoRequeridoNaoInformado;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ProcedimentoTipoInvalidoException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

@Entity
@Table(name = "TUsuario")
public class Usuario implements IArquivoTxt_linha  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private    int id;
	private String nome;
	private String senha;
	private String email;
	private    int tipo; //0=Administrador;1=Geral
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idPaciente")
	private List<Paciente> pacientes;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idProntuario")
	private List<Prontuario> prontuario;
	
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "idProcedimento")
	private List<Procedimento> procedimento;
	
	public List<Procedimento> getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(List<Procedimento> procedimento) {
		this.procedimento = procedimento;
	}

	public List<Prontuario> getProntuario() {
		return prontuario;
	}

	public void setProntuario(List<Prontuario> prontuario) {
		this.prontuario = prontuario;
	}

	public Usuario() {
	}
	
	public Usuario(String nome, String email, String senha) {
		this();
		this.setId(-1);
		this.setNome(nome);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public Usuario(String email, String senha) {
		this("", email, senha);
	}
	
	public String toString() {
		return String.format("Usuário: %s (%s) [%s]", nome, email, getUserIdLabel());
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserIdLabel( ) {
		if (this.id==-1) {
			return "Sem identificador!";
		}
		else {
			return String.valueOf(this.id);
		}
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public String getPrefixo() {
		return Constantes.PREFIXO_CLASSE_USUARIO;
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
				 this.id + Constantes.SEPARADOR +
				 this.tipo + Constantes.SEPARADOR +
				 this.nome + Constantes.SEPARADOR +
				 this.senha + Constantes.SEPARADOR +
				 this.email + Constantes.SEPARADOR); 
		
		return lRet;
	}

	@Override
	public void setLinha(String pLinha) throws ValorInvalidoException, DescricaoInvalidaException,
			ProcedimentoTipoInvalidoException, CampoRequeridoNaoInformado {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.id    = Integer.valueOf(lCampos[1]);
		this.tipo  = Integer.valueOf(lCampos[2]);
		this.nome  = lCampos[3];
		this.senha = lCampos[4];
		this.email = lCampos[5];
	}
	
}
