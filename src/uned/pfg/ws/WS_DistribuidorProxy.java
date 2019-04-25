package uned.pfg.ws;

public class WS_DistribuidorProxy implements uned.pfg.ws.WS_Distribuidor {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Distribuidor wS_Distribuidor = null;
  
  public WS_DistribuidorProxy() {
    _initWS_DistribuidorProxy();
  }
  
  public WS_DistribuidorProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_DistribuidorProxy();
  }
  
  private void _initWS_DistribuidorProxy() {
    try {
      wS_Distribuidor = (new uned.pfg.ws.WS_DistribuidorServiceLocator()).getWS_Distribuidor();
      if (wS_Distribuidor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Distribuidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Distribuidor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Distribuidor != null)
      ((javax.xml.rpc.Stub)wS_Distribuidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Distribuidor getWS_Distribuidor() {
    if (wS_Distribuidor == null)
      _initWS_DistribuidorProxy();
    return wS_Distribuidor;
  }
  
  public java.lang.String envioDistribuidores() throws java.rmi.RemoteException{
    if (wS_Distribuidor == null)
      _initWS_DistribuidorProxy();
    return wS_Distribuidor.envioDistribuidores();
  }
  
  
}