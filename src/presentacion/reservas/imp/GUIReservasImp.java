/**
 * 
 */
package presentacion.reservas.imp;

import presentacion.comandos.IDEventos;
import presentacion.reservas.GUIReservas;
import presentacion.reservas.paneles.PanelAltaReservas;
import presentacion.reservas.paneles.PanelBajaReservas;
import presentacion.reservas.paneles.PanelConsultaMultipleReservas;
import presentacion.reservas.paneles.PanelConsultaReservas;
import presentacion.reservas.paneles.PanelModificacionReservas;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIReservasImp extends GUIReservas {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private PanelAltaReservas panelAlta;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private PanelBajaReservas panelBaja;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private PanelModificacionReservas panelModificacion;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private PanelConsultaReservas panelConsulta;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private PanelConsultaMultipleReservas panelConsultaMultiple;// end-user-code

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#update(Integer idEvento, Object datos)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void update(IDEventos idEvento, Object datos) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#getPanelConsultaMultipleReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public PanelConsultaMultipleReservas getPanelConsultaMultipleReservas() {

		if ( panelConsultaMultiple == null ) {
			panelConsultaMultiple = new PanelConsultaMultipleReservas();
		}
		
		return panelConsultaMultiple;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#getPanelAltaReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public PanelAltaReservas getPanelAltaReservas() {

		if ( panelAlta == null ) {
			panelAlta = new PanelAltaReservas();
		}
		
		return panelAlta;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#getPanelBajaReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public PanelBajaReservas getPanelBajaReservas() {

		if( panelBaja == null ) {
			panelBaja = new PanelBajaReservas();
		}
		
		return panelBaja;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#getPanelConsultaReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public PanelConsultaReservas getPanelConsultaReservas() {

		if ( panelConsulta == null ) {
			panelConsulta = new PanelConsultaReservas();
		}
		
		return panelConsulta;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see GUIReservas#getFrameModificacionReservas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public PanelModificacionReservas getPanelModificacionReservas() {

		if ( panelModificacion == null ) {
			panelModificacion = new PanelModificacionReservas();
		}
		
		return panelModificacion;
	}
}