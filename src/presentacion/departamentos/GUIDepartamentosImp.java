/**
 * 
 */
package presentacion.departamentos;

import presentacion.departamentos.paneles.PanelAltaDepartamentos;
import presentacion.departamentos.paneles.PanelBajaDepartamentos;
import presentacion.departamentos.paneles.PanelConsultaDepartamento;
import presentacion.departamentos.paneles.PanelConsultaMultiplesDepartamentos;
import presentacion.departamentos.paneles.PanelModificacionDepartamentos;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIDepartamentosImp extends GUIDepartamentos {
	
	private PanelModificacionDepartamentos frameModificacionDepartamentos;
	private PanelConsultaMultiplesDepartamentos frameConsultaMultiplesDepartamentos;
	private PanelConsultaDepartamento frameConsultaDepartamentos;
	private PanelBajaDepartamentos frameBajaDepartamentos;
	private PanelAltaDepartamentos frameAltaDepartamentos;

	public PanelModificacionDepartamentos getPanelModificacionDepartamentos() {
		
		return frameModificacionDepartamentos;
	}

	public PanelConsultaMultiplesDepartamentos getPanelConsultaMultiplesDepartamentos() {
		
		return frameConsultaMultiplesDepartamentos;
	}

	public PanelConsultaDepartamento getPanelConsultaDepartamentos() {

		return frameConsultaDepartamentos;
	}
	
	public PanelBajaDepartamentos getPanelBajaDepartamentos() {
	
		return frameBajaDepartamentos;
	}

	public PanelAltaDepartamentos getPanelAltaDepartamentos() {
	
		return frameAltaDepartamentos;
	}

	public void update() {
		
	}
}