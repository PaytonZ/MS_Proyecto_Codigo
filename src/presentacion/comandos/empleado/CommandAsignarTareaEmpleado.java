/**
 * 
 */
package presentacion.comandos.empleado;

import java.util.HashSet;
import java.util.Set;

import negocio.empleados.objetonegocio.Empleado;
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
public class CommandAsignarTareaEmpleado implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Clase datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

		    Empleado emp = (Empleado) datos;
		    
		    Set<Tarea> tareas = emp.getTarea();
		    
		    emp.setTarea(new HashSet<Tarea>());
		    
		    cr.setDatos(FactorySA.getInstance().getSAEmpleados().anadirTareaEmpleado(emp.getDNI(), tareas));
		    cr.setEvento(IDEventos.EVENTO_ASIGNARTAREA_EMPLEADO);

		} catch (Exception bsod) { // cambiar por bsod

		    cr.setDatos(bsod);
		    cr.setEvento(IDEventos.ERROR_ASIGNARTAREA_EMPLEADO);
		}
		
		return cr;
	}
}