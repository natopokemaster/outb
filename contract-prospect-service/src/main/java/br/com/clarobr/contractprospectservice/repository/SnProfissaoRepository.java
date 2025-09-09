package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnProfissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnProfissaoRepository extends JpaRepository<SnProfissao, Integer> {
    SnProfissao findByIdProfissaoAndCodeBaseAndFlStatusBi(Integer idProfissao, String codeBase, String flStatusBi);
}
