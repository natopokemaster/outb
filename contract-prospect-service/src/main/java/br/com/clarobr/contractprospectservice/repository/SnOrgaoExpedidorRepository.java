package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnOrgaoExpedidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnOrgaoExpedidorRepository extends JpaRepository<SnOrgaoExpedidor, Integer> {

    SnOrgaoExpedidor findSnOrgaoExpedidorByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi(Integer idOrgaoExpedidor, String codeBase,
                                                                       String flStatusBi );
}
