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
	
	
	public void sendPedido() {

		WS_ObtenerPedido ws = new WS_ObtenerPedidoProxy("http://localhost:8080/Aplicacion_Web/services/WS_ObtenerPedido");
	
		try {
			System.out.println(ws.envioPedido("JORGE", "VILLALBA"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("NO SE PUDO CONECTAR CON EL SERVIDOR");
		}
		
	}

}
