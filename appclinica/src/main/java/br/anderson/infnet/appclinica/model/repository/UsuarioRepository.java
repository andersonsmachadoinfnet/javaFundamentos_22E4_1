package br.anderson.infnet.appclinica.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.anderson.infnet.appclinica.model.dominio.Usuario;

public class UsuarioRepository {
	private static Integer id = 1;
	private static Map<Integer, Usuario> Usuarios = new HashMap<Integer, Usuario>();
	//private static List<Usuario> lista = new ArrayList<Usuario>();

	public static boolean incluir(Usuario usuario) {
		usuario.setUserId(id++);
		try {
			Usuarios.put(usuario.getUserId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static Usuario excluir(Integer key) {
		return Usuarios.remove(key);
	}

	public static Collection<Usuario> obterLista(){
		return Usuarios.values();
	}

}
