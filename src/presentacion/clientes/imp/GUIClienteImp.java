/**
 * 
 */
package presentacion.clientes.imp;

import presentacion.clientes.GUICliente;
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
public class GUIClienteImp extends GUICliente {
	
	private PanelAltaClientes panelAlta;
	private PanelBajaClientes panelBaja;
	private PanelModificacionClientes panelModificacion;
	private PanelConsultaClientes panelConsulta;
	private PanelConsultaMultipleClientes panelConsultaMoltiple;

	public PanelAltaClientes getPanelAltaClientes() {
		
		if ( panelAlta == null)
			panelAlta = new PanelAltaClientes();
		
		return panelAlta;
	}

	public PanelBajaClientes getPanelBajaClientes() {
		
		if ( panelBaja == null)
			panelBaja = new PanelBajaClientes();
	
		return panelBaja;
	}

	public PanelConsultaClientes getPanelConsultaClientes() {
		
		if ( panelConsulta == null)
			panelConsulta = new PanelConsultaClientes();
	
		return panelConsulta;
	}

	public PanelModificacionClientes getPanelModificacionClientes() {
		
		if ( panelModificacion == null)
			panelModificacion = new PanelModificacionClientes();
	
		return panelModificacion;
	}

	public PanelConsultaMultipleClientes getPanelConsultaMultipleClientes() {
		
		if ( panelConsultaMoltiple == null)
			panelConsultaMoltiple = new PanelConsultaMultipleClientes();
		
		return panelConsultaMoltiple;

	}

	public void update(IDEventos evento_actual, Object datos) {
		switch (evento_actual) {
		case EVENTO_ALTA_CLIENTE:
			panelAlta.actualizarVentana(datos);
			break;
		case EVENTO_BAJA_CLIENTE:
			panelBaja.actualizarVentana(datos);
			break;
		case EVENTO_ACTUALIZAR_CLIENTE:
			panelModificacion.actualizarVentana(datos);
			break;
		case EVENTO_OBTENER_CLIENTE:
			panelConsulta.actualizarVentana(datos);
			break;
		case EVENTO_OBTENER_TODOS_CLIENTE:
			panelConsultaMoltiple.actualizarVentana(datos);
			break;

		default:
			break;

		}
	}
}