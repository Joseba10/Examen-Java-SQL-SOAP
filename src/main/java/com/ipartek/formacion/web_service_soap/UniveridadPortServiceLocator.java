/**
 * UniveridadPortServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public class UniveridadPortServiceLocator extends org.apache.axis.client.Service implements com.ipartek.formacion.web_service_soap.UniveridadPortService {

    public UniveridadPortServiceLocator() {
    }


    public UniveridadPortServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UniveridadPortServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for univeridadPortSoap11
    private java.lang.String univeridadPortSoap11_address = "http://192.168.0.42:8080/ws";

    public java.lang.String getuniveridadPortSoap11Address() {
        return univeridadPortSoap11_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String univeridadPortSoap11WSDDServiceName = "univeridadPortSoap11";

    public java.lang.String getuniveridadPortSoap11WSDDServiceName() {
        return univeridadPortSoap11WSDDServiceName;
    }

    public void setuniveridadPortSoap11WSDDServiceName(java.lang.String name) {
        univeridadPortSoap11WSDDServiceName = name;
    }

    public com.ipartek.formacion.web_service_soap.UniveridadPort getuniveridadPortSoap11() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(univeridadPortSoap11_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getuniveridadPortSoap11(endpoint);
    }

    public com.ipartek.formacion.web_service_soap.UniveridadPort getuniveridadPortSoap11(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ipartek.formacion.web_service_soap.UniveridadPortSoap11Stub _stub = new com.ipartek.formacion.web_service_soap.UniveridadPortSoap11Stub(portAddress, this);
            _stub.setPortName(getuniveridadPortSoap11WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setuniveridadPortSoap11EndpointAddress(java.lang.String address) {
        univeridadPortSoap11_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ipartek.formacion.web_service_soap.UniveridadPort.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ipartek.formacion.web_service_soap.UniveridadPortSoap11Stub _stub = new com.ipartek.formacion.web_service_soap.UniveridadPortSoap11Stub(new java.net.URL(univeridadPortSoap11_address), this);
                _stub.setPortName(getuniveridadPortSoap11WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("univeridadPortSoap11".equals(inputPortName)) {
            return getuniveridadPortSoap11();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "univeridadPortService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://formacion.ipartek.com/web-service-soap", "univeridadPortSoap11"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("univeridadPortSoap11".equals(portName)) {
            setuniveridadPortSoap11EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
