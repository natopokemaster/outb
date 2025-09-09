package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.models.SnRelStatusContrato;
import br.com.clarobr.contractprospectservice.models.SnRelStatusContratoServico;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoServicoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

/**
 * @author Raphael Zanarelli
 */
public interface SnRelStatusContratoServicoRepository extends JpaRepository<SnRelStatusContratoServico, Integer> {
    @Query("select s2 " +
            "from SnRelStatusContratoServico s,  SnStatusContrato s2, SnTipoServico s3 " +
            "where s.contractNumber = ?1 and s.cityCode = ?2 and s.baseCode = ?3 and s.flStatusBi = ?4 and s.endDate = ?5 " +
            "and s.contractStatusId = s2.idStatusContrato and s.serviceTypeId = s3.id and s2.codeBase = s.baseCode and s2.flStatusBi = s.flStatusBi and s.baseCode = s3.codeBase and s.flStatusBi = s3.flStatusBi and ROWNUM < 2" )
    List<SnStatusContrato> findSnRelStatusContratoServicoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(Integer numContrato, String cidContrato, String codeBase,
                                                                                                                          String flStatusBi, Date date );
}
