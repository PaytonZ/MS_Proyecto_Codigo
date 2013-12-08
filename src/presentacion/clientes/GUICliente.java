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
	
	private static GUICliente GUIClienteInstance;

	public abstract void update(IDEventos evento_actual, Object datos);

	public static GUICliente getInstance() {

		createGUICliente();

		return GUIClienteInstance;
	}

	private static synchronized void createGUICliente() {

		if (GUIClienteInstance == null) {
			GUIClienteInstance = new GUIClienteImp();
		}
	}

	public abstract PanelConsultaMultipleClientes getPanelConsultaMultipleClientes();

	public abstract PanelAltaClientes getPanelAltaClientes();

	public abstract PanelBajaClientes getPanelBajaClientes();
	
	public abstract PanelConsultaClientes getPanelConsultaClientes();

	public abstract PanelModificacionClientes getPanelModificacionClientes();
}