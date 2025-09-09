package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnTelefoneVoip;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnTelefoneVoipRepository extends JpaRepository<SnTelefoneVoip, String> {


    @Query("select s from SnTelefoneVoip s " +
            "where s.cidContrato = ?1 " +
            "and s.numContrato = ?2 " +
            "and s.idStatusTelefoneVoip = 'U' " +
            "and s.codeBase = ?3 " +
            "and s.flStatusBi = ?4 " +
            "and s.dtFim = ?5")
    List<SnTelefoneVoip> findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(String cityId,
                                                                                 Integer customerAccountId,
                                                                                 String codeBase,
                                                                                 String flStatusBi,
                                                                                 Date date);
}
