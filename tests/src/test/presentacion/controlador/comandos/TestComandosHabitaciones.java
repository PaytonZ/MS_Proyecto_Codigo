package test.presentacion.controlador.comandos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;
import negocio.habitaciones.transfer.TransferHabitacion;
import negocio.habitaciones.transfer.TransferHabitacionNormal;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.cliente.CommandAltaCliente;
import presentacion.comandos.cliente.CommandBajaCliente;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;
import presentacion.comandos.habitacion.CommandAltaHabitacion;
import presentacion.comandos.habitacion.CommandBajaHabitacion;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestComandosHabitaciones {
	@Test
	public void comandoaltaybajahabitacion()
	{
		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_ALTA_HABITACION);
		assertNotNull(c);
		assertTrue(c instanceof CommandAltaHabitacion);
		
		Object d = new TransferHabitacionNormal();
        

		
		((TransferHabitacion) d).setNumHabitacion(new Random().nextInt(99999));
		((TransferHabitacion) d).setPrecio(new Random().nextDouble());
      
        
		CommandResponse rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_ALTA_HABITACION);
		
		Integer a = (Integer) rc.getDatos() , b  = ((TransferHabitacion) d).getNumHabitacion();
		
		assertTrue(a.compareTo(b)==0);
				
	
		c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_BAJA_HABITACION);
		assertNotNull(c);
		assertTrue(c instanceof CommandBajaHabitacion);
		
		d= (Integer)(rc.getDatos());
        
		rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_BAJA_HABITACION);
		assertTrue((Boolean)rc.getDatos());
	}

}
