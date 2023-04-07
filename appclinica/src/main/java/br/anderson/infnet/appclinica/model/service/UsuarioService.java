package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario autenticar(Usuario usuario) {
		return repository.autenticacao(usuario.getEmail(), usuario.getSenha());
	}
	
	public Optional<Usuario> ler(Integer key) {
		return repository.findById(key);
	}
	
	public Usuario incluir(Usuario usuario) {
		return repository.save(usuario); // incluir
	}

	public void excluir(Integer key) {
		repository.deleteById(key); // excluir
	}

	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) repository.obterLista(Sort.by(Direction.ASC, "nome"));
		//return repository.obterLista();
	}
}
