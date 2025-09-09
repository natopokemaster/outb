package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnAssinante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnAssinanteRepository extends JpaRepository<SnAssinante, Long> {
    SnAssinante findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(Long idAssinante, String codeBase,
                                                                     String flStatusBi);

    List<SnAssinante> findAllByCpfAndFlStatusBi(String documentId, String flStatusBi);
    List<SnAssinante> findAllByTelComAndFlStatusBi(String tel,String flStatusBi);
    List<SnAssinante> findAllByTelResAndFlStatusBi(String tel,String flStatusBi);
    List<SnAssinante> findAllByCcTelCelAndFlStatusBi(String tel,String flStatusBi);
}
