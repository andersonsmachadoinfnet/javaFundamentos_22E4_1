package br.anderson.infnet.appclinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.anderson.infnet.appclinica.api.externa.ServicoDeCep;
import br.anderson.infnet.appclinica.model.dominio.Endereco;
import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.service.PacienteService;

@Controller
public class PacienteController {
	@Autowired
	private PacienteService pacienteService;
    private String mensagem;
    private Endereco endereco;
	
	@GetMapping(value = "/paciente")
	public String telaCadastro(Model model) {
		model.addAttribute("endereco", endereco);
		return "paciente/cadastro";
	}

	@PostMapping(value = "/paciente/incluir")
	public String incluir(Paciente paciente, Endereco endereco, @SessionAttribute("usuario") Usuario usuario) {
		System.out.println("IncluirPaciente: "+usuario.getId());
		paciente.setEndereco(endereco);
		paciente.setUsuario(usuario);
		pacienteService.incluir(paciente);
		mensagem = String.format("O paciênte %s foi cadastrado com sucesso!", paciente.getNome());
		
		return "redirect:/paciente/lista";
	}
	
	@PostMapping(value = "/paciente/cep")
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
		
		
		return "redirect:/paciente";
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
