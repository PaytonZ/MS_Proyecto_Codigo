package test.negocio.reservas.servicioaplicacion.imp;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import integracion.clientes.dao.DAOCliente;
import integracion.clientes.dao.imp.DAOClienteImp;
import integracion.habitaciones.dao.imp.DAOHabitacionImp;
import negocio.clientes.transfer.TransferCliente;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.reservas.servicioaplicacion.imp.SAReservasImp;
import negocio.reservas.transfer.TransferReserva;

import org.junit.Test;

public class TestSAReservasimp {
	
	//TODO Hay que borrar todos los datos de la reserva de la base de datos cada vez que se empiece a ejecutar los test

	//Caso normal añadir reserva
	@SuppressWarnings("deprecation")
	//Con la de pruebas que se ha hecho, seguro que hay al menos una habitacion en la base de datos
	@Test
	public void anyadereserva() 
	{
		//Preparar los datos
		TransferReserva tr = new TransferReserva();
		DAOHabitacionImp daohabitacion = new DAOHabitacionImp();
		DAOClienteImp daocliente = new DAOClienteImp();
		List<TransferHabitacion> allhabitaciones = daohabitacion.getAllHabitaciones();
		List<TransferCliente> allclientes = daocliente.getAllClientes();
		tr.setNumeroHabitacion(allhabitaciones.get(0).getNumHabitacion());
		tr.setDNI(allclientes.get(0).getDNI());
		Date diaentrada = new Date();		
		Date diareserva = diaentrada;		
		Date diasalida = diaentrada;
		diareserva.setYear(1);
		diaentrada.setYear(2);		
		diasalida.setYear(3);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		//Hacer las reservas y comprobar que se ha hecho bien
		SAReservasImp sareservas = new SAReservasImp();
		try
		{
		Integer ID = sareservas.anadirReserva(tr);
		TransferReserva recuperada = sareservas.obtenerReserva(ID);
		
		assertTrue("Fallo: No coincide el DNI que he insertado con el DNI al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getDNI().contentEquals(recuperada.getDNI()));
		
		assertEquals("Fallo: No coincide la fehca de entrada que he insertado con la fecha de entrada al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getFechaEntrada(), recuperada.getFechaEntrada());
		
		assertEquals("Fallo: No coincide la fehca de reserva que he insertado con la fecha de reserva al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getFechaReserva(), recuperada.getFechaReserva());
		
		assertEquals("Fallo: No coincide la fehca de salida que he insertado con la fecha de salida al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getFechaSalida(), recuperada.getFechaSalida());
		
		assertEquals("Fallo: No coincide el numero de habitacion que he insertado con el numero de habitacion al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getNumeroHabitacion(), tr.getNumeroHabitacion());
		
		assertEquals("Fallo: No coincide el ID de la reserva que ha insertado la base de datos al añadir la reserva con el ID de la reserva al recuper la reserva por numero de ID",
				tr.getNumeroReserva(), recuperada.getNumeroReserva());	
		}
		catch
		(Exception ex)
		{
			System.out.println("Fallo: No se pudo insertar una reserva normal");
		}
							
	}
	
	//Comprobar que se pueden añadir 2 reservas con el mismo DNI y/o habitacion
	@SuppressWarnings("deprecation")
	public void dosreservas()
	{
		//insertar dos reservas con mismo dni y distinta habitacion
		TransferReserva tr = new TransferReserva();
		DAOHabitacionImp daohabitacion = new DAOHabitacionImp();
		DAOClienteImp daocliente = new DAOClienteImp();
		List<TransferHabitacion> allhabitaciones = daohabitacion.getAllHabitaciones();
		List<TransferCliente> allclientes = daocliente.getAllClientes();
		tr.setNumeroHabitacion(allhabitaciones.get(0).getNumHabitacion());
		tr.setDNI(allclientes.get(0).getDNI());
		Date diaentrada = new Date();		
		Date diareserva = diaentrada;		
		Date diasalida = diaentrada;
		diareserva.setYear(4);
		diaentrada.setYear(5);		
		diasalida.setYear(6);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		TransferReserva tr2 = tr;
		tr2.setNumeroHabitacion(allhabitaciones.get(1).getNumHabitacion());
		diareserva.setYear(7);
		diaentrada.setYear(8);		
		diasalida.setYear(9);
		tr2.setFechaEntrada(diaentrada);
		tr2.setFechaReserva(diareserva);
		tr2.setFechaSalida(diasalida);
		
		
		SAReservasImp sareservas = new SAReservasImp();
		//si va bien, no debería saltar excepcion de sql
		try
		{
			sareservas.anadirReserva(tr);
			sareservas.anadirReserva(tr2);
		}
		catch
		(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//insertar dos reservas con distinto dni y misma habitacion
		diareserva.setYear(10);
		diaentrada.setYear(11);		
		diasalida.setYear(12);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		tr2 = tr;
		diareserva.setYear(13);
		diaentrada.setYear(14);		
		diasalida.setYear(15);
		tr2.setFechaEntrada(diaentrada);
		tr2.setFechaReserva(diareserva);
		tr2.setFechaSalida(diasalida);
		tr2.setNumeroHabitacion(allhabitaciones.get(1).getNumHabitacion());
		//si va bien, no debería saltar excepcion de sql
		try
		{
			sareservas.anadirReserva(tr);
			sareservas.anadirReserva(tr2);
		}
		catch
		(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//insertar dos reservas con mismo dni y misma habitacion
		diareserva.setYear(16);
		diaentrada.setYear(17);		
		diasalida.setYear(18);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		tr2 = tr;
		diareserva.setYear(19);
		diaentrada.setYear(20);		
		diasalida.setYear(21);
		tr2.setFechaEntrada(diaentrada);
		tr2.setFechaReserva(diareserva);
		tr2.setFechaSalida(diasalida);
		
	}
	
	//comprobar que salta excepción cuando insertas una reserva con una habitacion con un cliente o una habitación inexistente
	@SuppressWarnings("deprecation")
	public void anyadirconfantasma()
	{
		//insertar con habitacion inexistente
		TransferReserva tr = new TransferReserva();
		DAOHabitacionImp daohabitacion = new DAOHabitacionImp();
		DAOClienteImp daocliente = new DAOClienteImp();
		List<TransferHabitacion> allhabitaciones = daohabitacion.getAllHabitaciones();
		List<TransferCliente> allclientes = daocliente.getAllClientes();
		tr.setNumeroHabitacion(-5481);
		tr.setDNI(allclientes.get(0).getDNI());
		Date diaentrada = new Date();		
		Date diareserva = diaentrada;		
		Date diasalida = diaentrada;
		diareserva.setYear(22);
		diaentrada.setYear(23);		
		diasalida.setYear(24);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		SAReservasImp sareservas = new SAReservasImp();
		try
		{
			sareservas.anadirReserva(tr);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No se puede insertar reserva con una habitacion inexistente");			
		}
		
		//insertar con DNI de cliente inexistente
		
		tr.setNumeroHabitacion(allhabitaciones.get(0).getNumHabitacion());
		tr.setDNI("fasdhñl4iy");
		diareserva.setYear(25);
		diaentrada.setYear(26);		
		diasalida.setYear(27);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		try
		{
			sareservas.anadirReserva(tr);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No se puede insertar reserva con un cliente inexistente");
		}
		
	}
	
	//comprobacion de coherencia de fechas al insertar
	@SuppressWarnings("deprecation")
	public void anyadirconfechasincoherentes()
	{
		//insertar con fecha de entrada anterior a fecha de reserva
		TransferReserva tr = new TransferReserva();
		DAOHabitacionImp daohabitacion = new DAOHabitacionImp();
		DAOClienteImp daocliente = new DAOClienteImp();
		List<TransferHabitacion> allhabitaciones = daohabitacion.getAllHabitaciones();
		List<TransferCliente> allclientes = daocliente.getAllClientes();
		tr.setNumeroHabitacion(allhabitaciones.get(0).getNumHabitacion());
		tr.setDNI(allclientes.get(0).getDNI());
		Date diaentrada = new Date();		
		Date diareserva = diaentrada;		
		Date diasalida = diaentrada;
		diareserva.setYear(29);
		diaentrada.setYear(28);		
		diasalida.setYear(30);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		
		SAReservasImp sareservas = new SAReservasImp();
		try
		{
			sareservas.anadirReserva(tr);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No se puede hacer una reserva para un dia que pertenece al pasado (Cambiar esta condicion cuando las maquinas del tiempo existan)");
		}
		
		//insertar con fecha de salida anterior a fecha de entrada
		diareserva.setYear(31);
		diaentrada.setYear(33);		
		diasalida.setYear(32);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		try
		{
			sareservas.anadirReserva(tr);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No puedes salir de una habitacion antes de entrar");			
		}
		
		//insertar con fecha de salida anterior a fecha de reserva
		diareserva.setYear(35);
		diaentrada.setYear(34);		
		diasalida.setYear(33);
		tr.setFechaReserva(diareserva);
		tr.setFechaEntrada(diaentrada);
		tr.setFechaSalida(diasalida);
		try
		{
			sareservas.anadirReserva(tr);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No se puede salir de la habitacion antes de hacer una reserva");
		}
		
	}

}
