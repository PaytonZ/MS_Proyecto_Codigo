/**
 * 
 */
package presentacion.comandos.commandFactory.imp;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.cliente.CommandAltaCliente;
import presentacion.comandos.commandFactory.CommandFactory;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class CommandFactoryImp extends CommandFactory {
	/**
	 * (sin Javadoc)
	 * 
	 * @see CommandFactory#nuevoComando(Integer id_comando)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Command nuevoComando(IDEventos id_comando) {
		
		Command c = null;

		
		switch (id_comando) {
		
		case EVENTO_ALTA_CLIENTE: c = new CommandAltaCliente();
		
		
		
		}
		
		return c;
		
	}
}