/**
 * 
 */
package presentacion.empleados.imp;

import presentacion.comandos.IDEventos;
import presentacion.empleados.GUIEmpleados;
import presentacion.empleados.paneles.PanelAltaEmpleados;
import presentacion.empleados.paneles.PanelAsignarTareaEmpleados;
import presentacion.empleados.paneles.PanelBajaEmpleados;
import presentacion.empleados.paneles.PanelConsultaEmpleados;
import presentacion.empleados.paneles.PanelConsultaEmpleadosPorTarea;
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

	private PanelAsignarTareaEmpleados panelAltaTareaEmpleados;
	private PanelBajaEmpleados panelBajaEmpleados;
	private PanelConsultaMultipleEmpleados panelConsultaMultipleEmpleados;
	private PanelModificacionEmpleados panelModificacionEmpleados;
	private PanelConsultaEmpleados panelConsultaEmpleados;
	private PanelAltaEmpleados panelAltaEmpleados;
	private PanelConsultaEmpleadosPorTarea panelConsultaEmpleadosPorTarea;
	
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
	public PanelAsignarTareaEmpleados getPanelAsignarTareaEmpleados() {
		
		if ( panelAltaTareaEmpleados == null) {
			panelAltaTareaEmpleados = new PanelAsignarTareaEmpleados();
		}
		
		return panelAltaTareaEmpleados;
	}
	
	@Override
	public PanelConsultaEmpleadosPorTarea getPanelConsutlaEmpleadosPorTarea() {
	    
	    if ( panelConsultaEmpleadosPorTarea == null) {
		panelConsultaEmpleadosPorTarea = new PanelConsultaEmpleadosPorTarea();
	    }
	    
	    return panelConsultaEmpleadosPorTarea;
	}
	
	@Override
	public void update(IDEventos eventoActual, Object datos) {

	    switch (eventoActual) {
        	case EVENTO_ALTA_EMPLEADO:
        	case ERROR_ALTA_EMPLEADO:
        	case EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO:
        	    getPanelAltaEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_BAJA_EMPLEADO:
        	case ERROR_BAJA_EMPLEADO:
        	case EVENTO_CONSULTAR_EMPLEADOS_V_BORRAR:
        	case ERROR_CONSULTAR_EMPLEADOS_V_BORRAR:
        	    getPanelBajaEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_MODIFICAR_EMPLEADO:
        	case ERROR_MODIFICAR_EMPLEADO:
        	case EVENTO_CONSULTAR_EMPLEADOS_V_MODIFICAR:
        	case ERROR_CONSULTAR_EMPLEADOS_V_MODIFICAR:
        	case ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_ALTA_EMPLEADO:
        	case EVENTO_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO:
        	case ERROR_CONSULTAR_TODOS_DEPARTAMENTOS_V_MODIFICAR_EMPLEADO:
        	    getPanelModificacionEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_CONSULTAR_EMPLEADO:
        	case ERROR_CONSULTAR_EMPLEADO:
        	    getPanelConsultaEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_ASIGNARTAREA_EMPLEADO:
        	case ERROR_ASIGNARTAREA_EMPLEADO:
        	case EVENTO_CONSULTAR_TAREAS_V_ASIGARTAREA:
        	case ERROR_CONSULTAR_TAREAS_V_ASIGARTAREA:
        	case EVENTO_CONSULTAR_EMPLEADO_V_ASIGARTAREA:
        	case ERROR_CONSULTAR_EMPLEADO_V_ASIGARTAREA:
        	    getPanelAsignarTareaEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_CONSULTAR_TODOS_EMPLEADOS:
        	case ERROR_CONSULTAR_TODOS_EMPLEADOS:
        	    getPanelConsultaMultipleEmpleados().actualizarVentana(eventoActual, datos);
        	    break;
        	case EVENTO_CONSULTAR_TAREA_V_CONSULTAR_EMPLEADOS_POR_TAREA:
        	case ERROR_CONSULTAR_TAREA_V_CONSULTAR_EMPLEADOS_POR_TAREA:
        	case EVENTO_CONSULTAR_EMPLEADO_POR_TAREA:
        	case ERROR_CONSULTAR_EMPLEADO_POR_TAREA:
        	    getPanelConsutlaEmpleadosPorTarea().actualizarVentana(eventoActual, datos);
        	    break;
    	    default:
    		break;
	    
	    }
	}
}