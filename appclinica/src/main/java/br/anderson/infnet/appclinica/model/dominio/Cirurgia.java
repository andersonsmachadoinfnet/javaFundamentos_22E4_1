package br.anderson.infnet.appclinica.model.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.anderson.infnet.appclinica.model.auxiliar.Constantes;
import br.anderson.infnet.appclinica.model.auxiliar.PacienteTipo;
import br.anderson.infnet.appclinica.model.auxiliar.ProcedimentoTipo;
import br.anderson.infnet.appclinica.model.exceptions.DescricaoInvalidaException;
import br.anderson.infnet.appclinica.model.exceptions.ValorInvalidoException;

@Entity
@Table(name = "TCirurgia")
public class Cirurgia extends Procedimento {
	private String indicadoPara;
	
	public Cirurgia() {
		// TODO Auto-generated constructor stub
	}
	
	public Cirurgia(/*ProcedimentoTipo pTipo, */String descricao, float valor, String indicadoPara) 
		   throws ValorInvalidoException, DescricaoInvalidaException {
		super(ProcedimentoTipo.CIRURGIA, descricao, valor);
		this.indicadoPara = indicadoPara;
	}
	
	public Cirurgia(String pLinha) throws ValorInvalidoException, DescricaoInvalidaException {
		super(pLinha);
		setLinha(pLinha);
		checaSeValidoOuGeraErro();
	}

	@Override
	public float calcularValorDoProcedimento(PacienteTipo pPacienteTp) {
		return super.getValor()*pPacienteTp.ratio();
	}

	public String getIndicadoPara() {
		return indicadoPara;
	}

	@Override
	public List<String> obterLinha() {
		List<String> lRet;
		lRet = new ArrayList<String>();
		for (String lLinha : super.obterLinha()) {
			lRet.add(lLinha + Constantes.SEPARADOR + this.indicadoPara);
		}
		return lRet;
	}

	@Override
	public void setLinha(String pLinha) {
		super.setLinha(pLinha);
		String[] lCampos = pLinha.split(Constantes.SEPARADOR);
		this.indicadoPara= lCampos[3];
	}
}
