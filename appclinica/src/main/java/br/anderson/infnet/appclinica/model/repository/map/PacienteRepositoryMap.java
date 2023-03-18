package br.anderson.infnet.appclinica.model.repository.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Paciente;

@Component
public class PacienteRepositoryMap {
	private static Integer id = 1;
	private static Map<Integer, Paciente> pacientes = new HashMap<Integer, Paciente>();

	public  boolean incluir(Paciente paciente) {
		paciente.setId(id++);
		try {
			pacientes.put(paciente.getId(), paciente);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Paciente excluir(Integer key) {
		return pacientes.remove(key);
	}

	public Collection<Paciente> obterLista(){
		return pacientes.values();
	}

}
