package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnTipoAssinante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

/**
 * @author Alan Ricardo
 */
public interface SnTipoAssinanteRepository extends JpaRepository<SnTipoAssinante, Integer> {

    @Query("select s from SnRelContratoTipoAssinante r, SnTipoAssinante s " +
            "where r.cidContrato = ?1 and r.numContrato = ?2 and r.codeBase = ?3 and r.flStatusBi = ?4 and r.dtFim = ?5 and r.idTipoAssinante = s.idTipoAssinante and s.codeBase = r.codeBase and r.flStatusBi = s.flStatusBi")
    public SnTipoAssinante findAllByIdTipoAssinante(String cidContrato, Integer numContrato, String codeBase, String flStatusBi, Date date);

}
