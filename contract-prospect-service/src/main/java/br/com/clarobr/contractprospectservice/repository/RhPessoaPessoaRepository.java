package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.RhPessoaPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alan Ricardo
 */
public interface RhPessoaPessoaRepository extends JpaRepository<RhPessoaPessoa, String> {
    RhPessoaPessoa findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
            String idPessoa, String idPessoaBase, Integer tipoRelacao, Integer idStatus,
            String codeBase, String flStatusBi);
}
