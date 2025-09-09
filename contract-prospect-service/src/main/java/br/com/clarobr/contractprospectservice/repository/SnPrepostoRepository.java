package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnPreposto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Alan Ricardo
 */
public interface SnPrepostoRepository extends JpaRepository<SnPreposto, Integer> {

    SnPreposto getFirstByNumContratoAndCidContratoAndCdBaseAndFlStatusBi(
            Integer numContrato, String cidContrato, String codeBase, String flStatusBi);
}
