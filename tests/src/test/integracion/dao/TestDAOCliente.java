package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestDAOCliente {

	@Test
	public void anadirCliente() {

		Integer idCliente = obtenerIdCliente();

		assertNotNull("El cliente no se creo, el id es nulo", idCliente);
		assertTrue(idCliente > 0);
	}

	@Test
	public void obtenerCliente() {
		DAOCliente dao = new DAOClienteImp();

		Integer id = obtenerIdCliente();

		assertNotNull("El id no puede ser nulo para obtener un cliente", id);

		TransferCliente cliente = dao.getCliente(id);

		assertNotNull("El cliente obtenido es nulo", cliente);
	}

	@Test
	public void modificarCliente() {

		DAOCliente dao = new DAOClienteImp();

		Integer id = obtenerIdCliente();

		TransferCliente c = dao.getCliente(id);

		assertNotNull("El cliente no puede ser nulo para modificarlo", c);

		String nombreeditado = "Editado";
		String direccioneditada = "editada";
		c.setNombre(nombreeditado);
		c.setDireccion(direccioneditada);

		boolean correcto = dao.updateCliente(c);
		TransferCliente c1 = dao.getCliente(c.getID());

		assertNotNull(c1);

		assertTrue(c1.getDNI().equalsIgnoreCase(c.getDNI()));
		assertTrue(c1.getNombre().equalsIgnoreCase(nombreeditado));
		assertTrue(c1.getDireccion().equalsIgnoreCase(direccioneditada));

		assertTrue(correcto);
	}

	@Test
	public void borrarCliente() {

		DAOCliente dao = new DAOClienteImp();

		Integer id = obtenerIdCliente();

		assertNotNull("El cliente no puede ser nulo para borrarlo", id);

		boolean correcto = dao.deleteCliente(id);

		assertTrue("El cliente no se borró", correcto);
	}

	private Integer obtenerIdCliente() {

		DAOCliente dao = new DAOClienteImp();

		TransferCliente cliente = crearCliente();

		cliente.setID(dao.addCliente(cliente));

		return cliente.getID();
	}

	private TransferCliente crearCliente() {

		TransferCliente c = new TransferCliente();

		c.setDNI(String.valueOf(new Random().nextInt(99999)));
		c.setDireccion("asdasd");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);

		return c;
	}
}
