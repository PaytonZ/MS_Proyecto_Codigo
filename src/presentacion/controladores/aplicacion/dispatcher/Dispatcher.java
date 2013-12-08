/**
 * 
 */
package presentacion.controladores.aplicacion.dispatcher;

import presentacion.comandos.commandFactory.CommandResponse;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class Dispatcher {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static Dispatcher dispatcherInstance;

	/**
	 * @return el dispatcherInstance
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Dispatcher getDispatcherInstance() {
		// begin-user-code
		return dispatcherInstance;
		// end-user-code
	}

	/**
	 * @param dispatcherInstance
	 *            el dispatcherInstance a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setDispatcherInstance(Dispatcher dispatcherInstance) {
		// begin-user-code
		Dispatcher.dispatcherInstance = dispatcherInstance;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param respuestacomando
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void redirect(CommandResponse respuestacomando);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static Dispatcher getInstance() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}
}