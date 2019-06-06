package uned.pfg.logica;


import java.rmi.RemoteException;

import uned.pfg.ws.WS_ObtenerPedido;
import uned.pfg.ws.WS_ObtenerPedidoProxy;

/**
 * Clase que consume el servicio web del servidor, de modo que manda al servidor
 * un pedido nuevo y su lista de articulos.
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioEnvioPedido {

	private String pedido, articulo;
	
	/**
	 * Constructor que asigna a las variables de clase, las pasadas por parametro
	 * @param pedido String que representa un XML de un pedido nuevo
	 * @param articulo String que representa un XML con los articulos del nuevo pedido
	 */
	public ServicioEnvioPedido(String pedido, String articulo) {
		
		this.pedido = pedido;
		this.articulo = articulo;
	}
	
	
	/**
	 * Funcion que inicia, consume y envia mediante el servicio web, el nuevo pedido
	 * y los articulos en formato XML al servidor para que los inserte en la base de datos.
	 * @return
	 */
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
