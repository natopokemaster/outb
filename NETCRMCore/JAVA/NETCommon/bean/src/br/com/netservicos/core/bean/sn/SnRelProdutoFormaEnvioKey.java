package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

import br.com.netservicos.core.bean.av.AvFormaEnvioBean;
import br.com.netservicos.framework.core.bean.BaseCompositeKey;


/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Key que representa a chave composta para a tabela sn_rel_produto_forma_envio.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                               Prior
 * Date       By                 Version  Project/CSR     Description
 * ---------- ------------------ -------- --------------  -----------------------
 * 02/04/2011 Leonardo Sugahara    N/A    Aviso de Compra Created.
 * ==============================================================================
 * </PRE>
 * 
 * 
 */
public class SnRelProdutoFormaEnvioKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = 1L;

	/**
	 * Entidade que representa a tabela AV_FORMA_ENVIO.
	 */
	private AvFormaEnvioBean formaEnvioBean;
	
	/**
	 * ID_PRODUTO_FORMA_ENVIO NUMBER(10) N. Identificador produto x forma de envio. 
	 */
	private Long idProdutoFormaEnvio;
	
	public SnRelProdutoFormaEnvioKey(){
	}
	
	public SnRelProdutoFormaEnvioKey(AvFormaEnvioBean formaEnvioBean, Long idProdutoFormaEnvio) {
		super();
		this.formaEnvioBean = formaEnvioBean;
		this.idProdutoFormaEnvio = idProdutoFormaEnvio;
	}
	
	/**
	 * Recupera a entidade AvFormaEnvioBean
	 * 
	 * @return the produtoFormaEnvio
	 * @hibernate.many-to-one class="br.com.netservicos.core.bean.av.AvFormaEnvioBean"
     *                        column="ID_FORMA_ENVIO" 
     *                        not-null="false"
     */
	public AvFormaEnvioBean getFormaEnvioBean() {
		return formaEnvioBean;
	}
	
	/**
	 * @param formaEnvioBean The formaEnvioBean to set.
	 */
	public void setFormaEnvioBean(AvFormaEnvioBean formaEnvioBean) {
		this.formaEnvioBean = formaEnvioBean;
	}
	
	/**
	 * Recupera o identificador do produto x forma de envio.
	 * 
	 * @return Returns the idProdutoFormaEnvio.
	 *
	 * @hibernate.property 
	 * 		column = "id_produto_forma_envio"
	 * 		type="long"
	 */
	public Long getIdProdutoFormaEnvio() {
		return idProdutoFormaEnvio;
	}
	
	/**
	 * @param idProdutoFormaEnvio The idProdutoFormaEnvio to set.
	 */
	public void setIdProdutoFormaEnvio(Long idProdutoFormaEnvio) {
		this.idProdutoFormaEnvio = idProdutoFormaEnvio;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object key) {
        if (key instanceof SnRelProdutoFormaEnvioKey) {
        	SnRelProdutoFormaEnvioKey comp = (SnRelProdutoFormaEnvioKey) key;
            return this.getFormaEnvioBean().equals(comp.getFormaEnvioBean())
                    && this.getIdProdutoFormaEnvio().equals(comp.getIdProdutoFormaEnvio());
        } else {
            return super.equals(key);
        }
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result
                + ((formaEnvioBean == null) ? 0 : formaEnvioBean.hashCode());
        result = prime * result + ((idProdutoFormaEnvio == null) ? 0 : idProdutoFormaEnvio.hashCode());
       
        return result;
	}
	
	/* (non-Javadoc)
	 * @see br.com.netservicos.framework.core.bean.BaseCompositeKey#buildKey(java.lang.String)
	 */
	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}
	
}
