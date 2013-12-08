/**
 * 
 */
package presentacion.clientes;

import presentacion.clientes.imp.GUIClienteImp;
import presentacion.clientes.paneles.PanelAltaClientes;
import presentacion.clientes.paneles.PanelBajaClientes;
import presentacion.clientes.paneles.PanelConsultaClientes;
import presentacion.clientes.paneles.PanelConsultaMultipleClientes;
import presentacion.clientes.paneles.PanelModificacionClientes;
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