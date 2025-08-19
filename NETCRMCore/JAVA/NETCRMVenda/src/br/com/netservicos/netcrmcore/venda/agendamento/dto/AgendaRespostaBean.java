package br.com.netservicos.netcrmcore.venda.agendamento.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.netservicos.core.bean.sn.SnOsBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.PeriodoBean;

public class AgendaRespostaBean implements Serializable {

	private List<SnOsBean> listaOrdensCampo;

	private List<PeriodoBean> periodos;
	
	private String agendaArea;
	
	private String agendaClasse;
	
	private String agendaSegmento;
	
	public List<PeriodoBean> getPeriodos() { 
		if(periodos == null){
			periodos = new ArrayList<PeriodoBean>();
		}
		
		return periodos;
	}
	
	public void setPeriodo(ArrayList<PeriodoBean> listPeeriodo) {
		periodos = listPeeriodo;
		
	}
	
	public boolean adicionarNovoPeriodoBean(final PeriodoBean periodo) {
		if(periodos == null){
			periodos = new ArrayList<PeriodoBean>();
		}
		
		return this.periodos.add(periodo);
	}
	
	
	
	/**
	 * Melhor usar apenas o adicionarNovoPeriodoBean
	 * 
	 * @param periodos
	public void setPeriodos(List periodos) {
		this.periodos = periodos;
	}*/

	public String getAgendaArea() {
		return agendaArea;
	}

	public void setAgendaArea(final String agendaArea) {
		this.agendaArea = agendaArea;
	}

	public String getAgendaClasse() {
		return agendaClasse;
	}

	public void setAgendaClasse(final String agendaClasse) {
		this.agendaClasse = agendaClasse;
	}

	public String getAgendaSegmento() {
		return agendaSegmento;
	}

	public void setAgendaSegmento(final String agendaSegmento) {
		this.agendaSegmento = agendaSegmento;
	}

	public int getMinutosRequeridos() {
		return minutosRequeridos;
	}

	public void setMinutosRequeridos(final int minutosRequeridos) {
		this.minutosRequeridos = minutosRequeridos;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public boolean adicionarNovaOrdemCampo(final SnOsBean osBean) {
		if (this.listaOrdensCampo == null) {
			this.listaOrdensCampo = new ArrayList<SnOsBean>();
		} else {
			if (!this.listaOrdensCampo.contains(osBean)) {
				this.listaOrdensCampo.add(osBean);
			}
		}
		return listaOrdensCampo.add(osBean);
	}
	
	public List<SnOsBean> getListaOrdensCampo() {
		return listaOrdensCampo;
	}

	private int minutosRequeridos;
	
	private static final long serialVersionUID = 6399886557640479530L;
	
}