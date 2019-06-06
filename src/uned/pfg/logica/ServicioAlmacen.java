package uned.pfg.logica;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Almacen;
import uned.pfg.ws.WS_Almacen;
import uned.pfg.ws.WS_AlmacenProxy;



/**
 * Clase que consume el servicio web del servidor, de modo que, recoge todos los articulos del
 * almacen que han sido encontrados en la base de datos
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioAlmacen {

	private static final String ARCHIVO = "XML_almacen.xml";
	
	/**
	 * Constructor por defecto que llama a una funcion privada, que establece la conexion
	 * con el servicio web del servidor y llama al metodo de ese servicio web
	 */
	public ServicioAlmacen() {

		cogerServicio();
	}
	
	
	/**
	 * Funcion que llama al servicio web del servidor y al metodo de dicho servicio web.
	 * En caso de lanzar una excepcion, muestra por pantalla una ventana informativa.
	 */
	private void cogerServicio() {
		
		WS_Almacen ws = new WS_AlmacenProxy("http://localhost:8080/Aplicacion_Web/services/WS_Almacen");

		try (FileWriter file = new FileWriter(ARCHIVO)) {
			PrintWriter p = new PrintWriter(file);
			p.print(ws.enviarAlmacen());
			p.close();
		} catch (Exception e) {

			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede "
					+ "obtener el stock del almacen  de la base de datos."
					+ " Compruebe su funcionamiento", "Ventas", 2);
		}
		
	}

	/**
	 * Funcion que pasa el XML que ha sido recogido en la llama al servicio web y lo pasa
	 * a una lista con todos los articulos del almacen.
	 * @return Lista que representa a todos los articulos que tiene el almacen en la base de datos.
	 */
	public List<Almacen> parseXMLtoList() {
		List<Almacen> lista = new ArrayList<Almacen>();
		try {

			String[] aux;
			aux = new String[3];

			DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
			Document documento = creadorDocumento.parse(ARCHIVO);

			Element raiz = documento.getDocumentElement();

			// Obtener la lista de nodos que tienen etiqueta "reserva"
			NodeList listaEmpleados = raiz.getElementsByTagName("almacen");
			// Recorrer la lista de reserva

			for (int i = 0; i < listaEmpleados.getLength(); i++) {

				Node empleado = listaEmpleados.item(i);

				NodeList datosEmpleado = empleado.getChildNodes();

				for (int j = 0; j < datosEmpleado.getLength(); j++) {
					// Obtener de la lista de datos un dato tras otro
					Node dato = datosEmpleado.item(j);

					// Comprobar que el dato se trata de un nodo de tipo Element
					if (dato.getNodeType() == Node.ELEMENT_NODE) {

						Node datoContenido = dato.getFirstChild();
						// Mostrar el valor contenido en el nodo que debe ser de tipo Text
						if (datoContenido != null && datoContenido.getNodeType() == Node.TEXT_NODE)

							aux[j] = datoContenido.getNodeValue();
					}
				}


				Almacen a = new Almacen(Integer.parseInt(aux[0]), 
						Integer.parseInt(aux[1]), 
						Integer.parseInt(aux[2]));

				lista.add(a);

			}

		} catch (Exception ex) {

			
		}

		File archivo = new File(ARCHIVO);
		archivo.delete();
		return lista;
	}
}
