package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.ProntuarioRepository;

@Service
public class ProntuarioService {
	@Autowired
	private ProntuarioRepository repository;
	
	public Prontuario incluir(Prontuario item) {
		return repository.save(item);
		//return repository.incluir(item);
	}

	public void excluir(Integer key) {
		repository.deleteById(key);
		//return repository.excluir(key);
	}

	public Collection<Prontuario> obterLista(){
		return (Collection<Prontuario>) repository.findAll();
		//return repository.obterLista();
	}
	
	public Collection<Prontuario> obterLista(Usuario usuario){
		return (Collection<Prontuario>) repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
		//return repository.obterLista();
	}
	
	public Prontuario obterPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}
}
