package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnContratoRepository extends JpaRepository<SnContrato, Integer> {

    SnContrato findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi( Integer numContrato,String cidContrato, String codeBase,
                                                            String flStatusBi);

    SnContrato findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(Integer idAssinante, String codeBase, String flStatusBi);
}
