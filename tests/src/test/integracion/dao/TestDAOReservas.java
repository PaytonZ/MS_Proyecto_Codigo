package test.integracion.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import integracion.reservas.dao.DAOReserva;
import integracion.reservas.dao.imp.DAOReservaImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
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
		Integer id=null;
		try {
			id = obteneridReserva().getNumeroReserva();
		
		} catch (BSoDException e) {
			assertTrue(e.getMensaje().equals("Error al hacer la reserva"));
		}
		finally{
			assertNotNull("La reserva no se creo, la reserva es nula",id);
			assertTrue(id >= 0);	
			commit();
		}
		
	}
	private TransferReserva obteneridReserva() throws BSoDException
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
		t.setNumeroHabitacion(obtenerIdHabitacion());
		t.setFechaReserva(new Date(new java.util.Date().getTime()));
		t.setFechaEntrada(new Date(new java.util.Date().getTime()));
		t.setFechaSalida(new Date(new java.util.Date().getTime()));	
		return t;
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
	
	private Integer obtenerIdHabitacion() {

		
		DAOHabitacion dao = new DAOHabitacionImp();

		TransferHabitacion hab = crearHabitacion();

		try {
			hab.setNumHabitacion((dao.addHabitacion(hab)));
		} catch (BSoDException e) {
			e.printStackTrace();
			assertTrue(false);
		}

		commit();

		return hab.getNumHabitacion();
		
	}
	private TransferHabitacion crearHabitacion() {

		TransferHabitacion c = new TransferHabitacionNormal();
		int numhab;
		double precio;
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
	@Test
	public void  deleteReserva() {
		DAOReserva d = new DAOReservaImp();
		Integer id= null;
		boolean prueba = false;
		try {
			 id = obteneridReserva().getNumeroReserva();
			 prueba =d.deleteReserva(id);
		} catch (BSoDException e) {
			assertTrue(e.getMensaje().equals("Error al eliminar la reserva"));
		}
		finally
		{
			assertTrue(prueba);
		}
		
	}
	@Test
	public void  getAllReservas() 
	{
		DAOReserva d = new DAOReservaImp();
		List<TransferReserva> listareservas = null;
		try {
			TransferReserva reserva = obteneridReserva();	
			listareservas = d.getAllReservasporCliente(reserva.getidusuario());
		} catch (BSoDException e) {
			assertTrue(e.getMensaje().equals("Error al carga la reservas"));
		}
		finally
		{
			assertNotNull(listareservas);
			assertTrue(listareservas.size() >= 1);
		}
	}

	@Test
	public void  getReserva() 
	{
		DAOReserva d = new DAOReservaImp();
		TransferReserva reserva2 = null;
		TransferReserva reserva= null ;
		try {
			 reserva  = obteneridReserva();
			Integer id = reserva.getNumeroReserva();
			reserva2 = d.getReserva(id);
		} catch (BSoDException e) {
			assertTrue(e.getMensaje().equals("Error al carga la reservas"));
		}
		finally
		{
			assertNotNull(reserva2);
			assertTrue(reserva2.getidusuario().equals(reserva.getidusuario()));
			assertTrue(reserva2.getNumeroReserva().equals(reserva.getNumeroReserva()));
			assertTrue(reserva2.getFechaReserva().toString().equals(reserva.getFechaReserva().toString()));
			assertTrue(reserva2.getFechaEntrada().toString().equals(reserva.getFechaEntrada().toString()));
			assertTrue(reserva2.getFechaSalida().toString().equals(reserva.getFechaSalida().toString()));
		}
	}

	@Test
	public void  updateReserva() 
	{
		boolean prueba = false;
		try {
			DAOReserva d = new DAOReservaImp();
			TransferReserva reserva  = obteneridReserva();	
			TransferReserva reserva2 = new TransferReserva();
			reserva2.setNumeroReserva(reserva.getNumeroReserva());
			reserva2.setidusuario(reserva.getidusuario());
			reserva2.setNumeroHabitacion(reserva.getNumeroHabitacion());
			reserva2.setFechaReserva(reserva.getFechaReserva());	
			reserva2.setFechaSalida(null);
			prueba =d.updateReserva(reserva2);
			
		} catch (BSoDException e) {
			assertTrue(e.getMensaje().equals("Error al actualizar la reserva"));
		}
		finally
		{
			assertTrue(prueba);
			
		}
	}
	
	@After
	public void closeConnection() {
		
		TransactionManager tm = TransactionManager.getInstance();
		tm.eliminaTransaccion();
		
	
	}
}
