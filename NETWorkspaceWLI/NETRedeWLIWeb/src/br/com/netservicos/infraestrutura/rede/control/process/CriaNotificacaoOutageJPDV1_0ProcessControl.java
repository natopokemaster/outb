package br.com.netservicos.infraestrutura.rede.control.process;

/**
 */
@org.apache.beehive.controls.api.bean.ControlExtension
@com.bea.wli.common.control.Location(uri="/NETRedeWLIWeb/br/com/netservicos/infraestrutura/rede/CriaNotificacaoOutageJPDV1_0.jpd")
public interface CriaNotificacaoOutageJPDV1_0ProcessControl extends com.bea.control.ProcessControl
{
    public java.lang.String criar(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument request, br.com.netservicos.v2.netHeader.NetHeaderDocument header);

    public CriaNotificacaoOutageJPDV1_0ProcessControl create();

    static final long serialVersionUID = 1L;
}

