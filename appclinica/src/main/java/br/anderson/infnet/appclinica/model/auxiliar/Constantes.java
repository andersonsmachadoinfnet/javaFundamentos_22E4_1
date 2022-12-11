package br.anderson.infnet.appclinica.model.auxiliar;

import java.time.format.DateTimeFormatter;

public class Constantes {
	public static final String _FMT_DATE_BR_     = "dd/MM/yyyy";
	public static final String _FMT_DATETIME_BR_ = "dd/MM/yyyy HH:mm";
	
	public static final String SEPARADOR = ";";
	public static final String PREFIXO_CLASSE_PACIENTE   = "P";
	public static final String PREFIXO_CLASSE_PRONTUARIO = "C";
	public static final String PREFIXO_CLASSE_PROCEDIMENTO_EXAME = "PE";
	public static final String PREFIXO_CLASSE_PROCEDIMENTO_MEDIC = "PM";
	public static final String PREFIXO_CLASSE_PROCEDIMENTO_CIRUR = "PC";
	public static final String CRLF = "\r\n";
	
	
	public static final DateTimeFormatter FMT_DATE_BR() {
		return DateTimeFormatter.ofPattern(_FMT_DATE_BR_);
	}
	
	public static final DateTimeFormatter FMT_DATETIME_BR() {
		return DateTimeFormatter.ofPattern(_FMT_DATETIME_BR_);
	}
}