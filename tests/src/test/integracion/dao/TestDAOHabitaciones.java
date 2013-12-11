package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.util.Random;

import negocio.excepciones.BSoDException;
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

		TransferHabitacion hab = null;
		try {
			hab = dao.getHabitacion(id);
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
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

		TransferHabitacion h = null;
		TransferHabitacion h1 = null;
		boolean correcto = false;
		try {
			h = dao.getHabitacion(id);
		

		assertNotNull("La habitacion no puede ser nula para modificarlo", h);

		Double nuevoprecio = 0000d;
		h.setPrecio(nuevoprecio);

		correcto = dao.updateHabitacion(h);
		h1 = dao.getHabitacion(h.getNumHabitacion());
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		assertNotNull(h1);

		assertTrue(h1.getNumHabitacion().compareTo(h.getNumHabitacion()) == 0);
		assertTrue(h1.getPrecio().compareTo(h.getPrecio())==0);

		assertTrue(correcto);
		
		commit();
		
	}

	@Test
	public void borrarHabitacion() {
		
		DAOHabitacion dao = new DAOHabitacionImp();

		Integer id = obtenerIdHabitacion();

		assertNotNull("La habitacion no puede ser nula para borrarlo", id);

		boolean correcto = false;
		try {
			correcto = dao.deleteHabitacion(id);
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}

		assertTrue("la habitacion no se borró", correcto);
	

		

	}

	private Integer obtenerIdHabitacion() {

	
		DAOHabitacion dao = new DAOHabitacionImp();

		TransferHabitacion hab = crearHabitacion();

		try {
			hab.setNumHabitacion((dao.addHabitacion(hab)));
		} catch (BSoDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}

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
