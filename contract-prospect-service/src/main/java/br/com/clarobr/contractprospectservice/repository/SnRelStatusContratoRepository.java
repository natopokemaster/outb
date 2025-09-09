package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnRelStatusContrato;
import java.util.List;

import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Alan Ricardo
 */
public interface SnRelStatusContratoRepository extends JpaRepository<SnRelStatusContrato, Integer> {
    @Query("select s2 from SnRelStatusContrato s,  SnStatusContrato s2 " +
            "where s.numContrato = ?1 and s.cidContrato = ?2 and s.codeBase = ?3 and s.flStatusBi = ?4 and s.dtFim is null " +
            "and s.idStatus = s2.idStatusContrato and s2.codeBase = s.codeBase and s2.flStatusBi = s2.flStatusBi and ROWNUM < 2" )
    List<SnStatusContrato> findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(Integer numContrato, String cidContrato, String codeBase,
                                                                                                      String flStatusBi );
}
