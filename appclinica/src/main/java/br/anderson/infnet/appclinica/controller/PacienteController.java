package br.anderson.infnet.appclinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.repository.PacienteRepository;

@Controller
public class PacienteController {
private String mensagem;
	
	@GetMapping(value = "/paciente")
	public String telaCadastro() {
		return "paciente/cadastro";
	}

	@PostMapping(value = "/paciente/incluir")
	public String incluir(Paciente paciente) {
		PacienteRepository.incluir(paciente);
		mensagem = String.format("O paciênte %s foi cadastrado com sucesso!", paciente.getNome());
		
		return "redirect:/paciente/lista";
	}
	
	@GetMapping(value = "/paciente/lista")
	public String telaLista(Model model) {
		mensagem = "teste";
		model.addAttribute("pacientes", PacienteRepository.obterLista());
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "paciente/lista";
	}
	
	@GetMapping(value = "/paciente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		Paciente paciente = PacienteRepository.excluir(id);
		
		mensagem = String.format("Item %s removido", paciente.getNome());

		return "redirect:/paciente/lista";
	}
}
