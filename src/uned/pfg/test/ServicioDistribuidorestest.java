package uned.pfg.test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import uned.pfg.bean.Distribuidor;
import uned.pfg.logica.ServicioObtenerDistribuidor;

public class ServicioDistribuidorestest {

	@Test
	public void test() {
		
		ServicioObtenerDistribuidor serv = new ServicioObtenerDistribuidor();
		List<Distribuidor> list = serv.parseXMLtoList();
		
		Iterator<Distribuidor> it = list.iterator();
		
		while (it.hasNext()) {
			
			Distribuidor dis = it.next();
			
			assertNotNull(dis);
		}
		
	}

}
