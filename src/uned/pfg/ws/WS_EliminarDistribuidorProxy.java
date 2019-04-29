package uned.pfg.ws;

public class WS_EliminarDistribuidorProxy implements uned.pfg.ws.WS_EliminarDistribuidor {
  private String _endpoint = null;
  private uned.pfg.ws.WS_EliminarDistribuidor wS_EliminarDistribuidor = null;
  
  public WS_EliminarDistribuidorProxy() {
    _initWS_EliminarDistribuidorProxy();
  }
  
  public WS_EliminarDistribuidorProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_EliminarDistribuidorProxy();
  }
  
  private void _initWS_EliminarDistribuidorProxy() {
    try {
      wS_EliminarDistribuidor = (new uned.pfg.ws.WS_EliminarDistribuidorServiceLocator()).getWS_EliminarDistribuidor();
      if (wS_EliminarDistribuidor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_EliminarDistribuidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_EliminarDistribuidor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_EliminarDistribuidor != null)
      ((javax.xml.rpc.Stub)wS_EliminarDistribuidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_EliminarDistribuidor getWS_EliminarDistribuidor() {
    if (wS_EliminarDistribuidor == null)
      _initWS_EliminarDistribuidorProxy();
    return wS_EliminarDistribuidor;
  }
  
  public java.lang.String eliminaDistribuidor(java.lang.String id_distribuidor) throws java.rmi.RemoteException{
    if (wS_EliminarDistribuidor == null)
      _initWS_EliminarDistribuidorProxy();
    return wS_EliminarDistribuidor.eliminaDistribuidor(id_distribuidor);
  }
  
  
}