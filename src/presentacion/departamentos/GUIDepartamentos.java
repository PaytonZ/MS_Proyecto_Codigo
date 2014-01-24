/**
 * 
 */
package presentacion.departamentos;

import presentacion.comandos.IDEventos;
import presentacion.departamentos.imp.GUIDepartamentosImp;
import presentacion.departamentos.paneles.PanelAltaDepartamentos;
import presentacion.departamentos.paneles.PanelBajaDepartamentos;
import presentacion.departamentos.paneles.PanelConsultaDepartamento;
import presentacion.departamentos.paneles.PanelConsultaMultiplesDepartamentos;
import presentacion.departamentos.paneles.PanelModificacionDepartamentos;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public abstract class GUIDepartamentos {
	
	private static GUIDepartamentos selfInstance;

	public static GUIDepartamentos getInstance() {

		crearGUIDepartamentos();
		
		return selfInstance;
	}
	
	private static synchronized void crearGUIDepartamentos() {
		
		if ( selfInstance == null ) {
			
			selfInstance = new GUIDepartamentosImp();
		}
	}

	public abstract void update(IDEventos evento_actual, Object datos);

	public abstract PanelAltaDepartamentos getPanelAltaDepartamentos();

	public abstract PanelBajaDepartamentos getPanelBajaDepartamentos();

	public abstract PanelConsultaDepartamento getPanelConsultaDepartamentos();

	public abstract PanelConsultaMultiplesDepartamentos getPanelConsultaMultiplesDepartamentos();

	public abstract PanelModificacionDepartamentos getPanelModificacionDepartamentos();
}