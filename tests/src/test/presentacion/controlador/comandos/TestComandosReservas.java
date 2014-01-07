package test.presentacion.controlador.comandos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.habitaciones.dao.DAOHabitacion;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import integracion.transacciones.transaction.Transaction;
import integracion.transacciones.transactionManager.TransactionManager;

import java.sql.Date;
import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;
import negocio.reservas.transfer.TransferReserva;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;
import presentacion.comandos.habitacion.CommandConsultaHabitacion;
import presentacion.comandos.reserva.CommandAltaReserva;
import presentacion.comandos.reserva.CommandBajaReserva;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestComandosReservas {
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
	public void comandoAltaYBajaReserva() throws BSoDException
	{
		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_ALTA_RESERVA);
		assertNotNull(c);
		assertTrue(c instanceof CommandAltaReserva);
		
		Object d = new TransferReserva();
        

        ((TransferReserva) d).setidusuario(obtenerIdCliente().getID());
        ((TransferReserva) d).setNumeroHabitacion(obtenerIdHabitacion());
        ((TransferReserva) d).setFechaReserva(new Date(new java.util.Date().getTime()));
        ((TransferReserva) d).setFechaEntrada(new Date(new java.util.Date().getTime()));
        ((TransferReserva) d).setFechaSalida(new Date(new java.util.Date().getTime()));	
        
		CommandResponse rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_ALTA_RESERVA);
		assertTrue((Integer)rc.getDatos()>=0);
				
	
		c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_BAJA_RESERVA);
		assertNotNull(c);
		assertTrue(c instanceof CommandBajaReserva);
		
		d= (Integer)(rc.getDatos());
        
		rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_BAJA_RESERVA);
		assertTrue((Boolean)rc.getDatos());
			
	}
	
	@Test
	public void commandoADDandconsultaCliente() throws BSoDException
	{
		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_ALTA_RESERVA);
		assertNotNull(c);
		assertTrue(c instanceof CommandAltaReserva);
		
		Object d = new TransferReserva();
        

        ((TransferReserva) d).setidusuario(obtenerIdCliente().getID());
        ((TransferReserva) d).setNumeroHabitacion(obtenerIdHabitacion());
        ((TransferReserva) d).setFechaReserva(new Date(new java.util.Date().getTime()));
        ((TransferReserva) d).setFechaEntrada(new Date(new java.util.Date().getTime()));
        ((TransferReserva) d).setFechaSalida(new Date(new java.util.Date().getTime()));	
        
		CommandResponse rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_ALTA_RESERVA);
		assertTrue((Integer)rc.getDatos()>=0);
				
		
		c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_HABITACION);
		assertNotNull(c);
		assertTrue(c instanceof CommandConsultaHabitacion);
		
		Integer i= (Integer)rc.getDatos();
		
		rc = c.execute(i);

		assertTrue(rc.getEvento()==IDEventos.EVENTO_CONSULTAR_HABITACION);
		assertTrue(((TransferReserva) rc.getDatos()).getNumeroReserva().compareTo(((TransferReserva) d).getNumeroReserva())==0);
		
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
	
private Integer obtenerIdHabitacion() throws BSoDException {

		
		DAOHabitacion dao = new DAOHabitacionImp();

		TransferHabitacion hab = crearHabitacion();

		hab.setNumHabitacion((dao.addHabitacion(hab)));

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
		
		try {
			transaction.commit();
		} catch (BSoDException e) {
//			e.printStackTrace();
			assertTrue(false);
		}
	}
}
