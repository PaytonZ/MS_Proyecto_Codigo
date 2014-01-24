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
public class CommandRConsultarDepartamentosVAltaEmpleado implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Clase datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {

		Command command = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTO);

		CommandResponse cr = command.execute(datos);
		
		if ( cr.getEvento().equals(IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTO) ) {
			
			cr.setEvento(IDEventos.ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO);
		}
		else {
			
			cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO);
		}
		
		return cr;
	}
}