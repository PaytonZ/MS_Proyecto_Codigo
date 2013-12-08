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

		IDEventos evento_actual = respuestacomando.getEvento();
		Object datos = respuestacomando.getDatos();

		if (evento_actual == IDEventos.EVENTO_ALTA_CLIENTE
				|| evento_actual == IDEventos.EVENTO_BAJA_CLIENTE
				|| evento_actual == IDEventos.EVENTO_ACTUALIZAR_CLIENTE
				|| evento_actual == IDEventos.EVENTO_OBTENER_CLIENTE
				|| evento_actual == IDEventos.EVENTO_OBTENER_TODOS_CLIENTE) {
			GUICliente.getInstance().update(evento_actual, datos);
		}
		else if(evento_actual == IDEventos.EVENTO_ALTA_RESERVA
				    || evento_actual == IDEventos.EVENTO_BAJA_RESERVA
				    || evento_actual == IDEventos.EVENTO_MODIFICAR_RESERVA
				    || evento_actual == IDEventos.EVENTO_CONSULTAR_RESERVA
				    || evento_actual == IDEventos.EVENTO_CONSULTAR_TODAS_RESERVAS)
		{
			GUIReservas.getInstance().update(evento_actual, datos);
		}
		// rellenar else if con el resto

	}
}