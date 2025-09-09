package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Alan Ricardo
 */
public interface SnStatusContratoRepository extends JpaRepository<SnStatusContrato, Integer> {

    @Query("select s from SnStatusContrato s inner join SnRelStatusContrato sr on s.idStatusContrato = sr.idStatus " +
            "where s.idStatusContrato = ?1 and s.codeBase = ?2 and s.flStatusBi = ?3 and sr.dtFim is null")
    SnStatusContrato findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(Integer idStatusContrato, String codeBase, String flStatusBi);

}
