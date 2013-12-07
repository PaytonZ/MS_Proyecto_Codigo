package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestDAOCliente {

	@Before
	public void configureTransaction() {
		
		TransactionManager tm = TransactionManager.getInstance();
		
		Transaction transaction = tm.nuevaTransaccion();
		
		transaction.start();
	}
	
	@Test
	public void anadirCliente() {

		Integer idCliente = obtenerIdCliente();

		assertNotNull("El cliente no se creo, el id es nulo", idCliente);
		assertTrue(idCliente > 0);
		
		commit();
	}

	@Test
	public void obtenerCliente() {
		DAOCliente dao = new DAOClienteImp();

		Integer id = obtenerIdCliente();

		assertNotNull("El id no puede ser nulo para obtener un cliente", id);

		TransferCliente cliente = dao.getCliente(id);

		assertNotNull("El cliente obtenido es nulo", cliente);
		
		commit();
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
		assertTrue(c1.getDireccion().equalsIgnoreCase(c.getDireccion()));
		assertTrue(c1.getPrimerApellido().equalsIgnoreCase(c.getPrimerApellido()));
		assertTrue(c1.getSegundoApellido().equalsIgnoreCase(c.getSegundoApellido()));
		assertTrue(c1.getNumTelefono().compareTo(c.getNumTelefono()) == 0);

		assertTrue(correcto);
		
		commit();
	}

	@Test
	public void borrarCliente() {

		DAOCliente dao = new DAOClienteImp();

		Integer id = obtenerIdCliente();

		assertNotNull("El cliente no puede ser nulo para borrarlo", id);

		boolean correcto = dao.deleteCliente(id);

		assertTrue("El cliente no se borró", correcto);
		
		//closeConnection();
	}

	private Integer obtenerIdCliente() {

		DAOCliente dao = new DAOClienteImp();

		TransferCliente cliente = crearCliente();

		cliente.setID(dao.addCliente(cliente));

		commit();

		return cliente.getID();
	}

	private TransferCliente crearCliente() {

		TransferCliente c = new TransferCliente();

		c.setDNI(String.valueOf(new Random().nextInt(99999)));
		c.setDireccion("direccion");
		c.setNombre("asdasd");
		c.setPrimerApellido("asdasd");
		c.setSegundoApellido("asdasd");
		c.setNumTelefono(454545);

		return c;
	}
	
	private void commit() {

		TransactionManager tm = TransactionManager.getInstance();
		
		Transaction transaction = tm.getTransaccion();
		
		transaction.commit();
	}
	
	@After
	public void closeConnection() {
		Transaction transaccion = TransactionManager.getInstance().getTransaccion();
		Connection connection = transaccion.getResource();
		
		tm.eliminaTransaccion();
	}
}
