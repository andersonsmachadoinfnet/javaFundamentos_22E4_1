package br.anderson.infnet.appclinica.controller.api;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.anderson.infnet.appclinica.model.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import br.anderson.infnet.appclinica.model.dominio.Paciente;

//https://github.com/springdoc/springdoc-openapi-demos/blob/master/springdoc-openapi-spring-boot-1/src/main/java/org/springdoc/demo/app1/sample1/PeopleRestService.java
//https://github.com/springdoc/springdoc-openapi-demos/blob/master/springdoc-openapi-book-service/src/main/java/org/springdoc/demo/services/book/controller/BookController.java
//https://springdoc.org/#demos

@RestController
@RequestMapping("/api/paciente")
public class PacienteControllerAPI {
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping("/{id}")
	@Operation(description = "Retorna um paciente")
	public Optional<Paciente> testar(
		@Parameter(description = "É o identificador único do paciente.", required = true) 
		@PathVariable int id) 
	{
		return pacienteService.ler(id);
	}
	
	@GetMapping("/")
	@Operation(description = "Retorna a lista completa de Pacientes")
	public ResponseEntity<Collection<Paciente>> listar() {
		return ResponseEntity.ok(pacienteService.obterLista());
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Atualiza um paciente já existente na base.")
	public Paciente atualizaPaciente(
		@Parameter(description = "É o identificador único do paciente.", required = true) 
		@PathVariable("id") final int id, 
		@RequestBody(description = "Contém o JSON do objeto Paciente", required = true)  final Paciente paciente) {
		return pacienteService.incluir(paciente);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(description = "Inclui um novo paciente")
	public Paciente postBook(@NotNull @Valid @RequestBody final Paciente paciente) {
		return pacienteService.incluir(paciente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Deleta um paciente existente")
	public long deleteBook(
		@Parameter(description = "É o identificador único do paciente.", required = true) 
		@PathVariable final int id) 
	{
		pacienteService.excluir(id);
		return id;
	}
}
