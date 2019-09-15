package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;


import org.junit.Test;

import uned.pfg.bean.Articulo;
import uned.pfg.logica.ServicioArticulos;

public class ServicioArticulosTest {

	private ServicioArticulos serv;
	
	
	
	@Test
	public void servicioArticulos() {
		
		serv = new ServicioArticulos();
		List<Articulo> lista = serv.parseXMLtoList();
		Iterator<Articulo> it = lista.iterator();
		
		while(it.hasNext()) {
			
			Articulo art = it.next();
			
			assertNotNull(art);
		}
		
		serv = null;
	}
	
	@Test
	public void servicioArticulo() {
		
		serv = new ServicioArticulos("10");
		Articulo art = serv.parseXMLtoArticulo();
		
		assertEquals(10, art.getId_articulo());
		
		
	}

}
