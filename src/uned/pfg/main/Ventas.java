package uned.pfg.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.Distribuidor;
import uned.pfg.logica.ServicioEliminarDistribuidor;
import uned.pfg.logica.ServicioNuevoArticulo;
import uned.pfg.logica.ServicioObtenerDistribuidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Clase que representa a la interfaz grafica
 * 
 * @author JORGE VILLALBA RUIZ 47536486V
 * @version 1.0
 */
public class Ventas extends javax.swing.JFrame {



	private static final long serialVersionUID = 1L;
	/**
	 * Constructor que inicializa todos los componentes y carga los datos necesarios
	 */
    public Ventas() {
        initComponents();
    }



   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        infoNombreArt = new javax.swing.JLabel();
        infoFecha = new javax.swing.JLabel();
        infoNuevoArticulos = new javax.swing.JLabel();
        nombreArt = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();
        precio = new javax.swing.JTextField();
        infoPrecio = new javax.swing.JLabel();
        euro = new javax.swing.JLabel();
        enviar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        infoBajaDistribuidor = new javax.swing.JLabel();
        distribuidores = new javax.swing.JComboBox<String>();
        eliminarDistribuidor = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        consultarPedido = new javax.swing.JButton();
        nuevoPedido = new javax.swing.JButton();
        stock = new javax.swing.JButton();
        listaDis = new ArrayList<Distribuidor>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VENTAS ");

        fecha.setDateFormatString("dd/MM/yyyy");
        infoNombreArt.setText("NOMBRE DEL ARTÍCULO");

        infoFecha.setText("FECHA DE ENTRADA");

        infoNuevoArticulos.setText("ALTA NUEVOS ARTICULOS ");
        infoNuevoArticulos.setMaximumSize(new java.awt.Dimension(131, 20));
        infoNuevoArticulos.setMinimumSize(new java.awt.Dimension(131, 20));

        infoPrecio.setText("PRECIO POR UNIDAD");

        euro.setText("€");

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        borrar.setText("Borrar");
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        infoBajaDistribuidor.setText("BAJA DISTRIBUIDOR");

        distribuidores.setModel(new javax.swing.DefaultComboBoxModel<String>(Distribuidores()));

        eliminarDistribuidor.setText("Eliminar Distribuidor");
        eliminarDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarDistribuidorActionPerformed(evt);
            }
        });

        consultarPedido.setText("CONSULTAR PEDIDOS");
        consultarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPedidoActionPerformed(evt);
            }
        });

        nuevoPedido.setText("NUEVO PEDIDO");
        nuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPedidoActionPerformed(evt);
            }
        });

        stock.setText("ALMACEN");
        stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(consultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(infoNombreArt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(infoPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(infoFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreArt)
                                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(euro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(distribuidores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarDistribuidor, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(infoNuevoArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoBajaDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoNuevoArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoBajaDistribuidor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoNombreArt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(euro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarDistribuidor)))))
        );

        pack();
    }// </editor-fold>                        

    
    
    
    /**
     * Metodo que recoge los campos de texto para dar entrada a un nuevo producto en el sistema.
     * Para ello, crea el xml y lo manda consumiendo el Web Service que el servidor tiene para tal fin.
     * @param evt
     */
    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
    	
    	
    	String nombre = nombreArt.getText();
    	Date fecha_recogida = fecha.getDate();
    	Date fecha_actual = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	String pre = precio.getText();
    	
    	
    	
    	
    	
    	if(nombre ==null ||
    			fecha_recogida == null ||
    			pre == null) {
    		
    		JOptionPane.showMessageDialog(null, "No puede haber campos vacios por favor...", "Ventas", 2);
    		
    		
    	}else {
    		
    		int comparacion = sdf.format(fecha_recogida).compareTo(sdf.format(fecha_actual));
    		
    		if(!isDouble(pre)) {
    			
    			JOptionPane.showMessageDialog(null, "El precio introducido no es numerio o decimal...(X.X)",
    					"Ventas", 2);
    			
    		}else {
    			
    			if(comparacion<0) {
    				
        			JOptionPane.showMessageDialog(null, "La fecha es anterior a la actual...revisela por favor",
        					"Ventas", 2);
    			}else{
    				
    				
    				Articulo art = new Articulo (nombre, fecha_recogida, Double.parseDouble(pre));
    				
    				if(new ServicioNuevoArticulo(art).servicio().equals("exito")) {
    					
            			JOptionPane.showMessageDialog(null, "ARTICULO GUARDADO CORRECTAMENTE",
            					"Ventas", 3);
            	    	nombreArt.setText(null);
            	    	 fecha.setCalendar(null);
            	    	precio.setText(null);
    				}else {
    					
            			JOptionPane.showMessageDialog(null, "Ups..problemas con conexion al servidor",
            					"Ventas", 2);
    				}
    			}
    			
    		}
    		
    	}
    	
    	
    }                                      

    /**
     * Funcion privada que comprueba si el contenido del parametro es de tipo Double
     * @param pre String el cual se quiere comprobar si su contenido pertenece a un Double o no.
     * @return True, si el dato pasado por parametro es de tipo Double, False en caso contrario
     */
    private boolean isDouble(String pre) {
 	   try{
	        Double.parseDouble(pre);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	}

    /**
     * Funcion que llama a un nuevo Frame, para poder crear un nuevo pedido en el sistema.
     * @param evt
     */
	private void nuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
    	Gui_NuevoPedido nuevopedido = new Gui_NuevoPedido();
    	nuevopedido.setVisible(true);
    }                                           

	/**
	 * Funcion que crea un nuevo Frame correspondiente a la visualizacion d elos productos
	 * @param evt
	 */
    private void consultarPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                                

    	new Gui_Pedido().setVisible(true);
    }                                               

    /**
     * Funcion que crea un nuevo Frame para visualizar el contenido del almacen.
     * @param evt
     */
    private void stockActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
    	new Gui_Almacen().setVisible(true);
    	
    }                                     

    /**
     * Funcion que borra los campos de texto de un nuevo producto, dejandolos vacios 
     * @param evt
     */
    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
    	fecha.setCalendar(null);
    	nombreArt.setText(null);
    	precio.setText(null);
    	
    }                                      

    /**
     * Funcion que elimina un distribuidor en el caso de que no disponga de ningun
     * pedido pendiente en el sistema.Es decir, si el distribuidor seleccionado
     * tiene algun pedido en tramite, no se puede eliminar
     * @param evt
     */
    private void eliminarDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        
    	
    	String seleccion = distribuidores.getSelectedItem().toString();
    	
    	if(seleccion.equals("Selec. Distribuidor")) {
			   JOptionPane.showMessageDialog(null, "Debe marcar algun distribuidor a eliminar..."
					   , "Ventas", 2);
    		
    	}else {
    		
    		int confirmar = JOptionPane.showConfirmDialog(null, "¿Esta segudo de eliminar el"
    				+ " el distribuidor " + seleccion + " ?");
    		
    		if(JOptionPane.OK_OPTION == confirmar) {
    			
    			String result = new ServicioEliminarDistribuidor(seleccion).getResultado();
            	if(result.equals("exito")) {
            		
     			   JOptionPane.showMessageDialog(null, "DISTRIBUIDOR ELIMINADO"
    					   , "Ventas", 1);
            	}else if(result.equals("error")) {
            		
      			   JOptionPane.showMessageDialog(null, "NO ES POSIBLE BORRAR EL DISTRIBUIDOR."
      			   		+ " Posee pedidos aun pendientes de confirmar"
    					   , "Ventas", 2);
            	}else {
            		
       			   JOptionPane.showMessageDialog(null, "Ups..no es posible conectar con el servidor..."
       					   , "Ventas", 2);
            	}
        		
            	distribuidores.setModel(new javax.swing.DefaultComboBoxModel<String>(Distribuidores()));
    		}
    		
    		
    	}
    	


    }
    
    /**
     * Función que rellena el ComoBox del Frame principal con los distribuidores que
     * han sido adquiridos mediante el consumo de un web service desde el servidor.
     * @return
     */
    private String[] Distribuidores() {
 	   
 	   ServicioObtenerDistribuidor servicio = new ServicioObtenerDistribuidor();
 	   listaDis = servicio.parseXMLtoList();
 	   
 	   String[] distribuidores = new String[listaDis.size()+1];
 	   
 	   Iterator<Distribuidor> it = listaDis.iterator();
 	   distribuidores[0] = "Selec. Distribuidor";
 	   int i =1;
 	   while(it.hasNext()) {
 		   
 		   Distribuidor d = it.next();
 		   distribuidores[i] = d.getNombre();
 		   i++;
 	   }
 	   
 	   
 	   
 	return distribuidores;
 	   
 	   
    }

   

    // Declaracion de variables.                    
    private javax.swing.JButton borrar;
    private javax.swing.JButton consultarPedido;
    private javax.swing.JComboBox<String> distribuidores;
    private javax.swing.JButton eliminarDistribuidor;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel euro;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel infoBajaDistribuidor;
    private javax.swing.JLabel infoFecha;
    private javax.swing.JLabel infoNombreArt;
    private javax.swing.JLabel infoNuevoArticulos;
    private javax.swing.JLabel infoPrecio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreArt;
    private javax.swing.JButton nuevoPedido;
    private javax.swing.JTextField precio;
    private javax.swing.JButton stock;
    private List<Distribuidor> listaDis;
    // Fin declaracion de variables                   
}
