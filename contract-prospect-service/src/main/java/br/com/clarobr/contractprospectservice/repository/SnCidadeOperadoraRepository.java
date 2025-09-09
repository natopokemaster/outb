package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnCidadeOperadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnCidadeOperadoraRepository extends JpaRepository<SnCidadeOperadora, String> {
    SnCidadeOperadora findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(String cityId,String codeBase, String flStatusBi );
}
