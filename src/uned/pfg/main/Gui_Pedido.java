package uned.pfg.main;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import uned.pfg.bean.ArticuloPedido;
import uned.pfg.bean.Pedido;
import uned.pfg.logica.ServicioArticulos_Pedido;
import uned.pfg.logica.ServicioPedido;

public class Gui_Pedido extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form NewJFrame2
     */
    public Gui_Pedido() {
        initComponents();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        verPedido = new javax.swing.JButton();
        idPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaArticulo = new javax.swing.JTable();
        entero = -1;

        modelo = new DefaultTableModel(filas, columnas);
        tablaPedido.setModel(modelo);
        jScrollPane1.setViewportView(tablaPedido);
        
       
        
        modelo2 = new DefaultTableModel(filas2, columnas2);
        TablaArticulo.setModel(modelo2);
        jScrollPane2.setViewportView(TablaArticulo);


        setTitle("VENTAS - Pedidos ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Pedido Seleccionado=>");

        verPedido.setText("Ver Pedido");


        idPedido.setText("");

        jLabel3.setText("Marca el pedido que desee, y a continuacion pulse en Ver Pedido");



        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(idPedido))
            .addGroup(layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addComponent(verPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(idPedido))))
                .addGap(6, 6, 6)
                .addComponent(verPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        
        tablaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
				 entero = tablaPedido.rowAtPoint(evt.getPoint());
				idPedido.setText(String.valueOf(tablaPedido.getValueAt(entero, 0)));
            }
        });
        
        verPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            	
            	if(entero != -1) rellenarTablaArticulos();
            	else {
            		
            		JOptionPane.showMessageDialog(null,
            				"Error; no ha seleccionado ningun pedido para visualizar."
            				+ " Seleccione uno de ellos para poder ver su contenido", 
            				"Ventas - Pedidos",
            				2);
            	}
            	
            }
        });
        
        contruirTabla();
    }// </editor-fold>                        

                                         
/*
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Pedido().setVisible(true);
            }
        });
    }*/
    
    
    
	private void contruirTabla() {

		
		ServicioPedido service = new ServicioPedido();
		
		List<Pedido> list = service.parseXMLtoList();
		
		if(!list.isEmpty()) {
		
		
		Iterator<Pedido> it = list.iterator();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		while(it.hasNext()) {
			
			Pedido p = it.next();
			
            Object [] row = {p.getId_pedido(), p.getId_distribuidor(), formatter.format(p.getFecha_entrada()),
            		formatter.format(p.getFecha_envio()), p.getEstado()};
            
            modelo.addRow(row);
		}
		
		}else {
			
    		JOptionPane.showMessageDialog(null,
    				"NO HAY NINGUN PEDIDO EN EL SISTEMA", 
    				"Ventas - Pedidos",
    				2);
			
		}
	}
	
	private void rellenarTablaArticulos() {
		
		modelo2.setNumRows(0);
		ServicioArticulos_Pedido serv = new ServicioArticulos_Pedido(idPedido.getText());
		
		//System.out.println("CANTIDAD DE ARTICULOS => " + serv.parseXMLtoList().size());
		
		Iterator<ArticuloPedido> it = serv.parseXMLtoList().iterator();
		
		
		
		while(it.hasNext()) {
			
			ArticuloPedido p = it.next();
			
			if(p.isRealizado() && p.isEmbalado()) {
				
	            Object [] row = {p.getArticulo().getId_articulo(),
        				p.getArticulo().getNombre(),
        				p.getArticulo().getPrecio(),
        				p.getCant(),
        				"SI",
        				"SI"};
        
	            modelo2.addRow(row);
				
			}else
			
			if(p.isRealizado() && !p.isEmbalado()) {
				
	            Object [] row = {p.getArticulo().getId_articulo(),
        				p.getArticulo().getNombre(),
        				p.getArticulo().getPrecio(),
        				p.getCant(),
        				"SI",
        				"NO"};
        
	            modelo2.addRow(row);
				
				
			}else
			
			if(!p.isRealizado() && p.isEmbalado()) {
				
	            Object [] row = {p.getArticulo().getId_articulo(),
        				p.getArticulo().getNombre(),
        				p.getArticulo().getPrecio(),
        				p.getCant(),
        				"NO",
        				"SI"};
        
	            modelo2.addRow(row);
				
			}
			
			else {
				
				
	            Object [] row = {p.getArticulo().getId_articulo(),
        				p.getArticulo().getNombre(),
        				p.getArticulo().getPrecio(),
        				p.getCant(),
        				"NO",
        				"NO"};
        
	            modelo2.addRow(row);
				
			}
			

		}
		
	}

    // Variables declaration - do not modify                     
    private javax.swing.JTable TablaArticulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel idPedido;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JButton verPedido;
    private DefaultTableModel modelo2;
    private Object [][]filas2;
    private Object [] columnas2 = {"ID_ARTICULO", "NOMBRE","PRECIO/unidad","CANTIDAD", "REALIZADO", "EMBALADO"};
    private DefaultTableModel modelo;
    private Object [][]filas;
    int entero;
    private Object [] columnas = {"ID PEDIDO", "DISTRIBUIDOR","FECHA REALIZACION","FECHA ENVIO", "ESTADO"};
    // End of variables declaration                   
}
