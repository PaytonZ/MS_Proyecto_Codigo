/**
 * 
 */
package presentacion.controladores.aplicacion.dispatcher.imp;

import presentacion.clientes.GUICliente;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;
import presentacion.controladores.aplicacion.dispatcher.Dispatcher;
import presentacion.reservas.GUIReservas;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DispatcherImp extends Dispatcher {
	/**
	 * (sin Javadoc)
	 * 
	 * @see Dispatcher#redirect(CommandResponse respuestacomando)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void redirect(CommandResponse respuestacomando) {

		IDEventos eventoActual = respuestacomando.getEvento();
		Object datos = respuestacomando.getDatos();

		if (eventoActual == IDEventos.EVENTO_ALTA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_BAJA_CLIENTE
				|| eventoActual == IDEventos.EVENTO_MODIFICAR_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE
				|| eventoActual == IDEventos.EVENTO_CONSULTAR_TODOS_CLIENTE_V_BORRA) {
			
			GUICliente.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_RESERVA
				    || eventoActual == IDEventos.EVENTO_BAJA_RESERVA
				    || eventoActual == IDEventos.EVENTO_MODIFICAR_RESERVA
				    || eventoActual == IDEventos.EVENTO_CONSULTAR_RESERVA
				    || eventoActual == IDEventos.EVENTO_CONSULTAR_TODAS_RESERVAS) {
			
			GUIReservas.getInstance().update(eventoActual, datos);
		}
		else if(eventoActual == IDEventos.EVENTO_ALTA_HABITACION
			    || eventoActual == IDEventos.EVENTO_BAJA_HABITACION
			    || eventoActual == IDEventos.EVENTO_MODIFICAR_HABITACION
			    || eventoActual == IDEventos.EVENTO_CONSULTAR_HABITACION
			    || eventoActual == IDEventos.EVENTO_CONSULTAR_HABITACION) {
			
			GUIReservas.getInstance().update(eventoActual, datos);
		}
	}
}