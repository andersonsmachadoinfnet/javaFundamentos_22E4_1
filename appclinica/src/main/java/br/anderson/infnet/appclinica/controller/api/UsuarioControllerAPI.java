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
import br.anderson.infnet.appclinica.model.dominio.Usuario;
import br.anderson.infnet.appclinica.model.service.MedicamentoService;
import br.anderson.infnet.appclinica.model.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControllerAPI {
	@Autowired
	private UsuarioService usrService;
	
	@GetMapping("/{id}")
	@Operation(description = "Retorna um usuário")
	public Optional<Usuario> testar(
		@Parameter(description = "É o identificador único do usuário.", required = true) 
		@PathVariable int id) 
	{
		return usrService.ler(id);
	}
	
	@GetMapping("/")
	@Operation(description = "Retorna a lista completa de Usuários")
	public ResponseEntity<Collection<Usuario>> listar() {
		return ResponseEntity.ok(usrService.obterLista());
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Atualiza um usuário já existente na base.")
	public Usuario atualizaUsuario(
		@Parameter(description = "É o identificador único do usuário.", required = true) 
		@PathVariable("id") final int id, 
		@RequestBody(description = "Contém o JSON do objeto Usuário", required = true)  final Usuario usuario) {
		return usrService.incluir(usuario);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(description = "Inclui um novo usuario")
	public Usuario postBook(@NotNull @Valid @RequestBody final Usuario usuario) {
		return usrService.incluir(usuario);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Operation(description = "Deleta um Usuário existente")
	public long deleteBook(
		@Parameter(description = "É o identificador único do usuário.", required = true) 
		@PathVariable final int id) 
	{
		usrService.excluir(id);
		return id;
	}
}
