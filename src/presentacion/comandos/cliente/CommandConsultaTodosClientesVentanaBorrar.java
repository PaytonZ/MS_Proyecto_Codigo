package presentacion.comandos.cliente;

import java.util.List;

import negocio.clientes.transfer.TransferCliente;
import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandConsultaTodosClientesVentanaBorrar implements Command {

	@Override
	public CommandResponse execute(Object datos) {
		
		FactorySA factoriaSa = FactorySA.getInstance();
		
		List<TransferCliente> lista = null;
		CommandResponse cr = new CommandResponse();
		try {
			lista = factoriaSa.getSAClientes().obtenerTodoslosClientes();
			
			cr.setDatos(lista);
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE_V_BORRAR);
			
		} catch (BSoDException bsod) {
			
			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_TODOS_CLIENTE_V_BORRAR);
		}
		
		return cr;
	}
}
