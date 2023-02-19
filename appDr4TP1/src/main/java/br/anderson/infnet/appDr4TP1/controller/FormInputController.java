package br.anderson.infnet.appDr4TP1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormInputController {
	
	@GetMapping(value = "/entrada")
	public String recebeForm(@RequestParam Integer codigo) {
		return "redirect:/personagem/"+codigo;
	}

}
