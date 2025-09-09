package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnTipoSegmento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnTipoSegmentoRepository extends JpaRepository<SnTipoSegmento, Integer> {
    SnTipoSegmento findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(Integer idTipoSegmento, String codeBase, String flStatusBi);

}
