/**
 * 
 */
package presentacion.comandos.empleado.redireccion;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Daniel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandRConsultarTareasVAsignarTarea  implements Command {

	@Override
	public CommandResponse execute(Object datos) {

		Command command = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_TODAS_TAREAS);

		CommandResponse cr = command.execute(datos);
		
		if ( cr.getEvento().equals(IDEventos.ERROR_CONSULTAR_TODAS_TAREAS) ) {
			
			cr.setEvento(IDEventos.ERROR_CONSULTAR_TAREAS_V_ASIGARTAREA);
		}
		else {
			
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_TAREAS_V_ASIGARTAREA);
		}
		
		return cr;
	}
}