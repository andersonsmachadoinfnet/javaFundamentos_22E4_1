package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.CirurgiaRepository;

@Component
public class CirurgiaService {
	@Autowired
	private CirurgiaRepository repository;
	
	public Cirurgia incluir(Cirurgia item) {
		return repository.save(item);
	}

	public void excluir(Integer key) {
		repository.deleteById(key);
	}

	public Collection<Cirurgia> obterLista(){
		return (Collection<Cirurgia>)repository.obterLista(Sort.by(Direction.ASC, "descricao"));
	}
	
	public Collection<Cirurgia> obterLista(Usuario usuario){
		return (Collection<Cirurgia>)repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
}
