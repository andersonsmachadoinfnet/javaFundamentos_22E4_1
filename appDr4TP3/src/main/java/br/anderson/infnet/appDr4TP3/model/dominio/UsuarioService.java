package br.anderson.infnet.appDr4TP3.model.dominio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anderson.infnet.appDr4TP3.API.ServicoDeCep;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario autenticar(Usuario usuario) {
		return usuarioRepository.autenticacao(usuario.getEmail(), usuario.getSenha());
	}

	public Usuario incluir(Usuario usuario) {
		/*Endereco endereco;
		try {
			endereco = ServicoDeCep.buscaEnderecoPelo(usuario.getCep());
			System.out.println(endereco);
			usuario.setEndereco(endereco.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer key) {
		usuarioRepository.deleteById(key);
	}
	
	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
}
