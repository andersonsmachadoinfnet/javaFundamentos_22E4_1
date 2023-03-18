package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.service.PacienteService;

@Controller
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
    private String mensagem;
	
	@GetMapping(value = "/paciente")
	public String telaCadastro() {
		return "paciente/cadastro";
	}

	@PostMapping(value = "/paciente/incluir")
	public String incluir(Paciente paciente, @SessionAttribute("usuario") Usuario usuario) {
		paciente.setUsuario(usuario);
		pacienteService.incluir(paciente);
		mensagem = String.format("O paciênte %s foi cadastrado com sucesso!", paciente.getNome());
		
		return "redirect:/paciente/lista";
	}
	
	@GetMapping(value = "/paciente/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		mensagem = "teste";
		model.addAttribute("pacientes", pacienteService.obterLista(usuario));
		model.addAttribute("mensagem", mensagem);
		mensagem = null;
		return "paciente/lista";
	}
	
	@GetMapping(value = "/paciente/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		/*Paciente paciente =*/ pacienteService.excluir(id);
		
		mensagem = "Item removido";// String.format("Item %s removido", paciente.getNome());

		return "redirect:/paciente/lista";
	}
}
