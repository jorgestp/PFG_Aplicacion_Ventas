package uned.pfg.logica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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



import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;

import uned.pfg.ws.WS_ArticulosPedido;
import uned.pfg.ws.WS_ArticulosPedidoProxy;


public class ServicioArticulos_Pedido {

	private static final String ARCHIVO = "XML_art.xml";
	private static final String SEND = "XML_artPedido_send.xml";
	String id;
	
	public ServicioArticulos_Pedido(String id) {
		
		this.id = id;
		cogerServicio();
	}
	
	public ServicioArticulos_Pedido() {
		
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
	
	 public String crearXML_Articulos(List<ArticuloPedido> listaArticulos) {
			
			
		 String s = "";
	        String line;
	          
	      try{
	           
	              DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	              DocumentBuilder builder = factory.newDocumentBuilder();
	              Document document = builder.newDocument();
	              
	              Element root = document.createElement("articulosPedidos");
	              document.appendChild(root);
	              
	              Iterator<ArticuloPedido> it = listaArticulos.iterator();
	              
	              while(it.hasNext()){
	                  
	            	  ArticuloPedido p = it.next();
	                  
	                  Element art = document.createElement("articuloPedido");
	                  root.appendChild(art);
	                 
	                  Element id_articulo = document. createElement("id_articulo");
	                  art.appendChild(id_articulo);
	                  id_articulo.appendChild(document.createTextNode(String.valueOf(p.getArticulo().getId_articulo())));
	                  
	                  
	                  Element cantidad = document.createElement("cantidad");
	                  art.appendChild(cantidad);
	                  cantidad.appendChild(document.createTextNode(String.valueOf(p.getCant())));
	   
	                  Element realizado = document.createElement("realizado");
	                  art.appendChild(realizado);
	                  realizado.appendChild(document.createTextNode(String.valueOf(p.isRealizado())));
	                  
	                  Element embalado = document.createElement("embalado");
	                  art.appendChild(embalado);
	                  embalado.appendChild(document.createTextNode(String.valueOf(p.isEmbalado())));
	                 
             
	              }
	              
	              
	              TransformerFactory tFactory = TransformerFactory.newInstance();
	              Transformer transformer = tFactory.newTransformer();
	              DOMSource source = new DOMSource(document);
	              StreamResult result = new StreamResult(new File(SEND));

	              transformer.transform(source, result);
	              
	              File ar = new File(SEND);
	              FileReader f = new FileReader(ar);
	              BufferedReader b = new BufferedReader(f); 
	              while((line = b.readLine())!=null) {
	                  s= s + line +"\n";
	                  
	              } 
	              
	              System.out.println(ar.getAbsolutePath());
	              
	          }catch( IOException | ParserConfigurationException | TransformerException | DOMException e){
	              
	              e.printStackTrace();
	          }
	     
	          
	          return s;
	}
    
    
	
}
