package uned.pfg.logica;

import java.rmi.RemoteException;

import uned.pfg.ws.WS_EliminarDistribuidor;
import uned.pfg.ws.WS_EliminarDistribuidorProxy;

public class ServicioEliminarDistribuidor {

	private String result;
	
	
	public ServicioEliminarDistribuidor(String id_distribuidor) {
		cogerServicio(id_distribuidor);
		
	}
	
	
	private void cogerServicio(String id_distribuidor) {
		
	WS_EliminarDistribuidor ws = new WS_EliminarDistribuidorProxy("http://localhost:8080/Aplicacion_Web/services/WS_EliminarDistribuidor");
		
	try {
		result = ws.eliminaDistribuidor(id_distribuidor);
	} catch (RemoteException e) {
		
		//e.printStackTrace();
		result = "problema";
	}
	
	}
	
	
	public String getResultado() {
		return result;
	}
}
