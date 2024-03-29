package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.anderson.infnet.appclinica.model.dominio.Prontuario;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.service.PacienteService;
import br.anderson.infnet.appclinica.model.service.ProcedimentoService;
import br.anderson.infnet.appclinica.model.service.ProntuarioService;

@Controller
public class ProntuarioController {

	@Autowired
	private ProntuarioService   service;
	@Autowired
	private PacienteService     pacienteService;
	@Autowired
	private ProcedimentoService procedimentoService;

	private String msg;

	@GetMapping(value = "/prontuario")
	public String telaCadastro(Model model, @SessionAttribute("usuario") Usuario usuario) {
		model.addAttribute("pacientes", pacienteService.obterLista(usuario));
		model.addAttribute("procedimentos", procedimentoService.obterLista(/*usuario*/));
		return "prontuario/cadastro";
	}	

	@GetMapping(value = "/prontuario/lista")
	public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {
		
		model.addAttribute("prontuarios", service.obterLista(usuario));

		model.addAttribute("mensagem", msg);
		
		msg = null;

		return "prontuario/lista";
	}
	
	@PostMapping(value = "/prontuario/incluir")
	public String incluir(Prontuario item, @SessionAttribute("usuario") Usuario usuario) {
		item.setUsuario(usuario);
		service.incluir(item);
		
		msg = "A inclusão do prontuario "+item.getDescricao()+" foi realizada com sucesso!!!";
		
		return "redirect:/prontuario/lista";
	}
		
	@GetMapping(value = "/prontuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		try {
			Prontuario item = service.obterPorId(id);
			service.excluir(id);
			msg = "A exclusão do prontuário "+item.getDescricao()+" foi realizada com sucesso!!!";
		} catch (Exception e) {
			msg = "Não foi possível remover o prontuário!";
		}
		return "redirect:/prontuario/lista";
	}
}
