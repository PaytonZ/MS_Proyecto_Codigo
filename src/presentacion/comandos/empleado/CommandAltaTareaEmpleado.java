/**
 * 
 */
package presentacion.comandos.empleado;

import java.util.ArrayList;
import java.util.List;

import negocio.empleados.objetonegocio.Empleado;
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
public class CommandAltaTareaEmpleado implements Command {
	/** 
	 * (sin Javadoc)
	 * @see Command#execute(Clase datos)
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public CommandResponse execute(Object datos) {

		CommandResponse cr = new CommandResponse();
		try {

		    Empleado emp = (Empleado) datos;
		    
		   // List<Tarea> tareas = emp.getListaTareas();
		    
		    //emp.setListaTareas(new ArrayList<Tarea>());
		    
		  //  cr.setDatos(FactorySA.getInstance().getSAEmpleados().anadirTareaEmpleado(emp.getDNI(), tareas));
		    cr.setEvento(IDEventos.EVENTO_ALTA_DEPARTAMENTO);

		} catch (Exception bsod) { // cambiar por bsod

		    cr.setDatos(bsod);
		    cr.setEvento(IDEventos.ERROR_ALTA_DEPARTAMENTO);
		}
		
		return cr;
	}
}