package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import uned.pfg.bean.Articulo;
import uned.pfg.logica.ServicioNuevoArticulo;

public class ServicioNuevoArticuloTest {

	@Test
	public void test() {

	
	Articulo art = new Articulo("Lote", new Date(), 8.52);
	
	String envio = new ServicioNuevoArticulo(art).servicio();
	
	assertEquals("exito", envio);
	
		
	}

}
