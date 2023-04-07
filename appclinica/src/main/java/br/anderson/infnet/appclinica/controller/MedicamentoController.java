package br.anderson.infnet.appclinica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.service.MedicamentoService;

@Controller
public class MedicamentoController {
	@Autowired
	private MedicamentoService medicamentoService;
	private String mensagem;
	
	@GetMapping(value = "/medicamento")
	public String telaCadastro() {
		return "medicamento/cadastro";
	}

	@PostMapping(value = "/medicamento/incluir")
	public String incluir(Medicamento medicamento) {
		medicamentoService.incluir(medicamento);
		mensagem = String.format("O %s foi cadastrado com sucesso!", medicamento.getDescricao());
		
		return "redirect:/medicamento/lista";
	}
	
	@GetMapping(value = "/medicamento/lista")
	public String telaLista(Model model) {
		model.addAttribute("medicamentos", medicamentoService.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "medicamento/lista";
	}
	
	@GetMapping(value = "/medicamento/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			/*Medicamento medicamento = */
			medicamentoService.excluir(id);
			mensagem = "Item %s removido";
		} catch (Exception e) {
			mensagem = "Não foi possível remover o item!";
		}

		return "redirect:/medicamento/lista";
	}
}
