/**
 * 
 */
package presentacion.controladores.aplicacion.controladoraplicacion;

import presentacion.comandos.IDEventos;
import presentacion.controladores.aplicacion.controladoraplicacion.imp.ControladorAplicacionImp;
import negocio.factorias.serviciosAplicacion.imp.FactorySAImp;

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
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static ControladorAplicacion getInstance() {
		createApplicationController();
		return controladorAplicacionInstance;
	}
	
	private synchronized static void createApplicationController() {
		if (controladorAplicacionInstance == null)
			controladorAplicacionInstance = new ControladorAplicacionImp();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param evento
	 * @param datos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void handleRequest(IDEventos evento, Object datos);
}