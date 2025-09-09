package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnEstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface SnEstadoCivilRepository extends JpaRepository<SnEstadoCivil, Integer> {
    SnEstadoCivil findByIdEstadoCivilAndCodeBaseAndFlStatusBi(Integer idEstadoCivil, String codeBase,
                                                              String flStatusBi);
}
