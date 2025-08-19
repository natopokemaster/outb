package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe que representa a chave primária da tabela sn_rel_ponto_extensao
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * 
 * <PRE>
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 * 
 * <P>
 * <B> Revision History: </B>
 * 
 * <PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * 21/10/2009 mcalegari      N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 * 
 * @author Mauro Cesar Calegari
 * @since 01/03/2010
 * @version $Revision: 1.5 $
 */
public class SnRelPontoExtensaoKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = 4701254586018772521L;
	
	private Long idExtensao;
	private Calendar dtIni;
	private Date dtFim;
	
	public SnRelPontoExtensaoKey(){
		super();
	}
	
	public SnRelPontoExtensaoKey(Long idExtensao, Calendar dtIni, Date dtFim){
		super();
		this.idExtensao = idExtensao;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
	}
	
	/**
	 * @return Returns the idExtensao.
	 * 
     * @hibernate.property
     *      column="id_extensao"
     *      type="long"
     */
	public Long getIdExtensao() {
		return idExtensao;
	}

	/**
	 * @param idExtensao
	 *            the idExtensao to set
	 */
	public void setIdExtensao(Long idExtensao) {
		this.idExtensao = idExtensao;
	}

	/**
	 * @return Returns the dtIni.
	 *
	 * @hibernate.property 
	 * 		column = "dt_ini"
	 * 		type="calendar"
	 */
	public Calendar getDtIni() {
		return dtIni;
	}

	/**
	 * @param dtIni
	 *            the dtIni to set
	 */
	public void setDtIni(Calendar dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @return Returns the dtFim.
	 *
	 * @hibernate.property 
	 * 		column = "dt_fim"
	 * 		type="date"
	 */
	public Date getDtFim() {
		return dtFim;
	}

	/**
	 * @param dtFim
	 *            the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public void buildKey(String value) {
		try {
			StringTokenizer tok = new StringTokenizer(value, "|");
			// SimpleDateFormat sdfDtIni = new SimpleDateFormat("dd/MM/yyyy HH:mm:SS");
			SimpleDateFormat sdfDtFim = new SimpleDateFormat("dd/MM/yyyy");
			this.idExtensao = Long.valueOf(tok.nextToken()); //new Long(tok.nextToken());
			//this.dtIni = sdfDtIni.parse(tok.nextToken());
			this.dtFim = sdfDtFim.parse(tok.nextToken());
		} catch (ParseException pe) {
			throw new BaseFailureException(pe);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtIni == null) ? 0 : dtIni.hashCode());
		result = prime * result
				+ ((idExtensao == null) ? 0 : idExtensao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	
		if (this != obj) {
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			
			if (!this.verificarData(obj) || !this.verifcarIdExtensao(obj)){
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * Metódo responsável em realizar a comparação entre as datas passada e armazenada.
	 * @param obj
	 * Objeto que contém os dados novos
	 * @return
	 * true para quando as datas forem iguais.
	 */
	private boolean verificarData(Object obj){

		SnRelPontoExtensaoKey other = (SnRelPontoExtensaoKey) obj;		
		if ( (dtFim == null || other.dtFim != null) || (!dtFim.equals(other.dtFim)) ) {
			return false;
		}

		if ((dtIni == null || other.dtIni != null) || (!dtIni.equals(other.dtIni))){
			return false;			
		}
		
		return true;
	}

	/**
	 * Metódo responsável em realizar a comparação entre os Id de Extensão passado e armazenado. 
	 * @param obj
	 * Objeto que contém os dados novos
	 * @return
	 * true para quando os Id´s forem iguais.
	 */
	private boolean verifcarIdExtensao(Object obj){

		SnRelPontoExtensaoKey other = (SnRelPontoExtensaoKey) obj;		
		if ( (idExtensao == null || other.idExtensao != null) || (!idExtensao.equals(other.idExtensao)) ) {
			return false;
		}
		
		return true;		
	}
	
}
