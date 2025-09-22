package br.com.netservicos.infraestrutura.rede.transform; 

import com.bea.wli.transform.DataTransformation;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;
import java.io.Serializable;

@DataTransformation()
public abstract class CriaNotificacaoOutageJPDV1_0Transformation implements com.bea.transform.TransformSource
{
    static final long serialVersionUID = 1L;

	
	public static class databaseControlsetCurrentDataSourceObject implements java.io.Serializable {
		public java.lang.String cidadeContrato;

		public java.lang.String jdbcRealm;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0databaseControlsetCurrentDataSource.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract databaseControlsetCurrentDataSourceObject databaseControlsetCurrentDataSource(java.lang.String jdbcRealm, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlconsultarRolloutOutage.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract java.lang.String outageLegadoJDBCControlconsultarRolloutOutage(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);

	

	public static class outageCustomControlgeraSqlParamAtualizarEnvioWAObject implements java.io.Serializable {
		public java.lang.String pIdNotificacao;

		public java.lang.String pCidContrato;

		public java.lang.String pTpEvento;

		public java.lang.String pFcEnvio;

		public java.lang.String pDsErro;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamAtualizarEnvioWA.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract outageCustomControlgeraSqlParamAtualizarEnvioWAObject outageCustomControlgeraSqlParamAtualizarEnvioWA(java.lang.String dsErro, java.lang.String fcEnvio, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros, java.lang.String tpEvento);


	public static class outageCustomControlgeraSqlParamAtualizarEnvioWA2Object implements java.io.Serializable {
		public java.lang.String pIdNotificacao;

		public java.lang.String pCidContrato;

		public java.lang.String pTpEvento;

		public java.lang.String pFcEnvio;

		public java.lang.String pDsErro;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamAtualizarEnvioWA2.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract outageCustomControlgeraSqlParamAtualizarEnvioWA2Object outageCustomControlgeraSqlParamAtualizarEnvioWA2(java.lang.String dsErro, java.lang.String fcEnvio, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros, java.lang.String tpEvento);


	public static class instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject implements java.io.Serializable {
		public br.com.netservicos.v2.netHeader.NetHeaderDocument request_Header_arg;

		public br.com.netservicos.instalacao.ConsultarEnderecoDomicilioPorContratoRequestDocument consultarEnderecoDomicilioPorContratoRequest_arg;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorContrato.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject instalacaoServiceControlconsultarEnderecoDomicilioPorContrato(br.com.netservicos.v2.netHeader.NetHeaderDocument header, java.lang.String numContrato, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros, java.lang.String versao);


	public static class outageLegadoJDBCControlbuscarContratoNotificacaoObject implements java.io.Serializable {
		public java.lang.String pCidContrato;

		public java.lang.String pNotificacao;

		public java.lang.String pLogradouro;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlbuscarContratoNotificacao.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract outageLegadoJDBCControlbuscarContratoNotificacaoObject outageLegadoJDBCControlbuscarContratoNotificacao(java.lang.String logradouroId, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageIntegracaoWAServiceControlnotifyOutageRequest.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract br.com.netservicos.workassure.outage.NotifyOutageRequestDocument outageIntegracaoWAServiceControlnotifyOutageRequest(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0outageIntegracaoWAServiceControlnotifyOutageRequest2.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract br.com.netservicos.workassure.outage.NotifyOutageRequestDocument outageIntegracaoWAServiceControlnotifyOutageRequest2(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);


  public static class instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject implements java.io.Serializable {
		public br.com.netservicos.v2.netHeader.NetHeaderDocument request_Header_arg;

		public br.com.netservicos.instalacao.ConsultarEnderecoDomicilioPorIDRequestDocument consultarEnderecoDomicilioPorIDRequest_arg;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorID.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject instalacaoServiceControlconsultarEnderecoDomicilioPorID(java.lang.String idEnderInstalacao, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros, java.lang.String versao, br.com.netservicos.v2.netHeader.NetHeaderDocument header);



	public static class outageCustomControlgeraSqlParamCriarOutageNode2Object implements java.io.Serializable {
		public java.lang.String usuario;

		public br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument doc;

		public java.lang.String nodeId;
	}

	@com.bea.wli.transform.XQueryTransform(transformType = com.bea.wli.transform.XQueryTransform.TransformMethodType.XQUERY_REF, value = "CriaNotificacaoOutageJPDV1_0geraSqlParamCriarOutageNode.xq", schemaValidate = @com.bea.wli.transform.XQueryTransform.SchemaValidate(returnValue = false, parameters = false))
	public abstract outageCustomControlgeraSqlParamCriarOutageNode2Object outageCustomControlgeraSqlParamCriarOutageNode2(br.com.netservicos.v2.netHeader.NetHeaderDocument header, br.com.netservicos.rede.outage.Node forEachNode, br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros);

	}
