package test.negocio.reservas.servicioaplicacion.imp;


import negocio.excepciones.BSoDException;

import org.junit.Test;

public class TestSAReservasimp {
	
	//TODO Hay que borrar todos los datos de la reserva de la base de datos cada vez que se empiece a ejecutar los test

	//Caso normal añadir reserva
	//Con la de pruebas que se ha hecho, seguro que hay al menos una habitacion en la base de datos
	@Test
	public void anyadereserva() throws BSoDException
	{
				
		/*//Preparar los datos
		
		SAClientes sacli = FactorySA.getInstance().getSAClientes();
		SAHabitaciones sahab = FactorySA.getInstance().getSAHabitaciones();
		SAReservas sareservas = FactorySA.getInstance().getSAReservas();
		
		//Añadir 2 clientes. Vale para todos los demas test
		TransferCliente tc = new TransferCliente();		
		tc.setDNI("765334");
		tc.setDireccion("sdfe");
		tc.setNombre("erth");
		tc.setNumTelefono(567423);
		tc.setPrimerApellido("ertjhn");
		tc.setSegundoApellido("tuikr");
		TransferCliente tc2 = tc;
		tc2.setDNI("765331");
		
		List<TransferCliente> allclientes = sacli.obtenerTodoslosClientes();
		if (allclientes.size() == 0)
		{
			sacli.anadirCliente(tc);
			sacli.anadirCliente(tc2);
		}
		else
			if (allclientes.size() == 1)
			{
				sacli.anadirCliente(tc2);
			}
		
		//Añadir 2 habitaciones. Vale para todos los demas test
		TransferHabitacion th = new TransferHabitacionNormal();
		th.setNumHabitacion(742341);
		th.setPrecio(456d);			
		TransferHabitacion th2 = th;
		th2.setNumHabitacion(742345);
		
		List<TransferHabitacion> allhabitaciones = sahab.obtenerTodaslasHabitaciones();
		if (allhabitaciones.size() == 0)
		{
			sahab.anadirHabitacion(th);
			sahab.anadirHabitacion(th2);
		}
		else
			if (allhabitaciones.size() == 1)
			{
				sahab.anadirHabitacion(th2);
			}											
		//Comprobar que se puede consultar cliente por su identificador (DNI)
		allclientes = sacli.obtenerTodoslosClientes();
		TransferCliente cliente_recuperado = sacli.obtenerCliente(allclientes.get(0).getDNI());
		assertEquals("No se ha podido insertar un cliente o consultar cliente por DNI", 
				allclientes.get(0).getDNI(), cliente_recuperado.getDNI());
		
		//Comprobar que se puede consultar habitacion por su identificador (Numero habitacion)
		allhabitaciones = sahab.obtenerTodaslasHabitaciones();
		TransferHabitacion habitacion_recuperada = sahab.obtenerHabitacion(allhabitaciones.get(0).getNumHabitacion());
		assertNotNull("La habitación es nula", habitacion_recuperada);
		assertNotNull("La lista de habitaciones es nula", allhabitaciones);
		assertFalse("La lista de habitaciones está vacia", allhabitaciones.isEmpty());
		assertNotNull("El elemento 0 de la lista de habitaciones es nulo", allhabitaciones.get(0).getNumHabitacion());
		assertEquals("No se ha podido insertar una habitacion o consultar habitacion por el numero de habitacion", 
				habitacion_recuperada.getNumHabitacion(), allhabitaciones.get(0).getNumHabitacion());
		
		//Hacer las reservas y comprobar que se ha hecho bien
		//Preparar la reserva
		TransferReserva tr = new TransferReserva();
		tr.setidusuario(allclientes.get(0).getID());
		//tr.setDNI(allclientes.get(0).getDNI());
		tr.setNumeroHabitacion(allhabitaciones.get(0).getNumHabitacion());
		
		//fechas
		java.util.Date dummyfecha = new java.util.Date(); //para obtener el dia actual
		//java.sql.Date dummy = new java.sql.Date(dummyfecha.getTime());
		java.util.Date dummy = dummyfecha;
		
		tr.setFechaReserva(dummy);
		dummy.setTime(dummy.getTime()+1000);
		tr.setFechaEntrada(dummy);
		dummy.setTime(dummy.getTime()+2000);
		tr.setFechaSalida(dummy);

		try
		{
		Integer ID = sareservas.anadirReserva(tr);
		TransferReserva recuperada = sareservas.obtenerReserva(ID);
		
		//assertTrue("Fallo: No coincide el DNI que he insertado con el DNI al recuperar el cliente por el ID devuelto por la base de datos",
		//		tr.getDNI().contentEquals(recuperada.getDNI()));
		
		//assertEquals("Fallo: No coincide la fehca de entrada que he insertado con la fecha de entrada al recuperar el cliente por el ID devuelto por la base de datos",
		//		tr.getFechaEntrada(), recuperada.getFechaEntrada());
		
		/*assertEquals("Fallo: No coincide la fehca de reserva que he insertado con la fecha de reserva al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getFechaReserva(), recuperada.getFechaReserva());
		
		assertEquals("Fallo: No coincide la fehca de salida que he insertado con la fecha de salida al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getFechaSalida(), recuperada.getFechaSalida());
		
		assertEquals("Fallo: No coincide el numero de habitacion que he insertado con el numero de habitacion al recuperar el cliente por el ID devuelto por la base de datos",
				tr.getNumeroHabitacion(), tr.getNumeroHabitacion());
		
		assertEquals("Fallo: No coincide el ID de la reserva que ha insertado la base de datos al añadir la reserva con el ID de la reserva al recuper la reserva por numero de ID",
				tr.getNumeroReserva(), recuperada.getNumeroReserva());	
		sareservas.borrarReserva(ID);
		}
		catch
		(Exception ex)
		{
//			ex.printStackTrace(System.out);
			assertTrue("Fallo: No se pudo insertar una reserva normal", false);
		}
			*/				
	}
	
	/*
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
			Integer id1 = sareservas.anadirReserva(tr);
			Integer id2 = sareservas.anadirReserva(tr2);
			sareservas.borrarReserva(id1);
			sareservas.borrarReserva(id2);
			
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
			Integer id1 = sareservas.anadirReserva(tr);
			Integer id2 = sareservas.anadirReserva(tr2);
			sareservas.borrarReserva(id1);
			sareservas.borrarReserva(id2);
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
			Integer id1 = sareservas.anadirReserva(tr);
			sareservas.borrarReserva(id1);
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
			Integer id1 = sareservas.anadirReserva(tr);
			sareservas.borrarReserva(id1);
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
			Integer id1 = sareservas.anadirReserva(tr);
			sareservas.borrarReserva(id1);
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
			Integer id1 = sareservas.anadirReserva(tr);
			sareservas.borrarReserva(id1);
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
			Integer id1 = sareservas.anadirReserva(tr);
			sareservas.borrarReserva(id1);
		}
		catch
		(Exception ex)
		{
			System.out.println("Correcto: No se puede salir de la habitacion antes de hacer una reserva");
		}
		
	}*/

}
