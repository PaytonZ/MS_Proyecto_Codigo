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
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIEmpleadosImp extends GUIEmpleados {

	private PanelBajaTareaEmpleados frameBajaTareaEmpleados;
	private PanelAltaTareaEmpleados frameAltaTareaEmpleados;
	private PanelBajaEmpleados frameBajaEmpleados;
	private PanelConsultaMultipleEmpleados frameConsultaMultipleEmpleados;
	private PanelModificacionEmpleados frameModificacionEmpleados;
	private PanelConsultaEmpleados frameConsultaEmpleados;
	private PanelAltaEmpleados frameAltaEmpleados;
	
	@Override
	public void update(IDEventos evento_actual, Object datos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public PanelAltaEmpleados getPanelAltaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelConsultaEmpleados getPanelConsultaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelConsultaMultipleEmpleados getPanelConsultaMultipleEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelModificacionEmpleados getPanelModificacionEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelBajaEmpleados getPanelBajaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelAltaTareaEmpleados getPanelAltaTareaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PanelBajaTareaEmpleados getPanelBajaTareaEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
}