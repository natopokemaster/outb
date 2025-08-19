/**
 * Created on 31/07/2007
 * Project : NETFramework
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
 * $Id: SimpleCadGeralEJBImpl.java,v 1.1 2009/12/03 19:06:28 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.geral.core.facade.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.EJBException;

import net.sf.jasperreports.engine.JasperReport;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl;
import br.com.netservicos.framework.core.facade.hibernate.SimpleCad;
import br.com.netservicos.framework.util.paging.PagingList;

/**
 * <P><B>Description :</B><BR>
 * 
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Jonatas Piscirilo
 * @since 05/05/2008
 * @version 
 * 
 * @ejb.bean name="SimpleCadGeralEJB"
 * 		type="Stateless"
 * 		display-name="SimpleCadGeralEJB"
 *      description="SimpleCadGeralEJB Session EJB Stateless"
 *      view-type="both"
 *      jndi-name="netservicos/netcrmcore/geral/ejb/SimpleCadEJB"
 * 		local-jndi-name="netservicos/netcrmcore/geral/ejb/local/SimpleCadEJB"
 *      transaction-type="Container"
 * @ejb.interface
 *   local-extends="javax.ejb.EJBLocalObject"
 *   extends="javax.ejb.EJBObject"
 *
 * @ejb.home
 *   local-extends="javax.ejb.EJBLocalHome"
 *   extends="javax.ejb.EJBHome"
 * @ejb.transaction
 *   type="Required"
 * @ejb.permission role-name="ACESSO"
 */
public class SimpleCadGeralEJBImpl extends AbstractSimpleCadEJBImpl 
		implements SimpleCad {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1352083890570331446L;

	/**
	 * @see br.com.netservicos.framework.core.facade.EJBImpl#ejbCreate()
	 * 
	 * @ejb.create-method
	 */
	@Override
	public void ejbCreate() throws CreateException {
		super.ejbCreate();
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.EJBImpl#ejbRemove()
	 */
	@Override
	public void ejbRemove() throws EJBException {
		super.ejbRemove();
	}
	

	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#findByPrimaryKey(br.com.netservicos.framework.core.bean.Bean)
	 * @ejb.interface-method view-type = "both"
	 * 
	 */
	public Bean findByPrimaryKey(Bean bean) {
		return super.findByPrimaryKey(bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#update(Bean)
	 * @ejb.interface-method view-type = "both"
	 */
	public void update(Bean bean) {
		super.updateToAllDBs(bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#update(Bean, String)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void update(Bean bean, String dbService) {
		super.update(bean, dbService);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#generateReport(Object, DynamicBean, String, String[])
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Map generateReport(Object report, DynamicBean parameters, String queryName, String[] reportFields) {
		
		return super.generateReport(report, parameters, queryName, reportFields);
	}
	
	
	
	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#generateReportWithConnection(net.sf.jasperreports.engine.JasperReport, java.util.Map)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	@Override
	public Map<String, Object> generateReportWithConnection(
			JasperReport report, Map<?, ?> parameters) {
		return super.generateReportWithConnection(report, parameters);
	}

	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#insert(Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean insert(Bean bean) {
		
		return super.insertToAllDBs(bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#insert(Bean, String)
	 * 
	 * @ejb.interface-method view-type = "both" 
	 */
	public Bean insert(Bean bean, String dbService) {
		
		return super.insert(bean, dbService);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#delete(Bean)
	 * 
	 * @ejb.interface-method view-type = "both" 
	 */
	public void delete(Bean bean) {
		super.deleteToAllDBs(bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#delete(Bean, String)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void delete(Bean bean, String dbService) {
		
		super.delete(bean, dbService);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#delete(String, Bean)
	 * 
     * @ejb.interface-method view-type = "both" 
	 */
	public void delete(String queryName, Bean bean) {
		super.delete(queryName, bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#delete(String, Bean, String)
	 * 
     * @ejb.interface-method view-type = "both" 
	 */
	public void delete(String queryName, Bean filter, String dbService) {
		super.delete(queryName, filter, dbService);
	}
	
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchPaging(PagingList)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public List searchPaging(PagingList pagingList) {	
		return super.searchPaging(pagingList);
	}
	
	/**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchLists(String[], Bean)
     * 
     * @ejb.interface-method view-type="both"
     */
    public Collection[] searchLists(String queryNames[], Bean bean) {
    	
    	return super.searchLists(queryNames, bean);
    }
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchLists(java.lang.String[], br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
     * 
     * @ejb.interface-method view-type="both"
     */
	public Collection[] searchLists(String[] queryNames, Bean bean, Boolean cache) {
		return super.searchLists(queryNames, bean, cache);
	}
    
    
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#search(String, Bean)
	 *
	 * @ejb.interface-method view-type = "both"
	 */
	public List search(String queryName, Bean bean) {
		
		return super.search(queryName, bean);
	}
	
	/**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#search(String, Bean, Boolean)
     * 
     * @ejb.interface-method  view-type = "both"
     */
    public List search(String queryName, Bean bean, Boolean cache) {
    	
    	return super.search(queryName, bean, cache);
    }
    
    /**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchAll(String, Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public List[] searchAll(String queryName, Bean bean) {
		
		return super.searchAll(queryName, bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchAll(java.lang.String, br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public List[] searchAll(String queryName, Bean bean, Boolean cache) {
		return super.searchAll(queryName, bean, cache);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchUnion(String, Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public List searchUnion(String queryName, Bean bean) {
		
		return super.searchUnion(queryName, bean);
	}
	
	/**
	 * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchUnion(java.lang.String, br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public List searchUnion(String queryName, Bean bean, Boolean cache) {
		return super.searchUnion(queryName, bean, cache);
	}
	
	/**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchUnionLists(String[], Bean)
     * 
     * @ejb.interface-method view-type = "both"
     */
    public Collection[] searchUnionLists(String queryName[], Bean bean) {
    	
    	return super.searchUnionLists(queryName, bean);
    }
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchUnionLists(java.lang.String[], br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
     * 
     * @ejb.interface-method view-type = "both"
     */
	public Collection[] searchUnionLists(String[] queryName, Bean bean, Boolean cache) {
    	return super.searchUnionLists(queryName, bean, cache);
	}

    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchMerge(String, Bean)
     * 
     * @ejb.interface-method view-type = "both"
     */
    public Set searchMerge(String queryName, Bean filter) {
    	
    	return super.searchMerge(queryName, filter);
    }
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchMerge(java.lang.String, br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
     * 
     * @ejb.interface-method view-type = "both"
     */
	public Set searchMerge(String queryName, Bean filter, Boolean cache) {
    	return super.searchMerge(queryName, filter, cache);
	}
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchMergeLists(String[], Bean)
     * 
     * @ejb.interface-method view-type = "both"
     */
    public Collection[] searchMergeLists(String queryName[], Bean filter) {
    	
    	return super.searchMergeLists(queryName, filter);
    }
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#searchMergeLists(java.lang.String[], br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
     * 
     * @ejb.interface-method view-type = "both"
     */
	public Collection[] searchMergeLists(String[] queryName, Bean filter, Boolean cache) {
    	return super.searchMergeLists(queryName, filter, cache);
	}
    
    /**
     * @see br.com.netservicos.framework.core.facade.hibernate.SimpleCad#getAvailableDBServices(String[])
     * 
     * @ejb.interface-method view-type="both"
     */
    public String[] getAvailableDBServices(String[] dbServices) {
    	
    	return super.getAvailableDBServices(dbServices);
    }
    
    /**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#configurateBeanToInsert(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean configurateBeanToInsert(Bean bean) {
		
		return super.configurateBeanToInsert(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#configurateBeanToUpdate(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean configurateBeanToUpdate(Bean bean) {
		
		return super.configurateBeanToUpdate(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#filterBeanCollectionsToCurrentDb(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean filterBeanCollectionsToCurrentDb(Bean bean) {
		
		return super.filterBeanCollectionsToCurrentDb(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#generatePrimaryKey(br.com.netservicos.framework.core.bean.Bean, java.lang.String[], java.lang.String)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Number generatePrimaryKey(Bean bean, String[] dbServices,
			String generatorType) {
		
		return super.generatePrimaryKey(bean, dbServices, generatorType);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#initializeLazyProperties(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean initializeLazyProperties(Bean bean) {
		
		return super.initializeLazyProperties(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#initializeLazyProperties(java.lang.String[], java.lang.Object)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Object initializeLazyProperties(String[] properties, Object source) {
		
		return super.initializeLazyProperties(properties, source);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#lineUpSequences(long[], java.lang.String[], long, br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void lineUpSequences(long[] sequences, String[] dbServices,
			long maxValue, Bean bean) {
		
		super.lineUpSequences(sequences, dbServices, maxValue, bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#processInsertToAllDBs(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Bean processInsertToAllDBs(Bean bean) {
		
		return super.processInsertToAllDBs(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#processInsertToDefaultDB(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void processInsertToDefaultDB(Bean bean) {
		
		super.processInsertToDefaultDB(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#processUpdateToAllDBs(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void processUpdateToAllDBs(Bean bean) {
		
		super.processUpdateToAllDBs(bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#processUpdateToDefaultDB(br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void processUpdateToDefaultDB(Bean bean) {
		
		super.processUpdateToDefaultDB(bean);
	}
	
	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#uniqueResult(java.lang.String, br.com.netservicos.framework.core.bean.Bean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Object uniqueResult(String queryName, Bean bean) {
		return super.uniqueResult(queryName, bean);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.core.facade.hibernate.AbstractSimpleCadEJBImpl#uniqueResult(java.lang.String, br.com.netservicos.framework.core.bean.Bean, java.lang.Boolean)
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public Object uniqueResult(String queryName, Bean bean, Boolean cache) {
		return super.uniqueResult(queryName, bean, cache);
	}
}
