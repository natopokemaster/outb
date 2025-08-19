/*
 * Created on 17/08/2007
 * Project : NETCRMGesCom
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
 * $Id: AbstractNETCRMGesComEJBImpl.java,v 1.5 2011/08/26 14:41:27 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.gescom.core.facade.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.gescom.util.UtilObject;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;

/**
 * 
 * <P><B>Description :</B><BR>
 * 	Classe base para EJB de negócio.
 * </P>
 * <P>
 * <B>
 * 	
 * @author Alessandro Mariano
 * @since 17/05/2011
 *
 * @ejb.bean
 *   name="AbstractNETCRMGesComEJB"
 *   display-name="AbstractNETCRMGesComEJB"
 *   generate="false"
 *
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 *
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 */
public abstract class AbstractNETCRMGesComEJBImpl extends AbstractSimpleCadMessageEJBImpl {

	private static final long serialVersionUID = 1454874135911156189L;

	/**
	 *
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadMessageEJBImpl#getResourceBundle()
	 */
	@Override
	protected String getResourceBundle() {
		return "br/com/netservicos/netcrmcore/gescom/resources/NETCRMGesComResourcesMessages";
	}

	/**
     *
     * @param messageCode
     * @param arguments
     * @return
     * @since 22/09/2010
     */
	protected ValidationMessage getValidationMessage(final String messageCode, final Object[] arguments) {
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
     *  Transforma uma lista de array em uma lista de DynamicBeans.
     * <p>
     * @param namedQuery
     * @param bean
     * @param cache
     * @param atributos
     * @return List<DynamicBean>
     * @since 12/04/2011
     */
    protected List<DynamicBean> searchSqlNamedQuery(final String namedQuery, final Bean bean,
        final Boolean cache, final String... atributos) {
        final List<DynamicBean> lista = new ArrayList<DynamicBean>();
        final List<?> resultado = this.search(namedQuery, bean, cache);
        for (final Object item : resultado) {
            if (item != null) {
                final DynamicBean dynaBean = UtilObject.newInstance(DynamicBean.class);
                if (item instanceof Object[]) {
                    this.criarBean(item, dynaBean, atributos);
                } else {
                    dynaBean.set(atributos[0], item);
                }
                lista.add(dynaBean);
            }
        }
        return lista;
    }

    /**
     * @param item
     * @param dynaBean
     * @param atributos
     * @since 15/04/2011
     */
    private void criarBean(final Object item, final DynamicBean dynaBean, final String... atributos) {
        final Object[] linha = (Object[]) item;
        for (int i = 0; i < atributos.length; ++i) {
            dynaBean.set(atributos[i], linha[i]);
        }
    }
}
