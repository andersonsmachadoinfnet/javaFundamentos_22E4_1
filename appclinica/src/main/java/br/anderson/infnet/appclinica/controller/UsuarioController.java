package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	private String mensagem;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {
		usuarioService.incluir(usuario);
		mensagem = String.format("O %s foi cadastrado com sucesso!", usuario.getNome());
		
		return "redirect:/usuario/lista";
	}
	
	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("usuarios", usuarioService.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		/*List<Usuario> lista = UsuarioRepository.obterLista();
		
		//System.out.println("Quantidade de usuários = " + lista.size());
	
		for(Usuario user : lista) {
			System.out.printf("%s - %s\n", user.getNome(), user.getEmail());
		}	
		*/
	
		return "usuario/lista";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			//Usuario usuario = usuarioService.excluir(id);
			usuarioService.excluir(id);
			mensagem = "Usuário removido";
			//mensagem = String.format("Usuário %s removido", usuario.getNome());
		} catch (Exception e) {
			mensagem = "Não foi possível remover o usuário!";
		}

		return "redirect:/usuario/lista";
	}

}
