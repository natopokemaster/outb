package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnContratoColetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnContratoColetivoRepository extends JpaRepository<SnContratoColetivo, Integer> {
}
