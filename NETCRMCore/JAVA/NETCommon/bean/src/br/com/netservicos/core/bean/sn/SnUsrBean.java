/*
 * Created on 24/01/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.core.bean.rh.RhPessoaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_usr.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
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
 * 24/01/2005 Ramon Carvalho N/A      Entidades      Created.
 * 24/01/2005 Ramon Carvalho 1.0      Entidades      Development.
 * 10/04/2006 Rodrigo Branas 1.3      Entidades      Changed lstSnIDFuncRelPendencias.
 * ==============================================================================
 * </PRE>
 *
 *
 * @hibernate.class table = "sn_usr"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 *                  lazy="true"
 *                  
 * @hibernate.cache
 *      usage = "read-write"
 * 
 * @hibernate.query name  = "lstSnUsr"
 *                   query = "FROM	br.com.netservicos.core.bean.sn.SnUsrBean usr"
 *
 *               
 * @hibernate.query name  = "lstSnUsrByUseriId"
 *                   query = "SELECT 	vendedor.idVendedor
 *                   			FROM	br.com.netservicos.core.bean.sn.SnUsrBean usr,
 *                   					br.com.netservicos.core.bean.cp.CpVendedorBean vendedor
 *                   			WHERE   usr.idUsr= :idUsr
 *                   					AND vendedor.pessoa.idPessoa = usr.idFuncionario"
 * 
 */
public class SnUsrBean extends DomainBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8061789885725912407L;

	private String idUsr;

	private String sistema;

	private String idFuncionario;

	private String codCidade;

	private RhPessoaBean funcionario;

	public static final String ID_USR = "idUsr";
	
//	public static final String LST_USR_ID_FUNC = "lstSnUsrIDFuncByEquipeCidade";

	/**
	 *  
	 */
	public SnUsrBean() {
		super(ID_USR);
	}

	/**
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="id_usr"
	 * 
	 */
	public String getIdUsr() {
		return idUsr;
	}

	/**
	 * @param idUsr The idUsr to set.
	 * 
	 */
	public void setIdUsr(String idUsr) {
		this.idUsr = idUsr;
	}

	/**
	 * Obtains and returns the new value of the codCidade attribute.
	 *
	 * @return Returns the codCidade.
	 * 
	 * @hibernate.property
	 * column="cod_cidade"
	 * type = "string"
	 * 
	 */
	public String getCodCidade() {
		return codCidade;
	}

	/**
	 * @param codCidade The codCidade to set.
	 * 
	 */
	public void setCodCidade(String codCidade) {
		this.codCidade = codCidade;
	}

	/**
	 * Obtains and returns the new value of the idFuncionario attribute.
	 *
	 * @return Returns the idFuncionario.
	 * 
	 * @hibernate.property
	 * column="id_funcionario"
	 * type = "string"
	 * 
	 */
	public String getIdFuncionario() {
		return idFuncionario;
	}

	/**
	 * @param idFuncionario The idFuncionario to set.
	 * 
	 */
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	/**
	 * Obtains and returns the new value of the sistema attribute.
	 *
	 * @return Returns the sistema.
	 * 
	 * @hibernate.property
	 * column="sistema"
	 * type = "string"
	 * 
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * @param sistema The sistema to set.
	 * 
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	/**
	 * @hibernate.many-to-one
	 *      column="id_funcionario"
	 *      insert="false"
	 *      update="false"
	 * @return
	 */
	public RhPessoaBean getFuncionario() {
	    return funcionario;
	}

	public void setFuncionario(RhPessoaBean funcionario) {
	    this.funcionario = funcionario;
	}
	
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SnUsrBean))
			return false;
		SnUsrBean u = (SnUsrBean) o;
		if(idUsr != null ? !idUsr.equals(u.getIdUsr()) : u.getIdUsr() != null)
			return false;
		if(sistema != null ? !sistema.equals(u.getSistema()) : u.getSistema() != null)
			return false;
		if(idFuncionario != null ? !idFuncionario.equals(u.getIdFuncionario()) : u.getIdFuncionario() != null)
			return false;
		if(funcionario != null ? !funcionario.equals(u.getFuncionario()) : u.getFuncionario() != null)
			return false;
		if(codCidade != null ? !codCidade.equals(u.getCodCidade()) : u.getCodCidade() != null)
			return false;
		return true;
	}
	
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + (idUsr != null ? idUsr.hashCode() : 0);
		hash = hash * 31 + (sistema != null ? sistema.hashCode() : 0);
		hash = hash * 31 + (idFuncionario != null ? idFuncionario.hashCode() : 0);
		hash = hash * 31 + (funcionario != null ? funcionario.hashCode() : 0);
		hash = hash * 31 + (codCidade != null ? codCidade.hashCode() : 0);
		return hash;
	}

}
