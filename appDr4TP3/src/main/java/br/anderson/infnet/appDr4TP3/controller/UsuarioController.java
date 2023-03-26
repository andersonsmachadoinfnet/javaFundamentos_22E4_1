package br.anderson.infnet.appDr4TP3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.anderson.infnet.appDr4TP3.API.ServicoDeCep;
import br.anderson.infnet.appDr4TP3.model.dominio.Endereco;
import br.anderson.infnet.appDr4TP3.model.dominio.Usuario;
import br.anderson.infnet.appDr4TP3.model.dominio.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	private String msg;
	private Endereco endereco;
	
	@GetMapping(value = "/usuario")
	public String telaCadastro(Model model) {
		model.addAttribute("endereco", endereco);
		return "usuario/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista(Model model) {
		model.addAttribute("usuarios", usuarioService.obterLista());
		
		model.addAttribute("mensagem", msg);
		
		msg = null;
		
		return "usuario/lista";
	}
	
	@PostMapping(value = "/usuario/cep")
	public String consultaCEP(Model model, @RequestParam String cep) {
		
		//Endereco endereco;
		try {
			endereco = ServicoDeCep.buscaEnderecoPelo(cep);
			System.out.println(endereco);
			//usuario.setEndereco(endereco.toString());
			model.addAttribute("endereco", endereco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("mensagem", msg);
		msg = null;
		
		return "redirect:/usuario";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		usuarioService.incluir(usuario);
		
		msg = "A inclusão do usuário "+usuario.getNome()+" foi realizada com sucesso!!!";
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		usuarioService.excluir(id);
		
		msg = "Item removido";

		return "redirect:/usuario/lista";
	}
}
