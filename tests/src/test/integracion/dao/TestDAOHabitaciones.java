package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.habitaciones.transfer.TransferHabitacion;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestDAOHabitaciones {

	private int numhab;
	private double precio;
	
	@Before
	public void configureTransaction() {
		
		TransactionManager tm = TransactionManager.getInstance();
		
		Transaction transaction = tm.nuevaTransaccion();
		
		transaction.start();
	}
	
	@Test
	public void anadirHabitacion() {

		Integer id = obtenerIdHabitacion();
		
		assertNotNull(id);
		assertTrue(id>=0);
		
		
		commit();
	}

	@Test
	public void obtenerHabitacion() {
		
		DAOHabitacion dao = new DAOHabitacionImp();



		Integer id = obtenerIdHabitacion();

		assertNotNull(id);
		assertTrue(id>=0);

		TransferHabitacion hab = dao.getHabitacion(id);
		
		assertNotNull(hab);
		assertTrue(hab.getNumHabitacion()==numhab);
		assertTrue(hab.getPrecio()==precio);
	
		
		commit();
		
	}

	@Test
	public void modificaHabitacion() {

		
	}

	@Test
	public void borrarHabitacion() {

	

		

	}

	private Integer obtenerIdHabitacion() {

	
		DAOHabitacion dao = new DAOHabitacionImp();

		TransferHabitacion hab = crearHabitacion();

		hab.setNumHabitacion((dao.addHabitacion(hab)));

		commit();

		return hab.getNumHabitacion();
		
	}

	private TransferHabitacion crearHabitacion() {

		TransferHabitacion c = new TransferHabitacion();

		numhab = new Random().nextInt(99999);
		precio = new Random().nextDouble();
		c.setNumHabitacion(numhab);
		c.setPrecio(precio);

		return c;
	}
	
	private void commit() {

		TransactionManager tm = TransactionManager.getInstance();

		
		Transaction transaction = tm.getTransaccion();
		
		transaction.commit();
	}
	
	@After
	public void closeConnection() {
		
		TransactionManager tm = TransactionManager.getInstance();
		tm.eliminaTransaccion();
		
	
	}
	
}
