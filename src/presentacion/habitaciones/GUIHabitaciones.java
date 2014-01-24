/**
 * 
 */
package presentacion.habitaciones;

import presentacion.comandos.IDEventos;
import presentacion.habitaciones.imp.GUIHabitacionesImp;
import presentacion.habitaciones.paneles.PanelAltaHabitaciones;
import presentacion.habitaciones.paneles.PanelBajaHabitaciones;
import presentacion.habitaciones.paneles.PanelConsultaHabitaciones;
import presentacion.habitaciones.paneles.PanelConsultaMultiplesHabitaciones;
import presentacion.habitaciones.paneles.PanelModificacionHabitaciones;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class GUIHabitaciones {

	private static GUIHabitaciones selfInstance;

	public abstract void update(IDEventos idEvento, Object datos);

	public static GUIHabitaciones getInstance() {
		
		crearGUIHabitaciones();
		
		return selfInstance;
	}
	
	private static synchronized void crearGUIHabitaciones() {
		
		if ( selfInstance == null ) {
			
			selfInstance = new GUIHabitacionesImp();
		}
	}

	public abstract PanelAltaHabitaciones getPanelAltaHabitaciones();
	
	public abstract PanelBajaHabitaciones getPanelBajaHabitaciones();

	public abstract PanelModificacionHabitaciones getPanelModificacionHabitaciones();

	public abstract PanelConsultaHabitaciones getPanelConsultaHabitaciones();

	public abstract PanelConsultaMultiplesHabitaciones getPanelConsultaMultiplesHabitaciones();
}