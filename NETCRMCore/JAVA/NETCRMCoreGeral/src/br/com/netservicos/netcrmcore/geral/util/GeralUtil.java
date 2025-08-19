package br.com.netservicos.netcrmcore.geral.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class GeralUtil {
	
    private final static Log LOGGER = LogFactory.getLog(GeralUtil.class);

    
     public static String[] REPLACES = { "a", "e", "i", "o", "u", "c", "A", "E", "I", "O", "U", "C" };  
       
     public static Pattern[] PATTERNS = null;  
       
     public static void compilePatterns() {  
           PATTERNS = new Pattern[REPLACES.length];  
           PATTERNS[0]  = Pattern.compile("[‚„·‡‰]");  
           PATTERNS[1]  = Pattern.compile("[ÈËÍÎ]");  
           PATTERNS[2]  = Pattern.compile("[ÌÏÓÔ]");  
           PATTERNS[3]  = Pattern.compile("[ÛÚÙıˆ]");  
           PATTERNS[4]  = Pattern.compile("[˙˘˚¸]");  
           PATTERNS[5]  = Pattern.compile("[Á]");  
           PATTERNS[6]  = Pattern.compile("[¬√¡¿ƒ]");  
           PATTERNS[7]  = Pattern.compile("[…» À]");  
           PATTERNS[8]  = Pattern.compile("[ÕÃŒœ]");  
           PATTERNS[9]  = Pattern.compile("[”“‘’÷]");  
           PATTERNS[10] = Pattern.compile("[⁄Ÿ€‹]");  
           PATTERNS[11] = Pattern.compile("[«]");  
    }  
     
     
    private GeralUtil() {
    }
    
     /** 
         * Substitui os caracteres acentuados por nao acentuados. 
         *  
         * @param text 
         * @return 
         */  
    public static String replaceCaracteresSpeciais(String text) {  
           if (PATTERNS == null) {  
              compilePatterns();  
           }  
       
           String result = text;  
           for (int i = 0; i < PATTERNS.length; i++) {  
              Matcher matcher = PATTERNS[i].matcher(result);  
              result = matcher.replaceAll(REPLACES[i]);  
           }  
           return result;  
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
     * @return Long
     * @since  22/09/2010
     */
    public static Long toLong(final BigDecimal number) {
        if (!isNull(number)) {
            return number.longValue();
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
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param number
     * @return String
     * @since  22/09/2010
     */
    public static String preencheZero(String codigo,int tamFinal){        
        if (tamFinal > codigo.length()) {           
          int indice = tamFinal - codigo.length();
          for (int i=0; i<indice; i++) {
             codigo = "0" + codigo;
          }         
        }
        return codigo.trim();       
    }
    
    /**
     * <p>
     * <b>Description: Formata o DDD de um telefone para conter somente 2 digitos  </b><br/>
     * <p>
     * 
     * @param String DDD de telefone
     * @return String DDD formatado
     * @since 22/09/2010
     */
    public static String formataDDD(String dddOld) {
        if(dddOld != null ){
        	dddOld = dddOld.trim();	        	
        	if(dddOld.length() == 3 && dddOld.charAt(0) == '0'){
        		dddOld = dddOld.substring(1,3);
        	}else if(dddOld.length()>=2){
        		dddOld = dddOld.substring(0,2);
        	}else{
        		dddOld="00";
        	}
        }
        return dddOld;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * Copia dados de um Objeto para outro Objeto.
     * <p>
     * @param Object
     * @param Object
     * @return boolean
     * @since 30/09/2010
     * @author Alessandro Mariano
     */
    public static Object copyProperties(final Object destino, final Object origem) {
        try {
            BeanUtils.copyProperties(destino, origem);
        } catch (final Exception execption) {
            LOGGER.error(execption.getMessage());
        }
        return destino; 
    }

}
