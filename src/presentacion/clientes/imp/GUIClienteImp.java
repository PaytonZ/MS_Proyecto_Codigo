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
		case ERROR_ALTA_CLIENTE:
			getPanelAltaClientes().actualizarVentana(datos);
			break;
		case EVENTO_BAJA_CLIENTE:
		case ERROR_BAJA_CLIENTE:
		case EVENTO_CONSULTAR_CLIENTE_V_BORRAR:
		case ERROR_CONSULTAR_CLIENTE_V_BORRAR:
			getPanelBajaClientes().actualizarVentana(datos);
			break;
		case EVENTO_MODIFICAR_CLIENTE:
		case ERROR_MODIFICAR_CLIENTE:
			getPanelModificacionClientes().actualizarVentana(datos);
			break;
		case EVENTO_CONSULTAR_CLIENTE:
		case ERROR_CONSULTAR_CLIENTE:
			getPanelConsultaClientes().actualizarVentana(datos);
			break;
		case EVENTO_CONSULTAR_TODOS_CLIENTE:
		case ERROR_CONSULTAR_TODOS_CLIENTE:
			getPanelConsultaMultipleClientes().actualizarVentana(datos);
			break;

		default:
			break;

		}
	}
	}
