package test.negocio.clientes.servicioaplicacion.imp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import negocio.clientes.servicioaplicacion.SAClientes;
import negocio.clientes.servicioaplicacion.imp.SAClientesImp;
import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
		Integer id=null;
		try {
			id = s.anadirCliente(c);
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		List<TransferCliente> lista = new ArrayList<>();
		try {
			lista = s.obtenerTodoslosClientes();
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(lista);
		assertFalse(lista.isEmpty());
		
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
		Integer id=null;
		try {
			id = s.anadirCliente(c);
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(id >=0);
		
		String nombreeditado = "Editado";
		String direccioneditada = "editada";
		c.setNombre(nombreeditado);
		c.setDireccion(direccioneditada);

		boolean correcto = s.actualizarCliente(c);
		
		assertTrue(correcto);
		
		TransferCliente c1 =  s.obtenerCliente(id);

		assertNotNull(c1);

		assertTrue(c1.getDNI().equalsIgnoreCase(c.getDNI()));
		assertTrue(c1.getNombre().equals(nombreeditado));
		assertTrue(c1.getDireccion().equalsIgnoreCase(direccioneditada));
		assertTrue(c1.getPrimerApellido().equalsIgnoreCase(c.getPrimerApellido()));
		assertTrue(c1.getSegundoApellido().equalsIgnoreCase(c.getSegundoApellido()));
		assertTrue(c1.getNumTelefono().compareTo(c.getNumTelefono()) == 0);

		assertTrue(correcto);
		
	}
	@Test
	public void borrarCliente() {
		
		
	}

	}
