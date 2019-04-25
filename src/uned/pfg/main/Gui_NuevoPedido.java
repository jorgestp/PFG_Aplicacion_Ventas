package uned.pfg.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.Distribuidor;
import uned.pfg.logica.ServicioArticulos;
import uned.pfg.logica.ServicioArticulos_Pedido;
import uned.pfg.logica.ServicioObtenerDistribuidor;

/**
*
* @author Windows
*/
public class Gui_NuevoPedido extends javax.swing.JFrame {

   /**
    * Creates new form Gui_NuevoPedido
    */
   public Gui_NuevoPedido() {
       initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   private void initComponents() {

       PanelTabla = new javax.swing.JPanel();
       jScrollPane1 = new javax.swing.JScrollPane();
       Tabla = new javax.swing.JTable();
       botonEliminar = new javax.swing.JButton();
       PanelArticulos = new javax.swing.JPanel();
       InfoArticulo = new javax.swing.JLabel();
       articuloSeleccionado = new javax.swing.JComboBox<>();
       InfoCantidad = new javax.swing.JLabel();
       textCantidad = new javax.swing.JTextField();
       AnadirArticulo = new javax.swing.JButton();
       jScrollPane2 = new javax.swing.JScrollPane();
       idArticulo = new javax.swing.JTextPane();
       info_detallada_Art = new javax.swing.JLabel();
       jScrollPane3 = new javax.swing.JScrollPane();
       nombreArt = new javax.swing.JTextPane();
       jScrollPane4 = new javax.swing.JScrollPane();
       fechaArti = new javax.swing.JTextPane();
       jScrollPane5 = new javax.swing.JScrollPane();
       precioArt = new javax.swing.JTextPane();
       euro = new javax.swing.JLabel();
       infoID = new javax.swing.JLabel();
       infoNombre = new javax.swing.JLabel();
       infoFechaEntrada = new javax.swing.JLabel();
       infoprecioArt = new javax.swing.JLabel();
       PanelDatosPedido = new javax.swing.JPanel();
       infoCliente = new javax.swing.JLabel();
       JCombo_distribuidores = new javax.swing.JComboBox<>();
       fechaEnvio = new com.toedter.calendar.JDateChooser();
       InfoFecha = new javax.swing.JLabel();
       total = new javax.swing.JLabel();
       numArticulos = new javax.swing.JLabel();
       infoPrecio = new javax.swing.JLabel();
       precio = new javax.swing.JLabel();
       pedido = new javax.swing.JButton();
       modelo = new DefaultTableModel();
       listaArt = new ArrayList<Articulo>();
       
       modelo = new DefaultTableModel(filas, columnas);
       Tabla.setModel(modelo);
       
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       
       jScrollPane1.setViewportView(Tabla);

       botonEliminar.setText("Eliminar Articulo");

       javax.swing.GroupLayout PanelTablaLayout = new javax.swing.GroupLayout(PanelTabla);
       PanelTabla.setLayout(PanelTablaLayout);
       PanelTablaLayout.setHorizontalGroup(
           PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelTablaLayout.createSequentialGroup()
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(botonEliminar)
               .addGap(25, 25, 25))
           .addGroup(PanelTablaLayout.createSequentialGroup()
               .addContainerGap()
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(15, Short.MAX_VALUE))
       );
       PanelTablaLayout.setVerticalGroup(
           PanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelTablaLayout.createSequentialGroup()
               .addGap(6, 6, 6)
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(botonEliminar)
               .addContainerGap(24, Short.MAX_VALUE))
       );

       InfoArticulo.setText("Seleccione articulo");

       articuloSeleccionado.setModel(new DefaultComboBoxModel<String>(Articulos()));
       articuloSeleccionado.addItemListener(new java.awt.event.ItemListener() {
           public void itemStateChanged(java.awt.event.ItemEvent evt) {
               articuloSeleccionadoItemStateChanged(evt);
           }
       });

       InfoCantidad.setText("Seleccione Cantidad");

       AnadirArticulo.setText("A�adir Articulo");
       AnadirArticulo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               AnadirArticuloActionPerformed(evt);
           }
       });

       jScrollPane2.setViewportView(idArticulo);

       info_detallada_Art.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       info_detallada_Art.setText("INFORMACION DE ARTICULO");

       jScrollPane3.setViewportView(nombreArt);

       jScrollPane4.setViewportView(fechaArti);

       jScrollPane5.setViewportView(precioArt);

       euro.setText("�");

       infoID.setText("ID");

       infoNombre.setText("NOMBRE");

       infoFechaEntrada.setText("FECHA ENTRADA");

       infoprecioArt.setText("PRECIO");

       javax.swing.GroupLayout PanelArticulosLayout = new javax.swing.GroupLayout(PanelArticulos);
       PanelArticulos.setLayout(PanelArticulosLayout);
       PanelArticulosLayout.setHorizontalGroup(
           PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelArticulosLayout.createSequentialGroup()
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(PanelArticulosLayout.createSequentialGroup()
                       .addContainerGap()
                       .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(PanelArticulosLayout.createSequentialGroup()
                               .addComponent(AnadirArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                               .addGap(0, 8, Short.MAX_VALUE))
                           .addGroup(PanelArticulosLayout.createSequentialGroup()
                               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(InfoCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                   .addComponent(InfoArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(articuloSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                   .addGroup(PanelArticulosLayout.createSequentialGroup()
                       .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(PanelArticulosLayout.createSequentialGroup()
                               .addGap(49, 49, 49)
                               .addComponent(info_detallada_Art, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(PanelArticulosLayout.createSequentialGroup()
                               .addContainerGap()
                               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(infoID, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(infoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(infoFechaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(infoprecioArt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                               .addGap(34, 34, 34)
                               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jScrollPane3)
                                   .addComponent(jScrollPane4)
                                   .addGroup(PanelArticulosLayout.createSequentialGroup()
                                       .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                       .addComponent(euro, javax.swing.GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)))))
                       .addGap(0, 0, Short.MAX_VALUE)))
               .addContainerGap())
       );
       PanelArticulosLayout.setVerticalGroup(
           PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelArticulosLayout.createSequentialGroup()
               .addContainerGap()
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(InfoArticulo)
                   .addComponent(articuloSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(InfoCantidad)
                   .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGap(18, 18, 18)
               .addComponent(AnadirArticulo)
               .addGap(29, 29, 29)
               .addComponent(info_detallada_Art, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGap(18, 18, 18)
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(infoID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(infoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(infoFechaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addGroup(PanelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                   .addComponent(euro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(infoprecioArt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                   .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       );

       infoCliente.setText("Seleccione un Cliente");

       JCombo_distribuidores.setModel(new javax.swing.DefaultComboBoxModel<>(Distribuidores()));
       JCombo_distribuidores.addItemListener(new java.awt.event.ItemListener() {
           public void itemStateChanged(java.awt.event.ItemEvent evt) {
               JCombo_distribuidoresItemStateChanged(evt);
           }
       });

       fechaEnvio.setDateFormatString("dd/MM/yyyy");

       InfoFecha.setText("Seleccione fecha de envio");

       javax.swing.GroupLayout PanelDatosPedidoLayout = new javax.swing.GroupLayout(PanelDatosPedido);
       PanelDatosPedido.setLayout(PanelDatosPedidoLayout);
       PanelDatosPedidoLayout.setHorizontalGroup(
           PanelDatosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelDatosPedidoLayout.createSequentialGroup()
               .addGroup(PanelDatosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                   .addGroup(PanelDatosPedidoLayout.createSequentialGroup()
                       .addComponent(InfoFecha)
                       .addGap(18, 18, 18)
                       .addComponent(fechaEnvio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                   .addGroup(PanelDatosPedidoLayout.createSequentialGroup()
                       .addComponent(infoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(JCombo_distribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGap(0, 80, Short.MAX_VALUE))
       );
       PanelDatosPedidoLayout.setVerticalGroup(
           PanelDatosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(PanelDatosPedidoLayout.createSequentialGroup()
               .addGroup(PanelDatosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                   .addComponent(infoCliente)
                   .addComponent(JCombo_distribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addGroup(PanelDatosPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                   .addComponent(fechaEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(InfoFecha))
               .addGap(0, 20, Short.MAX_VALUE))
       );

       total.setText("TOTAL ARTICULOS");

       numArticulos.setText(" ");

       infoPrecio.setText("PRECIO TOTAL ( � )");

       precio.setText(" ");

       pedido.setText("Enviar Pedido");

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addComponent(PanelDatosPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                   .addGroup(layout.createSequentialGroup()
                       .addGap(10, 10, 10)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(infoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                           .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addGap(18, 18, 18)
                               .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                               .addGap(17, 17, 17)
                               .addComponent(numArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                       .addGap(27, 27, 27)
                       .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(PanelArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addContainerGap())
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                   .addGroup(layout.createSequentialGroup()
                       .addComponent(PanelDatosPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addComponent(PanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addGroup(layout.createSequentialGroup()
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(total)
                                   .addComponent(numArticulos))
                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(infoPrecio)
                                   .addComponent(precio)))
                           .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                       .addGap(12, 12, 12))
                   .addComponent(PanelArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addContainerGap())
       );

       pack();
   }// </editor-fold>                        



private void JCombo_distribuidoresItemStateChanged(java.awt.event.ItemEvent evt) {                                                       
       // TODO add your handling code here:
   }                                                      

   private void articuloSeleccionadoItemStateChanged(java.awt.event.ItemEvent evt) {                                                      
       // TODO add your handling code here:
   }                                                     

   private void AnadirArticuloActionPerformed(java.awt.event.ActionEvent evt) {                                               
       
	   
	   String seleccion = articuloSeleccionado.getSelectedItem().toString();
	   
	   String cantidad = textCantidad.getText();
	   
	   
	
	   if(seleccion.equalsIgnoreCase("Selec. Art�culo") || !isNumero(cantidad)) {
		   
		   JOptionPane.showMessageDialog(null, "No ha seleccionado un articulo"
		   		+ " o la cantidad no es un valor numerico..", "Ventas", 2);
	   }else {
		   
		   Object [] row = {seleccion, buscaPrecio(seleccion), Integer.parseInt(cantidad)};
		   	  
		   if(!isPedido(row)) {
			   
			   modelo.addRow(row);
			   numArticulos.setText(String.valueOf(modelo.getRowCount()));
		   }
	   }//fin else
	   
	   textCantidad.setText("");
	   
   } //fin metodo                                            

   private boolean isPedido(Object[] row ) {
	
	   for(int i=0; i< modelo.getRowCount();i++) {
		   
		   String nombre = (String) modelo.getValueAt(i, 0);
		   Object cantAnterior =    modelo.getValueAt(i, 2);
		   
		   if(nombre.equals(row[0])) {

			   
			   int valorInicial = (int)cantAnterior;
			   int suma = valorInicial + (int)row[2];
			   modelo.setValueAt(suma , i, 2);
			   			   
			   return true;
			   
		   }
		   
	   }
	
	   return false;
}

private boolean isNumero(String cantidad) {
	
	   try{
	        Integer.parseInt(cantidad);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	
   }
   
   private double buscaPrecio(String nombre) {
	   
	   Iterator<Articulo> it = listaArt.iterator();
	   double precio = 0.0;
	   while(it.hasNext()) {
		   
		   Articulo art = it.next();
		   String nom = art.getNombre();
		   if(nom.equals(nombre)) {
			   
			   precio = art.getPrecio();
			   return precio;
		   }
		   
	   }
	   return precio; 
   }

/**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
       /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
       /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
       try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(Gui_NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(Gui_NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(Gui_NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(Gui_NuevoPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
       //</editor-fold>

       /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new Gui_NuevoPedido().setVisible(true);
           }
       });
   }
   
   
   private String[] Distribuidores() {
	   
	   ServicioObtenerDistribuidor servicio = new ServicioObtenerDistribuidor();
	   List<Distribuidor> listaDis = servicio.parseXMLtoList();
	   
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
   
   
   private String[] Articulos() {
	   
	   ServicioArticulos servicioArt = new ServicioArticulos();
	   
	   listaArt = servicioArt.parseXMLtoList();
	   Iterator<Articulo> it = listaArt.iterator();
	   
	   String[] articulos = new String[listaArt.size()+1];
	   articulos[0] = "Selec. Art�culo";
	   int i =1;
	   while(it.hasNext()) {
		   
		   Articulo a = it.next();
		   articulos[i] = a.getNombre();
		   i++;
	   }
	   
	   return articulos;
}

   // Variables declaration - do not modify                     
   private javax.swing.JButton AnadirArticulo;
   private javax.swing.JLabel InfoArticulo;
   private javax.swing.JLabel InfoCantidad;
   private javax.swing.JLabel InfoFecha;
   private javax.swing.JComboBox<String> JCombo_distribuidores;
   private javax.swing.JPanel PanelArticulos;
   private javax.swing.JPanel PanelDatosPedido;
   private javax.swing.JPanel PanelTabla;
   private javax.swing.JTable Tabla;
   private javax.swing.JComboBox<String> articuloSeleccionado;
   private javax.swing.JButton botonEliminar;
   private javax.swing.JLabel euro;
   private javax.swing.JTextPane fechaArti;
   private com.toedter.calendar.JDateChooser fechaEnvio;
   private javax.swing.JTextPane idArticulo;
   private javax.swing.JLabel infoCliente;
   private javax.swing.JLabel infoFechaEntrada;
   private javax.swing.JLabel infoID;
   private javax.swing.JLabel infoNombre;
   private javax.swing.JLabel infoPrecio;
   private javax.swing.JLabel info_detallada_Art;
   private javax.swing.JLabel infoprecioArt;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JScrollPane jScrollPane3;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JTextPane nombreArt;
   private javax.swing.JLabel numArticulos;
   private javax.swing.JButton pedido;
   private javax.swing.JLabel precio;
   private javax.swing.JTextPane precioArt;
   private javax.swing.JTextField textCantidad;
   private javax.swing.JLabel total;
   private DefaultTableModel modelo;
   private Object [][]filas;
   private Object [] columnas = {"NOMBRE", "PRECIO", "CANTIDAD", "OTROS"};
   List<Articulo> listaArt;
   // End of variables declaration                   
}
