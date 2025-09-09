package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnSexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnSexoRepository extends JpaRepository<SnSexo, Integer> {
    SnSexo findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(Integer idSexo, String codeBase, String flStatusBi);
}
