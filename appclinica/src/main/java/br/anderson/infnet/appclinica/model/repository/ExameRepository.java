package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.dominio.Exame;

public class ExameRepository {
	private static Integer id = 1;
	private static Map<Integer, Exame> Exames = new HashMap<Integer, Exame>();

	public static boolean incluir(Exame exame) {
		exame.setId(id++);
		try {
			Exames.put(exame.getId(), exame);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Exame excluir(Integer key) {
		return Exames.remove(key);
	}

	public static Collection<Exame> obterLista(){
		return Exames.values();
	}

}
