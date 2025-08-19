package br.com.netservicos.netcrmcore.produto.core.facade.impl;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.netservicos.core.bean.cp.CpCidadeOperadoraBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpTipoPontoBean;
import br.com.netservicos.core.bean.sn.SnCaracteristicaBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.core.bean.sn.SnLocalizacaoBean;
import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.produto.constants.ProdutoConstants;
import br.com.netservicos.netcrmcore.produto.core.facade.ProdutoService;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoVirtuaDTO;
import br.com.netservicos.netcrmcore.produto.dto.FormaAquisicaoDTO;
import br.com.netservicos.netcrmcore.produto.dto.ProdutoDTO;
import br.com.netservicos.netcrmcore.produto.dto.ProvedorDTO;
import br.com.netservicos.netcrmcore.produto.dto.ServicoGravacaoDigitalDTO;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe responsavel por efetuar operaçoes de Produto
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 28/09/2010
 * @version 1.0
 * 
 * @ejb.bean name="ProdutoEJB" type="Stateless" display-name="ProdutoEJB"
 *           description="ProdutoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/produto/ejb/ProdutoEJB"
 *           local-jndi-name="netcrmcore/produto/ejb/local/ProdutoEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 */
public class ProdutoEJBImpl extends AbstractNETCRMProdutoEJBImpl implements ProdutoService {

	private static final long serialVersionUID = 1713492184667436066L;
	
	private static final String ID_PROPOSTA = "idProposta";
	private static final String CID_CONTRATO = "cidContrato";
	private static final String ID_PRODUTO = "idProduto";
	private static final String NUM_CONTRATO = "numContrato";
	private static final String ID_TIPO_PRODUTO = "idTipoProduto";
		
	private static final String LST_DADOS_PRODUTO_NET_TV = "lstDadosProdutoNetTv";
	private static final String LST_DADOS_PRODUTO_NET_VIRTUA = "lstDadosProdutoNetVirtua";
	private static final String LST_DADOS_PRODUTO_NET_FONE = "lstDadosProdutoNetFone";
	private static final String LST_ID_PRODUTO = "lstIdProduto";

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por validar e inserir o produto na proposta.
     * <p>
     * 
     * @since 28/09/2010
     * @author Alessandro Mariano
     * @param DynamicBean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_INSERIR_PRODUTO_PROPOSTA"
     */
	@SuppressWarnings(GeralConstants.UNCHECKED)
	public void inserirProdutoProposta(final DynamicBean dadosProdutoProposta) {
		
		final Long idProposta = (Long) dadosProdutoProposta.get(ID_PROPOSTA);
		final List<DadosProdutoTvDTO> lstProdutoTvDTO = (List<DadosProdutoTvDTO>) dadosProdutoProposta.get(LST_DADOS_PRODUTO_NET_TV);
		final List<DadosProdutoVirtuaDTO> lstProdutoVirtuaDTO = (List<DadosProdutoVirtuaDTO>) dadosProdutoProposta.get(LST_DADOS_PRODUTO_NET_VIRTUA);
		final List<DadosProdutoFoneDTO> lstProdutoFoneDTO = (List<DadosProdutoFoneDTO>) dadosProdutoProposta.get(LST_DADOS_PRODUTO_NET_FONE);
		
		final List<ValidationMessage> erros =  validarDadosProdutoProspota(idProposta, lstProdutoTvDTO, lstProdutoVirtuaDTO, lstProdutoFoneDTO);
		if(erros.size() == 0) {
			if (!isEmptyLstTV(lstProdutoTvDTO)) {
				inserirProdutoNetTV(idProposta, lstProdutoTvDTO);
			}
			if (!isEmptyLstVirtua(lstProdutoVirtuaDTO)) {
				inserirProdutoNetVirtua(idProposta, lstProdutoVirtuaDTO);
			}
			if (!isEmptyLstFone(lstProdutoFoneDTO)) {
				inserirProdutoNetFone(idProposta, lstProdutoFoneDTO);
			}
		}else{
		    verificarErrosValidacao(erros);
		}
	}
	
	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por deletar os produtos inseridos na proposta.
     * <p>
     * 
     * @since 19/10/2010
     * @author Alessandro Mariano
     * @param DynamicBean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_DELETE_PRODUTO_PROPOSTA"
     */
	public void deleteAllProdutosProposta(final DynamicBean dadosDeleteProduto) {
		final Long idProposta = (Long) dadosDeleteProduto.get(ID_PROPOSTA);
		
		final List<ValidationMessage> erros =  validarDadosDeleteProdutoProspota(idProposta);
		if(erros.size() == 0) {
			deleteAllProdutos(idProposta);
		}else{
		    verificarErrosValidacao(erros);
		}
	}
	
	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por deletar os produtos inseridos na proposta.
     * <p>
     * 
     * @since 20/10/2010
     * @author Alessandro Mariano
     * @param DynamicBean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_DELETE_PRODUTO_PROPOSTA"
     */
	@SuppressWarnings(GeralConstants.UNCHECKED)
	public void deleteLstProdutosProposta(final DynamicBean dadosAgregado) {
		final String cidContrato = (String) dadosAgregado.get(CID_CONTRATO);
		final Long idProposta = (Long) dadosAgregado.get(ID_PROPOSTA);
		final List<Long> lstIdProduto = (List<Long>) dadosAgregado.get(LST_ID_PRODUTO);
		
		final List<ValidationMessage> erros =  validarDadosDeleteProdutoProspota(cidContrato, idProposta, lstIdProduto);
		if(erros.size() == 0) {
			deleteLstProdutos(cidContrato, idProposta, lstIdProduto);
		}else{
		    verificarErrosValidacao(erros);
		}
	}
	
	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por consultar os produtos contratados.
     * <p>
     * 
     * @since 20/10/2010
     * @author Alessandro Mariano
     * @param DynamicBean
     * @return List<?>
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_CONSULTAR_PRODUTOS_CONTRATADOS"
     */
	public List<?> consultarProdutosContratados(final DynamicBean dadosProdutoContratado) {
		
		Integer idTipoProduto = null;
				
		if (!StringUtils.isEmpty((String) dadosProdutoContratado.get(ID_TIPO_PRODUTO))) {
			idTipoProduto = Integer.valueOf((String) dadosProdutoContratado.get(ID_TIPO_PRODUTO)); 
		}
		
		List<?> list = new ArrayList<Object>();
		
		final List<ValidationMessage> erros = validarDadosProdutoContratado(dadosProdutoContratado);
		if(erros.size() == 0) {
			if (idTipoProduto != null) { //Pacotes ou a La Carte
				list = popularProdutosContratados(super.search("SnRelPontoProdutoBeanBuscaProdutosContratadosByIdtipoProduto", dadosProdutoContratado));
			} else { //Pacotes e a La Carte
				list = popularProdutosContratados(super.search("SnRelPontoProdutoBeanBuscaProdutosContratadosAll", dadosProdutoContratado));
			} 
		} else {
		    verificarErrosValidacao(erros);
		}
		 
		return list;
	}

	private List<ValidationMessage> validarDadosProdutoContratado(final DynamicBean dadosProdutoContratado) {
		final String cidContrato = (String) dadosProdutoContratado.get(CID_CONTRATO);
		final Long numContrato = (Long) dadosProdutoContratado.get(NUM_CONTRATO);
		
		final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		final CpCidadeOperadoraBean cpCidade = obterCidadeOperadora(cidContrato);
	    if (cpCidade == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_CID_CONTRATO_INVALIDO, new Object[]{CID_CONTRATO}));
	    }
		
		final SnContratoBean snContrato = obterContrato(numContrato, cidContrato);
	    if (snContrato == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_NUM_CONTRATO_INVALIDO, new Object[]{NUM_CONTRATO}));
	    }
	    		
		return errorList;
	}

	private List<ValidationMessage> validarDadosProdutoProspota(final Long idProposta, final List<DadosProdutoTvDTO> lstProdutoTvDTO, final List<DadosProdutoVirtuaDTO> lstProdutoVirtuaDTO, final List<DadosProdutoFoneDTO> lstProdutoFoneDTO) {
		
		final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		final CpPropostaBean cpProposta = obterProposta(idProposta);
	    if (cpProposta == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_ID_PROPOSTA_INVALIDO, new Object[]{ID_PROPOSTA}));
	    }
	    
	    Boolean existProdutoPrincipalList = Boolean.FALSE;
	    //Valida dados TV
    	if (!isEmptyLstTV(lstProdutoTvDTO)) {
	    	for (DadosProdutoTvDTO produtoTvDTO : lstProdutoTvDTO) {
	    		if (!validaDadosProdutoObrigatorio(produtoTvDTO.getProduto())) {
	    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"TV - Produto"}));
	    		}
	    		if (hasFormaAquisicao(produtoTvDTO.getProduto())){
	    			if (!validaDadosFormaAquisicaoObrigatorio(produtoTvDTO.getFormaAquisicao())) {
	    				errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"TV - FormaAquisicao"}));
	    			}
	    		}
	    		if (hasServicoGravacaoDigital(produtoTvDTO.getProduto())){
	    			if (!validaDadosServicoGravacaoDigitalObrigatorio(produtoTvDTO.getServicoGravacaoDigital())) {
	    				errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"TV - ServicoGravacaoDigital"}));
	    			}
	    		}
			}
	    	existProdutoPrincipalList = Boolean.TRUE;
    	}
    	// Valida dados Virtua
	    if (existProdutoPrincipalList) {
		    if (!isEmptyLstVirtua(lstProdutoVirtuaDTO)) {
		    	for (DadosProdutoVirtuaDTO produtoVirtuaDTO : lstProdutoVirtuaDTO) {
		    		if (!validaDadosProdutoObrigatorio(produtoVirtuaDTO.getProduto())) {
		    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - Produto"}));
		    		}
		    		if (!validaDadosFormaAquisicaoObrigatorio(produtoVirtuaDTO.getFormaAquisicao())) {
	    				errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - FormaAquisicao"}));
	    			}
		    		if (!validaDadosProvedorObrigatorio(produtoVirtuaDTO.getProvedor())) {
		    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - Provedor"}));
		    		}
				}
			}
	    } else {
	    	if (hasProdutoPrincipal(idProposta)) {
	    		if (!isEmptyLstVirtua(lstProdutoVirtuaDTO)) {
			    	for (DadosProdutoVirtuaDTO produtoVirtuaDTO : lstProdutoVirtuaDTO) {
			    		if (!validaDadosProdutoObrigatorio(produtoVirtuaDTO.getProduto())) {
			    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - Produto"}));
			    		}
			    		if (!validaDadosFormaAquisicaoObrigatorio(produtoVirtuaDTO.getFormaAquisicao())) {
		    				errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - FormaAquisicao"}));
		    			}
			    		if (!validaDadosProvedorObrigatorio(produtoVirtuaDTO.getProvedor())) {
			    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Virtua - Provedor Virtua"}));
			    		}
					}
				}
		    } else {
		    	errorList.add(getValidationMessage(ProdutoConstants.MSG_INSERIR_PRODUTO_TV, new Object[]{}));
		    }
	    }
	    //Valida dados Fone
	    if (existProdutoPrincipalList) {
			if (!isEmptyLstFone(lstProdutoFoneDTO)) {
				for (DadosProdutoFoneDTO produtoFoneDTO : lstProdutoFoneDTO) {
					if (!validaDadosProdutoObrigatorio(produtoFoneDTO.getProduto())) {
		    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Fone - Produto"}));
		    		}
				}
			}
	    } else {
	    	if (hasProdutoPrincipal(idProposta)) {
				if (!isEmptyLstFone(lstProdutoFoneDTO)) {
					for (DadosProdutoFoneDTO produtoFoneDTO : lstProdutoFoneDTO) {
						if (!validaDadosProdutoObrigatorio(produtoFoneDTO.getProduto())) {
			    			errorList.add(getValidationMessage(ProdutoConstants.MSG_OBRIGATORIO_PREENCHIMENTO, new Object[]{"Fone - Produto"}));
			    		}
					}
				}
		    } else {
		    	errorList.add(getValidationMessage(ProdutoConstants.MSG_INSERIR_PRODUTO_TV, new Object[]{}));
		    }
	    }
	    
	    return errorList;
	}
	
	
	private Boolean isEmptyLstTV(final List<DadosProdutoTvDTO> lstProdutoTvDTO) {
		Boolean retorno = Boolean.FALSE;

		if (lstProdutoTvDTO != null && lstProdutoTvDTO.size() > 0) {
			for (DadosProdutoTvDTO dadosProdutoTvDTO : lstProdutoTvDTO) {
				if (isEmptyProduto(dadosProdutoTvDTO.getProduto())) {
					return retorno = Boolean.TRUE;
				}
				if (hasFormaAquisicao(dadosProdutoTvDTO.getProduto())) {
					if (isEmptyFormaAquisicao(dadosProdutoTvDTO
							.getFormaAquisicao())) {
						return retorno = Boolean.TRUE;
					}
				}
				if (hasServicoGravacaoDigital(dadosProdutoTvDTO.getProduto())) {
					if (isEmptyServicoGravacaoDigital(dadosProdutoTvDTO
							.getServicoGravacaoDigital())) {
						return retorno = Boolean.TRUE;
					}
				}
			}
		}

		return retorno;
	}

	
	private Boolean isEmptyLstVirtua(final List<DadosProdutoVirtuaDTO> lstProdutoVirtuaDTO) {
		Boolean retorno = Boolean.FALSE;
		
		if (lstProdutoVirtuaDTO != null && lstProdutoVirtuaDTO.size() > 0){
			for (DadosProdutoVirtuaDTO dadosProdutoVirtuaDTO : lstProdutoVirtuaDTO) {
				if (isEmptyProduto(dadosProdutoVirtuaDTO.getProduto())){
					return retorno = Boolean.TRUE;
				}
				if (isEmptyFormaAquisicao(dadosProdutoVirtuaDTO.getFormaAquisicao())){
					return retorno = Boolean.TRUE;
				}
				if (isEmptyProvedor(dadosProdutoVirtuaDTO.getProvedor())){
					return retorno = Boolean.TRUE;
				}
			}
		}

		return retorno;
	}
	
	private Boolean isEmptyLstFone(final List<DadosProdutoFoneDTO> lstProdutoFoneDTO) {
		Boolean retorno = Boolean.FALSE;
		
		if (lstProdutoFoneDTO != null && lstProdutoFoneDTO.size() > 0){
			for (DadosProdutoFoneDTO dadosProdutoFoneDTO : lstProdutoFoneDTO) {
				if (isEmptyProduto(dadosProdutoFoneDTO.getProduto())){
					return retorno = Boolean.TRUE;
				}
			}
		}

		return retorno;
	}

	private Boolean isEmptyProduto(final ProdutoDTO produto) {
		Boolean retorno = Boolean.FALSE;
		
		String idProduto = produto.getIdProduto();
		String idPromocao = produto.getIdPromocao();
		String idLocalizacao = produto.getIdLocalizacao();
		String idPagamento = produto.getIdPagamento();
		
		if (StringUtils.isEmpty(idProduto)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPromocao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idLocalizacao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPagamento)){
			return retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	private Boolean isEmptyFormaAquisicao(final FormaAquisicaoDTO formaAquisicao) {
		Boolean retorno = Boolean.FALSE;
		
		String idProduto = formaAquisicao.getIdProduto();
		String idPromocao = formaAquisicao.getIdPromocao();
		String idLocalizacao = formaAquisicao.getIdLocalizacao();
		String idPagamento = formaAquisicao.getIdPagamento();
		
		if (StringUtils.isEmpty(idProduto)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPromocao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idLocalizacao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPagamento)){
			return retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	private Boolean isEmptyServicoGravacaoDigital(final ServicoGravacaoDigitalDTO servicoGravacaoDigital) {
		Boolean retorno = Boolean.FALSE;
		
		String idProduto = servicoGravacaoDigital.getIdProduto();
		String idPromocao = servicoGravacaoDigital.getIdPromocao();
		String idLocalizacao = servicoGravacaoDigital.getIdLocalizacao();
		String idPagamento = servicoGravacaoDigital.getIdPagamento();
		
		if (StringUtils.isEmpty(idProduto)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPromocao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idLocalizacao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPagamento)){
			return retorno = Boolean.TRUE;
		}
		
		return retorno;
	}
	
	private Boolean isEmptyProvedor(final ProvedorDTO provedor) {
		Boolean retorno = Boolean.FALSE;
		
		String idProduto = provedor.getIdProduto();
		String idPromocao = provedor.getIdPromocao();
		String idLocalizacao = provedor.getIdLocalizacao();
		String idPagamento = provedor.getIdPagamento();
		
		if (StringUtils.isEmpty(idProduto)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPromocao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idLocalizacao)){
			return retorno = Boolean.TRUE;
		}
		if (StringUtils.isEmpty(idPagamento)){
			return retorno = Boolean.TRUE;
		}
		
		return retorno;
	}

	private List<ValidationMessage> validarDadosDeleteProdutoProspota(final Long idProposta) {
		final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		final CpPropostaBean cpProposta = obterProposta(idProposta);
	    if (cpProposta == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_ID_PROPOSTA_INVALIDO, new Object[]{ID_PROPOSTA}));
	    }

		return errorList;
	}

	private List<ValidationMessage> validarDadosDeleteProdutoProspota(final String cidContrato, final Long idProposta, final List<Long> lstIdProduto) {
		
		final List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		final CpCidadeOperadoraBean cpCidade = obterCidadeOperadora(cidContrato);
	    if (cpCidade == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_CID_CONTRATO_INVALIDO, new Object[]{CID_CONTRATO}));
	    }
	    
		final CpPropostaBean cpProposta = obterProposta(idProposta);
	    if (cpProposta == null) {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_ID_PROPOSTA_INVALIDO, new Object[]{ID_PROPOSTA}));
	    }
	    
	    if (lstIdProduto != null && lstIdProduto.size() > 0) {
	    	for (Long idProduto : lstIdProduto) {
	    		final SnProdutoBean snProduto = obterProduto(idProduto);
	    		if (snProduto == null) {
	    			errorList.add(getValidationMessage(ProdutoConstants.MSG_ID_PRODUTO_INVALIDO, new Object[]{ID_PRODUTO}));
	    		}
			}
	    } else {
	    	errorList.add(getValidationMessage(ProdutoConstants.MSG_CAMPO_OBRIGATORIO, new Object[]{ID_PRODUTO}));
	    }
		
		return errorList;
	}

	private Boolean validaDadosProdutoObrigatorio(final ProdutoDTO produto) {
		Boolean retorno = Boolean.FALSE;

		if (!isEmptyProduto(produto)){
			retorno = Boolean.TRUE;
		}
		return retorno;
	}
	
	private Boolean validaDadosFormaAquisicaoObrigatorio(final FormaAquisicaoDTO formaAquisicao) {
		Boolean retorno = Boolean.FALSE;

		if (!isEmptyFormaAquisicao(formaAquisicao)){
			retorno = Boolean.TRUE;
		}
		return retorno;
	}
	
	private Boolean validaDadosServicoGravacaoDigitalObrigatorio(final ServicoGravacaoDigitalDTO servicoGravacaoDigital) {
		Boolean retorno = Boolean.FALSE;

		if (!isEmptyServicoGravacaoDigital(servicoGravacaoDigital)){
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	private Boolean validaDadosProvedorObrigatorio(final ProvedorDTO provedor) {
		Boolean retorno = Boolean.FALSE;

		if (!isEmptyProvedor(provedor)){
			retorno = Boolean.TRUE;
		}
		return retorno;
	}

	private void inserirProdutoNetTV(final Long idProposta, final List<DadosProdutoTvDTO> lstProdutoTvDTO) {
		
		for (DadosProdutoTvDTO dadosProdutoTvDTO : lstProdutoTvDTO) {
			
			final ProdutoDTO produtoDTO = dadosProdutoTvDTO.getProduto();
		    if (!hasProdutoPrincipal(idProposta)){
				produtoDTO.setIdTipoPonto("5");
			} else {
            	produtoDTO.setIdTipoPonto("6");
			}
		    produtoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
			
       		final CpPontoBean produtoPai = (CpPontoBean) this.createProduto(idProposta, produtoDTO);
       		final List<CpPontoBean> produtosFilhos = new ArrayList<CpPontoBean>();
       		
       		if (hasFormaAquisicao(produtoDTO)) {
       			final FormaAquisicaoDTO formaAquisicaoDTO = dadosProdutoTvDTO.getFormaAquisicao();
       			formaAquisicaoDTO.setIdTipoPonto("2");
       			formaAquisicaoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
       			produtosFilhos.add(createFormaAquisicao(idProposta, formaAquisicaoDTO));
       		}

	        if (hasServicoGravacaoDigital(produtoDTO)) {
	        	final ServicoGravacaoDigitalDTO servicoGravacaoDigitalDTO = dadosProdutoTvDTO.getServicoGravacaoDigital();
	        	servicoGravacaoDigitalDTO.setIdTipoPonto("2");
	        	servicoGravacaoDigitalDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
	        	produtosFilhos.add(this.createServicoGravacaoDigital(idProposta, servicoGravacaoDigitalDTO));
	        }
       		
       		inserirProduto(produtoPai, produtosFilhos);
		}
    }

	private void inserirProdutoNetVirtua(final Long idProposta, final List<DadosProdutoVirtuaDTO> lstProdutoVirtuaDTO) {
		
		for (DadosProdutoVirtuaDTO dadosProdutoVirtuaDTO : lstProdutoVirtuaDTO) {
			final ProdutoDTO produtoDTO = dadosProdutoVirtuaDTO.getProduto();
			produtoDTO.setIdTipoPonto("6");
			produtoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
			
			final FormaAquisicaoDTO formaAquisicaoDTO = dadosProdutoVirtuaDTO.getFormaAquisicao();
			formaAquisicaoDTO.setIdTipoPonto("2");
			formaAquisicaoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
			
			final ProvedorDTO provedorDTO = dadosProdutoVirtuaDTO.getProvedor();
			provedorDTO.setIdTipoPonto("1");
			provedorDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
	
	   		final CpPontoBean produtoPai = (CpPontoBean) this.createProduto(idProposta, produtoDTO);
	   		final List<CpPontoBean> produtosFilhos = new ArrayList<CpPontoBean>();
	   		produtosFilhos.add(createFormaAquisicao(idProposta, formaAquisicaoDTO));
	   		produtosFilhos.add(createProvedor(idProposta, provedorDTO));
	
	   		inserirProduto(produtoPai, produtosFilhos);
		}
	}
	
	private void inserirProdutoNetFone(final Long idProposta, final List<DadosProdutoFoneDTO> lstProdutoFoneDTO) {
		
		for (DadosProdutoFoneDTO dadosProdutoFoneDTO : lstProdutoFoneDTO) {
			final ProdutoDTO produtoDTO = dadosProdutoFoneDTO.getProduto();
			produtoDTO.setIdTipoPonto("6");
			produtoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
			
			final CpPontoBean produtoPai = (CpPontoBean) this.createProduto(idProposta, produtoDTO);
			final List<CpPontoBean> produtosFilhos = new ArrayList<CpPontoBean>();
			
			inserirProduto(produtoPai, produtosFilhos);
		}
	}

	private CpPontoBean createProduto(final Long idProposta, final ProdutoDTO produtoDTO) {

		final CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setProposta(obterProposta(idProposta));
		cpPonto.setProduto(obterProduto(Long.valueOf(produtoDTO.getIdProduto())));
		cpPonto.setPromocao(obterPromocao(Integer.valueOf(produtoDTO.getIdPromocao())));
		cpPonto.setLocalizacao(obterLocalizacao(Long.valueOf(produtoDTO.getIdLocalizacao())));
		cpPonto.setPlanoPgto(obterPlanoPgto(Long.valueOf(produtoDTO.getIdPagamento())));
		cpPonto.setTipoPonto(obterTipoPonto(Long.valueOf(produtoDTO.getIdTipoPonto())));
		cpPonto.setCaracteristica(obterCaracteristica(Long.valueOf(produtoDTO.getIdCaracteristica())));
		cpPonto.setPrecoProd(new BigDecimal(produtoDTO.getPrecoMensal()));
		cpPonto.setVlPrimeiroMes(new BigDecimal(produtoDTO.getPrecoAdesao()));

		return cpPonto;
    }
	
	private CpPontoBean createFormaAquisicao(final Long idProposta, final FormaAquisicaoDTO formaAquisicaoDTO) {

		final CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setProposta(obterProposta(idProposta));
		cpPonto.setProduto(obterProduto(Long.valueOf(formaAquisicaoDTO.getIdProduto())));
		cpPonto.setPromocao(obterPromocao(Integer.valueOf(formaAquisicaoDTO.getIdPromocao())));
		cpPonto.setLocalizacao(obterLocalizacao(Long.valueOf(formaAquisicaoDTO.getIdLocalizacao())));
		cpPonto.setPlanoPgto(obterPlanoPgto(Long.valueOf(formaAquisicaoDTO.getIdPagamento())));
		cpPonto.setTipoPonto(obterTipoPonto(Long.valueOf(formaAquisicaoDTO.getIdTipoPonto())));
		cpPonto.setCaracteristica(obterCaracteristica(Long.valueOf(formaAquisicaoDTO.getIdCaracteristica())));
		cpPonto.setPrecoProd(new BigDecimal(formaAquisicaoDTO.getPrecoMensal()));
		cpPonto.setVlPrimeiroMes(new BigDecimal(formaAquisicaoDTO.getPrecoAdesao()));

		return cpPonto;
	}
	
	private CpPontoBean createServicoGravacaoDigital(final Long idProposta, final ServicoGravacaoDigitalDTO servicoGravacaoDigitalDTO) {
		
		final CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setProposta(obterProposta(idProposta));
		cpPonto.setProduto(obterProduto(Long.valueOf(servicoGravacaoDigitalDTO.getIdProduto())));
		cpPonto.setPromocao(obterPromocao(Integer.valueOf(servicoGravacaoDigitalDTO.getIdPromocao())));
		cpPonto.setLocalizacao(obterLocalizacao(Long.valueOf(servicoGravacaoDigitalDTO.getIdLocalizacao())));
		cpPonto.setPlanoPgto(obterPlanoPgto(Long.valueOf(servicoGravacaoDigitalDTO.getIdPagamento())));
		cpPonto.setTipoPonto(obterTipoPonto(Long.valueOf(servicoGravacaoDigitalDTO.getIdTipoPonto())));
		cpPonto.setCaracteristica(obterCaracteristica(Long.valueOf(servicoGravacaoDigitalDTO.getIdCaracteristica())));
		cpPonto.setPrecoProd(new BigDecimal(servicoGravacaoDigitalDTO.getPrecoMensal()));
		cpPonto.setVlPrimeiroMes(new BigDecimal(servicoGravacaoDigitalDTO.getPrecoAdesao()));

		return cpPonto;
	}
	
	private CpPontoBean createProvedor(final Long idProposta, final ProvedorDTO provedorDTO) {

		final CpPontoBean cpPonto = new CpPontoBean();
		cpPonto.setProposta(obterProposta(idProposta));
		cpPonto.setProduto(obterProduto(Long.valueOf(provedorDTO.getIdProduto())));
		cpPonto.setPromocao(obterPromocao(Integer.valueOf(provedorDTO.getIdPromocao())));
		cpPonto.setLocalizacao(obterLocalizacao(Long.valueOf(provedorDTO.getIdLocalizacao())));
		cpPonto.setPlanoPgto(obterPlanoPgto(Long.valueOf(provedorDTO.getIdPagamento())));
		cpPonto.setTipoPonto(obterTipoPonto(Long.valueOf(provedorDTO.getIdTipoPonto())));
		cpPonto.setCaracteristica(obterCaracteristica(Long.valueOf(provedorDTO.getIdCaracteristica())));
		cpPonto.setPrecoProd(new BigDecimal(provedorDTO.getPrecoMensal()));
		cpPonto.setVlPrimeiroMes(new BigDecimal(provedorDTO.getPrecoAdesao()));

		return cpPonto;
	}
	
	private Boolean hasFormaAquisicao(final ProdutoDTO produtoDTO) {
		Boolean resultado = Boolean.FALSE;
		
		produtoDTO.setIdCaracteristica(String.valueOf(obterIdCaracteristica(produtoDTO)));
		
		if (!produtoDTO.getIdCaracteristica().equals("0")) {
			resultado = Boolean.TRUE;
		}
		return resultado;
	}
	
	private Boolean hasServicoGravacaoDigital(final ProdutoDTO produtoDTO) {
		Boolean retorno = Boolean.FALSE;
		
		final DynamicBean dadosProduto = new DynamicBean(); 
		dadosProduto.put(ID_PRODUTO, produtoDTO.getIdProduto());
		
		final List<?> list = super.search("lstProdutoHDMax", dadosProduto);
		if (list.size() > 0) {
			retorno = Boolean.TRUE;
		}
		return retorno;
	}
	
	
	@SuppressWarnings(GeralConstants.UNCHECKED)
	private Boolean hasProdutoPrincipal(final Long idProposta) {
		Boolean resultado = Boolean.FALSE;
		
		final DynamicBean dadosProduto = new DynamicBean(); 
		dadosProduto.put(ID_PROPOSTA, idProposta);
		
		final List<Long> list = super.search("lstIdPontoPrincipal", dadosProduto);
		if (list.size() > 0) {
			resultado = Boolean.TRUE;
		}
		return resultado;
	}
	
    private void inserirProduto(final CpPontoBean produtoPai, final List<CpPontoBean> lstProdutoFilho) {

        this.getCurrentDAO().insert(produtoPai);
        this.getCurrentDAO().flush();
        for (final CpPontoBean produtoFilho : lstProdutoFilho) {
        	produtoFilho.setPontoPai(new CpPontoBean());
        	produtoFilho.getPontoPai().setIdPonto(produtoPai.getIdPonto());
            this.getCurrentDAO().insert(produtoFilho);
        }
    }
    
    @SuppressWarnings(GeralConstants.UNCHECKED)
    private void deleteAllProdutos(final Long idProposta) {

	    final String sql = "{call prod_jd.pgsms_manutencao_netcombo.prsms_exc_produtos_proposta(?,?,?)}";
	
	    final DynamicBean dadosProduto = new DynamicBean();
	    dadosProduto.put(ID_PROPOSTA, idProposta);
	
	    final List<Object> lstDados = super.search("lstPontoPrincipal", dadosProduto);
	
	    	if (!lstDados.isEmpty()) {
			    final Object[] lst = (Object[]) lstDados.get(0);
			
			    final Long idPonto = (Long) lst[0];
			    final Long idProduto = (Long) lst[1];
			    final BatchParameter[] parameters = { new BatchParameter(idProposta, Types.NUMERIC),
			    new BatchParameter(idPonto, Types.NUMERIC),
			    new BatchParameter(idProduto, Types.NUMERIC) };
			
			    this.getCurrentDAO().executeBatch(sql, parameters);
	    	}
    }

	
	@SuppressWarnings(GeralConstants.UNCHECKED)
	private void deleteLstProdutos(final String cidContrato, Long idProposta, final List<Long> lstIdProduto) {

		final String sql = "{call prod_jd.pgsms_manutencao_netcombo.prsms_exc_produtos_proposta(?,?,?)}";
		
		for (Long idProduto : lstIdProduto) {
			final DynamicBean dadosProdutos = new DynamicBean(); 
			dadosProdutos.put(ID_PROPOSTA, idProposta);
			dadosProdutos.put(ID_PRODUTO, idProduto);
			List<Long> lstPonto = (List<Long>) super.search("lstIdPontoByIdProduto", dadosProdutos);
			if (lstPonto.size() > 0) {
				for (Long idPonto : lstPonto) {
					final BatchParameter[] parameters = { new BatchParameter(idProposta, Types.NUMERIC),
														  new BatchParameter(idPonto, Types.NUMERIC),
							                              new BatchParameter(idProduto, Types.NUMERIC) };
					
					this.getCurrentDAO().executeBatch(sql, parameters);
					break;
				}
			}
		}
	}
	
	private List<DynamicBean> popularProdutosContratados(final List<?> lst) {

		final List<DynamicBean> lstProdutosContratados = new ArrayList<DynamicBean>();
		for (final Object object : lst) {
			final Object[] tmp = (Object[]) object;
			final DynamicBean bean = new DynamicBean();
			bean.set("idProduto", String.valueOf(tmp[0]));
			bean.set("descricaoProduto", tmp[1]);
			bean.set("planoProdutoServico", tmp[2]);
			bean.set("familia", tmp[3]);
			bean.set("velocidade", tmp[4]);
			bean.set("classificacao", tmp[5]);
			bean.set("tipoProduto", tmp[6]);
			bean.set("tipoPonto", tmp[7]);
			bean.set("dataInstalacaoProduto", tmp[8]);
			bean.set("situacaoInstalacaoProduto", tmp[9]);
			bean.set("linhaNegocio", tmp[10]);
			bean.set("faixaOcupacao", tmp[11]);
			bean.set("comercializacao", tmp[12]);
			bean.set("codigoEnderecavel", tmp[13]);
			bean.set("tipoTecnologia", tmp[14]);

			lstProdutosContratados.add(bean);
		}
		return lstProdutosContratados;
	}
	
	private CpPropostaBean obterProposta(final Long idProposta) {
		CpPropostaBean proposta = new CpPropostaBean();
		proposta.setIdProposta(idProposta);
        return (CpPropostaBean) super.findByPrimaryKey(proposta);
    }
	
	private SnProdutoBean obterProduto(final Long idProduto) {
		SnProdutoBean produto = new SnProdutoBean();
		produto.setIdProduto(idProduto);
        return (SnProdutoBean) super.findByPrimaryKey(produto);
    }
	
	private SnPromocaoBean obterPromocao(final Integer idPromocao) {
		SnPromocaoBean promocao = new SnPromocaoBean();
		promocao.setIdPromocao(idPromocao);
        return (SnPromocaoBean) super.findByPrimaryKey(promocao);
    }
	
	private SnLocalizacaoBean obterLocalizacao(final Long idLocalizacao) {
		SnLocalizacaoBean localizacao = new SnLocalizacaoBean();
		localizacao.setIdLocalizacao(idLocalizacao);
        return (SnLocalizacaoBean) super.findByPrimaryKey(localizacao);
    }
	
	private SnPlanoPgtoBean obterPlanoPgto(final Long idPlanoPgto) {
		SnPlanoPgtoBean planoPgto = new SnPlanoPgtoBean();
		planoPgto.setIdPlanoPgto(idPlanoPgto);
        return (SnPlanoPgtoBean) super.findByPrimaryKey(planoPgto);
    }
	
	private CpTipoPontoBean obterTipoPonto(final Long idTipoPonto) {
		CpTipoPontoBean tipoPonto = new CpTipoPontoBean();
		tipoPonto.setIdTipoPonto(idTipoPonto);
        return (CpTipoPontoBean) super.findByPrimaryKey(tipoPonto);
    }
	
	private SnCaracteristicaBean obterCaracteristica(final Long idCaracteristica) {
		SnCaracteristicaBean caracteristica = new SnCaracteristicaBean();
		caracteristica.setIdCaracteristica(idCaracteristica);
        return (SnCaracteristicaBean) super.findByPrimaryKey(caracteristica);
	}
	
	private CpCidadeOperadoraBean obterCidadeOperadora(final String cidContrato) {
		CpCidadeOperadoraBean cidadeOperadora = new CpCidadeOperadoraBean();
		cidadeOperadora.setIdCidade(cidContrato);
        return (CpCidadeOperadoraBean) super.findByPrimaryKey(cidadeOperadora);
	}

	private Long obterIdCaracteristica(final ProdutoDTO produtoDTO) {
		final SnProdutoBean snProduto = obterProduto(Long.valueOf(produtoDTO.getIdProduto()));
		final Long idCaracteristica = snProduto.getCaracteristica().getIdCaracteristica();
		return idCaracteristica;
	}
	
	private SnContratoBean obterContrato(final Long numContrato, final String cidContrato) {
		SnContratoKey compositekey = new SnContratoKey();
		compositekey.setCidContrato(cidContrato);
		compositekey.setNumContrato(numContrato);

		SnContratoBean contrato = new SnContratoBean();
		contrato.setCompositeKey(compositekey);
        return (SnContratoBean) super.findByPrimaryKey(contrato);
	}
}
