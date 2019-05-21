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

import uned.pfg.bean.Articulo;
import uned.pfg.ws.WS_ArtSeleccionado;
import uned.pfg.ws.WS_ArtSeleccionadoProxy;
import uned.pfg.ws.WS_Articulo;
import uned.pfg.ws.WS_ArticuloProxy;


public class ServicioArticulos {

	
	private static final String ARCHIVO = "XML_articulos.xml";
	private static final String ARCHIVO_artSelec = "XML_artSelec.xml";
	
	public ServicioArticulos() {

		cogerServicio();
	}
	
	public ServicioArticulos(String id) {
		
		cogeServicioArticuloSeleccionado(id);
	}
	


	private void cogerServicio(){
	       
		   	
		   	WS_Articulo ws = new WS_ArticuloProxy("http://localhost:8080/Aplicacion_Web/services/WS_Articulo");
		   	
		        
		        try (FileWriter file = new FileWriter(ARCHIVO)) {
		            PrintWriter p = new PrintWriter(file);
		            p.print(ws.envioArticulos());
		            p.close();
		        }catch(Exception e){
		            
		            e.printStackTrace();
		        }
	}
	

	   
	   
	   
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
	   
	   ex.printStackTrace();
	} 
	       
			File archivo = new File(ARCHIVO);
			archivo.delete();
	       return lista;
	   }
	   
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
