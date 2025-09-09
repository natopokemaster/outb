package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnRelAssinanteSegmentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnRelAssinanteSegmentacaoRepository extends JpaRepository<SnRelAssinanteSegmentacao, Integer> {
    SnRelAssinanteSegmentacao findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
            Integer numContrato, String cidContrato, String codeBase, String flStatusBi
    );
}
