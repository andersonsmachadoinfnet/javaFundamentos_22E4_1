package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Paciente;

public class PacienteRepository {
	private static Integer id = 1;
	private static Map<Integer, Paciente> pacientes = new HashMap<Integer, Paciente>();

	public static boolean incluir(Paciente paciente) {
		paciente.setId(id++);
		try {
			pacientes.put(paciente.getId(), paciente);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Paciente excluir(Integer key) {
		return pacientes.remove(key);
	}

	public static Collection<Paciente> obterLista(){
		return pacientes.values();
	}

}
