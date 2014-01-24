/**
 * 
 */
package presentacion.empleados.imp;

import presentacion.comandos.IDEventos;
import presentacion.empleados.GUIEmpleados;
import presentacion.empleados.paneles.PanelAltaEmpleados;
import presentacion.empleados.paneles.PanelAltaTareaEmpleados;
import presentacion.empleados.paneles.PanelBajaEmpleados;
import presentacion.empleados.paneles.PanelBajaTareaEmpleados;
import presentacion.empleados.paneles.PanelConsultaEmpleados;
import presentacion.empleados.paneles.PanelConsultaMultipleEmpleados;
import presentacion.empleados.paneles.PanelModificacionEmpleados;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIEmpleadosImp extends GUIEmpleados {

	private PanelBajaTareaEmpleados panelBajaTareaEmpleados;
	private PanelAltaTareaEmpleados panelAltaTareaEmpleados;
	private PanelBajaEmpleados panelBajaEmpleados;
	private PanelConsultaMultipleEmpleados panelConsultaMultipleEmpleados;
	private PanelModificacionEmpleados panelModificacionEmpleados;
	private PanelConsultaEmpleados panelConsultaEmpleados;
	private PanelAltaEmpleados panelAltaEmpleados;
	
	@Override
	public void update(IDEventos evento_actual, Object datos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PanelAltaEmpleados getPanelAltaEmpleados() {

		if ( panelAltaEmpleados == null ) {
			panelAltaEmpleados = new PanelAltaEmpleados();
		}
		
		return panelAltaEmpleados;
	}
	@Override
	public PanelConsultaEmpleados getPanelConsultaEmpleados() {
		
		if ( panelConsultaEmpleados == null) {
			panelConsultaEmpleados = new PanelConsultaEmpleados();
		}
		
		return panelConsultaEmpleados;
	}
	@Override
	public PanelConsultaMultipleEmpleados getPanelConsultaMultipleEmpleados() {

		if ( panelConsultaMultipleEmpleados == null) {
			panelConsultaMultipleEmpleados = new PanelConsultaMultipleEmpleados();
		}
		
		return panelConsultaMultipleEmpleados;
	}
	@Override
	public PanelModificacionEmpleados getPanelModificacionEmpleados() {
		
		if ( panelModificacionEmpleados == null) {
			panelModificacionEmpleados = new PanelModificacionEmpleados();
		}
		
		return panelModificacionEmpleados;
	}
	@Override
	public PanelBajaEmpleados getPanelBajaEmpleados() {
		
		if ( panelBajaEmpleados == null) {
			panelBajaEmpleados = new PanelBajaEmpleados();
		}
		
		return panelBajaEmpleados;
	}
	@Override
	public PanelAltaTareaEmpleados getPanelAltaTareaEmpleados() {
		
		if ( panelAltaTareaEmpleados == null) {
			panelAltaTareaEmpleados = new PanelAltaTareaEmpleados();
		}
		
		return panelAltaTareaEmpleados;
	}
	@Override
	public PanelBajaTareaEmpleados getPanelBajaTareaEmpleados() {

		if (panelBajaTareaEmpleados == null) {
			panelBajaTareaEmpleados = new PanelBajaTareaEmpleados();
		}
		
		return panelBajaTareaEmpleados;
	}
}