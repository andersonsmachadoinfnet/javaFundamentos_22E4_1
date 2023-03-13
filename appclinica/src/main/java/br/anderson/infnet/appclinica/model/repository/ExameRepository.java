package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Exame;

@Component
public class ExameRepository {
	private static Integer id = 1;
	private static Map<Integer, Exame> Exames = new HashMap<Integer, Exame>();

	public boolean incluir(Exame exame) {
		exame.setId(id++);
		try {
			Exames.put(exame.getId(), exame);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Exame excluir(Integer key) {
		return Exames.remove(key);
	}

	public Collection<Exame> obterLista(){
		return Exames.values();
	}

}
