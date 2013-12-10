/**
 * 
 */
package presentacion.controladores.aplicacion.controladoraplicacion.imp;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.CommandFactory;
import presentacion.comandos.commandFactory.CommandResponse;
import presentacion.controladores.aplicacion.controladoraplicacion.ControladorAplicacion;
import presentacion.controladores.aplicacion.dispatcher.Dispatcher;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ControladorAplicacionImp extends ControladorAplicacion {
	/**
	 * (sin Javadoc)
	 * 
	 * @see ControladorAplicacion#handleRequest(Integer evento, Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void handleRequest(IDEventos evento, Object datos) {

		Command c = CommandFactory.getInstance().nuevoComando(evento);
		CommandResponse rc = c.execute(datos);
		Dispatcher.getInstance().redirect(rc);
	}
}