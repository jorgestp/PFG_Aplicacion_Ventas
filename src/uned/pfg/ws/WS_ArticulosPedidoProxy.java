package uned.pfg.ws;

public class WS_ArticulosPedidoProxy implements uned.pfg.ws.WS_ArticulosPedido {
  private String _endpoint = null;
  private uned.pfg.ws.WS_ArticulosPedido wS_ArticulosPedido = null;
  
  public WS_ArticulosPedidoProxy() {
    _initWS_ArticulosPedidoProxy();
  }
  
  public WS_ArticulosPedidoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_ArticulosPedidoProxy();
  }
  
  private void _initWS_ArticulosPedidoProxy() {
    try {
      wS_ArticulosPedido = (new uned.pfg.ws.WS_ArticulosPedidoServiceLocator()).getWS_ArticulosPedido();
      if (wS_ArticulosPedido != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_ArticulosPedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_ArticulosPedido)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_ArticulosPedido != null)
      ((javax.xml.rpc.Stub)wS_ArticulosPedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_ArticulosPedido getWS_ArticulosPedido() {
    if (wS_ArticulosPedido == null)
      _initWS_ArticulosPedidoProxy();
    return wS_ArticulosPedido;
  }
  
  public java.lang.String envioArticulos(java.lang.String id_pedido) throws java.rmi.RemoteException{
    if (wS_ArticulosPedido == null)
      _initWS_ArticulosPedidoProxy();
    return wS_ArticulosPedido.envioArticulos(id_pedido);
  }
  
  
}