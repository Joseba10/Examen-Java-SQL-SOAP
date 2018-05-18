/**
 * UniveridadPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ipartek.formacion.web_service_soap;

public interface UniveridadPort extends java.rmi.Remote {
    // getCodido is a notification style operation and is unsupported.;
    public com.ipartek.formacion.web_service_soap.GetAlumnoResponse getAlumno(com.ipartek.formacion.web_service_soap.GetAlumnoRequest getAlumnoRequest) throws java.rmi.RemoteException;
    public void getCodigo(com.ipartek.formacion.web_service_soap.GetCodigoRequest getCodigoRequest) throws java.rmi.RemoteException;
}
