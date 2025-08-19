/*
 * Created on 30/08/2006
 *
 * Copyright © 2006 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.cp;

import java.math.BigDecimal;

import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *   Classe Bean que representa a tabela CP_AGREGADO_INFORMATIVO.
 *   Responsável pelas informações dos agregados informativos dos produtos.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação do Bean							30/08/2006	Rafael Nami
 * Adição dos copyrights					21/09/2006	Rafael Nami
 * Modificação nos XDoclets por motivo
 * de modificações na nomenclatura de
 * atributos na base de dados				23/09/2006  Rafael Nami
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
 * 30/08/2006 Rafael Nami      N/A      NETCommon      Criado
 * 21/09/2006 Rafael Nami	  1.1.2.3	NETCommon	   Alterado
 * 23/09/2006 Rafael Nami     1.2.2.4   NETCommon	   Alterado
 * ==============================================================================
 * </PRE>
 *
 * @author Rafael Nami
 * @since  30/08/2006
 * @version 1.1.2.4
 *
 * @hibernate.class table="CP_AGREGADO_INFORMATIVO"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  lazy="true" 
 *					batch-size="10"
 *                  
 *      
 * @hibernate.query
 * 		 name  = "lstProdutosAgregadosInformativos" 
 *       query = "SELECT p.idProduto, p.descricao
 * 					FROM 
 *                       br.com.netservicos.core.bean.sn.SnProdutoBean p
 * 				   WHERE 
 *                       p.tipoProduto.idTipoProduto = 4
 * 					AND
 *            NOT EXISTS( SELECT s.produto.idProduto
 * 				            FROM br.com.netservicos.core.bean.sn.SnRelAtributosProdutoBean s
 * 				           WHERE s.atributoParametro.idAtributoParametro = 473
 * 					         AND s.produto.idProduto = p.idProduto )
 * 			    ORDER BY p.descricao"
 *
 * @hibernate.query
 * 		name = "lstProdutosAdicionados"
 * 		query = "SELECT  
 * 						 agregado.produto.idProduto,
 * 						 produto.descricao,
 * 					     agregado.qtInformativo,
 * 					     agregado.vlProduto,
 *  					 agregado.idAgregadoInformativo
 *               FROM    
 *               		 br.com.netservicos.core.bean.sn.SnProdutoBean produto,
 *                       br.com.netservicos.core.bean.cp.CpAgregadoInformativoBean agregado
 *               WHERE   
 *               		 agregado.idPropostaProspect = :idProposta
 *               AND     agregado.produto.idProduto = produto.idProduto"
 *               
 * @hibernate.query
 * 		name = "deleteAgregadosInformativoByProposta"
 * 		query = "FROM br.com.netservicos.core.bean.cp.CpAgregadoInformativoBean agregado
 * 				 WHERE agregado.idPropostaProspect = :idProposta"
 */
public class CpAgregadoInformativoBean extends WebBean {

	
	private static final long serialVersionUID = 6533148283083248352L;
	
	/**
	 * Constante responsável pela string de nome <br>
	 * do atributo de chave primária
	 */
	private static final String PRIMARY_KEY = "idAgregadoInformativo";
	
	/**
	 * Constante responsável pelo nome da pesquisa de produtos agregados informativos.
	 */
	public static final String LISTA_PRODUTOS_AGREGADOS_INFORMATIVOS = "lstProdutosAgregadosInformativos";
	
	/**
	 * Constante responsável pelo nome da pesquisa de preço do produto agregado informativo.
	 */
	public static final String LISTA_PRECO_PRODUTO_AGREGADO_INFORMATIVO = "lstPrecoProdutoAgregadoInformativo";
	
	public static final String DELETE_AGREGADOS_INFORMATIVO_BY_PROPOSTA = "deleteAgregadosInformativoByProposta";
	
	/**
	 * Atributo responsável pela chave sintética da tabela representada
	 * pelo bean (SurrogateKey)
	 */
	private Long idAgregadoInformativo;
	
	/**
	 * Atributo associado responsável por representar a proposta do assinante.
	 */
	private CpPropostaAssinanteBean propostaAssinante;
	
	/**
	 * Atributo responsável por representar a quantidade de agregados que
	 * serão adicionados ao produto. 
	 */
	private BigDecimal qtInformativo;
	
	/**
	 * Atributo responsável por representar o valor do produto.
	 */
	private BigDecimal vlProduto;
	
	/**
	 * Atributo responsável por representar o produto a qual o informativo
	 * se agrega.
	 */
	private SnProdutoBean produto;
	
	/**
	 * Atributo usado para representar o id da proposta prospect
	 * 
	 * */
	private Long idPropostaProspect;

	/**
	 * Construtor parametrizado.
	 * @param arg0 O nome da chave primária no banco relacional.
	 */
	public CpAgregadoInformativoBean(String arg0) {
		super(arg0);
	}
	
	/**
	 * Construtor padrão
	 */
	public CpAgregadoInformativoBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * Método de acesso ao atributo propostaAssinante
	 * @return O valor do atributo propostaAssinante
	 * 
	 * @hibernate.many-to-one
     *      column="id_proposta_assinante"
     *      lazy="proxy"      
	 */
	public CpPropostaAssinanteBean getPropostaAssinante() {
		return propostaAssinante;
	}

	/**
	 * Método de modificação do atributo propostaAssinante
	 * @param propostaAssinante Valor a ser setado para modificar o valor do atributo propostaAssinante
	 */
	public void setPropostaAssinante(
			CpPropostaAssinanteBean propostaAssinante) {
		this.propostaAssinante = propostaAssinante;
	}

	/**
	 * Método de acesso ao atributo idAgregadoInformativo
	 * @return O valor do atributo idAgregadoInformativo
	 * 
	 * @hibernate.id 
     * 		column="id_agregado_informativo"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="SQCP_AGREGADO_INFORMATIVO"
	 */
	public Long getIdAgregadoInformativo() {
		return idAgregadoInformativo;
	}

	/**
	 * Método de modificação do atributo idAgregadoInformativo
	 * @param idAgregadoInformativo Valor a ser setado para modificar o valor do atributo idAgregadoInformativo
	 */
	public void setIdAgregadoInformativo(Long idAgregadoInformativo) {
		this.idAgregadoInformativo = idAgregadoInformativo;
	}

	/**
	 * Método de acesso ao atributo qtInformativo
	 * @return O valor do atributo qtInformativo
	 * 
	 * @hibernate.property 
	 * 		column="qt_informativo" 
	 * 		length="3"
	 */
	public BigDecimal getQtInformativo() {
		return qtInformativo;
	}

	/**
	 * Método de modificação do atributo qtInformativo
	 * @param qtInformativo Valor a ser setado para modificar o valor do atributo qtInformativo
	 */
	public void setQtInformativo(BigDecimal qtInformativo) {
		this.qtInformativo = qtInformativo;
	}

	/**
	 * Método de acesso ao atributo produto
	 * @return O valor do atributo produto
	 * 
	 * @hibernate.many-to-one
	 * 		column="ID_PRODUTO"
	 * 		lazy="proxy"
	 */
	public SnProdutoBean getProduto() {
		return produto;
	}

	/**
	 * Método de modificação do atributo produto
	 * @param produto Valor a ser setado para modificar o valor do atributo produto
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * Método de acesso ao atributo vlProduto
	 * @return O valor do atributo vlProduto
	 * 
	 * @hibernate.property
	 * 		column="vl_produto"
	 * 		length="5"
	 */
	public BigDecimal getVlProduto() {
		return vlProduto;
	}

	/**
	 * Método de modificação do atributo vlProduto
	 * @param vlProduto Valor a ser setado para modificar o valor do atributo vlProduto
	 */
	public void setVlProduto(BigDecimal vlProduto) {
		this.vlProduto = vlProduto;
	}
	
	/**
	 * Método de acesso ao atributo idPropostaProspect
	 * @return O valor do atributo idPropostaProspect
	 * 
	 * @hibernate.property
	 * 		column="id_proposta"
	 */
	public Long getIdPropostaProspect() {
		return idPropostaProspect;
	}

	/**
	 * Método de modificação do atributo vlProduto
	 * @param vlProduto Valor a ser setado para modificar o valor do atributo vlProduto
	 */
	public void setIdPropostaProspect(Long idPropostaProspect) {
		this.idPropostaProspect = idPropostaProspect;
	}
	
	/**
	 * Método responsável por comparação atributo a atributo entre duas instâncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a instância da classe atual.
	 * @return 	se as duas instâncias são iguais ou não. 
	 */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CpAgregadoInformativoBean))
			return false;
		CpAgregadoInformativoBean obj = (CpAgregadoInformativoBean) o;
		
		if(idAgregadoInformativo != null ? !idAgregadoInformativo.equals(obj.getIdAgregadoInformativo()) : obj.getIdAgregadoInformativo() != null)
			return false;		
		return true;
	}
	
	/**
	 * Método responsável por retornar a instância da classe atual 
	 * no formato hash.
	 * @return  o hash da instância atual
	 */
	public int hashCode() {
		int value = (idAgregadoInformativo!=null ? idAgregadoInformativo.hashCode() : 0);
		return (int) (value ^ (value >>> 32));
	}
}