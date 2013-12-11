package presentacion.comandos.reserva;

import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;


public class CommandConsultaTodasReservas implements Command {

	@Override
	public CommandResponse execute(Object datos) {
		CommandResponse cr = new CommandResponse();
		try {

			cr.setDatos(FactorySA.getInstance().getSAReservas().obtenerTodaslasReservas());
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODAS_RESERVAS);

		} catch (BSoDException bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_TODAS_RESERVAS);
		}

		return cr;
	}

}
