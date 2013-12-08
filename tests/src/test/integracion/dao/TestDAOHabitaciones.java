package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.Random;

import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;

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
		System.out.println(hab.getPrecio() + "/////" + precio );
		assertTrue(Math.abs(hab.getPrecio()-precio) < 0.01);
	
		
		commit();
		
	}

	@Test
	public void modificaHabitacion() {
		DAOHabitacion dao = new DAOHabitacionImp();

		Integer id = obtenerIdHabitacion();

		TransferHabitacion h = dao.getHabitacion(id);

		assertNotNull("La habitacion no puede ser nula para modificarlo", h);

		Double nuevoprecio = 0000d;
		h.setPrecio(nuevoprecio);

		boolean correcto = dao.updateHabitacion(h);
		TransferHabitacion h1 = dao.getHabitacion(h.getNumHabitacion());

		assertNotNull(h1);

		assertTrue(h1.getNumHabitacion().compareTo(h.getNumHabitacion()) == 0);
		assertTrue(h1.getPrecio() == h.getPrecio());

		assertTrue(correcto);
		
		commit();
		
	}

	@Test
	public void borrarHabitacion() {
		
		DAOHabitacion dao = new DAOHabitacionImp();

		Integer id = obtenerIdHabitacion();

		assertNotNull("La habitacion no puede ser nula para borrarlo", id);

		boolean correcto = dao.deleteHabitacion(id);

		assertTrue("la habitacion no se borró", correcto);
	

		

	}

	private Integer obtenerIdHabitacion() {

	
		DAOHabitacion dao = new DAOHabitacionImp();

		TransferHabitacion hab = crearHabitacion();

		hab.setNumHabitacion((dao.addHabitacion(hab)));

		commit();

		return hab.getNumHabitacion();
		
	}

	private TransferHabitacion crearHabitacion() {

		TransferHabitacion c = new TransferHabitacionNormal();

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
