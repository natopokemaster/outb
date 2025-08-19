/*
 * Created on 26/08/2005
 *
 * Copyright © 2005 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;
;

/**
 * 
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_tipo_segmento.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação da classe						26/08/2005  Bruno Borges
 * Adição da HQL lstSnTipoSegmento			19/03/2007	Rafael Mauricio Nami
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
 * 26/08/2005 Bruno Borges    N/A      Entidades      Created.
 * 19/03/2007 Rafael Nami	  1.1	   Entidades	  Updated.
 * ==============================================================================
 * </PRE>
 * 
 * @hibernate.class 
 *      table = "sn_tipo_segmento"
 *      batch-size = "10"
 *      lazy = "false"
 * 
 *  @hibernate.cache
 *      usage = "read-write"
 *      
 * @hibernate.query name  = "lstSnTipoSegmentoIdDesc"
 *                  query = "SELECT segmento.idTipoSegmento, segmento.descricao
 *                  			FROM br.com.netservicos.core.bean.sn.SnTipoSegmentoBean segmento"    
 * 
 * @hibernate.query name="lstSnTipoSegmento"
 * 					query="select 
 * 								b.idTipoSegmento, 
 * 								b.descricao 
 * 						   from 
 * 								br.com.netservicos.core.bean.sn.SnTipoSegmentoBean b 
 * 						   order by 
 * 								b.descricao"
 * 
 * @hibernate.query name="lstSnTipoSegmentoSemSegmento"
 *                  query="select b from 
 *                              br.com.netservicos.core.bean.sn.SnTipoSegmentoBean b
 *                         where b.descricao = 'SEM SEGMENTO'"      
 *                     
 * 
 * 
 * 
 * 
 * 
 */
public class SnTipoSegmentoBean extends DomainBean {
  
    private static final long serialVersionUID = -2313350603356388799L;
    private String            descricao;
    private Long              idTipoSegmento;
    
    public SnTipoSegmentoBean() {
        super("idTipoSegmento");
    }
    
    public SnTipoSegmentoBean(Long idTipoSegmento) {
        this();
        setIdTipoSegmento(idTipoSegmento);
    }
    
    /**
     * @hibernate.property
     * @return
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * @hibernate.id column="id_tipo_segmento" generator-class="assigned"
     * @return
     */
    public Long getIdTipoSegmento() {
        return idTipoSegmento;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setIdTipoSegmento(Long idTipoSegmento) {
        this.idTipoSegmento = idTipoSegmento;
    }
}