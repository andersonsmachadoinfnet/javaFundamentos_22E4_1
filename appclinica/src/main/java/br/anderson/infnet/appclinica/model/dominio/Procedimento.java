package br.anderson.infnet.appclinica.model.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;
import br.anderson.infnet.appclinica.model.interfaces.IArquivoTxt_linha;

@Entity
@Table(name = "TProcedimento")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Procedimento implements IArquivoTxt_linha  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private              int id;
	private ProcedimentoTipo tipo;
	private           String descricao;
	private            float valor;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "procedimentos")
	private List<Prontuario> prontuarios; 
	
	public Usuario getUsuario() {
		return usuario;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setTipo(ProcedimentoTipo tipo) {
		this.tipo = tipo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public Procedimento() {
		
	}

	public Procedimento(ProcedimentoTipo pTipo, String pDescricao, float pValor) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		this();
		this.tipo      = pTipo;
		this.descricao = pDescricao;
		this.valor     = pValor;
		this.id        = -1;
		
		checaSeValidoOuGeraErro();
	}
	
	protected Procedimento(String pLinha) 
			throws ValorInvalidoException, DescricaoInvalidaException {
		this();
		setLinha(pLinha);
		checaSeValidoOuGeraErro();
	};
	
	public abstract float calcularValorDoProcedimento(PacienteTipo pPacienteTp);
	
	public void checaSeValidoOuGeraErro() throws ValorInvalidoException, DescricaoInvalidaException {
		if (this.valor==0) {
			throw new ValorInvalidoException("Não foi informado um valor para o procedimento!");
		}
		if (this.valor<0) {
			throw new ValorInvalidoException("O valor do procedimento é inválido!");
		}
		if (this.descricao==null || this.descricao.trim()=="") {
			throw new DescricaoInvalidaException("Não foi informado um descritivo para o procedimento!");
		}
		
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(tipo).append(Constantes.SEPARADOR)
				                  .append(descricao).append(Constantes.SEPARADOR)
		                          .append(valor).append(Constantes.SEPARADOR)
		                          .toString();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int pId) {
		this.id = pId;
	}
	
	
	
	public ProcedimentoTipo getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}
	
	@Override
	public String getPrefixo() {
		return this.tipo.getPrefixo();
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
				 this.descricao + Constantes.SEPARADOR +
		         this.valor);	
		return lRet;
	}
	
	@Override
	public void setLinha(String pLinha) {
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.tipo = ProcedimentoTipo.setPrefixo(lCampos[0].toUpperCase());
		this.descricao  = lCampos[1];
		this.valor      = Float.valueOf(lCampos[2]);
	}
}
