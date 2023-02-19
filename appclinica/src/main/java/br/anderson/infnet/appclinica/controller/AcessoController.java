package br.anderson.infnet.appclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.repository.AcessoRepository;

@Controller
public class AcessoController {
	String msg;

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
		
		Usuario user = new Usuario(email, senha);

		if(AcessoRepository.autenticar(user) != null) {
			return "redirect:/home";
		}
		
		model.addAttribute("mensagem", String.format("%s inexistente ou senha inválida!", email) );
		return telaLogin(); //"redirect:/login";
	}
}