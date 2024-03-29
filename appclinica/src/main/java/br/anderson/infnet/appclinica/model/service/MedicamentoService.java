package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.MedicamentoRepository;
import br.anderson.infnet.appclinica.model.repository.map.MedicamentoRepositoryMap;

@Service
public class MedicamentoService {
	@Autowired
	private MedicamentoRepository repository;
	
	public Medicamento incluir(Medicamento item) {
		return repository.save(item);
	}
	
	public Optional<Medicamento> ler(Integer key) {
		return repository.findById(key);
	}

	public void excluir(Integer key) {
		repository.deleteById(key);
	}

	public Collection<Medicamento> obterLista(){
		return repository.obterLista(Sort.by(Direction.ASC, "descricao"));
	}
	
	public Collection<Medicamento> obterLista(Usuario usuario) {
		return repository.obterLista(usuario.getId(), Sort.by(Direction.ASC, "descricao"));
	}
}
