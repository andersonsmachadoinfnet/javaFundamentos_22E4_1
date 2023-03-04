package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia;

public class CirurgiaRepository {
	private static Integer id = 1;
	private static Map<Integer, Cirurgia> Cirurgias = new HashMap<Integer, Cirurgia>();

	public static boolean incluir(Cirurgia cirurgia) {
		cirurgia.setId(id++);
		try {
			Cirurgias.put(cirurgia.getId(), cirurgia);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Cirurgia excluir(Integer key) {
		return Cirurgias.remove(key);
	}

	public static Collection<Cirurgia> obterLista(){
		return Cirurgias.values();
	}
}
