package uned.pfg.ws;

public class WS_AlmacenProxy implements uned.pfg.ws.WS_Almacen {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Almacen wS_Almacen = null;
  
  public WS_AlmacenProxy() {
    _initWS_AlmacenProxy();
  }
  
  public WS_AlmacenProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_AlmacenProxy();
  }
  
  private void _initWS_AlmacenProxy() {
    try {
      wS_Almacen = (new uned.pfg.ws.WS_AlmacenServiceLocator()).getWS_Almacen();
      if (wS_Almacen != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Almacen)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Almacen)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Almacen != null)
      ((javax.xml.rpc.Stub)wS_Almacen)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Almacen getWS_Almacen() {
    if (wS_Almacen == null)
      _initWS_AlmacenProxy();
    return wS_Almacen;
  }
  
  public java.lang.String enviarAlmacen() throws java.rmi.RemoteException{
    if (wS_Almacen == null)
      _initWS_AlmacenProxy();
    return wS_Almacen.enviarAlmacen();
  }
  
  
}