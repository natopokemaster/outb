package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto;

import java.util.ArrayList;
import java.util.List;

import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoVirtuaDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoVirtuaDTO;
import br.com.netservicos.netcrmcore.produto.dto.FormaAquisicaoDTO;
import br.com.netservicos.netcrmcore.produto.dto.ProdutoDTO;
import br.com.netservicos.netcrmcore.produto.dto.ProvedorDTO;
import br.com.netservicos.netcrmcore.produto.dto.ServicoGravacaoDigitalDTO;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoFoneType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoTvType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoVirtuaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoFoneType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoTvType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoVirtuaType;

public class ManterProdutoHelper {
	
	/**
	 * Construtor Padrão.
	 */
	private ManterProdutoHelper(){
	}
	
	public static List<DadosProdutoTvDTO> copyPropertiesProdutoTV(final DadosProdutoTvType[] lstProdutoTvType) {
		final List<DadosProdutoTvDTO> lstDadosProdutoTvDTO = new ArrayList<DadosProdutoTvDTO>();
		for (DadosProdutoTvType dadosProdutoTvType : lstProdutoTvType) {
			DadosProdutoTvDTO dadosProdutoTvDTO = new DadosProdutoTvDTO();
			lstDadosProdutoTvDTO.add((DadosProdutoTvDTO) copyPropertiesTV(dadosProdutoTvDTO, dadosProdutoTvType));
		}
		return lstDadosProdutoTvDTO;
	}
	
	public static List<DadosProdutoVirtuaDTO> copyPropertiesProdutoVirtua(final DadosProdutoVirtuaType[] lstProdutoVirtuaType) {
		final List<DadosProdutoVirtuaDTO> lstDadosProdutoVirtuaDTO = new ArrayList<DadosProdutoVirtuaDTO>();
		for (DadosProdutoVirtuaType dadosProdutoVirtuaType : lstProdutoVirtuaType) {
			DadosProdutoVirtuaDTO dadosProdutoVirtuaDTO = new DadosProdutoVirtuaDTO();
			lstDadosProdutoVirtuaDTO.add((DadosProdutoVirtuaDTO) copyPropertiesVirtua(dadosProdutoVirtuaDTO, dadosProdutoVirtuaType));
		}
		return lstDadosProdutoVirtuaDTO;
	}

	public static List<DadosProdutoFoneDTO> copyPropertiesProdutoFone(final DadosProdutoFoneType[] lstProdutoFoneType) {
		final List<DadosProdutoFoneDTO> lstDadosProdutoFoneDTO = new ArrayList<DadosProdutoFoneDTO>();
		for (DadosProdutoFoneType dadosProdutoFoneType : lstProdutoFoneType) {
			DadosProdutoFoneDTO dadosProdutoFoneDTO = new DadosProdutoFoneDTO();
			lstDadosProdutoFoneDTO.add((DadosProdutoFoneDTO) copyPropertiesFone(dadosProdutoFoneDTO, dadosProdutoFoneType));
		}
		return lstDadosProdutoFoneDTO;
	}
	
	public static List<DadosAgregadoTvDTO> copyPropertiesAgregadoTV(final AgregadoTvType[] lstAgregadoTvType) {
		final List<DadosAgregadoTvDTO> lstDadosAgregadoTvDTO = new ArrayList<DadosAgregadoTvDTO>();
		for (AgregadoTvType agregadoTvType : lstAgregadoTvType) {
			DadosAgregadoTvDTO agregadoTvDTO = new DadosAgregadoTvDTO();
			lstDadosAgregadoTvDTO.add((DadosAgregadoTvDTO) GeralUtil.copyProperties(agregadoTvDTO, agregadoTvType));
		}
		return lstDadosAgregadoTvDTO;
	}

	public static List<DadosAgregadoVirtuaDTO> copyPropertiesAgregadoVirtua(final AgregadoVirtuaType[] lstAgregadoVirtuaType) {
		final List<DadosAgregadoVirtuaDTO> lstDadosAgregadoVirtuaDTO = new ArrayList<DadosAgregadoVirtuaDTO>();
		for (AgregadoVirtuaType agregadoVirtuaType : lstAgregadoVirtuaType) {
			DadosAgregadoVirtuaDTO agregadoVirtuaDTO = new DadosAgregadoVirtuaDTO();
			lstDadosAgregadoVirtuaDTO.add((DadosAgregadoVirtuaDTO) GeralUtil.copyProperties(agregadoVirtuaDTO, agregadoVirtuaType));
		}
		return lstDadosAgregadoVirtuaDTO;
	}
	
	public static List<DadosAgregadoFoneDTO> copyPropertiesAgregadoFone(final AgregadoFoneType[] lstAgregadoFoneType) {
		final List<DadosAgregadoFoneDTO> lstDadosAgregadoFoneDTO = new ArrayList<DadosAgregadoFoneDTO>();
		for (AgregadoFoneType agregadoFoneType : lstAgregadoFoneType) {
			DadosAgregadoFoneDTO agregadoFoneDTO = new DadosAgregadoFoneDTO();
			agregadoFoneDTO =  (DadosAgregadoFoneDTO)GeralUtil.copyProperties(agregadoFoneDTO, agregadoFoneType);			
			lstDadosAgregadoFoneDTO.add(agregadoFoneDTO);
			    
		}
		return lstDadosAgregadoFoneDTO;
	}
	
	public static List<Long> copyPropertiesLong(final Long[] listOrigem) {
		final List<Long> listDestino = new ArrayList<Long>();
		for (Long value : listOrigem) {
			listDestino.add(value);
		}
		return listDestino;
	}
	
	private static DadosProdutoTvDTO copyPropertiesTV(final DadosProdutoTvDTO dadosProdutoTvDTO, final DadosProdutoTvType dadosProdutoTvType) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		FormaAquisicaoDTO formaAquisicaoDTO = new FormaAquisicaoDTO();
		ServicoGravacaoDigitalDTO servicoGravacaoDigitalDTO = new ServicoGravacaoDigitalDTO();
		
		GeralUtil.copyProperties(produtoDTO, dadosProdutoTvType.getProduto());
		GeralUtil.copyProperties(formaAquisicaoDTO, dadosProdutoTvType.getFormaAquisicao());
		GeralUtil.copyProperties(servicoGravacaoDigitalDTO, dadosProdutoTvType.getServicoGravacaoDigital());
		
		dadosProdutoTvDTO.setProduto(produtoDTO);
		dadosProdutoTvDTO.setFormaAquisicao(formaAquisicaoDTO);
		dadosProdutoTvDTO.setServicoGravacaoDigital(servicoGravacaoDigitalDTO);

		return dadosProdutoTvDTO;
	}
	
	private static DadosProdutoVirtuaDTO copyPropertiesVirtua(final DadosProdutoVirtuaDTO dadosProdutoVirtuaDTO, final DadosProdutoVirtuaType dadosProdutoVirtuaType) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		FormaAquisicaoDTO formaAquisicaoDTO = new FormaAquisicaoDTO();
		ProvedorDTO provedorDTO = new ProvedorDTO();
		
		GeralUtil.copyProperties(produtoDTO, dadosProdutoVirtuaType.getProduto());
		GeralUtil.copyProperties(formaAquisicaoDTO, dadosProdutoVirtuaType.getFormaAquisicao());
		GeralUtil.copyProperties(provedorDTO, dadosProdutoVirtuaType.getProvedor());
		
		dadosProdutoVirtuaDTO.setProduto(produtoDTO);
		dadosProdutoVirtuaDTO.setFormaAquisicao(formaAquisicaoDTO);
		dadosProdutoVirtuaDTO.setProvedor(provedorDTO);

		return dadosProdutoVirtuaDTO;
	}
	
	private static DadosProdutoFoneDTO copyPropertiesFone(final DadosProdutoFoneDTO dadosProdutoFoneDTO, final DadosProdutoFoneType dadosProdutoFoneType) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		GeralUtil.copyProperties(produtoDTO, dadosProdutoFoneType.getProduto());
		
		dadosProdutoFoneDTO.setProduto(produtoDTO);
		
		return dadosProdutoFoneDTO;
	}
}
