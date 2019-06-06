package uned.pfg.logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Pedido;
import uned.pfg.ws.WS_Pedido;
import uned.pfg.ws.WS_PedidoProxy;



/**
 * Clase que consume el servicio web del servidor, de modo que, recoge todos los pedidos
 * que hay en el sistema en un momento dado.
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioPedido {

	private static final String ARCHIVO = "XML_venta.xml";
	private Pedido pedido;
	private final String FILESEND = "./xmlToSend.xml";

	/**
	 * Constructor por defecto que llama a una funcion privada cuya finalidad es 
	 * consumir el servicio web del servidor para obtener todos los pedidos del sistema
	 */
	public ServicioPedido() {

		cogerServicio();
	}

	/**
	 * Constructor que asigna el Objeto de tipo pedido pasado por parametro a un campo
	 * de clase
	 */
	public ServicioPedido(Pedido pedido) {

		this.pedido = pedido;
	}

	/**
	 * Funcion privada que consume el servicio web de los pedidos, de modo que escribe en un
	 * archivo xml, el String que ha sido devuelto por la llamada a dicho servicio web
	 * y que viene en forma de String y con formato xml
	 */
	private void cogerServicio() {

		WS_Pedido ws = new WS_PedidoProxy("http://localhost:8080/Aplicacion_Web/services/WS_Pedido");

		try (FileWriter file = new FileWriter(ARCHIVO)) {
			PrintWriter p = new PrintWriter(file);
			p.print(ws.envioPedido());
			p.close();
		} catch (Exception e) {

			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede obtener los Pedidos del sistema..."
					+ " Compruebe su funcionamiento del servidor y la BBDD", "Ventas", 2);
		}
	}

	/**
	 * Funcion que parsea el archivo xml que tiene la clase con todos los pedidos que han sido
	 * devueltos por el servicio web, en una lista de Pedidos.
	 * @return Lista de Objetos de tipo Pedido
	 */
	public List<Pedido> parseXMLtoList() {

		List<Pedido> lista = new ArrayList<Pedido>();
		try {

			String[] aux;
			aux = new String[6];

			DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
			Document documento = creadorDocumento.parse(ARCHIVO);

			Element raiz = documento.getDocumentElement();

			// Obtener la lista de nodos que tienen etiqueta "reserva"
			NodeList listaEmpleados = raiz.getElementsByTagName("pedido");
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

				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
				Date date_entrada = formatter.parse(aux[2]);
				Date date_envio = formatter.parse(aux[3]);
				Pedido p = new Pedido(Integer.parseInt(aux[0]), Integer.parseInt(aux[1]), date_entrada, date_envio,
						aux[4], null);

				lista.add(p);

			}

		} catch (Exception ex) {

			//ex.printStackTrace();
		}

		File archivo = new File(ARCHIVO);
		archivo.delete();
		return lista;
	}

	/**
	 * Funcion que crea un XML mediante el campo de clase de tipo Pedido y lo parsea a String
	 * @return String que representa el pedido en formato XML
	 */
	public String prepararPedido_paraServidor() {

		String s = "";
		String line;

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element root = document.createElement("pedidos");
			document.appendChild(root);

			Element reserva = document.createElement("pedido");
			root.appendChild(reserva);

			Element id = document.createElement("id_distribuidor");
			reserva.appendChild(id);
			id.appendChild(document.createTextNode(String.valueOf(pedido.getId_distribuidor())));

			Element fecha = document.createElement("fecha_pedido");
			reserva.appendChild(fecha);
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			fecha.appendChild(document.createTextNode(formato.format(pedido.getFecha_entrada())));

			Element envio = document.createElement("fecha_envio");
			reserva.appendChild(envio);
			envio.appendChild(document.createTextNode(formato.format(pedido.getFecha_envio())));

			Element estado = document.createElement("estado");
			reserva.appendChild(estado);
			estado.appendChild(document.createTextNode(pedido.getEstado()));

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(FILESEND));

			transformer.transform(source, result);

			File ar = new File(FILESEND);
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
