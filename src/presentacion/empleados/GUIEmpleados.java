/**
 * 
 */
package presentacion.empleados;

import presentacion.comandos.IDEventos;
import presentacion.empleados.imp.GUIEmpleadosImp;
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
public abstract class GUIEmpleados {

	private static GUIEmpleados selfInstance;
	
	public static GUIEmpleados getInstance() {

		crearGUIEmpleados();
		
		return selfInstance;
	}
	
	private static synchronized void crearGUIEmpleados() {
		
		if ( selfInstance == null ) {
			selfInstance = new GUIEmpleadosImp();
		}
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract void update(IDEventos evento_actual, Object datos);

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelAltaEmpleados getPanelAltaEmpleados();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelConsultaEmpleados getPanelConsultaEmpleados();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelConsultaMultipleEmpleados getPanelConsultaMultipleEmpleados();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelModificacionEmpleados getPanelModificacionEmpleados();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelBajaEmpleados getPanelBajaEmpleados();

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract PanelAsignarTareaEmpleados getPanelAsignarTareaEmpleados();
	
	public abstract PanelConsultaEmpleadosPorTarea getPanelConsutlaEmpleadosPorTarea();
}