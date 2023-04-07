package br.anderson.infnet.appclinica.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.anderson.infnet.appclinica.model.dominio.Medicamento;

public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {
	@Query("from Medicamento m where m.usuario.id = :userId")
	List<Medicamento> obterLista(Integer userId, Sort sort);
	
	@Query("from Medicamento m")
	List<Medicamento> obterLista(Sort sort);
}
