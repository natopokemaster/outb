package br.com.netservicos.core.bean.sn;

import java.util.Calendar;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * 
* <P><B>Description :</B><BR>
* Classe Bean que representa a tabela sn_solicitacao_ass
* </P>
* <P>
* <B> Issues : <BR>
* </B>
* <PRE>    
* ==============================================================================
* Description                              Date        By
* ---------------------------------------- ----------- ------------------------
* 
* ==============================================================================
* </PRE>
*
* <P><B>
* Revision History:
* </B><PRE>
* ==============================================================================
*                           Prior
* Date       By             Version  Project/CSR    	Description
* ---------- -------------- -------- --------------    -------------------------
* 
* ==============================================================================
* </PRE>
*
* @hibernate.class 
* 		table="sn_solicitacao_ass" 
* 		dynamic-insert="true" 
* 		dynamic-update="true" 
* 		lazy="true" 
* 		batch-size="10"
*
* @author mcalegari
* @since 10/03/2010
* @version $Revision: 1.7 $
 */
public class SnSolicitacaoAssBean extends DomainBean {

	private static final long serialVersionUID = -7803119044289813127L;
	public static final String ID_SOLICITACAO_ASS = "idSolicitacaoAss";
	
	private Long idSolicitacaoAss;
	private SnContratoBean contrato;
	//private SnCidadeOperadoraBean cidadeOperadora;
	private SnTipoSolicBean tipoSolic;
	private String nomeSolic;
	private String telSolic;
	private Calendar dtCadastro;
	private SnUsrBean usrCadastro;
	private SnPlanoPgtoBean planoPgto;
	//private SnSolicDesabBean razaoCancelSolic;
	private Calendar dtBaixa;
	//private SnUsrBean usrBaixa;
	//private SnTipoFechamentoBean tipoFechamento;
	private SnTipoSolicProdBean tipoSolicProd;
	private Integer imediata;
	private Integer isento;
	private String obs;
	//private SnRazaoCancelamentoBean razaoCancelamento;
	//private Integer idPeriodoPre;
	//private String idAreaDespachoPre;
	//private Integer idClassePre;
	private Integer fcControlePaytv;
	//private SnChamadaBean chamada;
	
	public SnSolicitacaoAssBean() {
		super(ID_SOLICITACAO_ASS);
	}

	/**
	 * @return Returns the idSolicitacaoAss.
	 *
	 * @hibernate.id
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_solicitacao_ass"
	 *		type="long"
	 *
	 * @hibernate.generator-param 
	 * 		name="sequence"
	 * 		value="ssn_id_solicitacao_assinante"
	 */
	public Long getIdSolicitacaoAss() {
		return idSolicitacaoAss;
	}

	/**
	 * @param idSolicitacaoAss 
	 *				The idSolicitacaoAss to set.
	 */
	public void setIdSolicitacaoAss(Long idSolicitacaoAss) {
		this.idSolicitacaoAss = idSolicitacaoAss;
	}

	/**
	 * @return Returns the contrato.
	 *
	 * @hibernate.many-to-one
	 * 		name="contrato"
	 * 		class="br.com.netservicos.core.bean.sn.SnContratoBean"
	 * 		cascade="none"
	 * 		lazy="proxy"
	 * 
	 * @hibernate.column
	 *		name="num_contrato"
	 *
	 * @hibernate.column
	 *		name="cid_contrato"
	 *
	 */
	public SnContratoBean getContrato() {
		return contrato;
	}

	/**
	 * @param contrato 
	 *				The contrato to set.
	 */
	public void setContrato(SnContratoBean contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return Returns the nomeSolic.
	 *
	 * @hibernate.property
	 *		column="nome_solic"
	 *		type="string"
	 */
	public String getNomeSolic() {
		return nomeSolic;
	}

	/**
	 * @param nomeSolic 
	 *				The nomeSolic to set.
	 */
	public void setNomeSolic(String nomeSolic) {
		this.nomeSolic = nomeSolic;
	}

	/**
	 * @return Returns the telSolic.
	 *
	 * @hibernate.property
	 *		column="tel_solic"
	 *		type="string"
	 */
	public String getTelSolic() {
		return telSolic;
	}

	/**
	 * @param telSolic 
	 *				The telSolic to set.
	 */
	public void setTelSolic(String telSolic) {
		this.telSolic = telSolic;
	}

	/**
	 * @return Returns the dtCadastro.
	 *
	 * @hibernate.property
	 *		column="dt_cadastro"
	 *		type="calendar_date"
	 */
	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	/**
	 * @param dtCadastro 
	 *				The dtCadastro to set.
	 */
	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	/**
	 * @return Returns the dtBaixa.
	 *
	 * @hibernate.property
	 *		column="dt_baixa"
	 *		type="date"
	 */
	public Calendar getDtBaixa() {
		return dtBaixa;
	}

	/**
	 * @param dtBaixa 
	 *				The dtBaixa to set.
	 */
	public void setDtBaixa(Calendar dtBaixa) {
		this.dtBaixa = dtBaixa;
	}

	/**
	 * @return Returns the imediata.
	 *
	 * @hibernate.property
	 *		column="imediata"
	 *		type="int"
	 */
	public Integer getImediata() {
		return imediata;
	}

	/**
	 * @param imediata 
	 *				The imediata to set.
	 */
	public void setImediata(Integer imediata) {
		this.imediata = imediata;
	}

	/**
	 * @return Returns the isento.
	 *
	 * @hibernate.property
	 *		column="isento"
	 *		type="int"
	 */
	public Integer getIsento() {
		return isento;
	}

	/**
	 * @param isento 
	 *				The isento to set.
	 */
	public void setIsento(Integer isento) {
		this.isento = isento;
	}

	/**
	 * @return Returns the obs.
	 *
	 * @hibernate.property
	 *		column="obs"
	 *		type="string"
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs 
	 *				The obs to set.
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return Returns the fcControlePaytv.
	 *
	 * @hibernate.property
	 *		column="fc_controle_paytv"
	 *		type="int"
	 */
	public Integer getFcControlePaytv() {
		return fcControlePaytv;
	}

	/**
	 * @param fcControlePaytv 
	 *				The fcControlePaytv to set.
	 */
	public void setFcControlePaytv(Integer fcControlePaytv) {
		this.fcControlePaytv = fcControlePaytv;
	}

	/**
	 * @return Returns the tipoSolic.
	 *
	 * @hibernate.many-to-one
	 * 		name="tipoSolic"
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoSolicBean"
	 *		column="id_tipo_solic"
	 * 		cascade="none"
	 *		lazy="proxy"
	 *
	 */
	public SnTipoSolicBean getTipoSolic() {
		return tipoSolic;
	}

	/**
	 * @param tipoSolic 
	 *				The tipoSolic to set.
	 */
	public void setTipoSolic(SnTipoSolicBean tipoSolic) {
		this.tipoSolic = tipoSolic;
	}

	/**
	 * @return Returns the usrCadastro.
	 *
	 * @hibernate.many-to-one
	 * 		name="usrCadastro"
	 * 		class="br.com.netservicos.core.bean.sn.SnUsrBean"
	 *		column="usr_cadastro"
	 * 		cascade="none"
	 *		lazy="proxy"  
	 */
	public SnUsrBean getUsrCadastro() {
		return usrCadastro;
	}

	/**
	 * @param usrCadastro 
	 *				The usrCadastro to set.
	 */
	public void setUsrCadastro(SnUsrBean usrCadastro) {
		this.usrCadastro = usrCadastro;
	}

	/**
	 * @return Returns the planoPgto.
	 *
	 * @hibernate.many-to-one
	 * 		name="planoPgto"
	 * 		class="br.com.netservicos.core.bean.sn.SnPlanoPgtoBean"
	 *		column="id_plano_pgto"
	 * 		cascade="none"
	 *		lazy="proxy"  
	 */
	public SnPlanoPgtoBean getPlanoPgto() {
		return planoPgto;
	}

	/**
	 * @param planoPgto 
	 *				The planoPgto to set.
	 */
	public void setPlanoPgto(SnPlanoPgtoBean planoPgto) {
		this.planoPgto = planoPgto;
	}

	/**
	 * @return Returns the tipoSolicProd.
	 *
	 * @hibernate.many-to-one
	 * 		name="tipoSolicProd"
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoSolicProdBean"
	 *		column="id_tipo_solic_prod"
	 * 		cascade="none"
	 *		lazy="proxy" 
	 */
	public SnTipoSolicProdBean getTipoSolicProd() {
		return tipoSolicProd;
	}

	/**
	 * @param tipoSolicProd 
	 *				The tipoSolicProd to set.
	 */
	public void setTipoSolicProd(SnTipoSolicProdBean tipoSolicProd) {
		this.tipoSolicProd = tipoSolicProd;
	}

}
