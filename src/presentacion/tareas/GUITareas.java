/**
 * 
 */
package presentacion.tareas;

import presentacion.tareas.imp.GUITareasImp;
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
public abstract class GUITareas {

	private static GUITareas selfInstance;
	
	public static GUITareas getInstance() {

		crearGUITareas();
		
		return selfInstance;
	}
	
	private static synchronized void crearGUITareas() {
		
		if ( selfInstance == null ) {
			selfInstance = new GUITareasImp();
		}
	}

	public abstract void update(Object idVentana, Object datos);
	
	public abstract PanelAltaTareas getPanelAltaTareas();

	public abstract PanelBajaTareas getPanelBajaTareas();

	public abstract PanelConsultaMultipleTareas getPanelConsultaMultipleTareas();

	public abstract PanelConsultaTarea getPanelConsultaTarea();

	public abstract PanelModificacionTareas getPanelModificacionTareas();
}