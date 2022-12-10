package br.anderson.infnet.appclinica.model.auxiliar;

public enum ProcedimentoTipo {
	CIRURGIA("Cirurgia"), EXAME("Exame"), MEDICAMENTO("Medicamento");
	
	private String nome;
	private ProcedimentoTipo(String pNome) {
		this.nome = pNome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
