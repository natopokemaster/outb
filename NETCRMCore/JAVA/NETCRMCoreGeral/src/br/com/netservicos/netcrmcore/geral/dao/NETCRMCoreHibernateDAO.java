/**
 * Created on 12/01/2011
 * Project : NETCRMCoreGeral
 *
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 *
 */
package br.com.netservicos.netcrmcore.geral.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.engine.NamedSQLQueryDefinition;
import org.hibernate.engine.SessionFactoryImplementor;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.engine.query.HQLQueryPlan;
import org.hibernate.hql.ParameterTranslations;
import org.hibernate.hql.QueryTranslator;
import org.hibernate.impl.SQLQueryImpl;
import org.hibernate.loader.custom.SQLQueryScalarReturn;
import org.hibernate.type.Type;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.dao.BaseDAOException;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.core.dao.HibernateDAO;
import br.com.netservicos.framework.core.dao.JDBCDAO;
import br.com.netservicos.framework.util.BaseConstants;
import br.com.netservicos.framework.util.paging.PagingList;

/**
 * <p>
 * <b>Description: </b><br>
 * Customização do DAO para trabalhar com bases Oracle11g. Esta classe foi
 * criada para interceptar as querys executadas pelo sistema e quando estiver
 * logado em uma base Oracle11g, ira fazer tratamentos para retirada de hints.
 * </p>
 * <b> Issues: <br>
 * 
 * </b>
 * 
 * @author jorge.silva
 * @since 12/01/2011
 * @version
 * 
 */
public class NETCRMCoreHibernateDAO extends HibernateDAO {

	private static final String FIM_HINT = "*/";
	private static final String INICIO_HINT = "/*";
	private static final String CHAVE_PARA_RETORNO = "ZZZZ";
	private static final int ORACLE11G = 11;
	private static final String TUNING11G = "_tuning11g";
	private static final long serialVersionUID = 7132387089962488523L;
	private static final Log LOG = LogFactory.getLog(NETCRMCoreHibernateDAO.class);
	private static final String[] LST_HINTS = { "+0", "+ 0", "||''", "|| ''",
			"+0" };
	private static final String[] LST_NOT_HINTS = { "+0.", "+ 0." };
	private static final String ALTER_SESSION_OPTIMIZER_MODE_9I = "alter session set optimizer_mode = rule";
	private static final String ALTER_SESSION_OPTIMIZER_MODE_11G = "alter session set optimizer_mode = all_rows";

	@SuppressWarnings("unchecked")
	@Override
	public List select(String queryName, Bean bean, boolean cache) {

		try {
			List result = null;
			if (queryName != null) {
				final Session session = getHibernateSession();
				if (session != null) {
					Query query = this.getQuery(session, queryName);
					if (query != null) {
						query.setCacheable(cache);
						query
								.setCacheRegion(BaseConstants.QUERY_CACHE_REGION_SUFFIX);
						bindParameters(query, bean);
						result = query.list();
					} else {
						throw new BaseDAOException(
								"Query "
										+ queryName
										+ " não foi encontrado no respositorio de queries.");
					}
				}
			}
			return result;
		} catch (BaseDAOException ex) {
			if (LOG.isErrorEnabled()) {
				LOG
						.error(
								"Error occurried in processing of select(String, Bean, boolean) method with dbService: "
										+ dbService.getName(), ex);
			}
			throw ex;
		} catch (Exception ex) {
			if (LOG.isErrorEnabled()) {
				LOG
						.error(
								"Error occurried in processing of select(String, Bean, boolean) method with dbService: "
										+ dbService.getName(), ex);
			}
			throw new BaseDAOException(ex, dbService);
		}

	}

	/**
	 * Retorna um Query criado de acordo com a versão do Banco de Dados. No caso
	 * de Oracle11g será alterada a query retirando os hints da mesma exceto
	 * quanto a query for uma query de Tunning implementada pelo projeto
	 * Migracao 11g.
	 * 
	 * @param session
	 * @param queryName
	 * @return Query
	 */
	private Query getQuery(final Session session, final String queryName) {
		Query query = session.getNamedQuery(queryName);
		if (isOracle11g()) {
			try {
				query = session.getNamedQuery(queryName + TUNING11G);
				return query;
			} catch (MappingException e) {
			}
			query = this.clearHints(session, queryName);
		}
		return query;
	}

	/**
	 * Limpa a query retirando os hints.
	 * 
	 * @param query
	 * @return String
	 */
	private Query clearHints(final Session session, final String queryName) {
		Query query = session.getNamedQuery(queryName);

		String queryString = query.getQueryString();
		boolean contemHint = false;

		queryString = retiraHintsFalsos(queryString);
		for (String hint : LST_HINTS) {
			if (queryString.contains(hint)) {
				logaRetiradaHint(queryName, hint);
				queryString = queryString.replace(hint, "");
				contemHint = true;
			}
		}
		queryString = queryString.replace(CHAVE_PARA_RETORNO, "+ 0.");

		while ((queryString.contains(INICIO_HINT))
				&& (queryString.contains(FIM_HINT))) {
			String hint = queryString.substring(queryString
					.indexOf(INICIO_HINT), queryString.indexOf(FIM_HINT)
					+ FIM_HINT.length());
			logaRetiradaHint(queryName, hint);
			queryString = queryString.replace(hint, "");
			contemHint = true;
		}

		if (contemHint) {
			query = this.createQuery(session, queryName, query, queryString);
		}
		return query;
	}

	/**
	 * Verifica se existe alguma sequencia de caracter que possa ser semelhante
	 * a um hint +0, mas que faz por exemplo faz uma soma na query. Neste caso
	 * substitui este valor por uma string usada com chave para retornar o valor
	 * apos a limpeza de hints.
	 * 
	 * @param queryString
	 * @return
	 */
	private String retiraHintsFalsos(String queryString) {
		for (String hint : LST_NOT_HINTS) {
			if (queryString.contains(hint)) {
				queryString = queryString.replace(hint, CHAVE_PARA_RETORNO);
			}
		}
		return queryString;
	}

	/**
	 * Loga a retirada de hints.
	 * 
	 * @param queryName
	 * @param hint
	 */
	private void logaRetiradaHint(final String queryName, String hint) {
		if (LOG.isDebugEnabled()) {
			LOG
					.debug("QUERY "
							+ queryName
							+ " contem hint "
							+ hint
							+ ". Executando o processo de retirada de hints para bases Oracle11g.");
		}
	}

	/**
	 * Cria uma query sem os hints.
	 * 
	 * @param session
	 * @param queryName
	 * @param query
	 * @param queryString
	 */
	private Query createQuery(final Session session, final String queryName,
			final Query query, String queryString) {
		Query retorno = null;
		if (query instanceof SQLQueryImpl) {
			final SessionImplementor sessionImplementor = (SessionImplementor) session;
			final NamedSQLQueryDefinition namedSQLQueryDefinition = sessionImplementor
					.getFactory().getNamedSQLQuery(queryName);
			final SQLQueryScalarReturn[] sqlQueryScalarReturns = namedSQLQueryDefinition
					.getScalarQueryReturns();

			retorno = session.createSQLQuery(queryString);
			final SQLQueryImpl queryImpl = (SQLQueryImpl) retorno;
			for (SQLQueryScalarReturn scalar : sqlQueryScalarReturns) {
				queryImpl.addScalar(scalar.getColumnAlias(), scalar.getType());
			}
			retorno = queryImpl;
		} else {
			retorno = session.createQuery(queryString);
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List select(PagingList pagingList) {
		try {
			Session session = getHibernateSession();
			String queryName = pagingList.getQueryName();
			Query query = this.getQuery(session, queryName);
			bindParameters(query, pagingList.getBean());
			query.setCacheable(pagingList.getCacheable());
			query.setCacheRegion(BaseConstants.QUERY_CACHE_REGION_SUFFIX);
			// pageNum vem com base 1 (1, 2, 3, 4...)
			int pageNum = pagingList.getPageNum().intValue();
			int pageSize = pagingList.getPageSize().intValue();

			// Obtendo o numero de inicio da pagina.
			int firstResult = ((pageNum - 1) * pageSize);

			query.setFirstResult(firstResult);

			// Increment to see if there is another page
			if (!pagingList.getDoCount()) {
				pageSize++;
			}

			query.setMaxResults(pageSize);
			List resultQuery = query.list();

			if (pagingList.getDoCount()) {

				if (pagingList.isReCount()) {
					Long count = countRecords(queryName, pagingList.getBean());
					pagingList.setQueryCount(count);
				} else {
					if (pageNum == 1 && pagingList.getQueryCount() == null) {
						Long count = countRecords(queryName, pagingList
								.getBean());
						pagingList.setQueryCount(count);
					}
				}
			} else {
				pagingList.setQueryCount((long) resultQuery.size());
			}

			resultQuery = (pagingList.getPageSize() > resultQuery.size()) ? resultQuery
					: resultQuery.subList(0, pagingList.getPageSize());

			pagingList.addAll(resultQuery);

			return pagingList;
		} catch (Exception ex) {
			if (LOG.isErrorEnabled()) {
				LOG.error(
						"Error occurried in processing of select(PagingList) method with dbService: "
								+ dbService.getName(), ex);
			}
			throw new BaseDAOException(ex, dbService);
		}
	}

	@Override
	public Long countRecords(String queryName, Bean filter) {
		try {
			if (LOG.isTraceEnabled()) {
				LOG
						.trace("Starting the method to count records of specific HQL query: "
								+ queryName);
			}
			Session session = getHibernateSession();
			Query query = this.getQuery(session, queryName);
			if (query instanceof SQLQuery) {
				return countRecordsSQLQuery(session, query, filter);
			} else {
				return countRecordsHQLQuery(session, query, filter);
			}
		} catch (Exception ex) {
			String serviceName = (dbService != null ? dbService.getName()
					: null);

			if (LOG.isErrorEnabled()) {
				LOG
						.error(
								"Error occurred in processing of countRecords(String, Bean) method with query name ['"
										+ queryName
										+ "'] in datasource service ['"
										+ serviceName + "']", ex);
			}
			throw new BaseDAOException(ex, serviceName);
		}
	}

	/**
	 * Verifica a versão do banco de dados, se a versão for Oracle11g retorna
	 * true, caso contrario retorna false.
	 * 
	 * @return Boolean
	 */
	private Boolean isOracle11g() {
		try {
			final Session session = (Session) getHibernateSession();
			final int oracleVersion = session.connection().getMetaData()
					.getDatabaseMajorVersion();
			if (oracleVersion == ORACLE11G) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (HibernateException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Erro ao tentar recuperar a versao do oracle");
			}
			throw new BaseDAOException("Error during retrive oracle version.",
					e);
		} catch (SQLException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("Erro ao tentar recuperar a versao do oracle");
			}
			throw new BaseDAOException("Error during retrive oracle version.",
					e);
		}

	}

	/**
	 * Retorna a quantidade de registros para uma SQL query recebida como
	 * parâmetro.
	 * 
	 * @param session
	 *            Instância da Sessão do Hibernate.
	 * @param query
	 *            Instância de um objeto Query do Hibernate.
	 * @param filter
	 *            Instância do objeto que será utilizado como filtro.
	 * 
	 * @return Long Retorna o número de registros encontrados na query (HQL).
	 */
	@SuppressWarnings("unchecked")
	private Long countRecordsSQLQuery(Session session, Query query, Bean filter) {
		String sql = "select count(*) from (" + query.getQueryString() + ")";
		SQLQuery sqlQuery = session.createSQLQuery(sql);

		bindParameters(sqlQuery, filter);

		List result = sqlQuery.list();
		BigDecimal count = (BigDecimal) result.get(0);

		return count.longValue();
	}

	/**
	 * Retorna a quantidade de registros para a query (HQL) recebida como
	 * parâmetro.
	 * 
	 * @param session
	 *            Instância da Sessão do Hibernate.
	 * @param query
	 *            Instância de um objeto Query do Hibernate.
	 * @param filter
	 *            Instância do objeto que será utilizado como filtro.
	 * 
	 * @return Long Retorna o número de registros encontrados na query (HQL).
	 * 
	 * @throws Exception
	 *             Caso ocorra alguma exceção.
	 */
	private Long countRecordsHQLQuery(Session session, Query query, Bean filter)
			throws Exception {
		Connection connection = null;
		ResultSet rs = null;
		try {

			SessionFactoryImplementor implementor = (SessionFactoryImplementor) session
					.getSessionFactory();
			HQLQueryPlan queryPlan = implementor.getQueryPlanCache()
					.getHQLQueryPlan(query.getQueryString(), false, null);
			QueryTranslator translator = queryPlan.getTranslators()[0];
			ParameterTranslations parameterTranslations = translator
					.getParameterTranslations();

			String sql = "select count(*) from (" + translator.getSQLString()
					+ ")";
			LOG.trace("Native SQL that was mounted: " + sql);

			LOG.trace("Creating the JDBC connection and JDBC prepare statement"
					+ " to execute the count records query");
			connection = session.connection();
			PreparedStatement pstmt = connection.prepareStatement(sql);

			HashMap<String, Object> parameters = buildParameters(query
					.getNamedParameters(), filter, true);
			LOG.trace("Setting the parameters into the prepare statement"
					+ " for execute the count records query: "
					+ parameters.values());
			for (String key : parameters.keySet()) {
				int[] locations = parameterTranslations
						.getNamedParameterSqlLocations(key);
				for (int i = 0; i < locations.length; ++i) {
					if (parameters.get(key) instanceof Type) {
						Type type = (Type) parameters.get(key);
						pstmt.setObject(locations[i] + 1, null, type
								.sqlTypes(implementor)[0]);
					} else {
						if (parameters.get(key) instanceof Date) {
							pstmt.setDate(locations[i] + 1, new java.sql.Date(
									((Date) parameters.get(key)).getTime()));
						} else {
							pstmt.setObject(locations[i] + 1, parameters
									.get(key));
						}
					}
				}
			}
			LOG
					.trace("Executing the Prepared Statement of count records query");
			pstmt.execute();
			LOG
					.trace("Retrieving the number of records returned of query execution");
			rs = pstmt.getResultSet();
			rs.next();
			Long count = Long.valueOf(rs.getLong(1));
			LOG
					.trace("Closing the JDBC resources "
							+ "(ResultSet, PrepareStatement, Connection) after count records");
			rs.close();
			pstmt.close();
			connection.close();
			LOG.trace("Returning the number of records of specific HQL query: "
					+ count + " records");
			return count;
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List executeBatch(String batchCommand, BatchParameter[] parameters,
			boolean optimazer, Boolean suspendTransaction) {
		Session session;
		Connection connection = null;
		Statement stmt = null;
		HibernateTemplate hibernateTemplate;

		if (optimazer) {
			try {

				hibernateTemplate = new HibernateTemplate(getSessionFactory(),
						true/**/);
				session = hibernateTemplate.getSessionFactory()
						.getCurrentSession();
				connection = session.connection();
				stmt = connection.createStatement();
				if (!isOracle11g()) {
					stmt.executeUpdate(ALTER_SESSION_OPTIMIZER_MODE_9I);
				}

				return super.executeBatch(batchCommand, parameters, connection,
						suspendTransaction);
			} catch (Exception ex) {
				if (ex instanceof BaseDAOException)
					throw (BaseDAOException) ex;

				if (LOG.isErrorEnabled())
					LOG
							.error(
									"Error occurried in processing of executeBatch(String, BatchParameter[]) method with batch command ['"
											+ batchCommand
											+ "'] and list of parameters ['"
											+ ArrayUtils.toString(parameters)
											+ "'] in datasource service ['"
											+ dbService.getName() + "']", ex);

				throw new BaseDAOException(ex);
			} finally {
				JdbcUtils.closeStatement(stmt);
				JdbcUtils.closeConnection(connection);
			}
		}
		return executeBatch(batchCommand, parameters);
	}

}
