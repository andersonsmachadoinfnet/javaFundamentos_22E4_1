package br.anderson.infnet.appclinica.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repository;
	
	public boolean incluir(Usuario usuario) {
		return repository.incluir(usuario);
	}

	public Usuario excluir(Integer key) {
		return repository.excluir(key);
	}

	public Collection<Usuario> obterLista(){
		return repository.obterLista();
	}
}
