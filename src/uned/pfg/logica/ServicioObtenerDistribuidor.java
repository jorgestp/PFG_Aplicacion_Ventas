package uned.pfg.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Distribuidor;
import uned.pfg.bean.Pedido;
import uned.pfg.ws.WS_Distribuidor;
import uned.pfg.ws.WS_DistribuidorProxy;

public class ServicioObtenerDistribuidor {

	private static final String ARCHIVO = "XML_distribuidores.xml";

	public ServicioObtenerDistribuidor() {

		cogerServicio();
	}

	private void cogerServicio() {

		WS_Distribuidor ws = new WS_DistribuidorProxy("http://localhost:8080/Aplicacion_Web/services/WS_Distribuidor");

		try (FileWriter file = new FileWriter(ARCHIVO)) {
			PrintWriter p = new PrintWriter(file);
			p.print(ws.envioDistribuidores());
			p.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public List<Distribuidor> parseXMLtoList() {

		List<Distribuidor> lista = new ArrayList<Distribuidor>();
		try {

			String[] aux;
			aux = new String[2];

			DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
			DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
			Document documento = creadorDocumento.parse(ARCHIVO);

			Element raiz = documento.getDocumentElement();

			// Obtener la lista de nodos que tienen etiqueta "reserva"
			NodeList listaEmpleados = raiz.getElementsByTagName("distribuidor");
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

				Distribuidor dist = new Distribuidor(Integer.parseInt(aux[0]), aux[1]);

				lista.add(dist);

			}

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		File archivo = new File(ARCHIVO);
		archivo.delete();
		return lista;
	}

}
