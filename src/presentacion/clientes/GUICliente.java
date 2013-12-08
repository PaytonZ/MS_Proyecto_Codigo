/**
 * 
 */
package presentacion.clientes;

import presentacion.clientes.frames.FrameConsultaMultipleClientes;
import presentacion.clientes.frames.FrameAltaClientes;
import presentacion.clientes.frames.FrameBajaClientes;
import presentacion.clientes.frames.FrameConsultaClientes;
import presentacion.clientes.frames.FrameModificacionClientes;
import presentacion.clientes.imp.GUIClienteImp;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class GUICliente {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private static GUICliente selfInstance;

	/**
	 * @return el selfInstance
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static GUICliente getSelfInstance() {
		// begin-user-code
		return selfInstance;
		// end-user-code
	}

	/**
	 * @param selfInstance
	 *            el selfInstance a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setSelfInstance(GUICliente selfInstance) {
		// begin-user-code
		GUICliente.selfInstance = selfInstance;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param idEvento
	 * @param datos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(Integer idEvento, Object datos);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static GUICliente getInstance() {

		createGUICliente();
		
		return selfInstance;
	}
	
	private static synchronized void createGUICliente() {
		
		if ( selfInstance == null) {
			selfInstance = new GUIClienteImp();
		}
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract FrameConsultaMultipleClientes getFrameConsultaMultipleClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract FrameAltaClientes getFrameAltaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract FrameBajaClientes getFrameBajaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract FrameConsultaClientes getFrameConsultaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract FrameModificacionClientes getFameModificacionClientes();
}