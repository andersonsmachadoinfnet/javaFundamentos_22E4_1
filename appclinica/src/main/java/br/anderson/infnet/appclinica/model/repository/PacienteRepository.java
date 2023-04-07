package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.anderson.infnet.appclinica.model.dominio.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {
	@Query("from Paciente s where s.usuario.id = :userId")
	List<Paciente> obterLista(Integer userId, Sort sort);
	
	@Query("from Paciente s")
	List<Paciente> obterLista(Sort sort);
}
