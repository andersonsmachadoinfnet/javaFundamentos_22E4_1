package br.anderson.infnet.appclinica.model.auxiliar;

import java.time.format.DateTimeFormatter;

public class Constantes {
	public static final String _FMT_DATE_BR_     = "dd/MM/yyyy";
	public static final String _FMT_DATETIME_BR_ = "dd/MM/yyyy HH:mm";
	
	public static final char   SEPARADOR = ';';
	
	public static final DateTimeFormatter FMT_DATE_BR() {
		return DateTimeFormatter.ofPattern(_FMT_DATE_BR_);
	}
	
	public static final DateTimeFormatter FMT_DATETIME_BR() {
		return DateTimeFormatter.ofPattern(_FMT_DATETIME_BR_);
	}
}