package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anderson.infnet.appclinica.model.dominio.Exame;

public interface ExameRepository extends CrudRepository<Exame, Integer> {
	@Query("from Exame e where e.usuario.id = :userId")
	List<Exame> obterLista(Integer userId, Sort sort);
}
