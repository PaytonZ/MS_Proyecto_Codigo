package presentacion.comandos.reserva;

import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandConsultarClienteReserva implements Command{

	/**
	 * @param args
	 */

	@Override
	public CommandResponse execute(Object datos) {
		CommandResponse cr = new CommandResponse();
		try {
			cr.setDatos(FactorySA.getInstance().getSAClientes().obtenerCliente(datos.toString()));
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS);

		} catch (BSoDException bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_CLIENTE_V_ALTA_RESERVAS);
		}

		return cr;
	}

}
