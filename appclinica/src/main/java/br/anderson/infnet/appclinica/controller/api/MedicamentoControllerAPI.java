package br.anderson.infnet.appclinica.controller.api;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;
import br.anderson.infnet.appclinica.model.dominio.Paciente;
import br.anderson.infnet.appclinica.model.service.MedicamentoService;
import br.anderson.infnet.appclinica.model.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoControllerAPI {
	@Autowired
	private MedicamentoService medicamentoService;
	
	@GetMapping("/{id}")
	@Operation(description = "Retorna um medicamento")
	public Optional<Medicamento> testar(
		@Parameter(description = "É o identificador único do medicamento.", required = true) 
		@PathVariable int id) 
	{
		return medicamentoService.ler(id);
	}
	
	@GetMapping("/")
	@Operation(description = "Retorna a lista completa de Medicamentos")
	public ResponseEntity<Collection<Medicamento>> listar() {
		return ResponseEntity.ok(medicamentoService.obterLista());
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Atualiza um medicamento já existente na base.")
	public Medicamento atualizaMedicamento(
		@Parameter(description = "É o identificador único do medicamento.", required = true) 
		@PathVariable("id") final int id, 
		@RequestBody(description = "Contém o JSON do objeto Medicamento", required = true)  final Medicamento medicamento) {
		return medicamentoService.incluir(medicamento);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(description = "Inclui um novo medicamento")
	public Medicamento postBook(@NotNull @Valid @RequestBody final Medicamento medicamento) {
		return medicamentoService.incluir(medicamento);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Deleta um Medicamento existente")
	public long deleteBook(
		@Parameter(description = "É o identificador único do medicamento.", required = true) 
		@PathVariable final int id) 
	{
		medicamentoService.excluir(id);
		return id;
	}
}
