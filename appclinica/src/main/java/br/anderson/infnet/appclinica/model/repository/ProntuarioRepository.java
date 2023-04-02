package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.anderson.infnet.appclinica.model.dominio.Prontuario;

@Repository
public interface ProntuarioRepository extends CrudRepository<Prontuario, Integer>  {
	@Query("from Prontuario p where p.usuario.id = :userId")
	List<Prontuario> obterLista(Integer userId , Sort sort);
}
