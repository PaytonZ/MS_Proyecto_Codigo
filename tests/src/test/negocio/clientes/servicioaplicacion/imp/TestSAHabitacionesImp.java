package test.negocio.clientes.servicioaplicacion.imp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import negocio.habitaciones.servicioaplicacion.SAHabitaciones;
import negocio.habitaciones.servicioaplicacion.imp.SAHabitacionesImp;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestSAHabitacionesImp {
	
	
	@Test
	public void anadirHabitacionyObtener() {
		
		SAHabitaciones s = new SAHabitacionesImp();
		TransferHabitacion h = new TransferHabitacion();

		h.setNumHabitacion((new Random().nextInt(99999)));
		h.setPrecio(new Random().nextDouble());
		
		Integer id = s.anadirHabitacion(h);
		assertTrue(id >=0);
		
		TransferHabitacion h1 = s.obtenerHabitacion(id);
		
		assertNotNull(h1);
		
		
		assertTrue(h1.getNumHabitacion().compareTo(h.getNumHabitacion()) == 0);
		assertTrue(h1.getPrecio() == h.getPrecio());
		
	}
	
	@Test
	public void obtenerTodaslasHabitaciones() {
		
		SAHabitaciones s = new SAHabitacionesImp();
		List<TransferHabitacion> lista = s.obtenerTodaslasHabitaciones();
		assertNotNull(lista);
		
	}

	@Test
	public void actualizarCliente() {
	
		SAHabitaciones s = new SAHabitacionesImp();

		TransferHabitacion h = new TransferHabitacion();
		
		Integer numhabitacion = new Random().nextInt(99999) ;
		h.setNumHabitacion(numhabitacion);
		h.setPrecio(new Random().nextDouble());
	
		Integer id = s.anadirHabitacion(h);
		assertTrue(id >=0);
		
		
		Double nuevoprecio = 0000d;
		h.setPrecio(nuevoprecio);

		boolean correcto = s.actualizarHabitacion(h);
		
		assertTrue(correcto);
		
		TransferHabitacion h1 =  s.obtenerHabitacion(id);

		assertNotNull(h1);

		assertTrue(h1.getNumHabitacion().compareTo(numhabitacion) == 0);
		assertTrue(h1.getPrecio() == nuevoprecio);
	

		assertTrue(correcto);
		
	}
	
	@Test
	public void borrarHabitacio() {
		
		SAHabitaciones s = new  SAHabitacionesImp();
		TransferHabitacion h = new TransferHabitacion();
		
		Integer numhabitacion = new Random().nextInt(99999) ;
		h.setNumHabitacion(numhabitacion);
		h.setPrecio(new Random().nextDouble());
	
		Integer id = s.anadirHabitacion(h);
		assertTrue(id >=0);
		
		boolean correcto = s.borrarHabitacion(id);
		assertTrue(correcto);
		
	}
}
