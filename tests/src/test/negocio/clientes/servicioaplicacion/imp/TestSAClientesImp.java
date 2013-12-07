package test.negocio.clientes.servicioaplicacion.imp;

import java.util.List;
import java.util.Random;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.servicioaplicacion.imp.SAClientesImp;
import negocio.clientes.transfer.TransferCliente;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestSAClientesImp {
	
	@Test
	public void anadirClienteyObtener() {
		
		SAClientes s = new SAClientesImp();
		TransferCliente c = new TransferCliente();

		c.setDNI(String.valueOf(new Random().nextInt(99999)));
		c.setDireccion("asdasd");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);
		Integer id = s.anadirCliente(c);
		assertTrue(id >=0);
		
		TransferCliente c1 = s.obtenerCliente(id);
		
		assertNotNull(c1);
		
		
		assertTrue(c1.getDNI().equalsIgnoreCase(c.getDNI()));
		assertTrue(c1.getDireccion().equalsIgnoreCase(c.getDireccion()));
		assertTrue(c1.getPrimerApellido().equalsIgnoreCase(c.getPrimerApellido()));
		assertTrue(c1.getSegundoApellido().equalsIgnoreCase(c.getSegundoApellido()));
		assertTrue(c1.getNumTelefono().compareTo(c.getNumTelefono()) == 0);
		
		
		
		
	}

	@Test
	public void obtenerTodoslosClientes() {
		
		SAClientes s = new SAClientesImp();
		List<TransferCliente> lista = s.obtenerTodoslosClientes();
		assertNotNull(lista);
		
	}

	@Test
	public void actualizarCliente() {
		SAClientes s = new SAClientesImp();
		TransferCliente c = new TransferCliente();


		c.setDNI(String.valueOf(new Random().nextInt(99999)));
		c.setDireccion("asdasd");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);
		Integer id = s.anadirCliente(c);
		assertTrue(id >=0);
		String dir="dircambiada";
		c.setDireccion(dir);
		Boolean r = Boolean.valueOf(s.actualizarCliente(c));
		
		assertNotNull(r);
		assertTrue(r);
		
		TransferCliente c1 = s.obtenerCliente(id);
		assertNotNull(c1);
		
		
		assertTrue(c1.getDireccion().equalsIgnoreCase(c.getDireccion()));
		
		
	}
	@Test
	public void borrarCliente() {
		
		
	}

	}
