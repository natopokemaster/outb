/*
 * Created on 31/03/2011
 * Project : NETGESCOMCommon
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.av;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela MOTIVO_REENVIO.
 * </P>
 * <B> Issues : <BR>
 *
 * @since 26/05/2011
 * @hibernate.class table = "av_layout_conteudo" dynamic-insert = "true"
 *                  dynamic-update = "true" lazy="true"
 *
 */
public class AvLayoutConteudoBean extends DomainBean{

	private static final long serialVersionUID = 3505165519994170688L;

	public static final String COMPOSITE_KEY = "compositeKey";

	/**
	 *  TP_CONTEUDO CHAR(1) NOT NULL, Tipo do conteudo do layout.
	 */
	private String tipoConteudo;

	/**
	 *  DS_CONTEUDO VARCHAR2(4000) NOT NULL, Descricao do conteudo do layout.
	 */
	private String conteudo;

	/**
	 *  TP_CONDICAO_CONTEUDO CHAR(1) NOT NULL, Tipo da condicao do conteudo.
	 */
	private String tipoCondicao;

	/**
	 *  DS_CONDICAO_CONTEUDO VARCHAR2(4000), Descricao da condicao do conteudo.
	 */
	private String condicao;

	/**
	 *  DH_ALTERACAO DATE NOT NULL, Data da ultima alteracao.
	 */
	private Date dtUltimaAlteracao;

	/**
	 * Entidade composta com as chaves primárias da tabela AV_LAYOUT_CONTEUDO.
	 */
	private AvLayoutConteudoKey compositeKey;

	/**
	 * Contrutor Padrao.
	 */
	public AvLayoutConteudoBean(){
		super(COMPOSITE_KEY);
	}
	
	/**
	 * 
	 * @param compositeKey
	 */
	public void setCompositeKey(final AvLayoutConteudoKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * Retorna o compositeKey.
	 * @hibernate.id type="composite"
	 * @return AvLayoutConteudoKey
	 */
	public AvLayoutConteudoKey getCompositeKey() {
		return this.compositeKey;
	}


	/**
	 * Recupera o tipo de conteudo.
	 * 
	 * @return the tipoConteudo
	 * @hibernate.property column = "TP_CONTEUDO"
	 */
	public String getTipoConteudo() {
		return this.tipoConteudo;
	}

	/**
	 * @param tipoConteudo
	 *            the tipoConteudo to set
	 */
	public void setTipoConteudo(final String tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	/**
	 * Recupera a descricao do conteudo.
	 * 
	 * @return the conteudo
	 * @hibernate.property column = "DS_CONTEUDO"
	 */
	public String getConteudo() {
		return this.conteudo;
	}

	/**
	 * @param conteudo
	 *            the conteudo to set
	 */
	public void setConteudo(final String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * Recupera o tipo de condicao de conteudo.
	 * 
	 * @return the tipoCondicao
	 * @hibernate.property column = "TP_CONDICAO_CONTEUDO"
	 */
	public String getTipoCondicao() {
		return this.tipoCondicao;
	}

	/**
	 * @param tipoCondicao
	 *            the tipoCondicao to set
	 */
	public void setTipoCondicao(final String tipoCondicao) {
		this.tipoCondicao = tipoCondicao;
	}

	/**
	 * Recupera a descricao condicao do conteudo.
	 * 
	 * @return the condicao
	 * @hibernate.property column = "DS_CONDICAO_CONTEUDO"
	 */
	public String getCondicao() {
		return this.condicao;
	}

	/**
	 * @param condicao
	 *            the condicao to set
	 *
	 */
	public void setCondicao(final String condicao) {
		this.condicao = condicao;
	}

	/**
	 * Recupera a data da ultima alteracao.
	 * 
	 * @return the dtUltimaAlteracao
	 * @hibernate.property column = "DH_ALTERACAO"
	 */
	public Date getDtUltimaAlteracao() {
		return this.dtUltimaAlteracao;
	}

	/**
	 * @param dtUltimaAlteracao
	 *            the dtUltimaAlteracao to set
	 */
	public void setDtUltimaAlteracao(final Date dtUltimaAlteracao) {
		this.dtUltimaAlteracao = dtUltimaAlteracao;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.compositeKey == null) ? 0 : this.compositeKey.hashCode());
		result = prime * result
				+ ((this.condicao == null) ? 0 : this.condicao.hashCode());
		result = prime * result
				+ ((this.conteudo == null) ? 0 : this.conteudo.hashCode());
		result = prime
				* result
				+ ((this.dtUltimaAlteracao == null) ? 0 : this.dtUltimaAlteracao
						.hashCode());
		result = prime * result
				+ ((this.tipoCondicao == null) ? 0 : this.tipoCondicao.hashCode());
		result = prime * result
				+ ((this.tipoConteudo == null) ? 0 : this.tipoConteudo.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AvLayoutConteudoBean other = (AvLayoutConteudoBean) obj;
		if (this.compositeKey == null) {
			if (other.compositeKey != null) {
				return false;
			}
		} else if (!this.compositeKey.equals(other.compositeKey)) {
			return false;
		}
		if (this.condicao == null) {
			if (other.condicao != null) {
				return false;
			}
		} else if (!this.condicao.equals(other.condicao)) {
			return false;
		}
		if (this.conteudo == null) {
			if (other.conteudo != null) {
				return false;
			}
		} else if (!this.conteudo.equals(other.conteudo)) {
			return false;
		}
		if (this.dtUltimaAlteracao == null) {
			if (other.dtUltimaAlteracao != null) {
				return false;
			}
		} else if (!this.dtUltimaAlteracao.equals(other.dtUltimaAlteracao)) {
			return false;
		}
		if (this.tipoCondicao == null) {
			if (other.tipoCondicao != null) {
				return false;
			}
		} else if (!this.tipoCondicao.equals(other.tipoCondicao)) {
			return false;
		}
		if (this.tipoConteudo == null) {
			if (other.tipoConteudo != null) {
				return false;
			}
		} else if (!this.tipoConteudo.equals(other.tipoConteudo)) {
			return false;
		}
		return true;
	}


}
