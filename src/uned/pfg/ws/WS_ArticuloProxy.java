package uned.pfg.ws;

public class WS_ArticuloProxy implements uned.pfg.ws.WS_Articulo {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Articulo wS_Articulo = null;
  
  public WS_ArticuloProxy() {
    _initWS_ArticuloProxy();
  }
  
  public WS_ArticuloProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_ArticuloProxy();
  }
  
  private void _initWS_ArticuloProxy() {
    try {
      wS_Articulo = (new uned.pfg.ws.WS_ArticuloServiceLocator()).getWS_Articulo();
      if (wS_Articulo != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Articulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Articulo)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Articulo != null)
      ((javax.xml.rpc.Stub)wS_Articulo)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Articulo getWS_Articulo() {
    if (wS_Articulo == null)
      _initWS_ArticuloProxy();
    return wS_Articulo;
  }
  
  public java.lang.String envioArticulos() throws java.rmi.RemoteException{
    if (wS_Articulo == null)
      _initWS_ArticuloProxy();
    return wS_Articulo.envioArticulos();
  }
  
  
}