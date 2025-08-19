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
 *   A regra de negócio deste bean descreve que:
 *   Um assinante ao fazer uma requisição de um ponto, este ponto logicamente
 *   não se encontra instalado. Não se encontrando instalado, este ponto
 *   não existe na tabela cp_ponto, mas sim na tabela cp_ponto_assinante,
 *   podendo ou não estar ligada a um ponto, e podendo ou não possuir
 *   pontos de assinante filhos (dependendo da instalação).
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
 * Modificação dado que o bean
 * CpPontoContrBean não possui chave
 * composta, além de ser um one-to-one
 * desta entidade							27/09/2006	Rafael Nami
 * Modificações nos métodos equals e
 * hashCode									09/10/2006  Rafael Nami
 * Criação da lstResumoVenda				27/10/2006	Eduardo Pinheiro
 * Foi retirado o atributo idPonto que
 * já podia ser recuperado pelo pontoContr  16/11/2006  Leonardo Westphal
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
	 * Atributo responsável pela chave sintética da tabela representada
	 * pelo bean (SurrogateKey)
	 */
	private Long idPontoAssinante;

	private Long idSolicitacaoAssinante;

	/**
	 * Atributo responsável pelo valor do primeiro mês.
	 */
	private BigDecimal vlPrimeiroMes;

	/**
	 * Atributo responsável pelo valor do preço do produto.
	 */
	private BigDecimal vlPrecoProd;

	/**
	 * Atributo responsável pelo retorno telefônico.
	 */
	private Integer fnRetornoTelefonico;

	/**
	 * Atributo associado responsável por representar a solicitação do
	 * respectivo ponto pelo assinante.
	 */
	private CpSolicitacaoAssinanteBean solicitacaoAssinante;

	/**
	 * Atributo associado responsável pela promoção que o ponto
	 * não instalado do assinante pode possuir.
	 */
	private SnPromocaoBean promocao;

	/**
	 * Atributo associado responsável pelo produto associado ao ponto do assinante.
	 */
	private SnProdutoBean produto;

	/**
	 * Atributo associado responsável pelo plano de pagamento do ponto
	 * não instalado do assinante.
	 */
	private SnPlanoPgtoBean planoPgto;

	/**
	 * Atributo associado responsável pela característica do ponto não
	 * instalado do assinante.
	 */
	private SnCaracteristicaBean caracteristica;

	/**
	 * Atributo associado responsável pelo ponto principal que possa estar
	 * associado a este ponto não instalado do assinante
	 */
	private SnPontoContrBean pontoContr;

	/**
	 * Atributo associado responsável pelo ponto não instalado que pode ser
	 * o principal desta instância de ponto não instalado de assinante.
	 */
	private CpPontoAssinanteBean pontoAssinantePai;

	/**
	 * Atributo associado responsável pelos pontos não instalados filhos
	 * do assinante
	 */
	private List pontosFilhos;

	private List allPontosFilhos;

	/**
	 * Atributo associado responsável pelo tipo do ponto não instalado
	 * do assinante.
	 */
	private CpTipoPontoBean tipoPonto;

	/**
	 * Atributo associado responsável pelo idLocalizacao
	 * do assinante.
	 */
	private SnLocalizacaoBean localizacao;

	/**
	 * Atributo associado a lista de reservas voip para um ponto
	 */
	private List reservasVoip;

	/**
	 * Atributo associado responsável pelo id da manga de negociação
	 * */
	private CpMangaNegociacaoBean mangaNegociacao;

	/**
	 * Construtor parametrizado
	 * @param arg0 O nome do atributo mapeado para a chave primária da tabela.
	 */
	public CpPontoAssinanteBean(String pkName) {
		super(pkName);
	}

	/**
	 * Construtor padrão
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
	 * Método de acesso ao atributo caracteristica
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
	 * Método de modificação do atributo caracteristica
	 * @param caracteristica Valor a ser setado para modificar o valor do atributo caracteristica
	 */
	public void setCaracteristica(SnCaracteristicaBean caracteristica) {
		this.caracteristica = caracteristica;
	}

	/**
	 * Método de acesso ao atributo pontosContr
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
	 * Método de modificação do atributo pontoContr
	 * @param pontoContr Valor a ser setado para modificar o valor do atributo pontoContr
	 */
	public void setPontoContr(SnPontoContrBean pontoContr) {
		this.pontoContr = pontoContr;
	}

	/**
	 * Método de acesso ao atributo pontoAssinantePai
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
	 * Método de modificação do atributo pontoAssinantePai
	 * @param pontoAssinantePai Valor a ser setado para modificar o valor do atributo pontoAssinantePai
	 */
	public void setPontoAssinantePai(CpPontoAssinanteBean pontoAssinantePai) {
		this.pontoAssinantePai = pontoAssinantePai;
	}

	/**
	 * Método de acesso ao atributo solicitacaoAssinante
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
	 * Método de modificação do atributo solicitacaoAssinante
	 * @param solicitacaoAssinante Valor a ser setado para modificar o valor do atributo solicitacaoAssinante
	 */
	public void setSolicitacaoAssinante(
			CpSolicitacaoAssinanteBean solicitacaoAssinante) {
		this.solicitacaoAssinante = solicitacaoAssinante;
	}

	/**
	 * Método de acesso ao atributo tipoPonto
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
	 * Método de modificação do atributo tipoPonto
	 * @param tipoPonto Valor a ser setado para modificar o valor do atributo tipoPonto
	 */
	public void setTipoPonto(CpTipoPontoBean tipoPonto) {
		this.tipoPonto = tipoPonto;
	}

	/**
	 * Método de acesso ao atributo idPontoAssinante
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
	 * Método de modificação do atributo idPontoAssinante
	 * @param idPontoAssinante Valor a ser setado para modificar o valor do atributo idPontoAssinante
	 */
	public void setIdPontoAssinante(Long idPontoAssinante) {
		this.idPontoAssinante = idPontoAssinante;
	}

	/**
	 * Método de acesso ao atributo pontosFilhos
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
	 * Método de modificação do atributo pontosFilhos
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
	 * Método de acesso ao atributo precoProd
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
	 * Método de modificação do atributo vlPrecoProd
	 * @param vlPrecoProd Valor a ser setado para modificar o valor do atributo vlPrecoProd
	 */
	public void setVlPrecoProd(BigDecimal vlPrecoProd) {
		this.vlPrecoProd = vlPrecoProd;
	}

	/**
	 * Método de acesso ao atributo fnRetornoTelefonico
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
	 * Método de modificação do atributo fnRetornoTelefonico
	 * @param fnRetornoTelefonico Valor a ser setado para modificar o valor do atributo fnRetornoTelefonico
	 */
	public void setFnRetornoTelefonico(Integer retornoTelefonico) {
		this.fnRetornoTelefonico = retornoTelefonico;
	}

	/**
	 * Método de acesso ao atributo planoPgto
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
	 * Método de modificação do atributo planoPgto
	 * @param planoPgto Valor a ser setado para modificar o valor do atributo planoPgto
	 */
	public void setPlanoPgto(SnPlanoPgtoBean planoPgto) {
		this.planoPgto = planoPgto;
	}

	/**
	 * Método de acesso ao atributo produto
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
	 * Método de modificação do atributo produto
	 * @param produto Valor a ser setado para modificar o valor do atributo produto
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * Método de acesso ao atributo promocao
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
	 * Método de modificação do atributo promocao
	 * @param promocao Valor a ser setado para modificar o valor do atributo promocao
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * Método de acesso ao atributo vlPrimeiroMes
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
	 * Método de modificação do atributo vlPrimeiroMes
	 * @param vlPrimeiroMes Valor a ser setado para modificar o valor do atributo vlPrimeiroMes
	 */
	public void setVlPrimeiroMes(BigDecimal vlPrimeiroMes) {
		this.vlPrimeiroMes = vlPrimeiroMes;
	}

	/**
	 * Método de acesso ao atributo localizacao
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
	 * Método de modificação do atributo localizacao
	 * @param localizacao Valor a ser setado para modificar o valor do atributo localizacao
	 */
	public void setLocalizacao(SnLocalizacaoBean localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Método de acesso ao atributo idSolicitacaoAssinante
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
	 * Método de modificação do atributo idSolicitacaoAssinante
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
	 * Método responsável por comparação atributo a atributo entre duas instâncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a instância da classe atual.
	 * @return 	se as duas instâncias são iguais ou não.
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
	 * Método responsável por retornar a instância da classe atual
	 * no formato hash.
	 * @return  o hash da instância atual
	 */
	public int hashCode() {
		int value = (idPontoAssinante != null ? idPontoAssinante.hashCode() : 0);
		return (int) (value ^(value >>> 32));
	}

	/**
	 * Método responsável por recuperar o id da manga negociacao
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
	 * Método responsável por modificar o id da manga negociacao
	 * @param mangaNegociacao
	 * */
	public void setMangaNegociacao(CpMangaNegociacaoBean mangaNegociacao){
		this.mangaNegociacao = mangaNegociacao;
	}

}