package br.com.netservicos.netcrmcore.venda.extensaofone.facade;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * respons�vel pelo manuten��o extens�o fone.
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 *
 *
 * @version $Revision: 1.4 $
 */
public interface ManutencaoExtensaoFoneService extends Service {
	
	/**
	 * Opera��o que realiza a manuten��o de extens�o fone.
	 * 
	 * @param dadosExtensao Entidade que cont�m os dados de extens�o fone.
	 */
	String[] solicitarExtensaoFone(Bean dadosExtensao);
}
