package uned.pfg.ws;

public class WS_ArtSeleccionadoProxy implements uned.pfg.ws.WS_ArtSeleccionado {
  private String _endpoint = null;
  private uned.pfg.ws.WS_ArtSeleccionado wS_ArtSeleccionado = null;
  
  public WS_ArtSeleccionadoProxy() {
    _initWS_ArtSeleccionadoProxy();
  }
  
  public WS_ArtSeleccionadoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_ArtSeleccionadoProxy();
  }
  
  private void _initWS_ArtSeleccionadoProxy() {
    try {
      wS_ArtSeleccionado = (new uned.pfg.ws.WS_ArtSeleccionadoServiceLocator()).getWS_ArtSeleccionado();
      if (wS_ArtSeleccionado != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_ArtSeleccionado)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_ArtSeleccionado)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_ArtSeleccionado != null)
      ((javax.xml.rpc.Stub)wS_ArtSeleccionado)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_ArtSeleccionado getWS_ArtSeleccionado() {
    if (wS_ArtSeleccionado == null)
      _initWS_ArtSeleccionadoProxy();
    return wS_ArtSeleccionado;
  }
  
  public java.lang.String enviarArticuloSeleccionado(java.lang.String id) throws java.rmi.RemoteException{
    if (wS_ArtSeleccionado == null)
      _initWS_ArtSeleccionadoProxy();
    return wS_ArtSeleccionado.enviarArticuloSeleccionado(id);
  }
  
  
}