package uned.pfg.logica;


import java.rmi.RemoteException;

import uned.pfg.ws.WS_ObtenerPedido;
import uned.pfg.ws.WS_ObtenerPedidoProxy;


public class ServicioEnvioPedido {

	private String pedido, articulo;
	
	public ServicioEnvioPedido(String pedido, String articulo) {
		
		this.pedido = pedido;
		this.articulo = articulo;
	}
	
	
	public String sendPedido() {

		String respuesta = "error";
		WS_ObtenerPedido ws = new WS_ObtenerPedidoProxy("http://localhost:8080/Aplicacion_Web/services/WS_ObtenerPedido");
	
		try {
			 respuesta = ws.envioPedido(pedido, articulo);
			 return respuesta;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return respuesta;
		}
		
	}

}
