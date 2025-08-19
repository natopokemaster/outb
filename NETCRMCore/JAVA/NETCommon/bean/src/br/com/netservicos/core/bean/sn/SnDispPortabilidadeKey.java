package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Key que representa a chave composta para a
 *  tabela sn_disp_portabilidade.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 * =============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 *
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * =============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ---------------------------
 * 18/02/2008 Tiago Wenceslau N/A      Entidades      Created.
 * 18/02/2008 Tiago Wenceslau 1.0      Entidades      Development.
 * =============================================================================
 * </PRE>
 *
 *
 */

public class SnDispPortabilidadeKey implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 924842156321471434L;

    /**
     *
     */
    private String dddTelefoneVoip;

    /**
     *
     */
    private String numTelefoneVoip;

    /**
     *
     */
    public SnDispPortabilidadeKey() {
    }

    /**
     * @param dddTelefoneVoip String
     * @param numTelefoneVoip String
     */
    public SnDispPortabilidadeKey(String dddTelefoneVoip,
                                  String numTelefoneVoip) {
        this.dddTelefoneVoip = dddTelefoneVoip;
        this.numTelefoneVoip = numTelefoneVoip;
    }

    /**
     * @return Returns the dddTelefoneVoip.
     * @hibernate.property column = "ddd_telefone_voip"
     *
     */
    public String getDddTelefoneVoip() {
        return dddTelefoneVoip;
    }

    /**
     *
     * @param dddTelefoneVoip The dddTelefoneVoip to set.
     */
    public void setDddTelefoneVoip(String dddTelefoneVoip) {
        this.dddTelefoneVoip = dddTelefoneVoip;
    }

    /**
     * @return Returns the numTelefoneVoip.
     * @hibernate.property column = "num_telefone_voip"
     *
     */
    public String getNumTelefoneVoip() {
        return numTelefoneVoip;
    }

    /**
     *
     * @param numTelefoneVoip The numTelefoneVoip to set.
     */
    public void setNumTelefoneVoip(String numTelefoneVoip) {
        this.numTelefoneVoip = numTelefoneVoip;
    }

    /**
     * @param key Object
     * @return boolean
     */
    public boolean equals(Object key) {
        if (key instanceof SnDispPortabilidadeKey) {
            SnDispPortabilidadeKey comp = (SnDispPortabilidadeKey) key;
            return this.getDddTelefoneVoip().equals(comp.getDddTelefoneVoip())
                && this.getNumTelefoneVoip().equals(comp.getNumTelefoneVoip());
        } else {
            return super.equals(key);
        }
    }

    /**
     * @return int
     */
    public int hashCode() {
        int value = (getDddTelefoneVoip().hashCode()
                    + getNumTelefoneVoip().hashCode() * 2);
        return (int) (value ^ (value >>> 32));
    }
}
