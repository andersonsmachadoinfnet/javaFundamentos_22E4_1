package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.repository.MedicamentoRepository;

@Service
public class MedicamentoService {
	@Autowired
	private MedicamentoRepository repository;
	
	public boolean incluir(Medicamento item) {
		return repository.incluir(item);
	}

	public Medicamento excluir(Integer key) {
		return repository.excluir(key);
	}

	public Collection<Medicamento> obterLista(){
		return repository.obterLista();
	}
}
