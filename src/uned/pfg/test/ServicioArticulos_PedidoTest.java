package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import uned.pfg.bean.ArticuloPedido;
import uned.pfg.logica.ServicioArticulos_Pedido;


@RunWith(value = Parameterized.class)
public class ServicioArticulos_PedidoTest {
	
	private  ServicioArticulos_Pedido serv;
	private List<ArticuloPedido> lista;
	private  String id;
	
	

	
	@Parameters
	public static Iterable<String> getData(){
		
		return Arrays.asList(new String [] {"180","181","182"});
	}
	
	public ServicioArticulos_PedidoTest(String id) {
		this.id = id;
	}
	

	
	@Test
	public void articulosPedidoTest() {
		serv = new ServicioArticulos_Pedido(id);
		
		lista = new ArrayList<ArticuloPedido>();
		lista = serv.parseXMLtoList();
		Iterator<ArticuloPedido> it = lista.iterator();
		while(it.hasNext()) {
			
			ArticuloPedido artP = it.next();
			System.out.println(artP.getArticulo().getId_articulo());
			assertNotNull(artP);
		}
		
	}

}
