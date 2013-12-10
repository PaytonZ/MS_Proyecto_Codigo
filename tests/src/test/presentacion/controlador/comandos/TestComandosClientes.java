package test.presentacion.controlador.comandos;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.cliente.CommandAltaCliente;
import presentacion.comandos.cliente.CommandBajaCliente;
import presentacion.comandos.cliente.CommandConsultaCliente;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestComandosClientes {
	@Test
	public void comandoAltaYBajaCliente()
	{
		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_ALTA_CLIENTE);
		assertNotNull(c);
		assertTrue(c instanceof CommandAltaCliente);
		
		Object d = new TransferCliente();
        

        ((TransferCliente) d).setDNI(String.valueOf(new Random().nextInt(99999)));
        ((TransferCliente) d).setDireccion("testcommand");
        ((TransferCliente) d).setNombre("asdasd");
        ((TransferCliente) d).setPrimerApellido("asdasd");
        ((TransferCliente) d).setSegundoApellido("asdasd");
        ((TransferCliente) d).setNumTelefono(new Random().nextInt(99999));
        
		CommandResponse rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_ALTA_CLIENTE);
		assertTrue((Integer)rc.getDatos()>=0);
				
	
		c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_BAJA_CLIENTE);
		assertNotNull(c);
		assertTrue(c instanceof CommandBajaCliente);
		
		d= (Integer)(rc.getDatos());
        
		rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_BAJA_CLIENTE);
		assertTrue((Boolean)rc.getDatos());
			
	}
	@Test
	public void commandoADDandconsultaCliente()
	{
		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_ALTA_CLIENTE);
		assertNotNull(c);
		assertTrue(c instanceof CommandAltaCliente);
		
		Object d = new TransferCliente();
        

        ((TransferCliente) d).setDNI(String.valueOf(new Random().nextInt(99999)));
        ((TransferCliente) d).setDireccion("testcommand");
        ((TransferCliente) d).setNombre("asdasd");
        ((TransferCliente) d).setPrimerApellido("asdasd");
        ((TransferCliente) d).setSegundoApellido("asdasd");
        ((TransferCliente) d).setNumTelefono(new Random().nextInt(99999));
        
		CommandResponse rc = c.execute(d);
		
		assertTrue(rc.getEvento()==IDEventos.EVENTO_ALTA_CLIENTE);
		assertTrue((Integer)rc.getDatos()>=0);
				
		
		c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_CLIENTE);
		assertNotNull(c);
		assertTrue(c instanceof CommandConsultaCliente);
		rc = c.execute(((TransferCliente) d).getDNI());

		assertTrue(rc.getEvento()==IDEventos.EVENTO_CONSULTAR_CLIENTE);
		assertTrue(((TransferCliente) rc.getDatos()).getDNI().equalsIgnoreCase(((TransferCliente) d).getDNI()));
		
	}

}
