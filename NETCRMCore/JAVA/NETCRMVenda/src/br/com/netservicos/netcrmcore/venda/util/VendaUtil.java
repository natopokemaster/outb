package br.com.netservicos.netcrmcore.venda.util;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.framework.core.bean.Bean;

/**
 * <p>
 * <b>Description: </b><br>
 * </p>
 * Venda Manipulation Library. <b> Issues: <br>
 * </b>
 * 
 * @author Alessandro Mariano
 * @since 23/09/2010
 * @version 1.0
 */
public final class VendaUtil {

	/**
	 * Logger
	 */
	private final static Log LOGGER = LogFactory.getLog(VendaUtil.class);
	
	 private static final String LINE_FEED = "\n";

	/**
	 * Construtor Padrão.
	 */
	private VendaUtil() {
		super();
	}
	
	  /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param object
     * @return String
     * @since 22/09/2010
     */
    public static String getString(final Object object) {
        if (!isNull(object)) {
            return (String) object;
        }
        return "";

    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param object
     * @return String
     * @since  22/09/2010
     */
    public static String toString(final Object object) {
        if (!isNull(object)) {
            return String.valueOf(object);
        }
        return null;

    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param object
     * @return Boolean
     * @since 22/09/2010
     */
    public static boolean isNull(final Object object) {
        return object == null;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param number
     * @return Integer
     * @since  22/09/2010
     */
    public static Integer toInteger(final String number) {
        if (!isEmpty(number)) {
            return Integer.valueOf(number);
        }
        return null;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param string
     * @return boolean
     * @since22/09/2010
     */
    public static boolean isEmpty(final String string) {
        return isNull(string) || StringUtils.isEmpty(string);
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param number
     * @return Long
     * @since  22/09/2010
     */
    public static Long toLong(final String number) {
        if (!isEmpty(number)) {
            return Long.valueOf(number);
        }
        return null;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param number
     * @return BigDecimal
     * @since  22/09/2010
     */
    public static BigDecimal toBigDecimal(String number) {
        if (!isEmpty(number)) {
            return new BigDecimal(number);
        }
        return null;
    }
    
    /**
     * 
     * Retorna a propriedade de um bean. Se estiver null, retorna String vazia.
     * 
     * @param b
     * @param property
     * @return
     * 
     * @since 04/02/2010
     */
    public static String getBeanProperty(Bean b, String property) {
        String res = b.getBeanProperty(property);
        
        if (res == null) {
            res = "";
        }
        
        return res;
    }

    public static String getLineFeed(){
        return LINE_FEED;
    }
    
}
