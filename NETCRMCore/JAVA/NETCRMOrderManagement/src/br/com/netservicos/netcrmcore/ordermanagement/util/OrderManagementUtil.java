package br.com.netservicos.netcrmcore.ordermanagement.util;

import br.com.netservicos.framework.core.bean.Bean;

public final class OrderManagementUtil {

	private static final String LINE_FEED = "\n";
	
	private OrderManagementUtil(){
		super();
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