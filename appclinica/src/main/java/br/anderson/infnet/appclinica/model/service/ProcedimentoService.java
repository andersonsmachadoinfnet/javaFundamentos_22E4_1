package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.ProcedimentoRepository;

@Service
public class ProcedimentoService {
	@Autowired
	private ProcedimentoRepository repository;
	
	public Procedimento incluir(Procedimento item) {
		return repository.save(item);
		//return repository.incluir(item);
	}

	public void excluir(Integer key) {
		repository.deleteById(key);
		//return repository.excluir(key);
	}

	public Collection<Procedimento> obterLista(){
		return (Collection<Procedimento>) repository.obterLista(Sort.by(Direction.ASC, "descricao"));
		//return repository.obterLista();
	}
	
	public Collection<Procedimento> obterLista(Usuario usuario){
		return (Collection<Procedimento>) repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
		//return repository.obterLista();
	}
}
