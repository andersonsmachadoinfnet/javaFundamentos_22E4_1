package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;

@Component
public class MedicamentoRepository {
	private static Integer id = 1;
	private static Map<Integer, Medicamento> Medicamentos = new HashMap<Integer, Medicamento>();

	public boolean incluir(Medicamento medicamento) {
		medicamento.setId(id++);
		try {
			Medicamentos.put(medicamento.getId(), medicamento);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Medicamento excluir(Integer key) {
		return Medicamentos.remove(key);
	}

	public Collection<Medicamento> obterLista(){
		return Medicamentos.values();
	}
}
