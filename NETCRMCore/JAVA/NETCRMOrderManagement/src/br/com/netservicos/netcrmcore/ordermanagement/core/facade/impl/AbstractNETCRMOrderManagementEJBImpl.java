/**
 * Created on 17/08/2007
 * Project : NETExemplo
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
 * $Id: AbstractNETCRMOrderManagementEJBImpl.java,v 1.1 2009/12/03 19:09:11 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.ordermanagement.core.facade.impl;

import static br.com.netservicos.netcrmcore.ordermanagement.resources.NETCRMOrderManagementResources.BUNDLE_NAME;
import br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl;

/**
 * <P><B>Description :</B><BR>
 * 	TODO descrever
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Robin Michael Gray
 * @since 17/08/2007
 * @ejb.bean
 *   name="AbstractExemploEJB"
 *   display-name="AbstractExemploEJB"
 *   generate="false"
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"   
 */
public abstract class AbstractNETCRMOrderManagementEJBImpl extends
		AbstractSimpleCadMessageEJBImpl {

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl#getResourceBundle()
	 */
	@Override
	protected String getResourceBundle() {
		return BUNDLE_NAME;
	}
	

}
