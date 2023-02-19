package br.anderson.infnet.appclinica.model.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import br.anderson.infnet.appclinica.model.dominio.Usuario;

public class UsuarioRepository {
	//private static Map<Integer, Usuario> Usuarios = new HashMap<Integer, Usuario>();
	private static List<Usuario> lista = new ArrayList<Usuario>();

	public static boolean incluir(Usuario usuario) {
		
		try {
			//Usuarios.put(usuario.getUserId(), usuario);
			lista.add(usuario);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	public static List<Usuario> obterLista(){
		//List<Usuario> lista = new ArrayList<Usuario>(Usuarios.values());
		return lista;
		
	}

}
