/*
 * Created on 15/08/2005
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
* 	Classe Bean que representa a tabela ged.endereco.
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
* 15/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table = "endereco"
*                  dynamic-insert = "true"
*                  dynamic-update = "true"
*                  
* @hibernate.cache
*       usage = "read-write"
*                   
*                  
* @hibernate.query name  = "dadosEndereco"
*                  query = "SELECT 
*                               cidOperadora.ciNome, 
*                               ender.numCep, 
*                               bairro.nomBairro, 
*                               logradouro.nomLogrAbrev,
*                               ender.composite.codCidade,
*                               ender.composite.codLogradouro,                              
*                               bairro.composite.codBairro,                               
*                               ender.codTipoCompl1,
*                               ender.txtTipoCompl1,
*                               ender.codTipoCompl2,
*                               ender.txtTipoCompl2,
*                               ender.codTipoCompl3,
*                               ender.txtTipoCompl3,
*                               ender.codTipoCompl4,
*                               ender.txtTipoCompl4,
*                               ender.numEndereco,
*                               logradouro.codTipoLogr,
*                               logradouro.codPreposicao,
*                               cidOperadora.ciEstado,
*                               imovel.indTipoEdificacao,
*                               imovel.composite.codImovel,
*                               ender.composite.codEndereco                               
*                           FROM
*                               br.com.netservicos.core.bean.ged.GedEnderecoBean ender, 
*                               br.com.netservicos.core.bean.ged.GedLogradouroBean logradouro, 
*                               br.com.netservicos.core.bean.ged.GedBairroBean bairro, 
*                               br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean cidOperadora,
*                               br.com.netservicos.core.bean.ged.GedImovelBean imovel, 
*                               br.com.netservicos.core.bean.ged.GedHpImovelBean hpImovel
*                           WHERE
*                               ender.composite.codCidade = logradouro.composite.codCidade
*                           AND ender.composite.codLogradouro = logradouro.composite.codLogradouro
*                           AND ender.composite.codCidade = bairro.composite.codCidade(+)
*                           AND ender.codBairro = bairro.composite.codBairro(+)
*                           AND cidOperadora.cidContrato = ender.composite.codCidade
*                           AND ender.composite.codCidade = :gedEndereco.composite.codCidade
*                           AND ender.composite.codLogradouro = ( SELECT im.codLogradouro FROM br.com.netservicos.core.bean.ged.GedImovelBean im, br.com.netservicos.core.bean.ged.GedHpImovelBean hpim WHERE hpim.codImovel = im.composite.codImovel AND hpim.composite.codHP = :codHP AND im.codCidade = :gedEndereco.composite.codCidade )
*                           AND ender.composite.codEndereco = ( SELECT im.codEndereco FROM br.com.netservicos.core.bean.ged.GedImovelBean im, br.com.netservicos.core.bean.ged.GedHpImovelBean hpim WHERE hpim.codImovel = im.composite.codImovel AND hpim.composite.codHP = :codHP AND im.codCidade = :gedEndereco.composite.codCidade )
*                           AND hpImovel.codImovel = imovel.composite.codImovel 
*                           AND hpImovel.composite.codHP = :codHP 
*                           AND imovel.codCidade = :gedEndereco.composite.codCidade"
*                  
* 
*                               
*                  
*/
public class GedEnderecoBean extends DomainBean {
	
    private GedEnderecoKey composite;
    private GedLogradouroBean gedLogradouro;
    private String numEndereco;
    private Long codBairro;
    private Long numCep;
    private Date dtAtualizacao;
    private String codTipoCompl1;
    private String codTipoCompl2;
    private String codTipoCompl3;
    private String codTipoCompl4;
    private String txtTipoCompl1;
    private String txtTipoCompl2;
    private String txtTipoCompl3;
    private String txtTipoCompl4;
    private String numMapa;
    private String txtComplNum;
    private String indTipoRef;
    private Long codImovel;
    private String indEntradaPrincipal;
    private String indEspecial;
    private Double codFonetico;
    private String indLado;
    private String indMultiplaEntrada;
    private Double numCoordX;
    private Double numCoordY;
    private Long codEnderecoRef;
    private Long numOrdem;
    private String numCompleto;
    private String codUsuario;
    
    public static final String LST_ENDERECOS_BY_LISTA_ENDERECOS = "lstEnderecosByListaEnderecos";
    public static final String LST_LOGRADOUROS_CEP = "lstLogradourosCep";
    public static final String LST_LOGRADOUROS_BY_CEP = "lstLogradourosByCep";
    public static final String LST_LOGRADOUROS = "lstLogradouros";
    public static final String DADOS_ENDERECO = "dadosEndereco";
    public static final String VERIFICA_NUMERO_HP = "verificaNumeroHP";
    public static final String COMPOSITE_KEY = "composite";    
    public static final String LST_PESQUISA_LOGRADOUROS_CEP = "lstPesquisaLogradourosCep";
    public static final String LST_PESQUISA_LOGRADOUROS = "lstPesquisaLogradouros";    
    
    
    
    public GedEnderecoBean(){
        super(COMPOSITE_KEY);
    }
    
    /**
     * @hibernate.id
     * type = "composite"
     */
    public GedEnderecoKey getComposite() {
		return composite;
	}

	public void setComposite(GedEnderecoKey composite) {
		this.composite = composite;
	}
	
    /** 
     * @return GedLogradouroBean
     * 
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.ged.GedLogradouroBean"
     *      insert="false"
     *      update="false"
     *      cascade="none"
     *      not-null="false"
     * @hibernate.column name="cod_logradouro"
     * @hibernate.column name="cod_cidade"
     */
    public GedLogradouroBean getGedLogradouro() {
        return gedLogradouro;
    }

    public void setGedLogradouro(GedLogradouroBean gedLogradouro) {
        this.gedLogradouro = gedLogradouro;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_bairro"
     * type = "long"
     */
    public Long getCodBairro() {
        return codBairro;
    }

    public void setCodBairro(Long codBairro) {
        this.codBairro = codBairro;
    }

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_endereco_ref"
     * type = "long"
     */
    public Long getCodEnderecoRef() {
        return codEnderecoRef;
    }

    public void setCodEnderecoRef(Long codEnderecoRef) {
        this.codEnderecoRef = codEnderecoRef;
    }

    /** 
     * @return Double
     * 
     * @hibernate.property
     * column="cod_fonetico"
     * type = "double"
     */
    public Double getCodFonetico() {
        return codFonetico;
    }

    public void setCodFonetico(Double codFonetico) {
        this.codFonetico = codFonetico;
    }

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_imovel"
     * type = "long"
     */
    public Long getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(Long codImovel) {
        this.codImovel = codImovel;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="cod_tipo_compl1"
     * type = "string"
     */
    public String getCodTipoCompl1() {
        return codTipoCompl1;
    }

    public void setCodTipoCompl1(String codTipoCompl1) {
        this.codTipoCompl1 = codTipoCompl1;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="cod_tipo_compl2"
     * type = "string"
     */
    public String getCodTipoCompl2() {
        return codTipoCompl2;
    }

    public void setCodTipoCompl2(String codTipoCompl2) {
        this.codTipoCompl2 = codTipoCompl2;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="cod_tipo_compl3"
     * type = "string"
     */
    public String getCodTipoCompl3() {
        return codTipoCompl3;
    }

    public void setCodTipoCompl3(String codTipoCompl3) {
        this.codTipoCompl3 = codTipoCompl3;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="cod_tipo_compl4"
     * type = "string"
     */
    public String getCodTipoCompl4() {
        return codTipoCompl4;
    }

    public void setCodTipoCompl4(String codTipoCompl4) {
        this.codTipoCompl4 = codTipoCompl4;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="cod_usuario"
     * type = "string"
     */
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
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
     * @return String
     * 
     * @hibernate.property
     * column="ind_entrada_principal"
     * type = "string"
     */
    public String getIndEntradaPrincipal() {
        return indEntradaPrincipal;
    }

    public void setIndEntradaPrincipal(String indEntradaPrincipal) {
        this.indEntradaPrincipal = indEntradaPrincipal;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="ind_especial"
     * type = "string"
     */
    public String getIndEspecial() {
        return indEspecial;
    }

    public void setIndEspecial(String indEspecial) {
        this.indEspecial = indEspecial;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="ind_lado"
     * type = "string"
     */
    public String getIndLado() {
        return indLado;
    }

    public void setIndLado(String indLado) {
        this.indLado = indLado;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="ind_multipla_entrada"
     * type = "string"
     */
    public String getIndMultiplaEntrada() {
        return indMultiplaEntrada;
    }

    public void setIndMultiplaEntrada(String indMultiplaEntrada) {
        this.indMultiplaEntrada = indMultiplaEntrada;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="ind_tipo_ref"
     * type = "string"
     */
    public String getIndTipoRef() {
        return indTipoRef;
    }

    public void setIndTipoRef(String indTipoRef) {
        this.indTipoRef = indTipoRef;
    }

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="num_cep"
     * type = "long"
     */
    public Long getNumCep() {
        return numCep;
    }

    public void setNumCep(Long numCep) {
        this.numCep = numCep;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="num_completo"
     * type = "string"
     */
    public String getNumCompleto() {
        return numCompleto;
    }

    public void setNumCompleto(String numCompleto) {
        this.numCompleto = numCompleto;
    }

    /** 
     * @return Double
     * 
     * @hibernate.property
     * column="num_coord_x"
     * type = "double"
     */
    public Double getNumCoordX() {
        return numCoordX;
    }

    public void setNumCoordX(Double numCoordX) {
        this.numCoordX = numCoordX;
    }

    /** 
     * @return Double
     * 
     * @hibernate.property
     * column="num_coord_y"
     * type = "double"
     */
    public Double getNumCoordY() {
        return numCoordY;
    }

    public void setNumCoordY(Double numCoordY) {
        this.numCoordY = numCoordY;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="num_endereco"
     * type = "string"
     */
    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="num_mapa"
     * type = "string"
     */
    public String getNumMapa() {
        return numMapa;
    }

    public void setNumMapa(String numMapa) {
        this.numMapa = numMapa;
    }

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="num_ordem"
     * type = "long"
     */
    public Long getNumOrdem() {
        return numOrdem;
    }

    public void setNumOrdem(Long numOrdem) {
        this.numOrdem = numOrdem;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="txt_compl_num"
     * type = "string"
     */
    public String getTxtComplNum() {
        return txtComplNum;
    }

    public void setTxtComplNum(String txtComplNum) {
        this.txtComplNum = txtComplNum;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="txt_tipo_compl1"
     * type = "string"
     */
    public String getTxtTipoCompl1() {
        return txtTipoCompl1;
    }

    public void setTxtTipoCompl1(String txtTipoCompl1) {
        this.txtTipoCompl1 = txtTipoCompl1;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="txt_tipo_compl2"
     * type = "string"
     */
    public String getTxtTipoCompl2() {
        return txtTipoCompl2;
    }

    public void setTxtTipoCompl2(String txtTipoCompl2) {
        this.txtTipoCompl2 = txtTipoCompl2;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="txt_tipo_compl3"
     * type = "string"
     */
    public String getTxtTipoCompl3() {
        return txtTipoCompl3;
    }

    public void setTxtTipoCompl3(String txtTipoCompl3) {
        this.txtTipoCompl3 = txtTipoCompl3;
    }

    /** 
     * @return String
     * 
     * @hibernate.property
     * column="txt_tipo_compl4"
     * type = "string"
     */
    public String getTxtTipoCompl4() {
        return txtTipoCompl4;
    }
 
    public void setTxtTipoCompl4(String txtTipoCompl4) {
        this.txtTipoCompl4 = txtTipoCompl4;
    }
	
}