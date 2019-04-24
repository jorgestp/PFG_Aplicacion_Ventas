package uned.pfg.logica;

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
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.bean.Pedido;
import uned.pfg.ws.WS_ArticulosPedido;
import uned.pfg.ws.WS_ArticulosPedidoProxy;


public class ServicioArticulos_Pedido {

	private static final String ARCHIVO = "XML_art.xml";
	String id;
	
	public ServicioArticulos_Pedido(String id) {
		
		this.id = id;
		cogerServicio();
	}
	
	private void cogerServicio() {
		
    	WS_ArticulosPedido ws_art = new WS_ArticulosPedidoProxy("http://localhost:8080/Aplicacion_Web/services/WS_ArticulosPedido");
    	
    	
        
        try (FileWriter file = new FileWriter(ARCHIVO)) {
            PrintWriter p = new PrintWriter(file);
            p.print(ws_art.envioArticulos(id));
            p.close();
        }catch(Exception e){
            
            e.printStackTrace();
        }
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	 public List<ArticuloPedido> parseXMLtoList(){
	        
	        List<ArticuloPedido> lista = new ArrayList<ArticuloPedido>();
	        try {
	    
	            String [] aux; 
	            aux = new String[7];
	    
	    
	    
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
	           
	        		Articulo a = new Articulo(Integer.parseInt(aux[0]), aux[1], date_entrada, Double.parseDouble(aux[3]));
	        		
	        		ArticuloPedido p = new ArticuloPedido(a, Integer.parseInt(aux[4]), Boolean.parseBoolean(aux[5]), Boolean.parseBoolean(aux[6]));
	        		
	        		lista.add(p);
	           
	        
	    }
	    
	 
	} catch (Exception ex) {
	    
	    ex.printStackTrace();
	} 
	        
	        return lista;
	    }
	
	
}
