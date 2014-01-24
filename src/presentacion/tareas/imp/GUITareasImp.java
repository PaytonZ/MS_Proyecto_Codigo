/**
 * 
 */
package presentacion.tareas.imp;

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
	
	private PanelAltaTareas panelAlta;
	private PanelBajaTareas panelBaja;
	private PanelConsultaMultipleTareas panelConsultaMultiples;
	private PanelConsultaTarea panelConsulta;
	private PanelModificacionTareas panelModificacion;
	
	@Override
	public void update(Object idVentana, Object datos) {
		// TODO Auto-generated method stub
		
	}
	
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

}