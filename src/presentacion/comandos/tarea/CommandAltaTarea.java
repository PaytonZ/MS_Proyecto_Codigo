/**
 * 
 */
package presentacion.comandos.tarea;

import negocio.excepciones.BSoDException;
import negocio.factorias.serviciosAplicacion.FactorySA;
import negocio.tareas.objetonegocio.Tarea;
import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandResponse;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Daniel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public class CommandAltaTarea implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Clase datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

		    cr.setDatos(FactorySA.getInstance().getSATareas().anadirTarea((Tarea) datos));
		    cr.setEvento(IDEventos.EVENTO_ALTA_TAREA);

		} catch (BSoDException bsod) {

		    cr.setDatos(bsod);
		    cr.setEvento(IDEventos.ERROR_ALTA_TAREA);
		}
		
		return cr;
	}
}