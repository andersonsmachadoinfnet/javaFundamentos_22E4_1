package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.repository.CirurgiaRepository;

@Component
public class CirurgiaService {
	@Autowired
	private CirurgiaRepository repository;
	
	public boolean incluir(Cirurgia item) {
		return repository.incluir(item);
	}

	public Cirurgia excluir(Integer key) {
		return repository.excluir(key);
	}

	public Collection<Cirurgia> obterLista(){
		return repository.obterLista();
	}
}
