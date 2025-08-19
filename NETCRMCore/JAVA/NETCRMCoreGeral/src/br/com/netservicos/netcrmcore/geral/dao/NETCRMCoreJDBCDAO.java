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
 * with Sun.
 */
package br.com.netservicos.netcrmcore.geral.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.support.JdbcUtils;

import br.com.netservicos.framework.core.dao.BaseDAOException;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.core.dao.JDBCDAO;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * <p>
 * <b>Description: </b><br>
 * Customização do DAO para verificar a base e alterar o modo de otimização do
 * banco de acordo com a versão.
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
public class NETCRMCoreJDBCDAO extends JDBCDAO {

	private static final int ORACLE11G = 11;
	private static final String ALTER_SESSION_OPTIMIZER_MODE_9I = "alter session set optimizer_mode = rule";

	private static final Log LOG = LogFactory.getLog(NETCRMCoreJDBCDAO.class);

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List executeBatch(String batchCommand, BatchParameter[] parameters,
			boolean optimazer, Boolean suspendTransaction) {

		Statement stmt = null;
		Connection connection = null;

		try {
			connection = getConnection();

			stmt = connection.createStatement();
			if (optimazer) {
				if (!this.isOracle11g(connection)) {
					stmt.executeUpdate(ALTER_SESSION_OPTIMIZER_MODE_9I);
				}
			}

			return executeBatch(batchCommand, parameters, connection,
					suspendTransaction);
		} catch (Exception ex) {
			if ((ex instanceof BaseFailureException)
					|| (ex instanceof BaseDAOException))
				throw (RuntimeException) ex;
			else
				throw new BaseDAOException(ex);
		} finally {
			JdbcUtils.closeStatement(stmt);
			JdbcUtils.closeConnection(connection);
		}

	}

	/**
	 * Verifica a versão do banco de dados, se a versão for Oracle11g retorna
	 * true, caso contrario retorna false.
	 * 
	 * @return Boolean
	 * @throws ABSException
	 */
	public static Boolean isOracle11g(final Connection conn)
			throws SQLException {
		try {
			int oracleVersion = conn.getMetaData().getDatabaseMajorVersion();
			if (oracleVersion == ORACLE11G) {
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		} catch (SQLException e) {
			LOG.error("Erro ao tentar recuperar a versao do oracle");
			throw e;
		}

	}

}
