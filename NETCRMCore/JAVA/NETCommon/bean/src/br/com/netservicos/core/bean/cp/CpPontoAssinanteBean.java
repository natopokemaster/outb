/*
 * Created on 30/08/2006
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
package br.com.netservicos.core.bean.cp;

import java.math.BigDecimal;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnCaracteristicaBean;
import br.com.netservicos.core.bean.sn.SnLocalizacaoBean;
import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnPontoContrBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DomainBean;


/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *   Classe Bean que representa a tabela cp_ponto_assinante.
 *   A regra de neg�cio deste bean descreve que:
 *   Um assinante ao fazer uma requisi��o de um ponto, este ponto logicamente
 *   n�o se encontra instalado. N�o se encontrando instalado, este ponto
 *   n�o existe na tabela cp_ponto, mas sim na tabela cp_ponto_assinante,
 *   podendo ou n�o estar ligada a um ponto, e podendo ou n�o possuir
 *   pontos de assinante filhos (dependendo da instala��o).
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Cria��o do Bean							30/08/2006	Rafael Nami
 * Adi��o dos copyrights					21/09/2006	Rafael Nami
 * Modifica��o nos XDoclets por motivo
 * de modifica��es na nomenclatura de
 * atributos na base de dados				23/09/2006  Rafael Nami
 * Modifica��o dado que o bean
 * CpPontoContrBean n�o possui chave
 * composta, al�m de ser um one-to-one
 * desta entidade							27/09/2006	Rafael Nami
 * Modifica��es nos m�todos equals e
 * hashCode									09/10/2006  Rafael Nami
 * Cria��o da lstResumoVenda				27/10/2006	Eduardo Pinheiro
 * Foi retirado o atributo idPonto que
 * j� podia ser recuperado pelo pontoContr  16/11/2006  Leonardo Westphal
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ----------------------------
 * 30/08/2006 Rafael Nami      N/A      NETCommon      Criado
 * 21/09/2006 Rafael Nami	   1.1.2.3  NETCommon	   Atualizado
 * 23/09/2006 Rafael Nami      1.1.2.4  NETCommon      Atualizado
 * 27/09/2006 Rafael Nami	   1.1.2.5  NETCommon	   Atualizado
 * 27/10/2006 Eduardo Pinheiro 1.1.26.1  NETCommon	   Atualizado
 * ==============================================================================
 * </PRE>
 *
 * @author Rafael Nami
 * @since  30/08/2006
 * @version 1.1.2.5
 *
 * @hibernate.class table="CP_PONTO_ASSINANTE"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  lazy="true"
 *					batch-size="10"
 *
 *
 * 
 * 
 *
 * 
 *
 *	
 * 
 */
public class CpPontoAssinanteBean extends DomainBean {

    private static final long serialVersionUID = 2406213572347414220L;

    private static final String PROPERTY_PONTOS_FILHOS = "pontosFilhos";

	private static final String PRIMARY_KEY = "idPontoAssinante";	

	/**
	 * Atributo respons�vel pela chave sint�tica da tabela representada
	 * pelo bean (SurrogateKey)
	 */
	private Long idPontoAssinante;

	private Long idSolicitacaoAssinante;

	/**
	 * Atributo respons�vel pelo valor do primeiro m�s.
	 */
	private BigDecimal vlPrimeiroMes;

	/**
	 * Atributo respons�vel pelo valor do pre�o do produto.
	 */
	private BigDecimal vlPrecoProd;

	/**
	 * Atributo respons�vel pelo retorno telef�nico.
	 */
	private Integer fnRetornoTelefonico;

	/**
	 * Atributo associado respons�vel por representar a solicita��o do
	 * respectivo ponto pelo assinante.
	 */
	private CpSolicitacaoAssinanteBean solicitacaoAssinante;

	/**
	 * Atributo associado respons�vel pela promo��o que o ponto
	 * n�o instalado do assinante pode possuir.
	 */
	private SnPromocaoBean promocao;

	/**
	 * Atributo associado respons�vel pelo produto associado ao ponto do assinante.
	 */
	private SnProdutoBean produto;

	/**
	 * Atributo associado respons�vel pelo plano de pagamento do ponto
	 * n�o instalado do assinante.
	 */
	private SnPlanoPgtoBean planoPgto;

	/**
	 * Atributo associado respons�vel pela caracter�stica do ponto n�o
	 * instalado do assinante.
	 */
	private SnCaracteristicaBean caracteristica;

	/**
	 * Atributo associado respons�vel pelo ponto principal que possa estar
	 * associado a este ponto n�o instalado do assinante
	 */
	private SnPontoContrBean pontoContr;

	/**
	 * Atributo associado respons�vel pelo ponto n�o instalado que pode ser
	 * o principal desta inst�ncia de ponto n�o instalado de assinante.
	 */
	private CpPontoAssinanteBean pontoAssinantePai;

	/**
	 * Atributo associado respons�vel pelos pontos n�o instalados filhos
	 * do assinante
	 */
	private List pontosFilhos;

	private List allPontosFilhos;

	/**
	 * Atributo associado respons�vel pelo tipo do ponto n�o instalado
	 * do assinante.
	 */
	private CpTipoPontoBean tipoPonto;

	/**
	 * Atributo associado respons�vel pelo idLocalizacao
	 * do assinante.
	 */
	private SnLocalizacaoBean localizacao;

	/**
	 * Atributo associado a lista de reservas voip para um ponto
	 */
	private List reservasVoip;

	/**
	 * Atributo associado respons�vel pelo id da manga de negocia��o
	 * */
	private CpMangaNegociacaoBean mangaNegociacao;

	/**
	 * Construtor parametrizado
	 * @param arg0 O nome do atributo mapeado para a chave prim�ria da tabela.
	 */
	public CpPontoAssinanteBean(String pkName) {
		super(pkName);
	}

	/**
	 * Construtor padr�o
	 */
	public CpPontoAssinanteBean() {
		super(PRIMARY_KEY);
		metaData.put(PROPERTY_PONTOS_FILHOS, CpPontoAssinanteBean.class);
	}

	/**
	 *
	 * @param idPontoAssinante
	 */
	public CpPontoAssinanteBean(Long idPontoAssinante) {
		this();
		this.idPontoAssinante = idPontoAssinante;
	}

	/**
	 * M�todo de acesso ao atributo caracteristica
	 * @return O valor do atributo caracteristica
	 *
	 * @hibernate.many-to-one
	 * column = "ID_CARACTERISTICA"
	 * lazy="proxy"
	 */
	public SnCaracteristicaBean getCaracteristica() {
		return caracteristica;
	}

	/**
	 * M�todo de modifica��o do atributo caracteristica
	 * @param caracteristica Valor a ser setado para modificar o valor do atributo caracteristica
	 */
	public void setCaracteristica(SnCaracteristicaBean caracteristica) {
		this.caracteristica = caracteristica;
	}

	/**
	 * M�todo de acesso ao atributo pontosContr
	 * @return O valor do atributo pontosContr
	 *
	 * @hibernate.many-to-one
	 * column="ID_PONTO"
     * lazy="proxy"
	 */
	public SnPontoContrBean getPontoContr() {
		return pontoContr;
	}

	/**
	 * M�todo de modifica��o do atributo pontoContr
	 * @param pontoContr Valor a ser setado para modificar o valor do atributo pontoContr
	 */
	public void setPontoContr(SnPontoContrBean pontoContr) {
		this.pontoContr = pontoContr;
	}

	/**
	 * M�todo de acesso ao atributo pontoAssinantePai
	 * @return O valor do atributo pontoAssinantePai
	 *
	 * @hibernate.many-to-one
	 * column="ID_PONTO_PAI"
	 * lazy="proxy"
	 */
	public CpPontoAssinanteBean getPontoAssinantePai() {
		return pontoAssinantePai;
	}

	/**
	 * M�todo de modifica��o do atributo pontoAssinantePai
	 * @param pontoAssinantePai Valor a ser setado para modificar o valor do atributo pontoAssinantePai
	 */
	public void setPontoAssinantePai(CpPontoAssinanteBean pontoAssinantePai) {
		this.pontoAssinantePai = pontoAssinantePai;
	}

	/**
	 * M�todo de acesso ao atributo solicitacaoAssinante
	 * @return O valor do atributo solicitacaoAssinante
	 *
	 * @hibernate.many-to-one
	 * 		column = "ID_SOLICITACAO_ASSINANTE"
	 * 		cascade = "none"
	 * 		not-null = "true"
	 * 		lazy="proxy"
	 */
	public CpSolicitacaoAssinanteBean getSolicitacaoAssinante() {
		return solicitacaoAssinante;
	}

	/**
	 * M�todo de modifica��o do atributo solicitacaoAssinante
	 * @param solicitacaoAssinante Valor a ser setado para modificar o valor do atributo solicitacaoAssinante
	 */
	public void setSolicitacaoAssinante(
			CpSolicitacaoAssinanteBean solicitacaoAssinante) {
		this.solicitacaoAssinante = solicitacaoAssinante;
	}

	/**
	 * M�todo de acesso ao atributo tipoPonto
	 * @return O valor do atributo tipoPonto
	 *
	 * @hibernate.many-to-one
	 * 		column = "ID_TIPO_PONTO"
	 * 		cascade = "none"
	 * 		not-null = "true"
	 * 		lazy = "proxy"
	 */
	public CpTipoPontoBean getTipoPonto() {
		return tipoPonto;
	}

	/**
	 * M�todo de modifica��o do atributo tipoPonto
	 * @param tipoPonto Valor a ser setado para modificar o valor do atributo tipoPonto
	 */
	public void setTipoPonto(CpTipoPontoBean tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	/**
	 * M�todo de acesso ao atributo idPontoAssinante
	 * @return O valor do atributo idPontoAssinante
	 *
	 * @hibernate.id
	 * 		column = "ID_PONTO_ASSINANTE"
	 * 		length = "10"
	 * 		generator-class = "sequence"
	 * @hibernate.generator-param
	 * 		name = "sequence"
	 * 		value = "SQCP_PONTO_ASSINANTE"
	 */
	public Long getIdPontoAssinante() {
		return idPontoAssinante;
	}

	/**
	 * M�todo de modifica��o do atributo idPontoAssinante
	 * @param idPontoAssinante Valor a ser setado para modificar o valor do atributo idPontoAssinante
	 */
	public void setIdPontoAssinante(Long idPontoAssinante) {
		this.idPontoAssinante = idPontoAssinante;
	}

	/**
	 * M�todo de acesso ao atributo pontosFilhos
	 * @return O valor do atributo pontosFilhos
	 *
	 * @hibernate.bag
	 * 		table = "CP_PONTO_ASSINANTE"
	 * 		lazy = "true"
	 * 		cascade = "delete-orphan"
	 * 		batch-size = "5"
	 * 		where = "ID_TIPO_PONTO NOT IN (5,6)"
	 * @hibernate.collection-one-to-many
	 * 		class = "br.com.netservicos.core.bean.cp.CpPontoAssinanteBean"
	 * @hibernate.collection-key
	 * 		column = "ID_PONTO_PAI"
	 */
	public List getPontosFilhos() {
		return pontosFilhos;
	}

	/**
	 * M�todo de modifica��o do atributo pontosFilhos
	 * @param pontosFilhos Valor a ser setado para modificar o valor do atributo pontosFilhos
	 */
	public void setPontosFilhos(List pontosFilhos) {
		this.pontosFilhos = pontosFilhos;
	}

	/**
	 *
	 * @hibernate.bag
	 * 		table = "CP_PONTO_ASSINANTE"
	 * 		lazy = "true"
	 * 		cascade = "none"
	 * 		batch-size = "5"
	 * @hibernate.collection-one-to-many
	 * 		class = "br.com.netservicos.core.bean.cp.CpPontoAssinanteBean"
	 * @hibernate.collection-key
	 * 		column = "ID_PONTO_PAI"
	 */
	public List getAllPontosFilhos() {
		return allPontosFilhos;
	}

	/**
	 *
	 * @param allPontosFilhos
	 */
	public void setAllPontosFilhos(List allPontosFilhos) {
		this.allPontosFilhos = allPontosFilhos;
	}

	/**
	 * M�todo de acesso ao atributo precoProd
	 * @return O valor do atributo precoProd
	 *
	 * @hibernate.property
	 * 		column = "VL_PRECO_PROD"
	 * 		length = "5"
	 */
	public BigDecimal getVlPrecoProd() {
		return vlPrecoProd;
	}

	/**
	 * M�todo de modifica��o do atributo vlPrecoProd
	 * @param vlPrecoProd Valor a ser setado para modificar o valor do atributo vlPrecoProd
	 */
	public void setVlPrecoProd(BigDecimal vlPrecoProd) {
		this.vlPrecoProd = vlPrecoProd;
	}

	/**
	 * M�todo de acesso ao atributo fnRetornoTelefonico
	 * @return O valor do atributo fnRetornoTelefonico
	 *
	 * @hibernate.property
	 * 		column = "FN_RETORNO_TELEFONICO"
	 * 		length = "1"
	 */
	public Integer getFnRetornoTelefonico() {
		return fnRetornoTelefonico;
	}

	/**
	 * M�todo de modifica��o do atributo fnRetornoTelefonico
	 * @param fnRetornoTelefonico Valor a ser setado para modificar o valor do atributo fnRetornoTelefonico
	 */
	public void setFnRetornoTelefonico(Integer retornoTelefonico) {
		this.fnRetornoTelefonico = retornoTelefonico;
	}

	/**
	 * M�todo de acesso ao atributo planoPgto
	 * @return O valor do atributo planoPgto
	 *
	 * @hibernate.many-to-one
	 * 		column = "ID_PLANO_PGTO"
	 * 		cascade = "none"
	 * 		not-null = "true"
	 * 		lazy="proxy"
	 */
	public SnPlanoPgtoBean getPlanoPgto() {
		return planoPgto;
	}

	/**
	 * M�todo de modifica��o do atributo planoPgto
	 * @param planoPgto Valor a ser setado para modificar o valor do atributo planoPgto
	 */
	public void setPlanoPgto(SnPlanoPgtoBean planoPgto) {
		this.planoPgto = planoPgto;
	}

	/**
	 * M�todo de acesso ao atributo produto
	 * @return O valor do atributo produto
	 *
	 * @hibernate.many-to-one
	 * 		column = "ID_PRODUTO"
	 * 		cascade = "none"
	 * 		not-null = "true"
	 * 		lazy="proxy"
	 */
	public SnProdutoBean getProduto() {
		return produto;
	}

	/**
	 * M�todo de modifica��o do atributo produto
	 * @param produto Valor a ser setado para modificar o valor do atributo produto
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * M�todo de acesso ao atributo promocao
	 * @return O valor do atributo promocao
	 *
	 * @hibernate.many-to-one
	 * 		column = "ID_PROMOCAO"
	 * 		cascade = "none"
	 * 		lazy="proxy"
	 */
	public SnPromocaoBean getPromocao() {
		return promocao;
	}

	/**
	 * M�todo de modifica��o do atributo promocao
	 * @param promocao Valor a ser setado para modificar o valor do atributo promocao
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * M�todo de acesso ao atributo vlPrimeiroMes
	 * @return O valor do atributo vlPrimeiroMes
	 *
	 * @hibernate.property
	 * 		column = "VL_PRIMEIRO_MES"
	 * 		length = "5"
	 */
	public BigDecimal getVlPrimeiroMes() {
		return vlPrimeiroMes;
	}

	/**
	 * M�todo de modifica��o do atributo vlPrimeiroMes
	 * @param vlPrimeiroMes Valor a ser setado para modificar o valor do atributo vlPrimeiroMes
	 */
	public void setVlPrimeiroMes(BigDecimal vlPrimeiroMes) {
		this.vlPrimeiroMes = vlPrimeiroMes;
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
	 * M�todo de modifica��o do atributo localizacao
	 * @param localizacao Valor a ser setado para modificar o valor do atributo localizacao
	 */
	public void setLocalizacao(SnLocalizacaoBean localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * M�todo de acesso ao atributo idSolicitacaoAssinante
	 * @return O valor do atributo idSolicitacaoAssinante
	 *
	 * @hibernate.property
	 * 		column = "ID_SOLICITACAO_ASSINANTE"
	 * 		insert="false"
	 * 		update="false"
	 */
	public Long getIdSolicitacaoAssinante() {
		return idSolicitacaoAssinante;
	}

	/**
	 * M�todo de modifica��o do atributo idSolicitacaoAssinante
	 * @param idSolicitacaoAssinante Valor a ser setado para modificar o valor do atributo idSolicitacaoAssinante
	 */
	public void setIdSolicitacaoAssinante(Long idSolicitacaoAssinante) {
		this.idSolicitacaoAssinante = idSolicitacaoAssinante;
	}

	/**
     * @hibernate.bag
     *      table = "cp_reserva_telefone_voip"
     *      lazy = "true"
     *      cascade = "none"
     * @hibernate.collection-one-to-many
     *      class = "br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean"
     * @hibernate.collection-key
     *      column = "id_ponto_assinante"
     * @return
     */
    public List getReservasVoip() {
        return reservasVoip;
    }

    public void setReservasVoip(List reservasVoip) {
        this.reservasVoip = reservasVoip;
    }

	/**
	 * M�todo respons�vel por compara��o atributo a atributo entre duas inst�ncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a inst�ncia da classe atual.
	 * @return 	se as duas inst�ncias s�o iguais ou n�o.
	 */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CpPontoAssinanteBean))
			return false;
		CpPontoAssinanteBean obj = (CpPontoAssinanteBean) o;

		if(idPontoAssinante != null ? !idPontoAssinante.equals(obj.getIdPontoAssinante()) : obj.getIdPontoAssinante() != null)
			return false;
		return true;
	}

	/**
	 * M�todo respons�vel por retornar a inst�ncia da classe atual
	 * no formato hash.
	 * @return  o hash da inst�ncia atual
	 */
	public int hashCode() {
		int value = (idPontoAssinante != null ? idPontoAssinante.hashCode() : 0);
		return (int) (value ^(value >>> 32));
	}

	/**
	 * M�todo respons�vel por recuperar o id da manga negociacao
	 *
	 * @hibernate.many-to-one
	 * 		column = "id_manga_negociacao"
	 *
	 * @return mangaNegociacao
	 * */
	public CpMangaNegociacaoBean getMangaNegociacao(){
		return mangaNegociacao;
	}

	/**
	 * M�todo respons�vel por modificar o id da manga negociacao
	 * @param mangaNegociacao
	 * */
	public void setMangaNegociacao(CpMangaNegociacaoBean mangaNegociacao){
		this.mangaNegociacao = mangaNegociacao;
	}

}