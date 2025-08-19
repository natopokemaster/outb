package br.com.netservicos.core.bean.pr;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;


/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela pr_funcionario.
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
 * 10/04/2006 Leonardo Westphal 1    Entidades      Creation.
 * ==============================================================================
 * 
 * </PRE>
 * @hibernate.class
 *      table="pr_funcionario"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true"
 *      batch-size="10"
 *      
 * @hibernate.cache
 *      usage="read-write" 
 *  
 * @hibernate.query name  = "lstUserNameByPropostaIdPessoa"
 *                  query = "SELECT funcionario.userName
 *                  		 FROM br.com.netservicos.core.bean.pr.PrFuncionarioBean funcionario
 *                           WHERE funcionario.idPessoa = :vendedor.pessoa.idPessoa"
 *
 * @hibernate.query name = "lstFuncionarioByUsername"
 * 					query = "SELECT funcionario.idPessoa
 * 							 FROM br.com.netservicos.core.bean.pr.PrFuncionarioBean funcionario
 * 							 WHERE funcionario.userName = :username"
 *   
 */
public class PrFuncionarioBean extends DomainBean {
        
	private static final long serialVersionUID = -845075076716953072L;
	
	private String userName = null;    
    private String idPessoa = null;
    private String senha = null;
    private Long idPerfil = null;
    private Date dtCriacao = null;
    private String idEmpresa = null;
    
    public static final String LST_USERNAME_BY_PROPOSTA_IDPESSOA = "lstUserNameByPropostaIdPessoa";
    public static final String LST_FUNCIONARIO_BY_USERNAME = "lstFuncionarioByUsername";

    public PrFuncionarioBean() {
        super("userName");
    }

    
    /**
     * @hibernate.property
     *      column="data_criacao"
     * @return
     */
    public Date getDtCriacao() {
        return dtCriacao;
    }    

    /**
     * @hibernate.property
     * 		column="id_empresa"
     * @return
     */
    public String getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @hibernate.property
     * 		column="id_perfil"
     * @return
     */
    public Long getIdPerfil() {
        return idPerfil;
    }

    /**
     * @hibernate.property 		
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @hibernate.property
     * 			column="id_pessoa"
     * @return
     */
    public String getIdPessoa() {
        return idPessoa;
    }    
    
	/**
	 * @return Returns the userName.
	 * 
	 * @hibernate.id  
	 * column="username"
	 * generator-class="assigned"
	 * unsaved-value="null" 
	 * 
	 */    
    public String getUserName() {
        return userName;
    }    

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setIdEmpresa(String idEmpresa) {
    	this.idEmpresa = idEmpresa;
    }

    public void setIdPerfil(Long idPerfil) {
    	this.idPerfil = idPerfil;
    }
    
    public void setSenha(String senha) {
    	this.senha = senha;
    }

    public void setIdPessoa(String idPessoa) {
    	this.idPessoa = idPessoa;
    }    

}