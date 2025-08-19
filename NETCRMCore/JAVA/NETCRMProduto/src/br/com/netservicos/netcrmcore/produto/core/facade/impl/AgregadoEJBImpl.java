package br.com.netservicos.netcrmcore.produto.core.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.netservicos.core.bean.cp.CpExtensaoNETFonePropostaBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpProdutosAgregadosBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpPropostaServicoBean;
import br.com.netservicos.core.bean.cp.CpRelPontoExtensaoBean;
import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.DateUtils;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.produto.constants.ProdutoConstants;
import br.com.netservicos.netcrmcore.produto.core.facade.AgregadoService;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoVirtuaDTO;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe responsavel por efetuar operaçoes de Produto
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 08/10/2010
 * @version 1.0
 * 
 * @ejb.bean name="AgregadoEJB" type="Stateless" display-name="AgregadoEJB"
 *           description="AgregadoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/produto/ejb/AgregadoEJB"
 *           local-jndi-name="netcrmcore/produto/ejb/local/AgregadoEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 */
public class AgregadoEJBImpl extends AbstractNETCRMProdutoEJBImpl implements AgregadoService {

	private static final long serialVersionUID = 1713492184667436066L;
	
	private static final String CID_CONTRATO = "cidContrato";
	private static final String ID_PROPOSTA = "idProposta";
	private static final String ID_PRODUTO = "idProduto";
	private static final String ID_PROMOCAO = "idPromocao";
	private static final String ID_PAGAMENTO = "idPagamento";
	private static final String ID_CARACTERISTICA = "idCaracteristica";
	private static final String ID_TIPO_PONTO = "idTipoPonto";

	private static final String LST_DADOS_AGREGADO_TV = "lstDadosAgregadoTV";
	private static final String LST_DADOS_AGREGADO_VIRTUA = "lstDadosAgregadoVirtua";
	private static final String LST_DADOS_AGREGADO_FONE = "lstDadosAgregadoFone";

	private static final String ID_PRODUTO_PRINCIPAL = "idProdutoPrincipal";
	private static final String ID_PRODUTO_ADICIONAL = "idProdutoAdicional";


	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por validar e inserir o produto na proposta.
     * <p>
     * 
     * @since 08/10/2010
     * @author Alessandro Mariano
     * @param Bean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_INSERIR_AGREGADO_PROPOSTA"
     */
	@SuppressWarnings(GeralConstants.UNCHECKED)
	public void inserirAgregadoProposta(final DynamicBean dadosAgregadoProposta) {
		
		final Long idProposta = (Long) dadosAgregadoProposta.get(ID_PROPOSTA);
		final String cidContrato = (String) dadosAgregadoProposta.get(CID_CONTRATO);

		final List<DadosAgregadoTvDTO> lstAgregadoTv = (List<DadosAgregadoTvDTO>) dadosAgregadoProposta.get(LST_DADOS_AGREGADO_TV);
		final List<DadosAgregadoVirtuaDTO> lstAgregadoVirtua = (List<DadosAgregadoVirtuaDTO>) dadosAgregadoProposta.get(LST_DADOS_AGREGADO_VIRTUA);
		final List<DadosAgregadoFoneDTO> lstAgregadoFone = (List<DadosAgregadoFoneDTO>) dadosAgregadoProposta.get(LST_DADOS_AGREGADO_FONE);
		
		List<ValidationMessage> erros =  validarDadosAgregadoProspota(cidContrato, idProposta, lstAgregadoTv, lstAgregadoVirtua, lstAgregadoFone);
		if(erros.size() == 0) {
			if (!isEmptyLstAgregadoTV(lstAgregadoTv)) {
				inserirAgregadoTv(idProposta, lstAgregadoTv);
			}
			if (!isEmptyLstAgregadoVirtua(lstAgregadoVirtua)) {
				inserirAgregadoVirtua(idProposta, lstAgregadoVirtua);
			}
			if (!isEmptyLstAgregadoFone(lstAgregadoFone)) {
				inserirAgregadoFone(idProposta, lstAgregadoFone);
			}
		}else{
		    verificarErrosValidacao(erros);
		}
	}

	private List<ValidationMessage> validarDadosAgregadoProspota(final String cidContrato, final Long idProposta, final List<DadosAgregadoTvDTO> lstAgregadoTvDTO, final List<DadosAgregadoVirtuaDTO> lstAgregadoVirtuaDTO, final List<DadosAgregadoFoneDTO> lstAgregadoFoneDTO) {
		final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		final CpPropostaBean cpProposta = obterProposta(idProposta);
	    
	    if (cpProposta == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_ID_PROPOSTA_INVALIDO, new Object[]{ID_PROPOSTA}));
	    	return errorList;
	    }

	    if (!isEmptyLstAgregadoTV(lstAgregadoTvDTO)) {
	    	validaDadosAgregadoTv(cidContrato, idProposta, lstAgregadoTvDTO, errorList);
	    }
	    if (!isEmptyLstAgregadoVirtua(lstAgregadoVirtuaDTO)) {
	    	validaDadosAgregadoVirtua(cidContrato, idProposta, lstAgregadoVirtuaDTO, errorList);
		}
		if (!isEmptyLstAgregadoFone(lstAgregadoFoneDTO)) {
			validaDadosAgregadoFone(cidContrato, idProposta, lstAgregadoFoneDTO, errorList);
		}
		
		return errorList;
	}

	private void validaDadosAgregadoTv(final String cidContrato, final Long idProposta, final List<DadosAgregadoTvDTO> lstAgregadoTvDTO, final List<ValidationMessage> errorList) {
    	for (DadosAgregadoTvDTO agregadoTvDTO : lstAgregadoTvDTO) {
    		agregadoTvDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(agregadoTvDTO)));
    		validaDadosAgregadoTvObrigatorio(errorList, agregadoTvDTO);
    		if (hasPontoAgregado(idProposta, agregadoTvDTO.getIdCaracteristica())){
    			final List<Long> lstIdProdutoPrincipal = buscaIdProdutoPrincipalInserido(idProposta, agregadoTvDTO.getIdCaracteristica(), Integer.valueOf("5"));
    			for (Long idProdutoPrincipal : lstIdProdutoPrincipal) {
    				if (!hasConvivenciaProduto(idProdutoPrincipal, agregadoTvDTO.getIdProduto(), cidContrato)){
    					errorList.add(getValidationMessage(ProdutoConstants.MSG_PRODUTO_NAO_CONVIVE, new Object[]{ID_PROPOSTA}));
    				}
				}
    		} else {
    			errorList.add(getValidationMessage(ProdutoConstants.MSG_PONTO_INEXISTENTE, new Object[]{ID_PROPOSTA}));
    		}
    	}
	}

	private void validaDadosAgregadoVirtua(final String cidContrato, final Long idProposta, final List<DadosAgregadoVirtuaDTO> lstAgregadoVirtuaDTO, final List<ValidationMessage> errorList) {
		for (DadosAgregadoVirtuaDTO agregadoVirtuaDTO : lstAgregadoVirtuaDTO) {
			agregadoVirtuaDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(agregadoVirtuaDTO)));
			validaDadosAgregadoVirtuaObrigatorio(errorList, agregadoVirtuaDTO);
    		if (hasPontoAgregado(idProposta, agregadoVirtuaDTO.getIdCaracteristica())){
    			final List<Long> lstIdProdutoPrincipal = buscaIdProdutoPrincipalInserido(idProposta, agregadoVirtuaDTO.getIdCaracteristica(), Integer.valueOf("6"));
    			for (Long idProdutoPrincipal : lstIdProdutoPrincipal) {
    				if (!hasConvivenciaProdutoVirtua(idProdutoPrincipal, agregadoVirtuaDTO.getIdProduto())){
    					errorList.add(getValidationMessage(ProdutoConstants.MSG_PRODUTO_NAO_CONVIVE, new Object[]{ID_PRODUTO}));
    				}
				}
    		} else {
    			errorList.add(getValidationMessage(ProdutoConstants.MSG_PONTO_INEXISTENTE, new Object[]{ID_PROPOSTA}));
    		}
    	}
	}

	   private void validaDadosAgregadoFone(final String cidContrato, final Long idProposta, final List<DadosAgregadoFoneDTO> lstAgregadoFoneDTO, final List<ValidationMessage> errorList) {
	        for (DadosAgregadoFoneDTO agregadoFoneDTO : lstAgregadoFoneDTO) {
	            agregadoFoneDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(agregadoFoneDTO)));
	            validaDadosAgregadoFoneObrigatorio(errorList, agregadoFoneDTO);
//	          if (hasPontoAgregado(idProposta, agregadoFoneDTO.getIdCaracteristica())){
//	              final List<Long> lstIdProdutoPrincipal = buscaIdProdutoPrincipalInserido(idProposta, agregadoFoneDTO.getIdCaracteristica(), Integer.valueOf("6"));
//	              for (Long idProdutoPrincipal : lstIdProdutoPrincipal) {
//	                  if (!hasConvivenciaProduto(idProdutoPrincipal, agregadoFoneDTO.getIdProduto(), cidContrato)){
//	                      errorList.add(getValidationMessage(ProdutoConstants.MSG_PRODUTO_NAO_CONVIVE, new Object[]{ID_PRODUTO}));
//	                  }
//	              }
//	          } else {
//	              errorList.add(getValidationMessage(ProdutoConstants.MSG_PONTO_INEXISTENTE, new Object[]{ID_PROPOSTA}));
//	          }
	            
	            if (!hasPontoAgregado(idProposta, agregadoFoneDTO.getIdCaracteristica())){
	                errorList.add(getValidationMessage(ProdutoConstants.MSG_PONTO_INEXISTENTE, new Object[]{ID_PROPOSTA}));
	            }
	        }
	    }

	private void validaDadosAgregadoTvObrigatorio(final List<ValidationMessage> errorList, final DadosAgregadoTvDTO agregadoTvDTO) {
		try {
			String idProduto = agregadoTvDTO.getIdProduto();
			String idPromocao = agregadoTvDTO.getIdPromocao();
			String idPagamento = agregadoTvDTO.getIdPagamento();
			
			validarDadosObrigatorio(errorList, idProduto, idPromocao, idPagamento);
		} catch (Exception e) {
			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Produto"}));
		}
	}

	private void validaDadosAgregadoVirtuaObrigatorio(final List<ValidationMessage> errorList, final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		try {
			String idProduto = agregadoVirtuaDTO.getIdProduto();
			String idPromocao = agregadoVirtuaDTO.getIdPromocao();
			String idPagamento = agregadoVirtuaDTO.getIdPagamento();
//			String fcGeracaoOs = agregadoVirtuaDTO.getFcGeracaoOs();
//			
//			if (!StringUtils.isEmpty(fcGeracaoOs)) {
//				validaFcGeracaoOsObrigatorio(errorList, idProduto);
//			}
			
			validarDadosObrigatorio(errorList, idProduto, idPromocao, idPagamento);
		} catch (Exception e) {
			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Produto"}));
		}
	}
	
	private void validaDadosAgregadoFoneObrigatorio(final List<ValidationMessage> errorList, final DadosAgregadoFoneDTO agregadoFoneDTO) {
		try {
			String idProduto = agregadoFoneDTO.getIdProduto();
			String idPromocao = agregadoFoneDTO.getIdPromocao();
			String idPagamento = agregadoFoneDTO.getIdPagamento();
			
			validarDadosObrigatorio(errorList, idProduto, idPromocao, idPagamento);
		} catch (Exception e) {
			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Produto"}));
		}
	}
	
	private Boolean isEmptyLstAgregadoTV(final List<DadosAgregadoTvDTO> lstAgregadoTvDTO) {
		Boolean retorno = Boolean.FALSE;
		
		if (lstAgregadoTvDTO != null && lstAgregadoTvDTO.size() > 0){
			for (DadosAgregadoTvDTO dadosAgregadoTvDTO : lstAgregadoTvDTO) {
				if (StringUtils.isEmpty(dadosAgregadoTvDTO.getIdProduto())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoTvDTO.getIdPromocao())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoTvDTO.getIdPagamento())){
					return retorno = Boolean.TRUE;
				}
			}
		}

		return retorno;
	}
	
	private Boolean isEmptyLstAgregadoVirtua(final List<DadosAgregadoVirtuaDTO> lstAgregadoVirtuaDTO) {
		Boolean retorno = Boolean.FALSE;
		
		if (lstAgregadoVirtuaDTO != null && lstAgregadoVirtuaDTO.size() > 0){
			for (DadosAgregadoVirtuaDTO dadosAgregadoVirtuaDTO : lstAgregadoVirtuaDTO) {
				if (StringUtils.isEmpty(dadosAgregadoVirtuaDTO.getIdProduto())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoVirtuaDTO.getIdPromocao())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoVirtuaDTO.getIdPagamento())){
					return retorno = Boolean.TRUE;
				}
			}
		}

		return retorno;
	}
	
	private Boolean isEmptyLstAgregadoFone(final List<DadosAgregadoFoneDTO> lstAgregadoFoneDTO) {
		Boolean retorno = Boolean.FALSE;
		
		if (lstAgregadoFoneDTO != null && lstAgregadoFoneDTO.size() > 0){
			for (DadosAgregadoFoneDTO dadosAgregadoFoneDTO : lstAgregadoFoneDTO) {
				if (StringUtils.isEmpty(dadosAgregadoFoneDTO.getIdProduto())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoFoneDTO.getIdPromocao())){
					return retorno = Boolean.TRUE;
				}
				if (StringUtils.isEmpty(dadosAgregadoFoneDTO.getIdPagamento())){
					return retorno = Boolean.TRUE;
				}
			}
		}

		return retorno;
	}
	
//	private Boolean validaFcGeracaoOsObrigatorio(final List<ValidationMessage> errorList, String idProduto) {
//		 
//		final Boolean resultado = Boolean.FALSE;
//		
//		final BatchParameter[] parameters = { new BatchParameter(Types.VARCHAR, true),
//	   	 							      new BatchParameter(idProduto, Types.NUMERIC) };
//		
//		final String sql = "{? = call PGSMS_SERVICOS_AVANCADOS.FC_VERIFICA_GERACAO_OS(?)}";
//		 
//		final List<Object> lstInstalacaoServicosAvancados = this.getCurrentDAO().executeBatch(sql, parameters);
//		
//		final Integer valor = Integer.valueOf((String) lstInstalacaoServicosAvancados.get(0));
//		
//		if (valor == 706) {
//			//$("#instalacaoServicosAvancados").val("S");
//
//		} else if (valor == 707) {
//			//$("#instalacaoServicosAvancados").val("N");
//		}
//		return resultado;
//	}

	
	private Boolean hasPontoAgregado(Long idProposta, String idCaracteristica) {
		Boolean retorno = Boolean.FALSE;
		
		DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PROPOSTA, idProposta);
		dadosAgregado.put(ID_CARACTERISTICA, idCaracteristica);
		
		List list = super.search("lstProdutoInseridoBySegmentoNegocio", dadosAgregado);
		if (list.size() > 0) {
			retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	private Boolean hasConvivenciaProduto(final Long idProdutoPrincipal, final String idProdutoAdicional, final String cidContrato) {
		Boolean retorno = Boolean.FALSE;
		
		DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PRODUTO_PRINCIPAL, idProdutoPrincipal);
		dadosAgregado.put(ID_PRODUTO_ADICIONAL, idProdutoAdicional);
		dadosAgregado.put(CID_CONTRATO, cidContrato);
		
		List list = super.search("verifyConvivenciaProduto", dadosAgregado);
		if (list.size() > 0) {
			retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	private Boolean hasConvivenciaProdutoVirtua(final Long idProdutoPrincipal, final String idProdutoAdicional) {
		Boolean retorno = Boolean.FALSE;
		
		DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PRODUTO_PRINCIPAL, idProdutoPrincipal);
		dadosAgregado.put(ID_PRODUTO_ADICIONAL, idProdutoAdicional);
		
		List list = super.search("verifyConvivenciaProdutoVirtua", dadosAgregado);
		if (list.size() > 0) {
			retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	@SuppressWarnings(GeralConstants.UNCHECKED)
	private List<Long> buscaIdProdutoPrincipalInserido(final Long idProposta, final String idCaracteristica, final Integer idTipoPonto) {
		final DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PROPOSTA, idProposta);
		dadosAgregado.put(ID_CARACTERISTICA, idCaracteristica);
		dadosAgregado.put(ID_TIPO_PONTO, idTipoPonto);
		
		return super.search("lstIdProdutoPrincipalInserido", dadosAgregado);
	}
	
	private void validarDadosObrigatorio(List<ValidationMessage> errorList, String idProduto, String idPromocao, String idPagamento) {
		if (StringUtils.isEmpty(idProduto)){
			errorList.add(getValidationMessage(ProdutoConstants.MSG_CAMPO_OBRIGATORIO, new Object[]{ID_PRODUTO}));
		}
		if (StringUtils.isEmpty(idPromocao)){
			errorList.add(getValidationMessage(ProdutoConstants.MSG_CAMPO_OBRIGATORIO, new Object[]{ID_PROMOCAO}));
		}
		if (StringUtils.isEmpty(idPagamento)){
			errorList.add(getValidationMessage(ProdutoConstants.MSG_CAMPO_OBRIGATORIO, new Object[]{ID_PAGAMENTO}));
		}
	}

	private void inserirAgregadoTv(final Long idProposta, final List<DadosAgregadoTvDTO> lstAgregadoTv) {
		for (DadosAgregadoTvDTO dadosAgregadoTvDTO : lstAgregadoTv) {
			final CpProdutosAgregadosBean agregadoTv = (CpProdutosAgregadosBean) this.createProdutoAgregadoTv(idProposta, dadosAgregadoTvDTO);
			this.getCurrentDAO().insert(agregadoTv);
		}
	}
	
	private void inserirAgregadoVirtua(final Long idProposta, final List<DadosAgregadoVirtuaDTO> lstAgregadoVirtua) {
		for (DadosAgregadoVirtuaDTO dadosAgregadoVirtuaDTO : lstAgregadoVirtua) {
			final CpPropostaServicoBean agregadoVirtua = (CpPropostaServicoBean) this.createProdutoAgregadoVirtua(idProposta, dadosAgregadoVirtuaDTO);
			this.getCurrentDAO().insert(agregadoVirtua);
		}
	}

	private void inserirAgregadoFone(final Long idProposta, final List<DadosAgregadoFoneDTO> lstAgregadoFone) {
		//for (DadosAgregadoFoneDTO dadosAgregadoFoneDTO : lstAgregadoFone) {
		//	final CpRelPontoExtensaoBean agregadoFone = (CpRelPontoExtensaoBean) this.createProdutoAgregadoFone(idProposta, dadosAgregadoFoneDTO);
		//	this.getCurrentDAO().insert(agregadoFone);
		//}
	    
	    for (DadosAgregadoFoneDTO dadosAgregadoFoneDTO : lstAgregadoFone) {
	          final CpExtensaoNETFonePropostaBean agregadoFone = (CpExtensaoNETFonePropostaBean) this.createProdutoAgregadoFoneProposta(idProposta, dadosAgregadoFoneDTO);
	          this.getCurrentDAO().insert(agregadoFone);
	    }
	}

	private CpProdutosAgregadosBean createProdutoAgregadoTv(final Long idProposta, final DadosAgregadoTvDTO agregadoTvDTO) {

		final CpProdutosAgregadosBean cpProdutoAgregado = new CpProdutosAgregadosBean();
		
		cpProdutoAgregado.setPonto(obterPonto(idProposta, agregadoTvDTO));
		cpProdutoAgregado.setProduto(obterProduto(agregadoTvDTO));
		cpProdutoAgregado.setPromocao(obterPromocao(agregadoTvDTO));
		cpProdutoAgregado.setPlanoPgto(obterPagamento(agregadoTvDTO));
		cpProdutoAgregado.setPrecoProd(new BigDecimal(agregadoTvDTO.getPrecoMensal()));
		cpProdutoAgregado.setVlPrimeiroMes(new BigDecimal(agregadoTvDTO.getPrecoAdesao()));

		return cpProdutoAgregado;
    }
	
	private CpPropostaServicoBean createProdutoAgregadoVirtua(final Long idProposta, final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		final CpPropostaServicoBean cpPropostaServico = new CpPropostaServicoBean();
		cpPropostaServico.setProposta(obterProposta(idProposta));
		cpPropostaServico.setProduto(obterProduto(agregadoVirtuaDTO));
		cpPropostaServico.setPromocao(obterPromocao(agregadoVirtuaDTO));
		cpPropostaServico.setPlanoPagamento(obterPagamento(agregadoVirtuaDTO));		
		cpPropostaServico.setFcGeracaoOs("N");
		//cpPropostaServico.setIdEquipeVenda(Long.valueOf("2293"));
		return cpPropostaServico;
	}
	

	private CpRelPontoExtensaoBean createProdutoAgregadoFone(final Long idProposta, final DadosAgregadoFoneDTO agregadoFoneDTO) {
		final CpRelPontoExtensaoBean cpRelPontoExtensao = new CpRelPontoExtensaoBean();
		cpRelPontoExtensao.setPonto(obterPonto(idProposta, agregadoFoneDTO));
		cpRelPontoExtensao.setPromocao(obterPromocao(agregadoFoneDTO));
		cpRelPontoExtensao.setPlanoPagamento(obterPagamento(agregadoFoneDTO));
		cpRelPontoExtensao.setDtIni(new Date());
		cpRelPontoExtensao.setDtFim(DateUtils.toDate(("30/12/2049"), "dd/MM/yyyy"));
		
		return cpRelPontoExtensao;
	}
	
	private CpExtensaoNETFonePropostaBean createProdutoAgregadoFoneProposta(final Long idProposta, final DadosAgregadoFoneDTO agregadoFoneDTO) {
        final CpExtensaoNETFonePropostaBean cpRelExtensao = new CpExtensaoNETFonePropostaBean();
        cpRelExtensao.setPonto(obterPonto(idProposta, agregadoFoneDTO));
        cpRelExtensao.setPlanoPgto(obterPagamento(agregadoFoneDTO));
        cpRelExtensao.setPrecoUnitario(GeralUtil.toBigDecimal(agregadoFoneDTO.getPrecoAdesao()));      
        cpRelExtensao.setQtde(GeralUtil.toInteger(agregadoFoneDTO.getQtd()));
        return cpRelExtensao;
    }

	private CpPontoBean obterPonto(final Long idProposta, final DadosAgregadoTvDTO agregadoTvDTO) {
		final DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PROPOSTA, idProposta);
		
		final Long idPonto = (Long) super.search("lstIdPontoPrincipal", dadosAgregado).get(0);
		
		CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setIdPonto(idPonto);
		return cpPonto = (CpPontoBean) super.findByPrimaryKey(cpPonto);
	}
	
	private CpPontoBean obterPonto(final Long idProposta, final DadosAgregadoFoneDTO agregadoFoneDTO) {
		final DynamicBean dadosAgregado = new DynamicBean(); 
		dadosAgregado.put(ID_PROPOSTA, idProposta);
		dadosAgregado.put(ID_CARACTERISTICA, agregadoFoneDTO.getIdCaracteristica());
		
		final Long idPonto = (Long) super.search("lstIdPontoAdicionalByCaracteristica", dadosAgregado).get(0);
		
		CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setIdPonto(idPonto);
		return cpPonto = (CpPontoBean) super.findByPrimaryKey(cpPonto);
	}

	private SnProdutoBean obterProduto(final DadosAgregadoTvDTO agregadoTvDTO) {
		SnProdutoBean snProduto = new SnProdutoBean();
		snProduto.setIdProduto(Long.valueOf(agregadoTvDTO.getIdProduto()));
		return snProduto = (SnProdutoBean) super.findByPrimaryKey(snProduto);
	}
	
	private SnPromocaoBean obterPromocao(final DadosAgregadoTvDTO agregadoTvDTO) {
		SnPromocaoBean snPromocao = new SnPromocaoBean();
		snPromocao.setIdPromocao(Integer.valueOf(agregadoTvDTO.getIdPromocao()));
		return snPromocao = (SnPromocaoBean) super.findByPrimaryKey(snPromocao);
	}
	
	private SnPlanoPgtoBean obterPagamento(final DadosAgregadoTvDTO agregadoTvDTO) {
		SnPlanoPgtoBean snPlanoPgto = new SnPlanoPgtoBean();
		snPlanoPgto.setIdPlanoPgto(Long.valueOf(agregadoTvDTO.getIdPagamento()));
		return snPlanoPgto = (SnPlanoPgtoBean) super.findByPrimaryKey(snPlanoPgto);
	}
	
	private Long obterIdCaracteristica(final DadosAgregadoTvDTO agregadoTvDTO) {
		final SnProdutoBean snProduto = obterProduto(agregadoTvDTO);
		final Long idCaracteristica = snProduto.getCaracteristica().getIdCaracteristica();
		return idCaracteristica;
	}
	
	private SnProdutoBean obterProduto(final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		SnProdutoBean snProduto = new SnProdutoBean();
		snProduto.setIdProduto(Long.valueOf(agregadoVirtuaDTO.getIdProduto()));
		return snProduto = (SnProdutoBean) super.findByPrimaryKey(snProduto);
	}

	private SnPromocaoBean obterPromocao(final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		SnPromocaoBean snPromocao = new SnPromocaoBean();
		snPromocao.setIdPromocao(Integer.valueOf(agregadoVirtuaDTO.getIdPromocao()));
		return snPromocao = (SnPromocaoBean) super.findByPrimaryKey(snPromocao);
	}

	private SnPlanoPgtoBean obterPagamento(final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		SnPlanoPgtoBean snPlanoPgto = new SnPlanoPgtoBean();
		snPlanoPgto.setIdPlanoPgto(Long.valueOf(agregadoVirtuaDTO.getIdPagamento()));
		return snPlanoPgto = (SnPlanoPgtoBean) super.findByPrimaryKey(snPlanoPgto);
	}
	
	private Long obterIdCaracteristica(final DadosAgregadoVirtuaDTO agregadoVirtuaDTO) {
		final SnProdutoBean snProduto = obterProduto(agregadoVirtuaDTO);
		final Long idCaracteristica = snProduto.getCaracteristica().getIdCaracteristica();
		return idCaracteristica;
	}

	private SnProdutoBean obterProduto(DadosAgregadoFoneDTO agregadoFoneDTO) {
		SnProdutoBean snProduto = new SnProdutoBean();
		snProduto.setIdProduto(Long.valueOf(agregadoFoneDTO.getIdProduto()));
		return snProduto = (SnProdutoBean) super.findByPrimaryKey(snProduto);
	}
	
	private SnPromocaoBean obterPromocao(final DadosAgregadoFoneDTO agregadoFoneDTO) {
		SnPromocaoBean snPromocao = new SnPromocaoBean();
		snPromocao.setIdPromocao(Integer.valueOf(agregadoFoneDTO.getIdPromocao()));
		return snPromocao = (SnPromocaoBean) super.findByPrimaryKey(snPromocao);
	}
	
	private SnPlanoPgtoBean obterPagamento(DadosAgregadoFoneDTO agregadoFoneDTO) {
		SnPlanoPgtoBean snPlanoPgto = new SnPlanoPgtoBean();
		snPlanoPgto.setIdPlanoPgto(Long.valueOf(agregadoFoneDTO.getIdPagamento()));
		return snPlanoPgto = (SnPlanoPgtoBean) super.findByPrimaryKey(snPlanoPgto);
	}
	
	private Long obterIdCaracteristica(final DadosAgregadoFoneDTO agregadoFoneDTO) {
		final SnProdutoBean snProduto = obterProduto(agregadoFoneDTO);
		final Long idCaracteristica = snProduto.getCaracteristica().getIdCaracteristica();
		return idCaracteristica;
	}
	
	private CpPropostaBean obterProposta(final Long idProposta) {
		CpPropostaBean cpProposta = new CpPropostaBean();
		cpProposta.setIdProposta(idProposta);
		return cpProposta = (CpPropostaBean) super.findByPrimaryKey(cpProposta);
	}
}
