package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import uned.pfg.bean.Articulo;
import uned.pfg.bean.ArticuloPedido;
import uned.pfg.bean.Pedido;
import uned.pfg.logica.ServicioPedido;

public class ServicioPedidoTest {


	
	
	
	@Test
	public void obtencionPedidosTest() {
		
		ServicioPedido serv = new ServicioPedido();
		
		List<Pedido> lista = serv.parseXMLtoList();
		
		Iterator<Pedido> it =lista.iterator();
		
		while(it.hasNext()) {
			
			Pedido ped = it.next();
			assertNotNull(ped);
		}
		serv = null;
	}
	
	@Test
	public void introducirPedidoTest() {
		
		ArticuloPedido art = new ArticuloPedido(new Articulo(1), 85, false, false);
		List<ArticuloPedido> list = new ArrayList<ArticuloPedido>();
		list.add(art);
		Pedido ped = new Pedido( 0, new Date(), new Date(), "En Tramite", list);
		
		ServicioPedido serv = new ServicioPedido(ped);
		
		System.out.println(serv.prepararPedido_paraServidor());
		
	}

}
