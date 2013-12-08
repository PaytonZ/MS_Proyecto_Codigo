/**
 * 
 */
package presentacion.clientes.imp;

import presentacion.clientes.GUICliente;
<<<<<<< HEAD
import presentacion.clientes.frames.FrameAltaClientes;
import presentacion.clientes.frames.FrameBajaClientes;
import presentacion.clientes.frames.FrameConsultaClientes;
import presentacion.clientes.frames.FrameConsultaMultipleClientes;
import presentacion.clientes.frames.FrameModificacionClientes;
import presentacion.comandos.IDEventos;
=======
import presentacion.clientes.frames.PanelAltaClientes;
import presentacion.clientes.frames.PanelBajaClientes;
import presentacion.clientes.frames.PanelConsultaClientes;
import presentacion.clientes.frames.PanelConsultaMultipleClientes;
import presentacion.clientes.frames.PanelModificacionClientes;
>>>>>>> 6c3980978979fd72b7bf87d37428bbcac7dae021

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIClienteImp extends GUICliente {
	
	private PanelAltaClientes panelAlta;
	private PanelBajaClientes panelBaja;
	private PanelModificacionClientes panelModificacion;
	private PanelConsultaClientes panelConsulta;
	private PanelConsultaMultipleClientes panelConsultaMoltiple;

	public void update(Integer idEvento, Object datos) {
		
	}

	public PanelAltaClientes getPanelAlta() {
		
		if ( panelAlta == null)
			panelAlta = new PanelAltaClientes();
		
		return panelAlta;
	}

	public PanelBajaClientes getPanelBaja() {
		
		return panelBaja;
	}
	
	public PanelModificacionClientes getPanelModificacion() {
		
		return panelModificacion;
	}

	public PanelConsultaClientes getPanelConsulta() {
	
		return panelConsulta;
	}

<<<<<<< HEAD
	/**
	 * @param frameConsultaM
	 *            �ltiple el frameConsultaM�ltiple a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setFrameConsultaMoltiple(
			FrameConsultaMultipleClientes frameConsultaMoltiple) {
		// begin-user-code
		this.frameConsultaMoltiple = frameConsultaMoltiple;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUICliente#getFrameConsultaMultipleClientes()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public FrameConsultaMultipleClientes getFrameConsultaMultipleClientes() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
=======
	public PanelConsultaMultipleClientes getPanelConsultaMoltiple() {
		 
		return panelConsultaMoltiple;
	}

	public PanelConsultaMultipleClientes getPanelConsultaMultipleClientes() {
		
		return panelConsultaMoltiple;
>>>>>>> 6c3980978979fd72b7bf87d37428bbcac7dae021
	}

	public PanelAltaClientes getPanelAltaClientes() {
		
		return new PanelAltaClientes();
	}

	public PanelBajaClientes getPanelBajaClientes() {
	
		return panelBaja;
	}

	public PanelConsultaClientes getPanelConsultaClientes() {
	
		return panelConsulta;
	}

	public PanelModificacionClientes getPanelModificacionClientes() {
	
		return panelModificacion;
	}

	public void update(IDEventos evento_actual, Object datos) {
		switch (evento_actual) {
		case EVENTO_ALTA_CLIENTE:
			frameAlta.actualizarVentana(datos);
			break;
		case EVENTO_BAJA_CLIENTE:
			frameBaja.actualizarVentana(datos);
			break;
		case EVENTO_ACTUALIZAR_CLIENTE:
			frameModificacion.actualizarVentana(datos);
			break;
		case EVENTO_OBTENER_CLIENTE:
			frameConsulta.actualizarVentana(datos);
			break;
		case EVENTO_OBTENER_TODOS_CLIENTE:
			frameConsultaMoltiple.actualizarVentana(datos);
			break;

		default:
			break;

		}

	}
}