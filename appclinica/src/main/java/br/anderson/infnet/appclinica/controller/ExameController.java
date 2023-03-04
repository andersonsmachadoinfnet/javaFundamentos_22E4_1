package br.anderson.infnet.appclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Exame;
import br.anderson.infnet.appclinica.model.repository.ExameRepository;

@Controller
public class ExameController {
private String mensagem;
	
	@GetMapping(value = "/exame")
	public String telaCadastro() {
		return "exame/cadastro";
	}

	@PostMapping(value = "/exame/incluir")
	public String incluir(Exame exame) {
		ExameRepository.incluir(exame);
		mensagem = String.format("O %s foi cadastrado com sucesso!", exame.getDescricao());
		
		return "redirect:/exame/lista";
	}
	
	@GetMapping(value = "/exame/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("exames", ExameRepository.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "exame/lista";
	}
	
	@GetMapping(value = "/exame/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Exame exame = ExameRepository.excluir(id);
		
		mensagem = String.format("Item %s removido", exame.getDescricao());

		return "redirect:/exame/lista";
	}
}
