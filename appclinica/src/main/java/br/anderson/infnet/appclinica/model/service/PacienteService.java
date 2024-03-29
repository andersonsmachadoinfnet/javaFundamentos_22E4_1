package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository repository;
	
	public Paciente incluir(Paciente item) {
		return repository.save(item);
		//return repository.incluir(item);
	}
	
	public Optional<Paciente> ler(Integer key) {
		return repository.findById(key);
	}
	

	public void excluir(Integer key) {
		repository.deleteById(key);
		//return repository.excluir(key);
	}

	public Collection<Paciente> obterLista(){
		return (Collection<Paciente>) repository.obterLista(Sort.by(Direction.ASC, "nome"));
		//return repository.obterLista();
	}
	
	public Collection<Paciente> obterLista(Usuario usuario){
		return (Collection<Paciente>) repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "nome"));
		//return repository.obterLista();
	}

}
