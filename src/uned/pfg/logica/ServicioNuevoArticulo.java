package uned.pfg.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import uned.pfg.bean.Articulo;
import uned.pfg.ws.WS_NuevoArticulo;
import uned.pfg.ws.WS_NuevoArticuloProxy;

/**
 * Clase que consume el servicio web del servidor, de modo que manda al servidor
 * un nuevo articulo que ha sido dado de alta
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioNuevoArticulo {

	
	private static final String ARCHIVO = "XML_nuevoArt.xml";
	private Articulo art;
	String envio;
	
	/**
	 * Constructor que asigna a la variable de clase, la variable pasada por parametro,
	 * y ademas, parsea dicha variable a un String con formato xml
	 * @param art
	 */
	public ServicioNuevoArticulo(Articulo art) {

		this.art = art;
		envio = prepararPedido_paraServidor();
	}
	
	/**
	 * Funcion que inicia y consume el servicio web del servidor para dar de alta
	 * a un nuevo articulo.
	 * Dicho articulo es pasado en formato XML mediante un objeto de tipo String
	 * @return String con el valor del resultado de la nueva insercicion, de modo que
	 * en el caso de ocurrir algun error, devolverá "error", y "exito en caso de todo ir bien
	 */
	public String servicio() {
		
		WS_NuevoArticulo ws = new WS_NuevoArticuloProxy("http://localhost:8080/Aplicacion_Web/services/WS_NuevoArticulo");
		
		String resultado = "error";
		
		try {
			return ws.nuevoArticulo(envio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return resultado;
		}
		
		
	}
	
	
	/**
	 * Funcion privada que en primer lugar crea un XML mediante el objeto Articulo
	 * que tiene la variable de clase correspondiente. Luego, dicho XML es pasado a un archivo
	 * y por ultimo, ese archivo es parseado a String para poder ser mandado por web service
	 * @return
	 */
	private String prepararPedido_paraServidor() {

		String s = "";
		String line;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element root = document.createElement("articulos");
			document.appendChild(root);

			Element reserva = document.createElement("articulo");
			root.appendChild(reserva);

			Element nombre = document.createElement("nombre");
			reserva.appendChild(nombre);
			nombre.appendChild(document.createTextNode(String.valueOf(art.getNombre())));

			Element fecha = document.createElement("fecha_pedido");
			reserva.appendChild(fecha);
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			fecha.appendChild(document.createTextNode(String.valueOf(formato.format(art.getFecha_entrada()))));



			Element estado = document.createElement("precio");
			reserva.appendChild(estado);
			estado.appendChild(document.createTextNode(String.valueOf(art.getPrecio())));

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(ARCHIVO));

			transformer.transform(source, result);

			File ar = new File(ARCHIVO);
			FileReader f = new FileReader(ar);
			BufferedReader b = new BufferedReader(f);
			while ((line = b.readLine()) != null) {
				s = s + line + "\n";

			}

			ar.delete();
		} catch (IOException | ParserConfigurationException | TransformerException | DOMException e) {

			e.printStackTrace();
		}

		return s;
	}
}


