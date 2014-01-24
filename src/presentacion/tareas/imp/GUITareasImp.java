/**
 * 
 */
package presentacion.tareas.imp;

import presentacion.comandos.IDEventos;
import presentacion.tareas.GUITareas;
import presentacion.tareas.paneles.PanelAltaTareas;
import presentacion.tareas.paneles.PanelBajaTareas;
import presentacion.tareas.paneles.PanelConsultaMultipleTareas;
import presentacion.tareas.paneles.PanelConsultaTarea;
import presentacion.tareas.paneles.PanelModificacionTareas;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUITareasImp extends GUITareas {
	
	private static PanelAltaTareas panelAlta;
	private static PanelBajaTareas panelBaja;
	private static PanelConsultaMultipleTareas panelConsultaMultiples;
	private static PanelConsultaTarea panelConsulta;
	private static PanelModificacionTareas panelModificacion;
	
	@Override
	public PanelAltaTareas getPanelAltaTareas() {

		if(panelAlta == null) {
			panelAlta = new PanelAltaTareas();
		}
		
		return panelAlta;
	}
	
	@Override
	public PanelBajaTareas getPanelBajaTareas() {

		if ( panelBaja == null) {
			panelBaja = new PanelBajaTareas();
		}
		
		return panelBaja;
	}
	
	@Override
	public PanelConsultaMultipleTareas getPanelConsultaMultipleTareas() {
		
		if(panelConsultaMultiples == null) {
			panelConsultaMultiples = new PanelConsultaMultipleTareas();
		}
		
		return panelConsultaMultiples;
	}
	
	@Override
	public PanelConsultaTarea getPanelConsultaTarea() {
		
		if(panelConsulta == null) {
			panelConsulta = new PanelConsultaTarea();
		}
		
		return panelConsulta;
	}
	
	@Override
	public PanelModificacionTareas getPanelModificacionTareas() {

		if ( panelModificacion == null ) {
			panelModificacion = new PanelModificacionTareas();
		}
		
		return panelModificacion;
	}
	
	@Override
	public void update(IDEventos eventoActual, Object datos) {
	    
		switch (eventoActual) {
		
		case EVENTO_ALTA_TAREA:
		case ERROR_ALTA_TAREA:
		    getPanelAltaTareas().actualizarVentana(eventoActual, datos);
		    break;
		case EVENTO_BAJA_TAREA:
		case ERROR_BAJA_TAREA:
		case EVENTO_CONSULTAR_TAREAS_V_BORRAR:
		case ERROR_CONSULTAR_TAREAS_V_BORRAR:
		    getPanelBajaTareas().actualizarVentana(eventoActual, datos);
		    break;
		case EVENTO_MODIFICAR_TAREA:
		case ERROR_MODIFICAR_TAREA:
		case EVENTO_CONSULTAR_TAREAS_V_MODIFICAR:
		case ERROR_CONSULTAR_TAREAS_V_MODIFICAR:
		    getPanelModificacionTareas().actualizarVentana(eventoActual, datos);
		    break;
		case EVENTO_CONSULTAR_TAREA:
		case ERROR_CONSULTAR_TAREA:
		    getPanelConsultaTarea().actualizarVentana(eventoActual, datos);
		    break;
		case ERROR_CONSULTAR_TODAS_TAREAS:
		case ERROR_CONSULTAR_TODOS_DEPARTAMENTO:
		    getPanelConsultaMultipleTareas().actualizarVentana(eventoActual, datos);
		    break;

		default:
		    break;
		}
	}

}