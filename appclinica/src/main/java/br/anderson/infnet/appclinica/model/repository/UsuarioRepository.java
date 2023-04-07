package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.anderson.infnet.appclinica.model.dominio.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	@Query("from Usuario u where u.email = :email and u.senha = :senha")
	Usuario autenticacao(String email, String senha);
	
	@Query("from Usuario u where u.id = :userId")
	List<Usuario> obterLista(Integer userId, Sort sort);
	
	@Query("from Usuario u ")
	List<Usuario> obterLista(Sort sort);
}
