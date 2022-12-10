package br.anderson.infnet.appclinica.model.auxiliar;

public enum PacienteTipo {
	PARTICULAR, SUS, UNIMED;
	
	public float ratio() {
		if (this==PARTICULAR) { 
			return (float) 1.0;
		} else if (this==SUS) {
			return (float) 0.50;
		} else if (this==UNIMED) {
			return (float) 0.75;
		} else
			return 0;
	}
}
