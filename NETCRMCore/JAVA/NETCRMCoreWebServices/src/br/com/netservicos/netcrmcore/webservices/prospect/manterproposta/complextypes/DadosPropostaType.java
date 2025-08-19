/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Type que representa os dados para alteração de Cobrança.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 */
public class DadosPropostaType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private IdentificacaoOperadoraType cidadeOperadora;    
	private Long idProposta;

	public void setIdProposta(IdentificacaoOperadoraType pCidadeOperadora , Long idProposta) {
	        this.cidadeOperadora = pCidadeOperadora;
	        this.idProposta = idProposta;
	}

    public IdentificacaoOperadoraType getCidadeOperadora() {
        return cidadeOperadora;
    }

    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }
	
	public Long getIdProposta() {
        return idProposta;
    }   

    public void setIdProposta(Long idProposta) {
        this.idProposta = idProposta;
    }	
}
