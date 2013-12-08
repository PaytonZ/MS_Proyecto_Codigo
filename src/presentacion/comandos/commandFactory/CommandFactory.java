/**
 * 
 */
package presentacion.comandos.commandFactory;

import presentacion.comandos.Command;
import presentacion.comandos.IDEventos;
import presentacion.comandos.commandFactory.imp.CommandFactoryImp;
import negocio.factorias.serviciosAplicacion.imp.FactorySAImp;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class CommandFactory {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static CommandFactory commandFactoryInstance;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static CommandFactory getInstance() {
		
		createcommandFactory();
		return commandFactoryInstance;
		// end-user-code
	}
	
	private synchronized static void createcommandFactory() {
		if (commandFactoryInstance == null)
			commandFactoryInstance = new CommandFactoryImp();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param id_comando
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract Command nuevoComando(IDEventos id_comando);
}