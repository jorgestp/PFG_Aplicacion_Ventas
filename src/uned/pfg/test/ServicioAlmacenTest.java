package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uned.pfg.bean.Almacen;
import uned.pfg.logica.ServicioAlmacen;

public class ServicioAlmacenTest {

	private List<Almacen> almacen;
	private static ServicioAlmacen serv;
	
	@BeforeClass
	public static void beforeClass() {
		
		 serv = new ServicioAlmacen();
	}
	
	@Before
	public void before() {
		
		almacen = new ArrayList<Almacen>();
		
		almacen = (ArrayList<Almacen>) serv.parseXMLtoList();
		
	}
	
	@Test
	public void servicioAlmacen() {
		
		System.out.println("**** SERVICIOALMACENTEST ****");
		
		

		Iterator<Almacen> it = almacen.iterator();
		
		int i = 1;
		while (it.hasNext()) {
			
			Almacen alm = it.next();
			
			System.out.println("**** " + i + " ****");
			
			
			assertEquals(i, alm.getId_articulo());
			i++;
		}
	}
	


}
