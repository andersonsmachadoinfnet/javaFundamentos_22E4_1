package br.anderson.infnet.appclinica.model.interfaces;

public interface IArquivoTxt_linha {
	public abstract  String getPrefixo();
	public abstract boolean isPrefixo(String pPrefixo);
	public abstract  String obterLinha();
	public abstract    void setLinha(String pLinha);
}
