package br.anderson.infnet.appclinica.model.repository;

import br.anderson.infnet.appclinica.model.dominio.Usuario;

public class AcessoRepository {
	public static Usuario autenticar(Usuario usuario) {

		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
		}

		return null;
	}
}
