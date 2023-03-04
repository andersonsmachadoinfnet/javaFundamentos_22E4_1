package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;

public class MedicamentoRepository {
	private static Integer id = 1;
	private static Map<Integer, Medicamento> Medicamentos = new HashMap<Integer, Medicamento>();

	public static boolean incluir(Medicamento medicamento) {
		medicamento.setId(id++);
		try {
			Medicamentos.put(medicamento.getId(), medicamento);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Medicamento excluir(Integer key) {
		return Medicamentos.remove(key);
	}

	public static Collection<Medicamento> obterLista(){
		return Medicamentos.values();
	}
}
