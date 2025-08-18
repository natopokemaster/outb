package br.com.netservicos.relacionar.cliente.control;

/**
 */
@org.apache.beehive.controls.api.bean.ControlExtension
@com.bea.wli.common.control.Location(uri="/NETClienteWLIWeb/br/com/netservicos/relacionar/cliente/processos/DadoCobrancaJPDV1_0.jpd")
public interface DadoCobrancaProcessControl extends com.bea.control.ProcessControl
{
    public br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaRegistroType alterar(br.com.netservicos.v2.netHeader.NetHeaderDocument netHeader, br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaType dadoCobrancaType);

    public DadoCobrancaProcessControl create();

    static final long serialVersionUID = 1L;
}

