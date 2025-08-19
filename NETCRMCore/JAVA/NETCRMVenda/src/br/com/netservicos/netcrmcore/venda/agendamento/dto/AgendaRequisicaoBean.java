package br.com.netservicos.netcrmcore.venda.agendamento.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import br.com.netservicos.netcrmcore.venda.agendamento.dto.PeriodoBean;

public class AgendaRequisicaoBean implements Serializable {

	private static final long serialVersionUID = -8995227283217788464L;

	private Integer idTipoCliente;
	private String cidContrato;
	private XMLGregorianCalendar dataInicial;
	private Integer numeroDias;
	private Integer emergenciaFlag;
	private String encaixeSenha;
	private List<Entidade> entidades;
	private PeriodoBean periodo;
	private Integer idMotivoReag;

	private Integer flagForaPadrao;
	private Integer flagConvenienciaAssinante;

	private Boolean reagendamento;

	public AgendaRequisicaoBean() {
		super();
	}

	public AgendaRequisicaoBean(final Integer idTipoCliente, final String cidContrato,
			final XMLGregorianCalendar dataInicial, final Integer numeroDias, final Integer emergenciaFlag,
			final String encaixeSenha, final List<Entidade> entidades, final PeriodoBean periodo,
			final Integer idMotivoReag) {
		this.idTipoCliente = idTipoCliente;
		this.cidContrato = cidContrato;
		this.dataInicial = dataInicial;
		this.numeroDias = numeroDias;
		this.emergenciaFlag = emergenciaFlag;
		this.encaixeSenha = encaixeSenha;
		this.entidades = entidades;
		this.periodo = periodo;
		this.idMotivoReag = idMotivoReag;

	}

	public Boolean isReagendamento() {
		return reagendamento;
	}

	public void setReagendamento(Boolean reagendamento) {
		this.reagendamento = reagendamento;
	}

	public Integer getFlagForaPadrao() {
		return flagForaPadrao;
	}

	public void setFlagForaPadrao(Integer flagForaPadrao) {
		this.flagForaPadrao = flagForaPadrao;
	}

	public Integer getFlagConvenienciaAssinante() {
		return flagConvenienciaAssinante;
	}

	public void setFlagConvenienciaAssinante(Integer flagConvenienciaAssinante) {
		this.flagConvenienciaAssinante = flagConvenienciaAssinante;
	}

	public Integer getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(Integer idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}

	public String getCidContrato() {
		return cidContrato;
	}

	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	public XMLGregorianCalendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(XMLGregorianCalendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Integer getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(Integer numeroDias) {
		this.numeroDias = numeroDias;
	}

	public Integer getEmergenciaFlag() {
		return emergenciaFlag;
	}

	public void setEmergenciaFlag(Integer emergenciaFlag) {
		this.emergenciaFlag = emergenciaFlag;
	}

	public String getEncaixeSenha() {
		return encaixeSenha;
	}

	public void setEncaixeSenha(String encaixeSenha) {
		this.encaixeSenha = encaixeSenha;
	}

	public List<Entidade> getEntidades() {
		if (entidades == null) {
			entidades = new ArrayList<Entidade>();
		}
		return entidades;
	}

	public PeriodoBean getPeriodoBean() {
		return periodo;
	}

	public void setPeriodoBean(PeriodoBean periodo) {
		this.periodo = periodo;
	}

	public Integer getIdMotivoReagendamento() {
		return idMotivoReag;
	}

	public void setIdMotivoReagendamento(Integer idMotivoReagendamento) {
		idMotivoReag = idMotivoReagendamento;
	}

	public Boolean adicionarNovaEntidade(Entidade entidade) {
		if (entidades == null) {
			entidades = new ArrayList<Entidade>();
		}
		return entidades.add(entidade);
	}

	public Boolean adicionarNovaEntidade(String idEntidade, String idTipoEntidade, Integer cobrarOSimprodutiva,
			Integer codigoOrigem, String observacao, String acao) {

		if (entidades == null) {
			entidades = new ArrayList<Entidade>();
		}
		return entidades.add(new Entidade(idEntidade, idTipoEntidade, cobrarOSimprodutiva, codigoOrigem,
				observacao, acao));
	}

	public class Entidade {

		private String idEntidade;
		private String idTipoEntidade;
		private Integer cobrarOSimprodutiva;
		private Integer codigoOrigem;
		private String observacao;
		private String acao;

		public Entidade() {
		}

		public Entidade(String idEntidade, String idTipoEntidade, Integer cobrarOSimprodutiva,
				Integer codigoOrigem, String observacao, String acao) {
			super();
			this.idEntidade = idEntidade;
			this.idTipoEntidade = idTipoEntidade;
			this.cobrarOSimprodutiva = cobrarOSimprodutiva;
			this.codigoOrigem = codigoOrigem;
			this.observacao = observacao;
			this.acao = acao;
		}

		public String getAcao() {
			return acao;
		}

		public void setAcao(String acao) {
			this.acao = acao;
		}

		public String getIdEntidade() {
			return idEntidade;
		}

		public void setIdEntidade(String idEntidade) {
			this.idEntidade = idEntidade;
		}

		public String getIdTipoEntidade() {
			return idTipoEntidade;
		}

		public void setIdTipoEntidade(String idTipoEntidade) {
			this.idTipoEntidade = idTipoEntidade;
		}

		public Integer getCobrarOSimprodutiva() {
			return cobrarOSimprodutiva;
		}

		public void setCobrarOSimprodutiva(Integer cobrarOSimprodutiva) {
			this.cobrarOSimprodutiva = cobrarOSimprodutiva;
		}

		public Integer getCodigoOrigem() {
			return codigoOrigem;
		}

		public void setCodigoOrigem(Integer codigoOrigem) {
			this.codigoOrigem = codigoOrigem;
		}

		public String getObservacao() {
			return observacao;
		}

		public void setObservacao(String observacao) {
			this.observacao = observacao;
		}

	}
}