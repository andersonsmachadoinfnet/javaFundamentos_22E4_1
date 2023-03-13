package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Exame;
import br.anderson.infnet.appclinica.model.repository.ExameRepository;

@Service
public class ExameService {
	@Autowired
	private ExameRepository repository;
	
	public boolean incluir(Exame item) {
		return repository.incluir(item);
	}

	public Exame excluir(Integer key) {
		return repository.excluir(key);
	}

	public Collection<Exame> obterLista(){
		return repository.obterLista();
	}
}
