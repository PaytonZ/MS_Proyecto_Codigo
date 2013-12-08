/**
 * 
 */
package negocio.habitaciones.transfer;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferHabitacionNormal extends TransferHabitacion{
	
	private TipoHabitacion tipohabitacion = TipoHabitacion.HABITACION_NORMAL;

	/**
	 * @return the tipohabitacion
	 */
	public TipoHabitacion getTipohabitacion() {
		return tipohabitacion;
	}

	/**
	 * @param tipohabitacion the tipohabitacion to set
	 */
	public void setTipohabitacion(TipoHabitacion tipohabitacion) {
		this.tipohabitacion = tipohabitacion;
	}
	
}