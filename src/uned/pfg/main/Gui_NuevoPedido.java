package uned.pfg.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.bean.Distribuidor;
import uned.pfg.bean.Pedido;
import uned.pfg.logica.ServicioArticulos;
import uned.pfg.logica.ServicioArticulos_Pedido;
import uned.pfg.logica.ServicioEnvioPedido;
import uned.pfg.logica.ServicioObtenerDistribuidor;
import uned.pfg.logica.ServicioPedido;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

/**
*
* @author Windows
*/
public class Gui_NuevoPedido extends javax.swing.JFrame {

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
       info_detallada_Art = new javax.swing.JLabel();
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
       fila =-1;
       list_a�adido = new ArrayList<ArticuloPedido>();
       
       modelo = new DefaultTableModel(filas, columnas);
       Tabla.setModel(modelo);
 
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


       InfoCantidad.setText("Seleccione Cantidad");

       AnadirArticulo.setText("A�adir Articulo");
       AnadirArticulo.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
               AnadirArticuloActionPerformed(evt);
           }
       });

       info_detallada_Art.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       info_detallada_Art.setText("INFORMACION DE ARTICULO");

       euro.setText("�");

       infoID.setText("ID");

       infoNombre.setText("NOMBRE");

       infoFechaEntrada.setText("FECHA ENTRADA");

       infoprecioArt.setText("PRECIO");
       
       idArticulos = new JTextField();
       idArticulos.setColumns(10);
       
       nombreArt = new JTextField();
       nombreArt.setColumns(10);
       
       fecha_Ent = new JTextField();
       fecha_Ent.setColumns(10);
       
       precioArt = new JTextField();
       precioArt.setColumns(10);

       javax.swing.GroupLayout PanelArticulosLayout = new javax.swing.GroupLayout(PanelArticulos);
       PanelArticulosLayout.setHorizontalGroup(
       	PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(PanelArticulosLayout.createSequentialGroup()
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       				.addGroup(PanelArticulosLayout.createSequentialGroup()
       					.addContainerGap()
       					.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(PanelArticulosLayout.createSequentialGroup()
       							.addComponent(AnadirArticulo, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
       							.addGap(0, 8, Short.MAX_VALUE))
       						.addGroup(PanelArticulosLayout.createSequentialGroup()
       							.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.TRAILING, false)
       								.addComponent(InfoCantidad, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
       								.addComponent(InfoArticulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
       							.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       								.addComponent(articuloSeleccionado, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
       								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))))
       				.addGroup(PanelArticulosLayout.createSequentialGroup()
       					.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       						.addGroup(PanelArticulosLayout.createSequentialGroup()
       							.addGap(49)
       							.addComponent(info_detallada_Art, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
       						.addGroup(PanelArticulosLayout.createSequentialGroup()
       							.addContainerGap()
       							.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       								.addComponent(infoID, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
       								.addComponent(infoNombre, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
       								.addComponent(infoFechaEntrada, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
       								.addComponent(infoprecioArt, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
       							.addGap(18)
       							.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       								.addComponent(idArticulos, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
       								.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       									.addGroup(PanelArticulosLayout.createSequentialGroup()
       										.addComponent(precioArt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
       										.addGap(12)
       										.addComponent(euro, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE))
       									.addComponent(nombreArt, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
       									.addComponent(fecha_Ent, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))))
       					.addGap(0, 21, 21)))
       			.addContainerGap())
       );
       PanelArticulosLayout.setVerticalGroup(
       	PanelArticulosLayout.createParallelGroup(Alignment.LEADING)
       		.addGroup(PanelArticulosLayout.createSequentialGroup()
       			.addContainerGap()
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(InfoArticulo)
       				.addComponent(articuloSeleccionado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addGap(18)
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(InfoCantidad)
       				.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addGap(18)
       			.addComponent(AnadirArticulo)
       			.addGap(29)
       			.addComponent(info_detallada_Art, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
       			.addGap(21)
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.TRAILING)
       				.addComponent(infoID)
       				.addComponent(idArticulos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(infoNombre)
       				.addComponent(nombreArt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.BASELINE)
       				.addComponent(infoFechaEntrada)
       				.addComponent(fecha_Ent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       			.addPreferredGap(ComponentPlacement.RELATED)
       			.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.LEADING, false)
       				.addGroup(PanelArticulosLayout.createParallelGroup(Alignment.BASELINE)
       					.addComponent(euro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       					.addComponent(precioArt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
       				.addComponent(infoprecioArt, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
       			.addContainerGap(19, Short.MAX_VALUE))
       );
       PanelArticulos.setLayout(PanelArticulosLayout);

       infoCliente.setText("Seleccione un Cliente");

       JCombo_distribuidores.setModel(new javax.swing.DefaultComboBoxModel<>(Distribuidores()));

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
       
       Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               
				 fila = Tabla.rowAtPoint(evt.getPoint());
				
				 buscaFecha_e_id(String.valueOf(Tabla.getValueAt(fila, 0)));
				 idArticulos.setText(String.valueOf(id));
				 nombreArt.setText(String.valueOf(Tabla.getValueAt(fila, 0)));
				 fecha_Ent.setText(String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(fechaEntrad)));
				 precioArt.setText(String.valueOf(Tabla.getValueAt(fila, 1)));
           }

		private void buscaFecha_e_id(String valueOf) {
			
			Iterator<Articulo> it = listaArt.iterator();
			
			while(it.hasNext()) {
				
				Articulo a = it.next();
				
				if(a.getNombre().equals(valueOf)) {
					
					id = a.getId_articulo();
					fechaEntrad = a.getFecha_entrada();
				}
			}
			
		}
       });
       
       botonEliminar.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(fila == -1) {
				   JOptionPane.showMessageDialog(null, "Seleccione un articulo de la "
				   		+ "tabla para eliminar", "Ventas", 2);
				   numArticulos.setText(String.valueOf(modelo.getRowCount()));	
			}else {
				
				modelo.removeRow(fila);
				numArticulos.setText(String.valueOf(modelo.getRowCount()));
				precio.setText(String.valueOf(String.format("%.2f", calcularPrecioFinal())));
			}
			
			
		}
	});
       
       pedido.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String distribuidor = JCombo_distribuidores.getSelectedItem().toString();
			Date fe_env = fechaEnvio.getDate();
			if(distribuidor.equalsIgnoreCase("Selec. Distribuidor") || fe_env == null) {
				
				   JOptionPane.showMessageDialog(null, "Seleccione un distribuidor para "
				   		+ "asignarle el pedido y una fecha valida", "Ventas", 2);
				
			}else {
				
				
				Date f_actual = new Date();

 
					List<ArticuloPedido> list = obtenerListaArticulos();

				
				if(list.isEmpty()) {
					
					   JOptionPane.showMessageDialog(null, "NO HAY ARTICULOS EN EL PEDIDO...", "Ventas", 3);

					
				}else {
					
					Pedido pedido = new Pedido(
							obtenerIdDistribuidor(JCombo_distribuidores.getSelectedItem().toString())
							, f_actual, fe_env, "En Tramite", list);
					
					ServicioPedido servicioPedido = new ServicioPedido(pedido);
					
					String ped = servicioPedido.prepararPedido_paraServidor();
					
					ServicioArticulos_Pedido ser_Art_ped = new ServicioArticulos_Pedido();
					
					
					int opcion = JOptionPane.showConfirmDialog(null,
							"�Est� seguro dar de alta a un nuevo pedido para el distribuidor " +
									JCombo_distribuidores.getSelectedItem().toString() + " ?",
							"Ventas- Nuevo Pedido",
							1);
					if(JOptionPane.OK_OPTION == opcion) {
						
						String art = ser_Art_ped.crearXML_Articulos(list_a�adido);
						
						ServicioEnvioPedido s = new ServicioEnvioPedido(ped, art);
						
						String respuesta = s.sendPedido();
						
						if(respuesta.equalsIgnoreCase("exito")) {
							
							   JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO CORRECTAMENTE", "Ventas", 2);
							   
							   list_a�adido.clear();
							   modelo.setRowCount(0);
							   JCombo_distribuidores.setSelectedIndex(0);
							   fechaEnvio.setDate(null);
							   numArticulos.setText("0");
							   precio.setText("0");
							   
						}else {
							
							JOptionPane.showMessageDialog(null, "Ups...no se ha podido ingresar el pedido", "Ventas", 3);
						}
						
						
					}else {
						
						   JOptionPane.showMessageDialog(null, "De acuerdo, no se introduce el pedido", "Ventas", 2);

					}			
				}


			}
			
		}
		
		private int obtenerIdDistribuidor(String nombre) {
			
			Iterator<Distribuidor> it = listaDis.iterator();
			
			while(it.hasNext()) {
				
				Distribuidor d = it.next();
				
				if(d.getNombre().equals(nombre)) {
					
					return d.getId();
				}
			}
			
			return -1;
		}
		
		

		private List<ArticuloPedido> obtenerListaArticulos() {
			
			
			

			
			for(int i = 0; i< modelo.getRowCount(); i++) {
				
				Articulo art = buscaArticulo( (String) modelo.getValueAt(i, 0));
				
				Object obj = modelo.getValueAt(i, 2);
				int cant = (int) obj;
				ArticuloPedido artP = new ArticuloPedido(art, cant, false, false);
				
				list_a�adido.add(artP);
			}
			
			return list_a�adido;
		}

		private Articulo buscaArticulo(String valueAt) {
			
			Iterator<Articulo> it = listaArt.iterator();
			
			while(it.hasNext()) {
				
				Articulo articulo = it.next();
				
				if(articulo.getNombre().equals(valueAt)) {
					
					return articulo;
				}
			}
			
			return null;
		}
	});
   }// </editor-fold>                        



                                                  

   private void AnadirArticuloActionPerformed(java.awt.event.ActionEvent evt) {                                               
       
	   
	   String seleccion = articuloSeleccionado.getSelectedItem().toString();
	   
	   String cantidad = textCantidad.getText();
	   
	   
	
	   if(seleccion.equalsIgnoreCase("Selec. Art�culo") || !isNumero(cantidad)) {
		   
		   JOptionPane.showMessageDialog(null, "No ha seleccionado un articulo"
		   		+ " o la cantidad no es un valor numerico..", "Ventas", 2);
	   }else {
		   
		   double prec = buscaPrecio(seleccion);
		   double total = prec* Integer.parseInt(cantidad);
		   Object [] row = {seleccion, prec, Integer.parseInt(cantidad), total};
		   	  
		   if(!isPedido(row)) {
			   
			   modelo.addRow(row);
			   numArticulos.setText(String.valueOf(modelo.getRowCount()));
		   }
	   }//fin else
	   
	   textCantidad.setText("");
	   articuloSeleccionado.setSelectedIndex(0);
	   precio.setText(String.valueOf(String.format("%.2f", calcularPrecioFinal())));
	   
   } //fin metodo                                            

   private double calcularPrecioFinal() {
	
	   double suma = 0;
	   double cantidad = 0;
	   for(int i=0; i< Tabla.getRowCount();i++) {
		   
		   cantidad = Double.parseDouble(Tabla.getValueAt(i	, 3).toString());
		   suma += cantidad;
		   
	   }
	   
	   
	return suma;
}

private boolean isPedido(Object[] row ) {
	
	   for(int i=0; i< modelo.getRowCount();i++) {
		   
		   String nombre = (String) modelo.getValueAt(i, 0);
		   Object cantAnterior =    modelo.getValueAt(i, 2);
		   
		   if(nombre.equals(row[0])) {

			   
			   int valorInicial = (int)cantAnterior;
			   int suma = valorInicial + (int)row[2];
			   modelo.setValueAt(suma , i, 2);
			   Object precioAct =    modelo.getValueAt(i, 1);
			   double pre = (double) precioAct;
			   double precioActualizado = suma * pre ;
			   modelo.setValueAt(precioActualizado, i, 3);
			   			   
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
   
   private com.toedter.calendar.JDateChooser fechaEnvio;
   
   private javax.swing.JLabel infoCliente;
   private javax.swing.JLabel infoFechaEntrada;
   private javax.swing.JLabel infoID;
   private javax.swing.JLabel infoNombre;
   private javax.swing.JLabel infoPrecio;
   private javax.swing.JLabel info_detallada_Art;
   private javax.swing.JLabel infoprecioArt;
   private javax.swing.JScrollPane jScrollPane1;
  
   private javax.swing.JLabel numArticulos;
   private javax.swing.JButton pedido;
   private javax.swing.JLabel precio;
  
   private javax.swing.JTextField textCantidad;
   private javax.swing.JLabel total;
   private DefaultTableModel modelo;
   private Object [][]filas;
   private Object [] columnas = {"NOMBRE", "PRECIO", "CANTIDAD", "TOTAL (�)"};
   List<Articulo> listaArt;
   int fila, id;
   Date fechaEntrad;
   private JTextField idArticulos;
   private JTextField nombreArt;
   private JTextField fecha_Ent;
   private JTextField precioArt;
   List<Distribuidor> listaDis;
   List<ArticuloPedido> list_a�adido;
}
