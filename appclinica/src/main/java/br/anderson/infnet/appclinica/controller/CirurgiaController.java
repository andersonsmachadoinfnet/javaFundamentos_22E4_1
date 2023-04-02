package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia;
import br.anderson.infnet.appclinica.model.service.CirurgiaService;

@Controller
public class CirurgiaController {
	@Autowired
	private CirurgiaService cirurgiaService;
    private String mensagem;
	
	@GetMapping(value = "/cirurgia")
	public String telaCadastro() {
		return "cirurgia/cadastro";
	}

	@PostMapping(value = "/cirurgia/incluir")
	public String incluir(Cirurgia cirurgia) {
		cirurgiaService.incluir(cirurgia);
		mensagem = String.format("A %s foi cadastrada com sucesso!", cirurgia.getDescricao());
		
		return "redirect:/cirurgia/lista";
	}
	
	@GetMapping(value = "/cirurgia/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("cirurgias", cirurgiaService.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "cirurgia/lista";
	}
	
	@GetMapping(value = "/cirurgia/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		/*Cirurgia cirurgia = */cirurgiaService.excluir(id);
		
		mensagem = "Item removido";

		return "redirect:/cirurgia/lista";
	}

}
