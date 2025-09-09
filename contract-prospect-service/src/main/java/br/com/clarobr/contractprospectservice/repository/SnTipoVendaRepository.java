package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnTipoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */

@Repository
public interface SnTipoVendaRepository extends JpaRepository<SnTipoVenda, String> {
    SnTipoVenda findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(Integer idTipoVenda, String codeBase, String flStatusBi);
}
