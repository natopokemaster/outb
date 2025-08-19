package br.com.netservicos.netcrmcore.venda.extensaofone.facade;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * responsável pelo manutenção extensão fone.
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
	 * Operação que realiza a manutenção de extensão fone.
	 * 
	 * @param dadosExtensao Entidade que contém os dados de extensão fone.
	 */
	String[] solicitarExtensaoFone(Bean dadosExtensao);
}
