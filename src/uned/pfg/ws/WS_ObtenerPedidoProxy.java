package uned.pfg.ws;

public class WS_ObtenerPedidoProxy implements uned.pfg.ws.WS_ObtenerPedido {
  private String _endpoint = null;
  private uned.pfg.ws.WS_ObtenerPedido wS_ObtenerPedido = null;
  
  public WS_ObtenerPedidoProxy() {
    _initWS_ObtenerPedidoProxy();
  }
  
  public WS_ObtenerPedidoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_ObtenerPedidoProxy();
  }
  
  private void _initWS_ObtenerPedidoProxy() {
    try {
      wS_ObtenerPedido = (new uned.pfg.ws.WS_ObtenerPedidoServiceLocator()).getWS_ObtenerPedido();
      if (wS_ObtenerPedido != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_ObtenerPedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_ObtenerPedido)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_ObtenerPedido != null)
      ((javax.xml.rpc.Stub)wS_ObtenerPedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_ObtenerPedido getWS_ObtenerPedido() {
    if (wS_ObtenerPedido == null)
      _initWS_ObtenerPedidoProxy();
    return wS_ObtenerPedido;
  }
  
  public java.lang.String envioPedido(java.lang.String a, java.lang.String b) throws java.rmi.RemoteException{
    if (wS_ObtenerPedido == null)
      _initWS_ObtenerPedidoProxy();
    return wS_ObtenerPedido.envioPedido(a, b);
  }
  
  
}