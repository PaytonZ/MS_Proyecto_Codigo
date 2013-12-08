/**
 * 
 */
package presentacion.clientes;

import presentacion.clientes.frames.PanelConsultaMultipleClientes;
import presentacion.clientes.frames.PanelAltaClientes;
import presentacion.clientes.frames.PanelBajaClientes;
import presentacion.clientes.frames.PanelConsultaClientes;
import presentacion.clientes.frames.PanelModificacionClientes;
import presentacion.clientes.imp.GUIClienteImp;
import presentacion.comandos.IDEventos;

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

	private static GUICliente GUIClienteInstance;


	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param evento_actual
	 * @param datos
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(IDEventos evento_actual, Object datos);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static GUICliente getInstance() {

		createGUICliente();

		return GUIClienteInstance;
	}

	private static synchronized void createGUICliente() {

		if (GUIClienteInstance == null) {
			GUIClienteInstance = new GUIClienteImp();
		}
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelConsultaMultipleClientes getPanelConsultaMultipleClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelAltaClientes getPanelAltaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelBajaClientes getPanelBajaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelConsultaClientes getPanelConsultaClientes();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelModificacionClientes getPanelModificacionClientes();
}