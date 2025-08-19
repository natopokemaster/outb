/**
 * Created on 02/05/2008
 * Project : NETModelGeral
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 * 
 * $Id: AbstractGeralEJBImpl.java,v 1.2 2011/01/19 16:25:07 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.geral.core.facade.impl;

import static br.com.netservicos.netcrmcore.geral.resources.GeralResources.BUNDLE_KEY;

import java.util.List;

import br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl;
import br.com.netservicos.framework.exception.business.ValidationException;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;

/**
 * <P><B>Description :</B><BR>
 * 	TODO descrever
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Jonatas Piscirilo
 * @since 02/05/2008
 * @ejb.bean
 *   name="AbstractGeralEJB"
 *   display-name="AbstractGeralEJB"
 *   generate="false"
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"   
 */
public abstract class AbstractGeralEJBImpl extends
		AbstractSimpleCadMessageEJBImpl {

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl#getResourceBundle()
	 */
	@Override
	protected String getResourceBundle() {
		return BUNDLE_KEY;
	}
	
	
	 /**
     * 
     * @param messageCode
     * @param arguments
     * @return
     * @since 22/09/2010
     */
    protected ValidationMessage getValidationMessage(String messageCode, Object[] arguments) {
       String message = null;
       if (GeralUtil.isNull(arguments)) {
           message = this.getMessage(messageCode);
       }else{
           message = this.getMessage(messageCode, arguments);
       }
       return new ValidationMessage(messageCode, message);
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param mensagens
     * @throws ValidationException
     * @since 22/09/2010
     */
    protected void lancarErrosValidacao(List<ValidationMessage> mensagens) throws ValidationException {      
        ValidationException ex = null;            
        for (ValidationMessage validationMessage : mensagens) {
            if ( GeralUtil.isNull(ex) ) {
                String message = this.getMessage(validationMessage.getCode());
                ex = new ValidationException(validationMessage.getCode(), message, validationMessage, this.getClass().getName()); 
            }
            else {
                ex.addValidationMessage(validationMessage);
            }
        }            
        throw ex;       
    }
    
    /**
     * 
     * @param mensagem
     * @throws ValidationException
     */
    protected void lancarErrosValidacao(ValidationMessage mensagem) throws ValidationException {           
        String message = this.getMessage(mensagem.getCode());        
        ValidationException ex = new ValidationException(mensagem.getCode(), message, mensagem, this.getClass().getName());       
        throw ex;       
    }
    
    /**
     * 
     * @param mensagem
     * @throws ValidationException
     */
    protected void lancarErrosValidacao(String code, String mensagem) throws ValidationException {           
        ValidationMessage validateMessage =  getValidationMessage(code, null);
        ValidationException ex = new ValidationException(validateMessage.getCode(),mensagem,validateMessage, this.getClass().getName());       
        throw ex;       
    }
}
