/**
 * 
 */
package presentacion.comandos.reserva;

import negocio.clientes.transfer.TransferCliente;
import negocio.factorias.serviciosAplicacion.FactorySA;
import negocio.reservas.transfer.TransferReserva;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandAltaReserva implements Command {
	/**
	 * (sin Javadoc)
	 * 
	 * @see Command#execute(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public CommandResponse execute(Object datos) {
		
		CommandResponse cm = new CommandResponse();	
		cm.setDatos(FactorySA.getInstance().getSAReservas().anadirReserva((TransferReserva) datos));
		cm.setEvento(IDEventos.EVENTO_ALTA_RESERVA);
		return cm;
	}
}