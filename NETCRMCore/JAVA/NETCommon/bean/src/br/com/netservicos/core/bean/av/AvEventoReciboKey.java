package br.com.netservicos.core.bean.av;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa as chaves primárias da tabela AV_EVENTO_RECIBO.
 * </P>
 * <B> Issues : <BR>
 *
 *
 */
public class AvEventoReciboKey implements Serializable, BaseCompositeKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Representa a entidade da tabela AV_RECIBO_RELACIONAMENTO.
	 */
	private AvReciboRelacionamentoBean reciboRelacionamento;
	
	/**
	 * TP_EVENTO VARCHAR2(20) N. Tipo do evento do recibo.
	 */
	private String tpEvento;
	
	/**
	 * TP_EVENTO NUMBER(10) N. Identificador do tipo do evento.
	 */
	private Long idEvento;

	/**
	 * Recupera o entidade AvReciboRelacionamentoBean.
	 * 
	 * @return Returns the Recibo.
	 * 
	 * @hibernate.many-to-one 
	 *                        class="br.com.netservicos.core.bean.av.AvReciboRelacionamentoBean"
	 *                        column="ID_RECIBO_RELACIONAMENTO" cascade="none"
	 *                        not-null="false"
	 */
	public final AvReciboRelacionamentoBean getReciboRelacionamento() {
		return this.reciboRelacionamento;
	}

	/**
	 * @param pReciboRel
	 *            the reciboRelacionamento to set
	 */
	public final void setReciboRelacionamento(
			final AvReciboRelacionamentoBean pReciboRel) {
		this.reciboRelacionamento = pReciboRel;
	}

	/**
	 * Recupera o tipo do evento do recibo.
	 * 
	 * @return the tpEvento
	 * 
	 * @hibernate.property column = "TP_EVENTO" type="string"
	 */
	public String getTpEvento() {
		return tpEvento;
	}

	/**
	 * 
	 * @param tpEvento
	 */
	public void setTpEvento(String tpEvento) {
		this.tpEvento = tpEvento;
	}

	/**
	 * Recupera o identificador do evento do recibo.
	 * 
	 * @return the idEvento
	 * 
	 * @hibernate.property column = "ID_EVENTO" type="long"
	 */
	public Long getIdEvento() {
		return idEvento;
	}

	/**
	 * 
	 * @param idEvento
	 */
	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idEvento == null) ? 0 : idEvento.hashCode());
		result = prime
				* result
				+ ((reciboRelacionamento.getIdReciboRelacionamento() == null) ? 0
						: reciboRelacionamento.getIdReciboRelacionamento()
								.hashCode());
		result = prime * result
				+ ((tpEvento == null) ? 0 : tpEvento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvEventoReciboKey other = (AvEventoReciboKey) obj;
		if (idEvento == null) {
			if (other.idEvento != null)
				return false;
		} else if (!idEvento.equals(other.idEvento))
			return false;
		if (reciboRelacionamento.getIdReciboRelacionamento() == null) {
			if (other.reciboRelacionamento.getIdReciboRelacionamento() != null)
				return false;
		} else if (!reciboRelacionamento.getIdReciboRelacionamento().equals(
				other.reciboRelacionamento.getIdReciboRelacionamento()))
			return false;
		if (tpEvento == null) {
			if (other.tpEvento != null)
				return false;
		} else if (!tpEvento.equals(other.tpEvento))
			return false;
		return true;
	}

	/**
	 * @param pValue
	 */
	public void buildKey(final String pValue) {

		final StringTokenizer tok = new StringTokenizer(pValue, "|");
		try {
			this.reciboRelacionamento.setIdReciboRelacionamento(Long
					.valueOf(tok.nextToken()));
			this.tpEvento = (tok.nextToken());
			this.idEvento = Long.valueOf(tok.nextToken());
		} catch (Exception exception) {
			throw new BaseFailureException(exception);
		}
	}
}
