/*
 * Created on 31/03/2011
 * Project : NETGESCOMCommon
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.gescom.avisorelacionamento.carta.pdf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.framework.util.loader.ResourceLoader;
import br.com.netservicos.gescom.carta.ContentXMLReader;
import br.com.netservicos.gescom.carta.renderer.ContentRenderer;

import static java.lang.String.format;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INIT_BOLD;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INI_REP_BOLD;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INIT_ITALIC;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INI_REP_ITALIC;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INI_UNDERLINE;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.INI_REP_ULINE;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.END_TAG;
import static br.com.netservicos.netcrmcore.gescom.constants.GescomConstants.END_REPLACEMENT;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.SIM;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.PARAM_POSSUI_COMBO_MULTI;
import static br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants.PARAM_BASE_LOGADA;


/**
 *
 * <p><b>Description: </b><br>
 * Base de um renderizador Carta de Acordo Comercial para PDF.
 *
 * </p>
 * <b>
 * Issues: <br>
 *
 * </b>
 * @author diego.amaral
 * @since 26/05/2011
 * @version
 */
public abstract class AbstractCartaAcordoComercial implements ContentRenderer{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOG = LogFactory.getLog(AbstractCartaAcordoComercial.class);
	
	/**
	 * Identifica o formato do arquivo gerado.
	 */
	private static final String APPLICATION_PDF = "application/pdf";

	/**
	 * Sufixo utilizado para subreport.
	 */
	private static final String SUFIX_SUBREP = "_SUBREPORT";
	/**
	 * Sufixo utilizado para DS.
	 */
	private static final String SUFIX_DS = "_DATA_SOURCE";

	/**
	 * Subreports a serem carregados.
	 */
	public static final Map<String, String> SUB_REPORTS = new TreeMap<String, String>();

	private static final String FMT_REPORT_NAME = "%s%s.jasper";
	private static final String CLARO = "CLARO";
	private static final String EMPTY_STRING = "";
    private static final String FMT_MSG_REPORT_FOUND = "Report '%s' encontrado em cache.";
    private static final String FMT_MSG_REPORT_NOT_LOADED = "Nao foi possivel carregar o arquivo: %s";
    private static final String FMT_MSG_LOADING_REPORT = "Carregando report: %s";
    private static final String FMT_RESOURCE_NAME = "%s/%s";
    private static final String FMT_MSG_RESOURCE_IMG_NAME = "Path da imagem: : %s/%s";
	private static final String BANNER_HEADER_CLARO = "banner_header_claro.png";
	private static final String BANNER_FOOTER_CLARO = "banner_footer_claro.png";
	private static final String FMT_MSG_BANNERS_CLARO = "Carregando o banners da claro: header:[%s] - footer:[%s]";
	private static final String PARAM_NAME_IMG_BANNER = "IMG_BANNER";
	private static final String PARAM_NAME_IMG_FOOTER = "IMG_FOOTER";
	private static final String BANNER_HEADER = "banner_header.png";
	private static final String BANNER_HEADER_COMBO_MULTI = "banner_header_combo_multi.png";

	/**
	 * Cache de reports carregados em mememória. Evitar o IO.
	 */
	private static Map<String, JasperReport> reportCache = new TreeMap<String, JasperReport>();
	/**
	 * Reader do XML.
	 */
	private transient ContentXMLReader reader;
	/**
	 * Parametros do relatório
	 */
	private final transient Map<String, Object> parameters = new HashMap<String, Object>();
	/**
	 * Conteúdo do relatório.
	 */
	private transient ByteArrayInputStream content;

	static{
		SUB_REPORTS.put("Q1", "Q1SubReport.jasper");
		SUB_REPORTS.put("Q2", "Q2SubReport.jasper");
		SUB_REPORTS.put("Q3", "Q3SubReport.jasper");
		SUB_REPORTS.put("Q4", "Q4SubReport.jasper");
		SUB_REPORTS.put("Q5", "Q5SubReport.jasper");
		SUB_REPORTS.put("Q6", "Q6SubReport.jasper");
	}


	public String getContentType() {
		return APPLICATION_PDF;
	}

	public void setXMLContent(final String xml) {
		this.reader = new ContentXMLReader(xml);
	}
	public void setContentReader(final ContentXMLReader reader){
		this.reader = reader;
	}

	/**
	 * Obtém o conteúdo processado.
	 */
	public ByteArrayInputStream getContent(){
		return this.content;
	}

	/**
	 * Gera o pdf
	 */
	public void build() {
		LOG.info("Gerando PDF de Aviso de Relacionamento...");
		try {
			LOG.info(format("Carregando report '%s'", getReportName()));

            String reportNameSufix = loadParameters();
			loadMappedSubreport();
			
			final JasperPrint jasperPrint = JasperFillManager.fillReport(
											loadLocalResource(format(FMT_REPORT_NAME, getReportName(), reportNameSufix)),
											this.parameters,
											new JREmptyDataSource());

			this.content = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jasperPrint));

		} catch (final JRException exception) {
		    LOG.warn("Erro durante o 'build' da carta!", exception);
			throw new BaseFailureException(exception);
		}
	}
	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Carrega os subrelatorios para o relatorio principal.
	 * <p>
	 *
	 * @param reportName
	 * @since 22/03/2011
	 * @return {@link JasperReport}
	 */
	private JasperReport loadReport(final String reportName) {
		LOG.info(format(FMT_MSG_LOADING_REPORT, reportName));
		try {
            JasperReport report = reportCache.get(reportName);
			if (report == null) {
				report = (JasperReport) JRLoader.loadObject(loadLocalResource(reportName));
				reportCache.put(reportName, report);
				if(LOG.isDebugEnabled() && report != null){
					LOG.debug(format(FMT_MSG_REPORT_FOUND, reportName));
				}
			}
            return report;
        } catch (final Exception exp) {
            throw new BaseFailureException(format(FMT_MSG_REPORT_NOT_LOADED, reportName), exp);
        }
	}
	/**
	 *
	 * <p><b>Description:</b><br/>
	 * Carrega um arquivo (imagem/jasper) local.
	 * <p>
	 * @param resourceName
	 * @return
	 * @since 14/07/2011
	 * @author diego.amaral
	 */
	private InputStream loadLocalResource(final String resourceName){
		final String path = getClass().getPackage().getName().replaceAll("\\.", "/");
		if (LOG.isInfoEnabled()) {
		    LOG.info(format(FMT_MSG_RESOURCE_IMG_NAME, path, resourceName));
        }
		return new ResourceLoader(format(FMT_RESOURCE_NAME, path, resourceName)).getStream();
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por definir os parametros para montar a carta.
     * <p>
     *
     * @since 20/04/2011
     * @return DynamicBean
     */
	private String loadParameters() {
		
		LOG.info("Obtendo parametros para montar a carta...");
		String reportNameSufix = EMPTY_STRING;
		try {
            String baseLogada = reader.getParameters().get(PARAM_BASE_LOGADA);
			baseLogada = baseLogada == null ? EMPTY_STRING : baseLogada.trim();
			LOG.info(format("Base Logada: [%s]", baseLogada));
			if (CLARO.equals(baseLogada)){
				LOG.info(format(FMT_MSG_BANNERS_CLARO, BANNER_HEADER_CLARO, BANNER_FOOTER_CLARO));
				this.parameters.put(PARAM_NAME_IMG_BANNER, loadLocalResource(BANNER_HEADER_CLARO));
				this.parameters.put(PARAM_NAME_IMG_FOOTER, loadLocalResource(BANNER_FOOTER_CLARO));
                reportNameSufix = CLARO;
			} else {
				String possuiComboMulti = reader.getParameters().get(PARAM_POSSUI_COMBO_MULTI);
				this.parameters.put(PARAM_NAME_IMG_BANNER, loadLocalResource(
						SIM.equalsIgnoreCase(possuiComboMulti) ? BANNER_HEADER_COMBO_MULTI : BANNER_HEADER));
			}
			reader.getParameters().remove(PARAM_BASE_LOGADA);
		} catch(Exception e) {
			LOG.warn("Erro ao carregar o banner!", e);
			this.parameters.put(PARAM_NAME_IMG_BANNER, loadLocalResource(BANNER_HEADER));
        }

		treatStyle(this.reader.getTexts());
		this.parameters.putAll(this.reader.getTexts());
		this.parameters.putAll(this.reader.getParameters());
		
		return reportNameSufix;
		
	}
	/**
	 *
	 * <p><b>Description:</b><br/>
	 * Carrega os subreports.
	 * <p>
	 * @since 14/07/2011
	 * @author diego.amaral
	 */
	private void loadMappedSubreport() {
		String key;
		for(final Map.Entry<String, String> entry : SUB_REPORTS.entrySet()){
			key = entry.getKey();
			if(this.reader.getGrids().containsKey(key)){
				if(LOG.isDebugEnabled()){
					LOG.info(format("Adicionando grid '%s'", key));
				}
				this.parameters.put(key + SUFIX_SUBREP, loadReport(entry.getValue()));
				this.parameters.put(key + SUFIX_DS, createCollectionDS(this.reader.getGrid(key)));
			}
		}
	}
	/*
	 * Cria um DS Collection.
	 */
	private static JRBeanCollectionDataSource createCollectionDS(final Collection<?> collection){
		return new JRBeanCollectionDataSource(collection);
	}

	/**
     * <p>
     * <b>Description:</b><br/>
     * Metodo responsavel por configurar os textos para carta.
     * <p>
	 * @param map Map...
	 */
	private void treatStyle(final Map<String, String> map){

		for(final Map.Entry<String, String> entry : map.entrySet()){
            String value = entry.getValue();
			if (value != null) {
				value = value.replaceAll(INIT_BOLD, INI_REP_BOLD)
                        .replaceAll(INIT_ITALIC, INI_REP_ITALIC)
                        .replaceAll(INI_UNDERLINE, INI_REP_ULINE)
                        .replaceAll(END_TAG, END_REPLACEMENT);
				if(LOG.isDebugEnabled()){
					LOG.debug(format("parsed value '%s' -> %s", entry.getKey(), value));
				}
				entry.setValue(value);
			}
		}
	}


}
