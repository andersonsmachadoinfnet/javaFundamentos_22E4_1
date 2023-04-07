package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anderson.infnet.appclinica.model.dominio.Cirurgia	;

public interface CirurgiaRepository  extends CrudRepository<Cirurgia, Integer>  {
	@Query("from Cirurgia c where c.usuario.id = :userId")
	List<Cirurgia> obterLista(Integer userId, Sort sort);
	
	@Query("from Cirurgia c ")
	List<Cirurgia> obterLista(Sort sort);
}
