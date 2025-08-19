/*
 * Created on 04/09/2006
 *
 * Copyright � 2006 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.core.bean.cp.CpPontoAssinanteBean;
import br.com.netservicos.framework.core.bean.DomainBean;
/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *   Classe Bean que representa a tabela SN_PONTO_CONTR.
 *   Respons�vel pelas informa��es dos pontos do contrato.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Cria��o do Bean							04/09/2006	 Rafael Nami
 * Adi��o dos copyrights					21/09/2006	 Rafael Nami
 * Modifica��es nos m�todos equals e
 * hashCode
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 04/09/2006 Rafael Nami      N/A      NETCommon      Criado
 * 21/09/2006 Rafael Nami	  1.1.8.2   NETCommon	   Atualizado 
 * 09/10/2006 Rafael Nami     1.1.8.3   NETCommon	   Atualizado
 * ==============================================================================
 * </PRE>
 *
 * @author Rafael Nami
 * @since  04/09/2006
 * @version 1.1.8.3
 *
 * @hibernate.class table="SN_PONTO_CONTR"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  proxy = "br.com.netservicos.core.bean.sn.SnPontoContrBean"
 *                  lazy="true" 
 *                  
 * @hibernate.cache usage = "read-write"
 */
public class SnPontoContrBean extends DomainBean {

	/**
	 * Constante respons�vel pela string de nome <br>
	 * do atributo de chave prim�ria
	 */
	private static final String PRIMARY_KEY = "idPonto";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5295942442763675604L;

	/**
	 * Atributo respons�vel pela chave prim�ria do objeto.
	 */
	private Long idPonto;
	
	/**
	 * Atributo respons�vel pel
	 */
	private CpPontoAssinanteBean pontoAssinante;
	
	/**
	 * Atributo respons�vel pelo contrato do objeto.
	 */
	private SnContratoBean contrato;
	
	/**
	 * Atributo respons�vel pelo endere�o do ponto.
	 */
	private SnEnderBean ender;
	
	/**
	 * Atributo respons�vel pela localiza��o do ponto.
	 */
	private SnLocalizacaoBean localizacao;
			
	/**
	 * Atributo respons�vel por observa��es da localiza��o do ponto.
	 */
	private String obsLocalizacao;
	
	/**
	 * Construtor padr�o
	 */
	public SnPontoContrBean() {
		super(PRIMARY_KEY);
	}
	
	/**
	 * Construtor parametrizado da classe SnPontoContrBean.
	 */
	public SnPontoContrBean(Long id) {
		this();
		this.idPonto = id;
	}

	/**
	 * M�todo de acesso ao atributo idPonto
	 * @return O valor do atributo idPonto
	 * 
     * @hibernate.id
     * 		column="ID_PONTO"
     * 		generator-class="foreign"
     * @hibernate.generator-param
     *      name="property"
     *      value="ponto"
     * 
     * @return
	 */
	public Long getIdPonto() {
		return idPonto;
	}

	/**
	 * M�todo de acesso ao atributo obsLocalizacao
	 * @return O valor do atributo obsLocalizacao
	 * 
	 * @hibernate.property
	 * 		column = "OBS_LOCALIZACAO"
	 * 		length = "40"
	 */
	public String getObsLocalizacao() {
		return obsLocalizacao;
	}

	/**
	 * M�todo de modifica��o do atributo obsLocalizacao
	 * @param obsLocalizacao Valor a ser setado para modificar o valor do atributo obsLocalizacao
	 */
	public void setObsLocalizacao(String obsLocalizacao) {
		this.obsLocalizacao = obsLocalizacao;
	}
	
	/**
	 * M�todo de acesso ao atributo ender
	 * @return O valor do atributo ender
	 * 
	 * @hibernate.many-to-one
	 * 		column = "ID_ENDER"
	 * 		lazy="proxy"
	 */
	public SnEnderBean getEnder() {
		return ender;
	}

	/**
	 * M�todo de acesso ao atributo localizacao
	 * @return O valor do atributo localizacao
	 * 
	 * @hibernate.many-to-one
	 * 		column = "ID_LOCALIZACAO"
	 * 		lazy="proxy"
	 */
	public SnLocalizacaoBean getLocalizacao() {
		return localizacao;
	}

	/**
	 * M�todo de modifica��o do atributo ender
	 * @param ender Valor a ser setado para modificar o valor do atributo ender
	 */
	public void setEnder(SnEnderBean ender) {
		this.ender = ender;
	}

	/**
	 * M�todo de modifica��o do atributo localizacao
	 * @param localizacao Valor a ser setado para modificar o valor do atributo localizacao
	 */
	public void setLocalizacao(SnLocalizacaoBean localizacao) {
		this.localizacao = localizacao;
	}
	
	/**
	 * M�todo de acesso ao atributo contrato
	 * @return O valor do atributo contrato
	 */
	public SnContratoBean getContrato() {
		return contrato;
	}

	/**
	 * M�todo de acesso ao atributo pontoAssinante
	 * @return O valor do atributo pontoAssinante
	 * 
	 * @hibernate.one-to-one
     * 		constrained="true"
     *      cascade = "none"
     *      lazy="proxy"
	 */
	public CpPontoAssinanteBean getPontoAssinante() {
		return pontoAssinante;
	}

	/**
	 * M�todo de modifica��o do atributo contrato
	 * @param contrato Valor a ser setado para modificar o valor do atributo contrato
	 */
	public void setContrato(SnContratoBean contrato) {
		this.contrato = contrato;
	}

	/**
	 * M�todo de modifica��o do atributo idPonto
	 * @param idPonto Valor a ser setado para modificar o valor do atributo idPonto
	 */
	public void setIdPonto(Long idPonto) {
		this.idPonto = idPonto;
	}

	/**
	 * M�todo de modifica��o do atributo pontoAssinante
	 * @param pontoAssinante Valor a ser setado para modificar o valor do atributo pontoAssinante
	 */
	public void setPontoAssinante(CpPontoAssinanteBean pontoAssinante) {
		this.pontoAssinante = pontoAssinante;
	}

	/**
	 * M�todo respons�vel por compara��o atributo a atributo entre duas
	 * inst�ncias de uma classe
	 * 
	 * @param o
	 *            Objeto a ser comparado com a inst�ncia da classe atual.
	 * @return se as duas inst�ncias s�o iguais ou n�o.
	 */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SnPontoContrBean))
			return false;
		SnPontoContrBean obj = (SnPontoContrBean)o;
		if(idPonto != null ? !idPonto.equals(obj.getIdPonto()) : obj.getIdPonto() != null)
			return false;
		return true;
	}
	
	/**
	 * M�todo respons�vel por retornar a inst�ncia da classe atual no formato
	 * hash.
	 * 
	 * @return o hash da inst�ncia atual
	 */
	public int hashCode() {
		int value = (idPonto != null ? idPonto.hashCode() : 0);
		return (int) (value ^ (value >>> 32));
	}
	
	/**
	 * M�todo respons�vel por retornar a inst�ncia da classe atual
	 * no formato String.
	 * @return	a String da inst�ncia atual 
	 */
	public String toString() {
		// Cria um strigbuilder para fazer as concatena��es sem
		// o overhead de cria��o de novas strings a cada concatena��o.
		StringBuilder result = new StringBuilder();
		result.append("SNPONTOCONTRBEAN \n");
		if(idPonto != null) {
			result.append("IDPONTO: ");
			result.append(idPonto);
			result.append("\n");
		}
		if(contrato.getCompositeKey() != null) {
			result.append(contrato.getCompositeKey().toString());
		}
		if(ender != null) {
			if(ender.getIdEnder() != null) {
				result.append("ID_ENDER: ");
				result.append(ender.getIdEnder());
				result.append("\n");
			}
		}
		if(localizacao != null) {
			if(localizacao.getIdLocalizacao() != null) {
			result.append("ID_LOCALIZACAO: ");
				result.append(localizacao.getIdLocalizacao());
				result.append("\n");
			}
		}
		if(obsLocalizacao != null) {
			result.append("OBS_LOCALIZACAO: ");
			result.append(obsLocalizacao);
			result.append("\n");
		}
		return result.toString();
	}
	
	
}
