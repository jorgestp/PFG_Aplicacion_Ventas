package uned.pfg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import uned.pfg.logica.ServicioEliminarDistribuidor;

public class ServicioEliminaDistribuidorTest {

	@Test
	public void test() {
		
		ServicioEliminarDistribuidor serv = new ServicioEliminarDistribuidor("prueba");
		
		String result = serv.getResultado();
		String esperado = "exito";
		
		System.out.println(result);
		
		assertEquals(esperado, result);
	}

}
