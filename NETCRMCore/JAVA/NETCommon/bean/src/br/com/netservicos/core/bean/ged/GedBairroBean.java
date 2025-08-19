/*
 * Created on 25/08/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.ged;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
*   Classe Bean que representa a tabela ged.bairro.
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
*                           Prior
* Date       By             Version  Project/CSR    Description
* ---------- -------------- -------- -------------- ----------------------------
* 25/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table="bairro"
*                  dynamic-insert="true"
*                  dynamic-update="true"
*                  lazy="false" 
*                  
* @hibernate.cache
*       usage = "read-write"
*                   
*/
public class GedBairroBean extends DomainBean {
    
    private GedBairroKey composite;
    private Date dtAtualizacao;
    private Long codRegiao;
    private String nomBairro;
    private Date dtInclusaoBairro;
    private String nomBairroAbrev;
    private String indTipoInclusao;
    private Date dtIncExportar;
    private Date dtAltExportar;
    
    public static final String COMPOSITE_KEY = "composite";
    public static final String LST_BAIRROS = "lstBairros";
    public static final String LST_BAIRROS_BY_LISTA_BAIRROS = "lstBairrosByListaBairros";
    public static final String RETORNA_NOMES_BAIRROS_BY_COD_BAIRROS = "retornaNomesBairrosByCodBairros";
    
    public GedBairroBean(){
        super(COMPOSITE_KEY);
    }
    
    /**
     * @hibernate.id
     * type = "composite"
     */
    public GedBairroKey getComposite() {
        return composite;
    }

    public void setComposite(GedBairroKey composite) {
        this.composite = composite;
    }

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_regiao"
     * type = "long"
     */
    public Long getCodRegiao() {
        return codRegiao;
    }

    public void setCodRegiao(Long codRegiao) {
        this.codRegiao = codRegiao;
    }

    /** 
     * @return Date
     * 
     * @hibernate.property
     * column="dt_alt_exportar"
     * type = "date"
     */
    public Date getDtAltExportar() {
        return dtAltExportar;
    }

    public void setDtAltExportar(Date dtAltExportar) {
        this.dtAltExportar = dtAltExportar;
    }

    /** 
     * @return Date
     * 
     * @hibernate.property
     * column="dt_atualizacao"
     * type = "date"
     */
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    /** 
     * @return Date
     * 
     * @hibernate.property
     * column="dt_inc_exportar"
     * type = "date"
     */
    public Date getDtIncExportar() {
        return dtIncExportar;
    }

    public void setDtIncExportar(Date dtIncExportar) {
        this.dtIncExportar = dtIncExportar;
    }

    /** 
     * @return Date
     * 
     * @hibernate.property
     * column="dt_inclusao_bairro"
     * type = "date"
     */
    public Date getDtInclusaoBairro() {
        return dtInclusaoBairro;
    }

    public void setDtInclusaoBairro(Date dtInclusaoBairro) {
        this.dtInclusaoBairro = dtInclusaoBairro;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="ind_tipo_inclusao"
     * type = "string"
     */
    public String getIndTipoInclusao() {
        return indTipoInclusao;
    }

    public void setIndTipoInclusao(String indTipoInclusao) {
        this.indTipoInclusao = indTipoInclusao;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="nom_bairro"
     * type = "string"
     */
    public String getNomBairro() {
        return nomBairro;
    }

    public void setNomBairro(String nomBairro) {
        this.nomBairro = nomBairro;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="nom_bairro_abrev"
     * type = "string"
     */
    public String getNomBairroAbrev() {
        return nomBairroAbrev;
    }

    public void setNomBairroAbrev(String nomBairroAbrev) {
        this.nomBairroAbrev = nomBairroAbrev;
    }
    
}
