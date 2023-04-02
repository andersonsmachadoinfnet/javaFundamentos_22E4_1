package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Exame;
import br.anderson.infnet.appclinica.model.service.ExameService;

@Controller
public class ExameController {
	@Autowired
	private ExameService exameService;
	private String mensagem;
	
	@GetMapping(value = "/exame")
	public String telaCadastro() {
		return "exame/cadastro";
	}

	@PostMapping(value = "/exame/incluir")
	public String incluir(Exame exame) {
		exameService.incluir(exame);
		mensagem = String.format("O %s foi cadastrado com sucesso!", exame.getDescricao());
		
		return "redirect:/exame/lista";
	}
	
	@GetMapping(value = "/exame/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("exames", exameService.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "exame/lista";
	}
	
	@GetMapping(value = "/exame/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		/*Exame exame = */exameService.excluir(id);
		
		mensagem = "Item removido";

		return "redirect:/exame/lista";
	}
}
