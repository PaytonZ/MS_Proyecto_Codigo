package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;

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
		
		try {
			transaction.start();
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@Test
	public void anadirCliente() {

		Integer idCliente = obtenerIdCliente().getID();

		assertNotNull("El cliente no se creo, el id es nulo", idCliente);
		assertTrue(idCliente > 0);
		
		commit();
	}

	@Test
	public void obtenerCliente() {
		DAOCliente dao = new DAOClienteImp();

		TransferCliente cli = obtenerIdCliente();

		assertNotNull("El cliente no puede ser nulo", cli);
		assertNotNull("El id no puede ser nulo para obtener un cliente", cli.getID());

		TransferCliente cliente = null;
		try {
			cliente = dao.getCliente(cli.getDNI());
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull("El cliente obtenido es nulo", cliente);
		
		commit();
	}

	@Test
	public void modificarCliente() {

		DAOCliente dao = new DAOClienteImp();

		String dni = obtenerIdCliente().getDNI();

		TransferCliente c = null;
		try {
			c = dao.getCliente(dni);
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}

		assertNotNull("El cliente no puede ser nulo para modificarlo", c);

		String nombreeditado = "Editado";
		String direccioneditada = "editada";
		c.setNombre(nombreeditado);
		c.setDireccion(direccioneditada);

		boolean correcto = false;
		try {
			correcto = dao.updateCliente(c);
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}
		TransferCliente c1 = null;
		try {
			c1 = dao.getCliente(c.getDNI());
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}

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

		Integer id = obtenerIdCliente().getID();

		assertNotNull("El cliente no puede ser nulo para borrarlo", id);

		boolean correcto = false;
		try {
			correcto = dao.deleteCliente(id);
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}

		assertTrue("El cliente no se borró", correcto);
		

		

	}

	private TransferCliente obtenerIdCliente() {

		DAOCliente dao = new DAOClienteImp();

		TransferCliente cliente = crearCliente();

		try {
			cliente.setID(dao.addCliente(cliente));
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}

		commit();

		return cliente;
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
		
		try {
			transaction.commit();
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	@After
	public void closeConnection() {
		
		TransactionManager tm = TransactionManager.getInstance();
		try {
			tm.eliminaTransaccion();
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}
		
	
	}

}
