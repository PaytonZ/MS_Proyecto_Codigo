/**
 * 
 */
package presentacion.clientes.imp;

import presentacion.clientes.GUICliente;
import presentacion.clientes.frames.PanelAltaClientes;
import presentacion.clientes.frames.PanelBajaClientes;
import presentacion.clientes.frames.PanelConsultaClientes;
import presentacion.clientes.frames.PanelConsultaMultipleClientes;
import presentacion.clientes.frames.PanelModificacionClientes;
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

	public void update(Integer idEvento, Object datos) {
		
	}

	public PanelAltaClientes getPanelAlta() {
		
		if ( panelAlta == null)
			panelAlta = new PanelAltaClientes();
		
		return panelAlta;
	}

	public PanelBajaClientes getPanelBaja() {
		
		return panelBaja;
	}
	
	public PanelModificacionClientes getPanelModificacion() {
		
		return panelModificacion;
	}

	public PanelConsultaClientes getPanelConsulta() {
	
		return panelConsulta;
	}

public PanelConsultaMultipleClientes getPanelConsultaMoltiple() {
		 
		return panelConsultaMoltiple;
	}

	public PanelConsultaMultipleClientes getPanelConsultaMultipleClientes() {
		
		return panelConsultaMoltiple;

	}

	public PanelAltaClientes getPanelAltaClientes() {
		
		return new PanelAltaClientes();
	}

	public PanelBajaClientes getPanelBajaClientes() {
	
		return panelBaja;
	}

	public PanelConsultaClientes getPanelConsultaClientes() {
	
		return panelConsulta;
	}

	public PanelModificacionClientes getPanelModificacionClientes() {
	
		return panelModificacion;
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