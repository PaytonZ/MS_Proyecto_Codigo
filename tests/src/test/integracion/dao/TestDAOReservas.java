package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.reservas.dao.DAOReserva;
import integracion.reservas.dao.imp.DAOReservaImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.reservas.transfer.TransferReserva;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
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
		Integer id = obteneridReserva().getNumeroReserva();
		assertNotNull("La reserva no se creo, la reserva es nula",id);
		assertTrue(id >= 0);	
		commit();
	}
	private TransferReserva obteneridReserva()
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva t = crearReserva();
		t.setNumeroReserva(d.addReserva(t));
		commit();
		return t;
		
	}
	private TransferReserva crearReserva()
	{
		TransferReserva t = new TransferReserva();	
		t.setidusuario(obtenerIdCliente().getID());
		t.setNumeroHabitacion(2970);//cambiar por una habitacion creada igual que el cliente
		t.setFechaReserva(new Date(new java.util.Date().getTime()));
		t.setFechaEntrada(new Date(new java.util.Date().getTime()));
		t.setFechaSalida(new Date(new java.util.Date().getTime()));	
		return t;
	}
	private TransferCliente obtenerIdCliente() {

		DAOCliente dao = new DAOClienteImp();

		TransferCliente cliente = crearCliente();

		cliente.setID(dao.addCliente(cliente));

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
		
		transaction.commit();
	}
	@Test
	public void  deleteReserva() {
		DAOReserva d = new DAOReservaImp();
		Integer id = obteneridReserva().getNumeroReserva();
		assertTrue(d.deleteReserva(id));
		
	}
	@Test
	public void  getAllReservas() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva reserva = obteneridReserva();
		
		List<TransferReserva> listareservas = d.getAllReservas(reserva.getidusuario());
		assertNotNull(listareservas);
		assertTrue(listareservas.size() >= 1);
	}

	@Test
	public void  getReserva() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva reserva  = obteneridReserva();
		Integer id = reserva.getNumeroReserva();
		TransferReserva reserva2 = d.getReserva(id);
		assertTrue(reserva2.getidusuario().equals(reserva.getidusuario()));
		assertTrue(reserva2.getNumeroReserva().equals(reserva.getNumeroReserva()));
		assertTrue(reserva2.getFechaReserva().toString().equals(reserva.getFechaReserva().toString()));
		assertTrue(reserva2.getFechaEntrada().toString().equals(reserva.getFechaEntrada().toString()));
		assertTrue(reserva2.getFechaSalida().toString().equals(reserva.getFechaSalida().toString()));
	}

	@Test
	public void  updateReserva() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva reserva  = obteneridReserva();	
		TransferReserva reserva2 = new TransferReserva();
		reserva2.setNumeroReserva(reserva.getNumeroReserva());
		reserva2.setidusuario(reserva.getidusuario());
		reserva2.setNumeroHabitacion(reserva.getNumeroHabitacion());
		reserva2.setFechaReserva(reserva.getFechaReserva());	
		reserva2.setFechaSalida(null);;
		assertTrue(d.updateReserva(reserva2));
	}
	
	@After
	public void closeConnection() {
		
		TransactionManager tm = TransactionManager.getInstance();
		tm.eliminaTransaccion();
		
	
	}
}
