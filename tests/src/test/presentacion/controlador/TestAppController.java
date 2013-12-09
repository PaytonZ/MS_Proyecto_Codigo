package test.presentacion.controlador;

import java.util.Random;

import negocio.clientes.transfer.TransferCliente;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;

@RunWith(JUnit4.class)
@FixMethodOrder
public class TestAppController {
	@Test
	public void comandoAltaCliente()
	{
		Object c = new TransferCliente();
		

		((TransferCliente) c).setDNI(String.valueOf(new Random().nextInt(99999)));
		((TransferCliente) c).setDireccion("asdasd");
		((TransferCliente) c).setNombre("asdasd");
		((TransferCliente) c).setPrimerApellido("asdasd");
		((TransferCliente) c).setSegundoApellido("asdasd");
		((TransferCliente) c).setNumTelefono(454545);
		
		ControladorAplicacion.getInstance().handleRequest(IDEventos.EVENTO_ALTA_CLIENTE, c);
		
	}

}
