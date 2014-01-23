package presentacion.comandos.empleado;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;

public class CommandConsltaDepartamentosAltaEmpleado  implements Command {
	/**
	 * (sin Javadoc)
	 * 
	 * @see Command#execute(Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public CommandResponse execute(Object datos) {


		Command c = CommandFactory.getInstance().nuevoComando(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTO);
		
		CommandResponse cr = c.execute(datos);
		
		cr.setEvento(IDEventos.EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO);
		
		return cr;
	}
}