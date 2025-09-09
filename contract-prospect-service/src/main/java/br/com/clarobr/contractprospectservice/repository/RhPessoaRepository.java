package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.RhPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan Ricardo
 */
public interface RhPessoaRepository extends JpaRepository<RhPessoa, String> {
    RhPessoa findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(String idPessoa, String codeBase, String flStatusBi);
}
