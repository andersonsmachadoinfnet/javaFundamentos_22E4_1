package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import br.anderson.infnet.appclinica.model.dominio.Usuario;

@Component
public class UsuarioRepository {
	private static Integer id = 1;
	private static Map<Integer, Usuario> Usuarios = new HashMap<Integer, Usuario>();

	public boolean incluir(Usuario usuario) {
		usuario.setUserId(id++);
		try {
			Usuarios.put(usuario.getUserId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public Usuario excluir(Integer key) {
		return Usuarios.remove(key);
	}

	public Collection<Usuario> obterLista(){
		return Usuarios.values();
	}

}
