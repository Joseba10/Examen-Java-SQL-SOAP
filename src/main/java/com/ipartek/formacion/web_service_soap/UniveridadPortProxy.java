package com.ipartek.formacion.web_service_soap;

public class UniveridadPortProxy implements com.ipartek.formacion.web_service_soap.UniveridadPort {
  private String _endpoint = null;
  private com.ipartek.formacion.web_service_soap.UniveridadPort univeridadPort = null;
  
  public UniveridadPortProxy() {
    _initUniveridadPortProxy();
  }
  
  public UniveridadPortProxy(String endpoint) {
    _endpoint = endpoint;
    _initUniveridadPortProxy();
  }
  
  private void _initUniveridadPortProxy() {
    try {
      univeridadPort = (new com.ipartek.formacion.web_service_soap.UniveridadPortServiceLocator()).getuniveridadPortSoap11();
      if (univeridadPort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)univeridadPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)univeridadPort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (univeridadPort != null)
      ((javax.xml.rpc.Stub)univeridadPort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ipartek.formacion.web_service_soap.UniveridadPort getUniveridadPort() {
    if (univeridadPort == null)
      _initUniveridadPortProxy();
    return univeridadPort;
  }
  
  public com.ipartek.formacion.web_service_soap.GetAlumnoResponse getAlumno(com.ipartek.formacion.web_service_soap.GetAlumnoRequest getAlumnoRequest) throws java.rmi.RemoteException{
    if (univeridadPort == null)
      _initUniveridadPortProxy();
    return univeridadPort.getAlumno(getAlumnoRequest);
  }
  
  public void getCodigo(com.ipartek.formacion.web_service_soap.GetCodigoRequest getCodigoRequest) throws java.rmi.RemoteException{
    if (univeridadPort == null)
      _initUniveridadPortProxy();
    univeridadPort.getCodigo(getCodigoRequest);
  }
  
  
}