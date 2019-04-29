package uned.pfg.ws;

public class WS_NuevoArticuloProxy implements uned.pfg.ws.WS_NuevoArticulo {
  private String _endpoint = null;
  private uned.pfg.ws.WS_NuevoArticulo wS_NuevoArticulo = null;
  
  public WS_NuevoArticuloProxy() {
    _initWS_NuevoArticuloProxy();
  }
  
  public WS_NuevoArticuloProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_NuevoArticuloProxy();
  }
  
  private void _initWS_NuevoArticuloProxy() {
    try {
      wS_NuevoArticulo = (new uned.pfg.ws.WS_NuevoArticuloServiceLocator()).getWS_NuevoArticulo();
      if (wS_NuevoArticulo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_NuevoArticulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_NuevoArticulo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_NuevoArticulo != null)
      ((javax.xml.rpc.Stub)wS_NuevoArticulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_NuevoArticulo getWS_NuevoArticulo() {
    if (wS_NuevoArticulo == null)
      _initWS_NuevoArticuloProxy();
    return wS_NuevoArticulo;
  }
  
  public java.lang.String nuevoArticulo(java.lang.String articulo) throws java.rmi.RemoteException{
    if (wS_NuevoArticulo == null)
      _initWS_NuevoArticuloProxy();
    return wS_NuevoArticulo.nuevoArticulo(articulo);
  }
  
  
}