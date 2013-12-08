package test.negocio.habitaciones.servicioaplicacion.imp;

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
		assertTrue("La habitacion no se añadio",id >=0);
		
		TransferHabitacion h1 = s.obtenerHabitacion(id);
		
		assertNotNull("La habitacion no se obtenio",h1);
		
		
		assertTrue("El numero de habitacion no es el mismo",h1.getNumHabitacion().compareTo(h.getNumHabitacion()) == 0);
		assertTrue("El precio no es el mismo",h1.getPrecio() == h.getPrecio());
		
	}
	
	@Test
	public void obtenerTodaslasHabitaciones() {
		
		SAHabitaciones s = new SAHabitacionesImp();
		List<TransferHabitacion> lista = s.obtenerTodaslasHabitaciones();
		assertNotNull("No hay Lista de habitaciones",lista);
		
	}

	@Test
	public void actualizarHabitacion() {
	
		SAHabitaciones s = new SAHabitacionesImp();

		TransferHabitacion h = new TransferHabitacion();
		
		Integer numhabitacion = new Random().nextInt(99999) ;
		h.setNumHabitacion(numhabitacion);
		h.setPrecio(new Random().nextDouble());
	
		Integer id = s.anadirHabitacion(h);
		assertTrue("La habitacion no se añadio",id >=0);
		
		
		Double nuevoprecio = 0000d;
		h.setPrecio(nuevoprecio);

		boolean correcto = s.actualizarHabitacion(h);
		
		assertTrue("La habitacion no se actualizo correctamente",correcto);
		
		TransferHabitacion h1 =  s.obtenerHabitacion(id);

		assertNotNull("La habitacion no se obtenio",h1);

		assertTrue("El numero de habitacion no es el actualizado",h1.getNumHabitacion().compareTo(numhabitacion) == 0);
		assertTrue("El precio no es el actualizado",h1.getPrecio() == nuevoprecio);
	


		
	}
	
	@Test
	public void borrarHabitacion() {
		
		SAHabitaciones s = new  SAHabitacionesImp();
		TransferHabitacion h = new TransferHabitacion();
		
		Integer numhabitacion = new Random().nextInt(99999) ;
		h.setNumHabitacion(numhabitacion);
		h.setPrecio(new Random().nextDouble());
	
		Integer id = s.anadirHabitacion(h);
		assertTrue("La habitacion no se añadio",id >=0);
		
		boolean correcto = s.borrarHabitacion(id);
		assertTrue("La habitacion no se borro correctamente",correcto);
		
	}
}
