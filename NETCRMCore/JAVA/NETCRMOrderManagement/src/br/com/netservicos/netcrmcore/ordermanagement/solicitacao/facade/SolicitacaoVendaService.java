package br.com.netservicos.netcrmcore.ordermanagement.solicitacao.facade;

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
 * @version $Revision: 1.5 $
 */
public interface SolicitacaoVendaService extends Service {
	/**
	 * Operação que realiza a manutenção de extensão fone.
	 * 
	 * @param dadosExtensao Entidade que contém os dados de extensão fone.
	 */
	Long inserirSolicitacaoExtensaoFone(Bean dadosSolicitacao);
}
