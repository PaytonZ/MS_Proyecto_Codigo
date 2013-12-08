package test.integracion.dao;

import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.reservas.dao.DAOReserva;
import integracion.reservas.dao.imp.DAOReservaImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import negocio.reservas.transfer.TransferReserva;
@RunWith(JUnit4.class)
@FixMethodOrder
public class TestDAOReservas {

	@Before
	public void configureTransaction() {
		
		TransactionManager tm = TransactionManager.getInstance();
		
		Transaction transaction = tm.nuevaTransaccion();
		
		transaction.start();
	}
	
	@Test
	public void addReserva() {
		DAOReserva d = new DAOReservaImp();
		TransferReserva t = new TransferReserva();
		t.setDNI("1");
		t.setNumeroHabitacion(3408);
		t.setFechaReserva(new Date(new java.util.Date().getTime()));
		t.setFechaEntrada(new Date(new java.util.Date().getTime()));
		t.setFechaSalida(new Date(new java.util.Date().getTime()));		
		Integer id = d.addReserva(t);		
		assertNotNull("La reserva no se creo, la reserva es nula",id);
		assertTrue(id >=0);	
	}

	@Test
	public void  deleteReserva() {
		DAOReserva d = new DAOReservaImp();
		;
		assertTrue(d.deleteReserva(1));
		
	}
	@Test
	public void  getAllReservas() 
	{
		DAOReserva d = new DAOReservaImp();
		List<TransferReserva> listareservas = d.getAllReservas(1);
		assertNotNull(listareservas);
		assertTrue(listareservas.size() == 1);
	}

	@Test
	public void  getReserva() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva reserva = d.getReserva(1);
		assertTrue(reserva.getDNI().equals("1"));
		assertTrue(reserva.getNumeroReserva()== 1);
		Date fecha = new java.sql.Date(new Long("1381528800000"));
		assertTrue(reserva.getFechaReserva().equals(fecha));
		assertTrue(reserva.getFechaEntrada().equals(fecha));
		assertTrue(reserva.getFechaSalida().equals(fecha));
	}

	@Test
	public void  updateReserva() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva t = new TransferReserva();
		t.setDNI("2");
		t.setNumeroHabitacion(3408);
		t.setFechaReserva(new Date(new java.util.Date().getTime()));
		t.setFechaEntrada(new Date(new java.util.Date().getTime()));
		t.setFechaSalida(new Date(new java.util.Date().getTime()));		
		Integer id = d.addReserva(t);		
		assertNotNull("La reserva no se creo, la reserva es nula",id);
		assertTrue(id >=0);	
	}
	
	@After
	public void closeConnection() {
		
		TransactionManager tm = TransactionManager.getInstance();
		tm.eliminaTransaccion();
		
	
	}
}
