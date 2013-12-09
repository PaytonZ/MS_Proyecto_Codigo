/**
 * 
 */
package presentacion.comandos.commandFactory.imp;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.cliente.CommandAltaCliente;
import presentacion.comandos.cliente.CommandBajaCliente;
import presentacion.comandos.cliente.CommandConsultaCliente;
import presentacion.comandos.cliente.CommandConsultaTodosClientes;
import presentacion.comandos.cliente.CommandModificarCliente;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.habitacion.CommandAltaHabitacion;
import presentacion.comandos.habitacion.CommandBajaHabitacion;
import presentacion.comandos.habitacion.CommandConsultaHabitacion;
import presentacion.comandos.habitacion.CommandConsultaTodasHabitaciones;
import presentacion.comandos.habitacion.CommandModificarHabitacion;
import presentacion.comandos.reserva.CommandAltaReserva;
import presentacion.comandos.reserva.CommandBajaReserva;
import presentacion.comandos.reserva.CommandConsultaReserva;
import presentacion.comandos.reserva.CommandConsultaTodasReservas;
import presentacion.comandos.reserva.CommandModificarReserva;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {
	/**
	 * (sin Javadoc)
	 * 
	 * @see CommandFactory#nuevoComando(Integer id_comando)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Command nuevoComando(IDEventos id_comando) {

		Command c = null;

		switch (id_comando) {
		/* CLIENTES */
		case EVENTO_ALTA_CLIENTE:
			c = new CommandAltaCliente();
			break;

		case EVENTO_BAJA_CLIENTE:
			c = new CommandBajaCliente();
			break;

		case EVENTO_MODIFICAR_CLIENTE:
			c = new CommandModificarCliente();
			break;

		case EVENTO_CONSULTAR_CLIENTE:
			c = new CommandConsultaCliente();
			break;

		case EVENTO_CONSULTAR_TODOS_CLIENTE:
			c = new CommandConsultaTodosClientes();
			break;
		case EVENTO_ALTA_RESERVA:
			c = new CommandAltaReserva();
			break;
		case EVENTO_BAJA_RESERVA:
			c = new CommandBajaReserva();
			break;
		case EVENTO_MODIFICAR_RESERVA:
			c = new CommandModificarReserva();
			break;
		case EVENTO_CONSULTAR_RESERVA:
			c = new CommandConsultaReserva();
			break;
		case EVENTO_CONSULTAR_TODAS_RESERVAS:
			c = new CommandConsultaTodasReservas();
			break;
		/* HABITACIONES */

		case EVENTO_ALTA_HABITACION:
			c = new CommandAltaHabitacion();
			break;
		case EVENTO_CONSULTAR_HABITACION:
			c = new CommandConsultaHabitacion();
			break;
		case EVENTO_BAJA_HABITACION:
			c = new CommandBajaHabitacion();
			break;
		case EVENTO_MODIFICAR_HABITACION:
			c = new CommandModificarHabitacion();
			break;
		case EVENTO_CONSULTAR_TODAS_HABITACION:
			c = new CommandConsultaTodasHabitaciones();
			break;
		default:
			break;

		}

		return c;

	}
}