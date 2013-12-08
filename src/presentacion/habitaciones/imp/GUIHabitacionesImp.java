/**
 * 
 */
package presentacion.habitaciones.imp;

import presentacion.comandos.IDEventos;
import presentacion.habitaciones.GUIHabitaciones;
import presentacion.habitaciones.paneles.PanelAltaHabitaciones;
import presentacion.habitaciones.paneles.PanelBajaHabitaciones;
import presentacion.habitaciones.paneles.PanelConsultaHabitaciones;
import presentacion.habitaciones.paneles.PanelConsultaMultiplesHabitaciones;
import presentacion.habitaciones.paneles.PanelModificacionHabitaciones;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIHabitacionesImp extends GUIHabitaciones {

	private PanelAltaHabitaciones panelAlta;
	private PanelBajaHabitaciones panelBaja;
	private PanelModificacionHabitaciones panelModificacion;
	private PanelConsultaHabitaciones panelConsulta;
	private PanelConsultaMultiplesHabitaciones panelConsultaMultiple;
	
	@Override
	public void update(IDEventos idEvento, Object datos) {

			
	}
	
	@Override
	public PanelAltaHabitaciones getPanelAltaHabitaciones() {

		if ( panelAlta == null ) {
			panelAlta = new PanelAltaHabitaciones();
		}
		
		return panelAlta;
	}
	
	@Override
	public PanelBajaHabitaciones getPanelBajaHabitaciones() {

		if ( panelBaja == null ) {
			panelBaja = new PanelBajaHabitaciones();
		}
		
		return panelBaja;
	}
	
	@Override
	public PanelModificacionHabitaciones getPanelModificacionHabitaciones() {

		if ( panelModificacion == null ) {
			panelModificacion = new PanelModificacionHabitaciones();
		}
		
		return panelModificacion;
	}
	
	@Override
	public PanelConsultaHabitaciones getPanelConsultaHabitaciones() {

		if ( panelConsulta == null ) {
			panelConsulta = new PanelConsultaHabitaciones();
		}
		
		return panelConsulta;
	}
	
	@Override
	public PanelConsultaMultiplesHabitaciones getPanelConsultaMultiplesHabitaciones() {

		if ( panelConsultaMultiple == null ) {
			panelConsultaMultiple = new PanelConsultaMultiplesHabitaciones();
		}
		
		return panelConsultaMultiple;
	}
}