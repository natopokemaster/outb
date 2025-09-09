package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnEscolaridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnEscolaridadeRepository extends JpaRepository<SnEscolaridade, Integer> {
    SnEscolaridade findByIdEscolaridadeAndCodeBaseAndFlStatusBi(Integer idEscolaridade, String codeBase,
                                                                String flStatusBi);
}
