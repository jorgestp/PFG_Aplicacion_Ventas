package uned.pfg.logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import uned.pfg.bean.Articulo;
import uned.pfg.ws.WS_ArtSeleccionado;
import uned.pfg.ws.WS_ArtSeleccionadoProxy;
import uned.pfg.ws.WS_Articulo;
import uned.pfg.ws.WS_ArticuloProxy;

/**
 * Clase que consume dos sevicios web correspondientes a un Articulo en concreto cuyo identificador
 * será pasado a esta clase, o todos los articulos que hay en el sistema.
 * 
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class ServicioArticulos {

	
	private static final String ARCHIVO = "XML_articulos.xml";
	private static final String ARCHIVO_artSelec = "XML_artSelec.xml";
	
	/**
	 * Constructor que llama a la funcion privada que se encarga de 
	 * recoger del servidor mediante WS los articulos que hay en la BBDD.
	 */
	public ServicioArticulos() {

		cogerServicio();
	}
	
	/**
	 * Constructor que llama a una funcion privada que se encarga de llamar y consumir
	 * a un servidio web cuya funcion es devolver el articulo con identificador
	 * pasado por parametro.
	 * @param id String que representa el identificador del Articulo
	 */
	public ServicioArticulos(String id) {
		
		cogeServicioArticuloSeleccionado(id);
	}
	


	/**
	 * Funcion privada que llama y consume el servicio web que devuelve la lista de
	 * los articulos que hay en el sistema y los almacena en formato XML en un archivo
	 */
	private void cogerServicio(){
	       
		   	
		   	WS_Articulo ws = new WS_ArticuloProxy("http://localhost:8080/Aplicacion_Web/services/WS_Articulo");
		   	
		        
		        try (FileWriter file = new FileWriter(ARCHIVO)) {
		            PrintWriter p = new PrintWriter(file);
		            p.print(ws.envioArticulos());
		            p.close();
		        }catch(Exception e){
		            
		            //e.printStackTrace();
		        	
					JOptionPane.showMessageDialog(null, "No se puede "
							+ "obtener los articulos de la base de datos."
							+ " Compruebe su funcionamiento", "Ventas", 2);
		        }
	}
	

	   
	   
	   
		/**
		 * Funcion privada que llama y consume el servicio web que devuelve 
		 * el articulo que estamos buscando mediante su identificador
		 *  y lo almacena en formato XML en un archivo
		 */
	   private void cogeServicioArticuloSeleccionado(String id) {
		
		   WS_ArtSeleccionado ws = new WS_ArtSeleccionadoProxy("http://localhost:8080/Aplicacion_Web/services/WS_ArtSeleccionado");
		   
	        try (FileWriter file = new FileWriter(ARCHIVO_artSelec)) {
	            PrintWriter p = new PrintWriter(file);
	            p.print(ws.enviarArticuloSeleccionado(id));
	            p.close();
	        }catch(Exception e){
	            
	            e.printStackTrace();
	        }
		
	}

	   /**
	    * Funcion que parsea el archivo XML que contiene todos los articulos del sistema
	    * en un objeto de colecion de Articulos
	    * @return Lista de Articulos pasados a objeto
	    */
	public List<Articulo> parseXMLtoList(){
	       
	       List<Articulo> lista = new ArrayList<Articulo>();
	       try {
	   
	           String [] aux; 
	           aux = new String[4];
	   
	   
	   
	   DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
	   DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
	   Document documento = creadorDocumento.parse(ARCHIVO);
	   
	   Element raiz = documento.getDocumentElement();

	   //Obtener la lista de nodos que tienen etiqueta "reserva"
	   NodeList listaEmpleados = raiz.getElementsByTagName("articulo");
	   //Recorrer la lista de reserva

	   for(int i=0; i<listaEmpleados.getLength(); i++) {   
	       
	       Node empleado = listaEmpleados.item(i);
	   

	       
	       NodeList datosEmpleado = empleado.getChildNodes();
	       
	       for(int j=0; j<datosEmpleado.getLength(); j++) {
	           //Obtener de la lista de datos un dato tras otro
	           Node dato = datosEmpleado.item(j);

	           //Comprobar que el dato se trata de un nodo de tipo Element
	           if(dato.getNodeType()==Node.ELEMENT_NODE) {

	               Node datoContenido = dato.getFirstChild();                        
	               //Mostrar el valor contenido en el nodo que debe ser de tipo Text
	               if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
	                
	                aux[j] = datoContenido.getNodeValue();
	           } 
	       }
	       
   				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
   				Date date_entrada = formatter.parse(aux[2]);
	       		Articulo art = new Articulo(Integer.parseInt(aux[0]), aux[1], date_entrada, Double.parseDouble(aux[3]));
	          
	          lista.add(art);
	          
	       
	   }
	   

	} catch (Exception ex) {
	   
	   //ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "El sistema no tiene ningun articulo"
				+ " disponible. Por favor, compruebe que esto sea cierto o "
				+ " compruebe la conexion con la BBDD", "Ventas", 2);
		
	} 
	       
			File archivo = new File(ARCHIVO);
			archivo.delete();
	       return lista;
	   }
	   
	
	/**
	 * Funcion que parsea el archivo que contiene el XMl de un articulo dado,
	 * a un objeto de tipo Articulo
	 * @return Objeto que representa al articulo que estabamos buscando
	 */
	public Articulo parseXMLtoArticulo(){
	       
	       Articulo art = new Articulo();
	       try {
	   
	           String [] aux; 
	           aux = new String[4];
	   
	   
	   
	   DocumentBuilderFactory fabricaCreadorDocumento = DocumentBuilderFactory.newInstance();
	   DocumentBuilder creadorDocumento = fabricaCreadorDocumento.newDocumentBuilder();
	   Document documento = creadorDocumento.parse(ARCHIVO_artSelec);
	   
	   Element raiz = documento.getDocumentElement();

	   //Obtener la lista de nodos que tienen etiqueta "reserva"
	   NodeList listaEmpleados = raiz.getElementsByTagName("articulo");
	   //Recorrer la lista de reserva

	   for(int i=0; i<listaEmpleados.getLength(); i++) {   
	       
	       Node empleado = listaEmpleados.item(i);
	   

	       
	       NodeList datosEmpleado = empleado.getChildNodes();
	       
	       for(int j=0; j<datosEmpleado.getLength(); j++) {
	           //Obtener de la lista de datos un dato tras otro
	           Node dato = datosEmpleado.item(j);

	           //Comprobar que el dato se trata de un nodo de tipo Element
	           if(dato.getNodeType()==Node.ELEMENT_NODE) {

	               Node datoContenido = dato.getFirstChild();                        
	               //Mostrar el valor contenido en el nodo que debe ser de tipo Text
	               if(datoContenido!=null && datoContenido.getNodeType()==Node.TEXT_NODE)
	                
	                aux[j] = datoContenido.getNodeValue();
	           } 
	       }
	       
   				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
   				Date date_entrada = formatter.parse(aux[2]);
   				
   				art.setId_articulo(Integer.parseInt(aux[0]));
   				art.setNombre(aux[1]);
   				art.setFecha_entrada(date_entrada);
   				art.setPrecio(Double.parseDouble(aux[3]));

	       		 
	         
	          
	       
	   }
	   

	} catch (Exception ex) {
	   
	   ex.printStackTrace();
	} 
			File archivo = new File(ARCHIVO_artSelec);
			archivo.delete();
	       return art;
	   }
}
