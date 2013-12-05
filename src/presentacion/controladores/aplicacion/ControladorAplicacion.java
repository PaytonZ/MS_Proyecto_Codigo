/**
 * 
 */
package presentacion.controladores.aplicacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class ControladorAplicacion {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static ControladorAplicacion controladorAplicacionInstance;

	/**
	 * @return el controladorAplicacionInstance
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ControladorAplicacion getControladorAplicacionInstance() {
		// begin-user-code
		return controladorAplicacionInstance;
		// end-user-code
	}

	/**
	 * @param controladorAplicacionInstance
	 *            el controladorAplicacionInstance a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setControladorAplicacionInstance(
			ControladorAplicacion controladorAplicacionInstance) {
		// begin-user-code
		ControladorAplicacion.controladorAplicacionInstance = controladorAplicacionInstance;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ControladorAplicacion getInstance() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param evento
	 * @param datos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void handleRequest(Integer evento, Object datos);
}