/**
 * GetCodigoRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public class GetCodigoRequest  implements java.io.Serializable {
    private java.math.BigInteger parametrocodigo;

    public GetCodigoRequest() {
    }

    public GetCodigoRequest(
           java.math.BigInteger parametrocodigo) {
           this.parametrocodigo = parametrocodigo;
    }


    /**
     * Gets the parametrocodigo value for this GetCodigoRequest.
     * 
     * @return parametrocodigo
     */
    public java.math.BigInteger getParametrocodigo() {
        return parametrocodigo;
    }


    /**
     * Sets the parametrocodigo value for this GetCodigoRequest.
     * 
     * @param parametrocodigo
     */
    public void setParametrocodigo(java.math.BigInteger parametrocodigo) {
        this.parametrocodigo = parametrocodigo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCodigoRequest)) return false;
        GetCodigoRequest other = (GetCodigoRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.parametrocodigo==null && other.getParametrocodigo()==null) || 
             (this.parametrocodigo!=null &&
              this.parametrocodigo.equals(other.getParametrocodigo())));
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
        if (getParametrocodigo() != null) {
            _hashCode += getParametrocodigo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCodigoRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", ">getCodigoRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parametrocodigo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "parametrocodigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
