package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.anderson.infnet.appclinica.model.dominio.Procedimento;

@Repository
public interface ProcedimentoRepository extends CrudRepository<Procedimento, Integer> {
	@Query("from Procedimento p where p.usuario.id = :userId")
	List<Procedimento> obterLista(Integer userId);
}
