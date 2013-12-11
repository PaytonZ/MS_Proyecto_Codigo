/**
 * 
 */
package presentacion.reservas.imp;

import presentacion.comandos.IDEventos;
import presentacion.reservas.GUIReservas;
import presentacion.reservas.paneles.PanelAltaReservas;
import presentacion.reservas.paneles.PanelBajaReservas;
import presentacion.reservas.paneles.PanelConsultaMultipleReservas;
import presentacion.reservas.paneles.PanelConsultaReservas;
import presentacion.reservas.paneles.PanelModificacionReservas;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIReservasImp extends GUIReservas {

	private PanelAltaReservas panelAlta;
	private PanelBajaReservas panelBaja;
	private PanelModificacionReservas panelModificacion;
	private PanelConsultaReservas panelConsulta;
	private PanelConsultaMultipleReservas panelConsultaMultiple;// end-user-code
	
	public void update(IDEventos evento_actual, Object datos) {
switch (evento_actual) {
		
		case EVENTO_ALTA_RESERVA:
		case ERROR_ALTA_RESERVA:
		case EVENTO_CONSULTAR_CLIENTE_V_ALTA_RESERVAS:
		case ERROR_CONSULTAR_CLIENTE_V_ALTA_RESERVAS:
			getPanelAltaReservas().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_BAJA_RESERVA:
		case ERROR_BAJA_RESERVA:
			getPanelBajaReservas().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_CONSULTAR_RESERVA:
		case ERROR_CONSULTAR_RESERVA:
			getPanelConsultaReservas().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_MODIFICAR_RESERVA:
		case ERROR_MODIFICAR_RESERVA:
		case EVENTO_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS:
		case ERROR_CONSULTAR_RESERVA_V_MODIFICAR_RESERVAS:
			getPanelModificacionReservas().actualizarVentana(evento_actual, datos);
			break;
		case EVENTO_CONSULTAR_TODAS_RESERVAS:
		case ERROR_CONSULTAR_TODAS_RESERVAS:
			getPanelConsultaMultipleReservas().actualizarVentana(evento_actual, datos);
			break;

		default:
			break;

		}
	}

	public PanelConsultaMultipleReservas getPanelConsultaMultipleReservas() {

		if ( panelConsultaMultiple == null ) {
			panelConsultaMultiple = new PanelConsultaMultipleReservas();
		}
		
		return panelConsultaMultiple;
	}

	public PanelAltaReservas getPanelAltaReservas() {

		if ( panelAlta == null ) {
			panelAlta = new PanelAltaReservas();
		}
		
		return panelAlta;
	}

	public PanelBajaReservas getPanelBajaReservas() {

		if( panelBaja == null ) {
			panelBaja = new PanelBajaReservas();
		}
		
		return panelBaja;
	}

	public PanelConsultaReservas getPanelConsultaReservas() {

		if ( panelConsulta == null ) {
			panelConsulta = new PanelConsultaReservas();
		}
		
		return panelConsulta;
	}

	public PanelModificacionReservas getPanelModificacionReservas() {

		if ( panelModificacion == null ) {
			panelModificacion = new PanelModificacionReservas();
		}
		
		return panelModificacion;
	}
}