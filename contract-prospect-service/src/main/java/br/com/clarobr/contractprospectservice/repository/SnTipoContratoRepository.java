package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnTipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan Ricardo
 */
public interface SnTipoContratoRepository extends JpaRepository<SnTipoContrato, Integer> {

    SnTipoContrato findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(Integer idTipoContrato, String codeBase, String flStatusBi);
}
