package br.anderson.infnet.appclinica.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.repository.MedicamentoRepository;

@Controller
public class MedicamentoController {
private String mensagem;
	
	@GetMapping(value = "/medicamento")
	public String telaCadastro() {
		return "medicamento/cadastro";
	}

	@PostMapping(value = "/medicamento/incluir")
	public String incluir(Medicamento medicamento) {
		MedicamentoRepository.incluir(medicamento);
		mensagem = String.format("O %s foi cadastrado com sucesso!", medicamento.getDescricao());
		
		return "redirect:/medicamento/lista";
	}
	
	@GetMapping(value = "/medicamento/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("medicamentos", MedicamentoRepository.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "medicamento/lista";
	}
	
	@GetMapping(value = "/medicamento/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Medicamento medicamento = MedicamentoRepository.excluir(id);
		
		mensagem = String.format("Item %s removido", medicamento.getDescricao());

		return "redirect:/medicamento/lista";
	}
}
