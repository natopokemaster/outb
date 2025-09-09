package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnRazaoCancelamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan Ricardo
 */
public interface SnRazaoCancelamentoRepository extends JpaRepository<SnRazaoCancelamento,Integer> {
    SnRazaoCancelamento findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(Integer idCancelamento, String codeBase, String flStatusBi);

}
