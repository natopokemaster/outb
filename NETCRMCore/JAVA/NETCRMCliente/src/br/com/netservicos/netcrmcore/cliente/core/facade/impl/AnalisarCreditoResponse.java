/**
 * AnalisarCreditoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.netservicos.netcrmcore.cliente.core.facade.impl;

public class AnalisarCreditoResponse  implements java.io.Serializable {
    private java.lang.String analisarCreditoResult;

    public AnalisarCreditoResponse() {
    }

    public AnalisarCreditoResponse(
           java.lang.String analisarCreditoResult) {
           this.analisarCreditoResult = analisarCreditoResult;
    }


    /**
     * Gets the analisarCreditoResult value for this AnalisarCreditoResponse.
     * 
     * @return analisarCreditoResult
     */
    public java.lang.String getAnalisarCreditoResult() {
        return analisarCreditoResult;
    }


    /**
     * Sets the analisarCreditoResult value for this AnalisarCreditoResponse.
     * 
     * @param analisarCreditoResult
     */
    public void setAnalisarCreditoResult(java.lang.String analisarCreditoResult) {
        this.analisarCreditoResult = analisarCreditoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnalisarCreditoResponse)) return false;
        AnalisarCreditoResponse other = (AnalisarCreditoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.analisarCreditoResult==null && other.getAnalisarCreditoResult()==null) || 
             (this.analisarCreditoResult!=null &&
              this.analisarCreditoResult.equals(other.getAnalisarCreditoResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAnalisarCreditoResult() != null) {
            _hashCode += getAnalisarCreditoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
