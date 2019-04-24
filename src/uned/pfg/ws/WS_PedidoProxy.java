package uned.pfg.ws;

public class WS_PedidoProxy implements uned.pfg.ws.WS_Pedido {
  private String _endpoint = null;
  private uned.pfg.ws.WS_Pedido wS_Pedido = null;
  
  public WS_PedidoProxy() {
    _initWS_PedidoProxy();
  }
  
  public WS_PedidoProxy(String endpoint) {
    _endpoint = endpoint;
    _initWS_PedidoProxy();
  }
  
  private void _initWS_PedidoProxy() {
    try {
      wS_Pedido = (new uned.pfg.ws.WS_PedidoServiceLocator()).getWS_Pedido();
      if (wS_Pedido != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wS_Pedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wS_Pedido)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wS_Pedido != null)
      ((javax.xml.rpc.Stub)wS_Pedido)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uned.pfg.ws.WS_Pedido getWS_Pedido() {
    if (wS_Pedido == null)
      _initWS_PedidoProxy();
    return wS_Pedido;
  }
  
  public java.lang.String envioPedido() throws java.rmi.RemoteException{
    if (wS_Pedido == null)
      _initWS_PedidoProxy();
    return wS_Pedido.envioPedido();
  }
  
  
}