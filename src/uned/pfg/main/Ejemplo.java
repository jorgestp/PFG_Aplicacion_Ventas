package uned.pfg.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import uned.pfg.bean.Pedido;
import uned.pfg.logica.ServicioPedido;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.JScrollPane;

public class Ejemplo extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel modelo;
    private Object [][]filas;
    private Object [] columnas = {"ID PEDIDO", "DISTRIBUIDOR","FECHA REALIZACION","FECHA ENVIO", "ESTADO"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();

		panel.setBounds(24, 11, 514, 114);
		contentPane.add(panel);
		
		table = new JTable();
        modelo = new DefaultTableModel(filas, columnas);
        
        JScrollPane scrollPane = new JScrollPane();
        table.add(scrollPane);
        
        table.setModel(modelo);
		panel.add(table);
		
		JButton btnVerArticulos = new JButton("Ver Articulos");
		btnVerArticulos.setBounds(440, 153, 89, 23);
		contentPane.add(btnVerArticulos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(50, 175, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(50, 215, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(table.rowAtPoint(e.getPoint()));
				
				int entero = table.rowAtPoint(e.getPoint());
				lblNewLabel.setText(String.valueOf(table.getValueAt(entero, 0)));
				lblNewLabel_1.setText(String.valueOf(table.getValueAt(entero, 1)));
			}
		});

		
		contruirTabla();
	}
	
	
	private void contruirTabla() {

		
		ServicioPedido service = new ServicioPedido();
		
		List<Pedido> list = service.parseXMLtoList();
		
		//System.out.println(list.size());
		
		Iterator<Pedido> it = list.iterator();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		while(it.hasNext()) {
			
			Pedido p = it.next();
			
            Object [] row = {p.getId_pedido(), p.getId_distribuidor(), formatter.format(p.getFecha_entrada()),
            		formatter.format(p.getFecha_envio()), p.getEstado()};
            
            modelo.addRow(row);
		}
		
	}
}
