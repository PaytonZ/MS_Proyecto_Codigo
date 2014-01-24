/**
 * 
 */
package presentacion.departamentos.imp;

import presentacion.comandos.IDEventos;
import presentacion.departamentos.GUIDepartamentos;
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
public class GUIDepartamentosImp extends GUIDepartamentos {
	
	private PanelModificacionDepartamentos panelModificacionDepartamentos;
	private PanelConsultaMultiplesDepartamentos panelConsultaMultiplesDepartamentos;
	private PanelConsultaDepartamento panelConsultaDepartamentos;
	private PanelBajaDepartamentos panelBajaDepartamentos;
	private PanelAltaDepartamentos panleAltaDepartamentos;

	public PanelModificacionDepartamentos getPanelModificacionDepartamentos() {
		
		if ( panelModificacionDepartamentos == null) {
			panelModificacionDepartamentos = new PanelModificacionDepartamentos();
		}
		
		return panelModificacionDepartamentos;
	}

	public PanelConsultaMultiplesDepartamentos getPanelConsultaMultiplesDepartamentos() {
		
		if (panelConsultaMultiplesDepartamentos == null) {
			panelConsultaMultiplesDepartamentos = new PanelConsultaMultiplesDepartamentos();
		}
		
		return panelConsultaMultiplesDepartamentos;
	}

	public PanelConsultaDepartamento getPanelConsultaDepartamentos() {

		if (panelConsultaDepartamentos == null) {
			panelConsultaDepartamentos = new PanelConsultaDepartamento();
		}
		
		return panelConsultaDepartamentos;
	}
	
	public PanelBajaDepartamentos getPanelBajaDepartamentos() {
	
		if ( panelBajaDepartamentos == null) {
			panelBajaDepartamentos = new PanelBajaDepartamentos();
		}
		
		return panelBajaDepartamentos;
	}

	public PanelAltaDepartamentos getPanelAltaDepartamentos() {
	
		if ( panleAltaDepartamentos == null) {
			panleAltaDepartamentos = new PanelAltaDepartamentos();
		}
		
		return panleAltaDepartamentos;
	}

	public void update(IDEventos eventoActual, Object datos) {
		
		/*switch (eventoActual) {
		case value:
			
			break;

		default:
			break;
		}*/
	}
}