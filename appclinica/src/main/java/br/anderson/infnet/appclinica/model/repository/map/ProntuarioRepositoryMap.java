package br.anderson.infnet.appclinica.model.repository.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Prontuario;

public class ProntuarioRepositoryMap {
	private static Integer id = 1;
	private static Map<Integer, Prontuario> prontuarios = new HashMap<Integer, Prontuario>();

	public static boolean incluir(Prontuario prontuario) {
		prontuario.setId(id++);
		try {
			prontuarios.put(prontuario.getId(), prontuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Prontuario excluir(Integer key) {
		return prontuarios.remove(key);
	}

	public static Collection<Prontuario> obterLista(){
		return prontuarios.values();
	}

}
