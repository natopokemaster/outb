package br.com.netservicos.core.bean.av;

import java.util.Date;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.core.bean.sn.SnChamadaBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela AV_RECIBO_RELACIONAMENTO.
 * </P>
 * <B> Issues : <BR>
 *
 * @since 31/03/2011
 * @hibernate.class table = "av_recibo_relacionamento" dynamic-insert = "true"
 *                  dynamic-update = "true"
 *
 */
public class AvReciboRelacionamentoBean extends DomainBean {

	/**
	 * Identificador do recibo de compra.
	 */
	private static final String ID_RECIBO_RELACIONAMENTO = "idReciboRelacionamento";

	/**
	 * long
	 */
	private static final long serialVersionUID = 3202347760615109842L;

	/**
	 * ID_RECIBO_RELACIONAMENTO NUMBER(10) N. Identificador do recibo de
	 * relacionamento.
	 */
	private Long idReciboRelacionamento;

	/**
	 * NUM_CONTRATO NUMBER(9) N. Numero do contrato do cliente.
	 */
	private Long numContrato;

	/**
	 * CID_CONTRATO VARCHAR2(6) N. Identicacao cidade.
	 */
	private String cidContrato;

	/**
	 * SnContratoBean.
	 */
	private SnContratoBean contrato;

	/**
	 * DH_RECIBO DATE N. Data e hora em que o recibo foi gerado.
	 */
	private Date dhRecibo;

	/**
	 * ID_CHAMADA NUMBER(10) N.
	 */
	private SnChamadaBean chamada;

	/**
	 * XT_DETALHE_RECIBO SYS.XMLTYPE N. Detalhes do recibo de relacionamento.
	 */
	private String xtDetalheRecibo;

	/**
	 * ST_GERACAO_AVISO_REL CHAR(1) N Indica se já foi gerado um aviso de
	 * relacionamento para o ticket de venda: 0 - Pendente de geração 1 - Acordo
	 * comercial gerado
	 */
	private String stGeracaoAvisoRel;

	/**
	 * ID_TIPO_RELACIONAMENTO NUMBER(10) N. Identificador do tipo de
	 * relacionamento.
	 */
	private AvTipoRelacionamentoBean tipoRelacionamento;

	/**
	 * Construtor Padrao.
	 */
	public AvReciboRelacionamentoBean() {
		super(ID_RECIBO_RELACIONAMENTO);
	}

	/**
	 * @param pIdReciboRel
	 */
	public AvReciboRelacionamentoBean(final Long pIdReciboRel) {
		this();
		this.idReciboRelacionamento = pIdReciboRel;
	}

	/**
	 * Recupera o identificador do recibo.
	 * 
	 * @return the idReciboRelacionamento
	 * @hibernate.id column="ID_RECIBO_RELACIONAMENTO"
	 *               generator-class="sequence"
	 * @hibernate.generator-param name="sequence"
	 *                            value="SQ_RECIBO_RELACIONAMENTO"
	 */
	public Long getIdReciboRelacionamento() {
		return this.idReciboRelacionamento;
	}

	/**
	 * Recupera o numero contrato.
	 * 
	 * @return the numContrato
	 * @hibernate.property column = "NUM_CONTRATO"
	 */
	public Long getNumContrato() {
		return this.numContrato;
	}

	/**
	 * Recupera o identificacao cidade.
	 * 
	 * @return the cidContrato
	 * @hibernate.property column = "CID_CONTRATO"
	 */
	public String getCidContrato() {
		return this.cidContrato;
	}

	/**
	 * Recupera a entidade SnContratoBean.
	 * 
	 * @return the contrato
	 */
	public SnContratoBean getContrato() {
		return this.contrato;
	}

	/**
	 * Recupera a data do recibo.
	 * 
	 * @return the dhRecibo
	 * @hibernate.property column = "DH_RECIBO"
	 */
	public Date getDhRecibo() {
		return this.dhRecibo;
	}

	/**
	 * Recupera a entidade SnChamadaBean.
	 * 
	 * @return the chamada
	 * @hibernate.many-to-one
	 *                        class="br.com.netservicos.core.bean.sn.SnChamadaBean"
	 *                        column="ID_CHAMADA" not-null="false"
	 */
	public SnChamadaBean getChamada() {
		return this.chamada;
	}

	/**
	 * Recupera o detalhe do recibo.
	 * 
	 * @return the xtDetalheRecibo
	 * @hibernate.property column="XT_DETALHE_RECIBO" type="br.com.netservicos.gescom.util.bd.HibernateXMLType"
	 */
	public String getXtDetalheRecibo() {
		return this.xtDetalheRecibo;
	}

	/**
	 * Recupera status da geracao do aviso.
	 * 
	 * @return the stGeracaoAvisoRel
	 * @hibernate.property column = "ST_GERACAO_AVISO_REL"
	 */
	public String getStGeracaoAvisoRel() {
		return this.stGeracaoAvisoRel;
	}

	/**
	 * Recupera o tipo de relacionamento.
	 * 
	 * @return the tipoRelacionamento
	 * @hibernate.many-to-one
	 *                        class="br.com.netservicos.core.bean.av.AvTipoRelacionamentoBean"
	 *                        column="ID_TIPO_RELACIONAMENTO" not-null="false"
	 */
	public final AvTipoRelacionamentoBean getTipoRelacionamento() {
		return this.tipoRelacionamento;
	}

	/**
	 * @param pTipoRelac
	 *            the tipoRelacionamento to set
	 */
	public final void setTipoRelacionamento(
			final AvTipoRelacionamentoBean pTipoRelac) {
		this.tipoRelacionamento = pTipoRelac;
	}

	/**
	 * @param pIdReciboRel
	 *            the idReciboRelacionamento to set
	 */
	public void setIdReciboRelacionamento(final Long pIdReciboRel) {
		this.idReciboRelacionamento = pIdReciboRel;
	}

	/**
	 * @param pNumContrato
	 *            the numContrato to set
	 */
	public void setNumContrato(final Long pNumContrato) {
		this.numContrato = pNumContrato;
	}

	/**
	 * @param pCidContrato
	 *            the cidContrato to set
	 */
	public void setCidContrato(final String pCidContrato) {
		this.cidContrato = pCidContrato;
	}

	/**
	 * @param pContrato
	 *            the contrato to set
	 */
	public void setContrato(final SnContratoBean pContrato) {
		this.contrato = pContrato;
	}

	/**
	 * @param pDhRecibo
	 *            the dhRecibo to set
	 */
	public void setDhRecibo(final Date pDhRecibo) {
		this.dhRecibo = pDhRecibo;
	}

	/**
	 * @param pChamada
	 *            the chamada to set
	 */
	public void setChamada(final SnChamadaBean pChamada) {
		this.chamada = pChamada;
	}

	/**
	 * @param pXtDetalheRecibo
	 *            the xtDetalheRecibo to set
	 */
	public void setXtDetalheRecibo(final String pXtDetalheRecibo) {
		this.xtDetalheRecibo = pXtDetalheRecibo;
	}

	/**
	 * @param pStGeracaoAviRel
	 *            the stGeracaoAvisoRel to set
	 */
	public void setStGeracaoAvisoRel(final String pStGeracaoAviRel) {
		this.stGeracaoAvisoRel = pStGeracaoAviRel;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = BeanConstants.HASH_PRIME;
		int result = 1;
		result = prime * result;
		if (this.idReciboRelacionamento != null) {
			result = prime * result + this.idReciboRelacionamento.hashCode();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		boolean test = super.equals(obj);
		if (obj instanceof AvReciboRelacionamentoBean) {
			final AvReciboRelacionamentoBean comp = (AvReciboRelacionamentoBean) obj;
			test = getIdReciboRelacionamento().equals(
					comp.getIdReciboRelacionamento());
		}
		return test;
	}
}
