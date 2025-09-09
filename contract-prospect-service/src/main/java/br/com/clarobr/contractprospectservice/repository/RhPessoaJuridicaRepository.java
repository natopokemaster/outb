package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.RhPessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface RhPessoaJuridicaRepository extends JpaRepository<RhPessoaJuridica, String> {
    RhPessoaJuridica findRhPessoaJuridicaByIdEmpresaAndCodeBaseAndFlStatusBi(String idEmpresa, String codeBase, String flStatusBi);
}
