package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Exame;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.ExameRepository;
import br.anderson.infnet.appclinica.model.repository.map.ExameRepositoryMap;

@Service
public class ExameService {
	@Autowired
	private ExameRepository repository;
	
	public Exame incluir(Exame item) {
		return repository.save(item);
	}

	public void excluir(Integer key) {
		repository.deleteById(key);
	}

	public Collection<Exame> obterLista(){
		return (Collection<Exame>)repository.findAll();
	}
	
	public Collection<Exame> obterLista(Usuario usuario){
		return repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
}
