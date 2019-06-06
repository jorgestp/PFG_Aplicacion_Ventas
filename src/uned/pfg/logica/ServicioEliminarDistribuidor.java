package uned.pfg.logica;

import java.rmi.RemoteException;

import uned.pfg.ws.WS_EliminarDistribuidor;
import uned.pfg.ws.WS_EliminarDistribuidorProxy;


/**
 * Clase que consume el servicio web del servidor, de modo que, intenta eliminar
 * del sistema el distribuidor con identificador pasado al constructor.
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioEliminarDistribuidor {

	private String result;
	
	
	/**
	 * Constructor que recoge el id del distribuidor pasado por parametro, y 
	 * llama a una funcion privada que consume el servicio web del sistema
	 * para eliminar a dicho distribuidor.
	 * @param id_distribuidor
	 */
	public ServicioEliminarDistribuidor(String id_distribuidor) {
		cogerServicio(id_distribuidor);
		
	}
	
	
	/**
	 * Funcion privada que  inicia y consume el servicio web del servidor
	 * para eliminar el distribudor.
	 * El resultado de la eliminacion es guardado en una variable de tipo String
	 * @param id_distribuidor Identificador del distribuidor a eliminar
	 */
	private void cogerServicio(String id_distribuidor) {
		
	WS_EliminarDistribuidor ws = new WS_EliminarDistribuidorProxy("http://localhost:8080/Aplicacion_Web/services/WS_EliminarDistribuidor");
		
	try {
		result = ws.eliminaDistribuidor(id_distribuidor);
	} catch (RemoteException e) {
		
		//e.printStackTrace();
		result = "problema";
	}
	
	}
	
	
	/**
	 * Devuelve el valor que da como resultado la llamada al WS del servidor
	 * @return
	 */
	public String getResultado() {
		return result;
	}
}
