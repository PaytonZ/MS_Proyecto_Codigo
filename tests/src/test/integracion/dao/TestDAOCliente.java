package test.integracion.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Random;

import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import negocio.clientes.transfer.TransferCliente;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestDAOCliente {

	private TransferCliente c;
	
	@Before
	public void configureTest() {

		c = new TransferCliente();
		c.setDNI( String.valueOf( new Random().nextInt(8) ) );
		c.setDireccion("asdasd");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);
	}
	
	@Test
	public void anadirCliente() {
		
		DAOCliente dao = new DAOClienteImp();
		
		c.setID( dao.addCliente(c) );
		
		assertNotNull(c.getID());
	}
}
