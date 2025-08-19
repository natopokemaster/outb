package br.com.netservicos.netcrmcore.webservices.prospect.manutencaodadoscadastrais.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class AlteracaoDadosCadastraisProspectType implements BaseComplexType {

	private static final long serialVersionUID = 317951561921978624L;

    private IdentificacaoOperadoraType cidadeOperadora;
	private String idProspect;
	private String idTipoPessoa;
	private String dsNome;
	private String dsComplemento;
	private String sexo;
	private String dsEmail;
	private String dtNascimento;
	private String dsCpf;
	private String dsCnpj;
	private String dsRg;
	private String dsIe;
	private String dddCelular;
	private String dddTelCom;
	private String dddTelRes;
	private String telCelular;
	private String telComercial;
	private String telResidencial;
	private String profissao;
    private String orgaoExpedidor;
    private String estadoCivil;

    public IdentificacaoOperadoraType getCidadeOperadora() {
        return cidadeOperadora;
    }
    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }
    public String getIdProspect() {
        return idProspect;
    }
    public void setIdProspect(String idProspect) {
        this.idProspect = idProspect;
    }
    public String getIdTipoPessoa() {
        return idTipoPessoa;
    }
    public void setIdTipoPessoa(String idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }
    public String getDsNome() {
        return dsNome;
    }
    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }
    public String getDsComplemento() {
        return dsComplemento;
    }
    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getDsEmail() {
        return dsEmail;
    }
    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }
    public String getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public String getDsCpf() {
        return dsCpf;
    }
    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }
    public String getDsCnpj() {
        return dsCnpj;
    }
    public void setDsCnpj(String dsCnpj) {
        this.dsCnpj = dsCnpj;
    }
    public String getDsRg() {
        return dsRg;
    }
    public void setDsRg(String dsRg) {
        this.dsRg = dsRg;
    }
    public String getDsIe() {
        return dsIe;
    }
    public void setDsIe(String dsIe) {
        this.dsIe = dsIe;
    }
    public String getDddCelular() {
        return dddCelular;
    }
    public void setDddCelular(String dddCelular) {
        this.dddCelular = dddCelular;
    }
    public String getDddTelCom() {
        return dddTelCom;
    }
    public void setDddTelCom(String dddTelCom) {
        this.dddTelCom = dddTelCom;
    }
    public String getDddTelRes() {
        return dddTelRes;
    }
    public void setDddTelRes(String dddTelRes) {
        this.dddTelRes = dddTelRes;
    }
    public String getTelCelular() {
        return telCelular;
    }
    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }
    public String getTelComercial() {
        return telComercial;
    }
    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }
    public String getTelResidencial() {
        return telResidencial;
    }
    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
