package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repository;
	
	public boolean incluir(Paciente item) {
		return repository.incluir(item);
	}

	public Paciente excluir(Integer key) {
		return repository.excluir(key);
	}

	public Collection<Paciente> obterLista(){
		return repository.obterLista();
	}

}
