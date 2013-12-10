package presentacion.comandos.habitacion;

import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import negocio.habitaciones.transfer.TransferHabitacion;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandConsultaHabitacionVentanaModificar implements Command {

	@Override
	public CommandResponse execute(Object datos) {

		FactorySA factoriaSa = FactorySA.getInstance();

		TransferHabitacion habitacion = null;
		CommandResponse cr = new CommandResponse();
		try {
			Integer numHabitacion = (Integer) datos;
			
			habitacion = factoriaSa.getSAHabitaciones().obtenerHabitacion(numHabitacion);

			cr.setDatos(habitacion);
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_HABITACION_V_MODIFICAR);

		} catch (BSoDException bsod) {

			cr.setDatos(bsod);
			cr.setEvento(IDEventos.ERROR_CONSULTAR_HABITACION_V_MODIFICAR);
		}

		return cr;
	}
}
