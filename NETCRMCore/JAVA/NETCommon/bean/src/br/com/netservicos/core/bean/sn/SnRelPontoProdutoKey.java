/*
 * Created on 20/10/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

/**
 * <p>
 * <b>Description: </b><br>
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/10/2010
 * @version 1.0
 */
public class SnRelPontoProdutoKey implements Serializable {

    private static final long serialVersionUID = 7317571145595689405L;

    private String cidContrato;
    private Long numContrato;
    private SnPontoContrBean pontoContrato;
    private SnProdutoBean produto;

    /**
     * Construtor Padrão. 
     */
    public SnRelPontoProdutoKey() {
        super();
    }

    /**
     * @param pContrato
     * @param pNumContrato
     * @param pCidContrato
     * @param pProduto
     */
    public SnRelPontoProdutoKey(final SnPontoContrBean pContrato, final Long pNumContrato,
        final String pCidContrato, final SnProdutoBean pProduto) {
        this.numContrato = pNumContrato;
        this.cidContrato = pCidContrato;
        this.pontoContrato = pContrato;
        this.produto = pProduto;
    }

    /**
     * @return Returns the cidContrato.
     * @hibernate.property column = "cid_contrato" insert = "false" update = "false"
     */
    public String getCidContrato() {
        return this.cidContrato;
    }

    /**
     * @return Returns the numContrato.
     * @hibernate.property column = "num_contrato" insert = "false" update = "false"
     */
    public Long getNumContrato() {
        return this.numContrato;
    }

    /**
     * @hibernate.many-to-one column="id_ponto" cascade="none" not-null="true"
     * @return Returns the pontoContrato.
     */
    public SnPontoContrBean getPontoContrato() {
        return this.pontoContrato;
    }

    /**
     * @hibernate.many-to-one column="id_produto" cascade="none" not-null="true"
     * @return Returns the produto.
     */
    public SnProdutoBean getProduto() {
        return this.produto;
    }

    /**
     * @param pCidContrato
     *        The cidContrato to set.
     */
    public void setCidContrato(final String pCidContrato) {
        this.cidContrato = pCidContrato;
    }

    /**
     * @param pNumContrato
     *        The numContrato to set.
     */
    public void setNumContrato(final Long pNumContrato) {
        this.numContrato = pNumContrato;
    }

    /**
     * @param pPontoContrato
     *        The pontoContrato to set.
     */
    public void setPontoContrato(final SnPontoContrBean pPontoContrato) {
        this.pontoContrato = pPontoContrato;
    }

    /**
     * @param pProduto
     *        The produto to set.
     */
    public void setProduto(final SnProdutoBean pProduto) {
        this.produto = pProduto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result =
            prime * result + ((this.getPontoContrato() == null) ? 0 : this.getPontoContrato().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        boolean test = super.equals(obj);
        if (obj instanceof SnRelPontoProdutoKey) {
            final SnRelPontoProdutoKey key = (SnRelPontoProdutoKey) obj;

            test =
                this.getPontoContrato().getIdPonto().equals(key.getPontoContrato().getIdPonto())
                    && this.getProduto().getIdProduto().equals(key.getProduto().getIdProduto());
        }
        return test;
    }
}
