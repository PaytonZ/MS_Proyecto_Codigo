package negocio.habitaciones.transfer;

/**
* <!-- begin-UML-doc --> <!-- end-UML-doc -->
* 
* @author NASAIII
* @generated 
*            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TransferHabitacion {
	
	private TipoHabitacion tipohabitacion = TipoHabitacion.HABITACION_SUITE;
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Integer num_habitacion;

	/**
	 * @return el num_habitacion
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Integer getNumHabitacion() {
		// begin-user-code
		return num_habitacion;
		// end-user-code
	}

	/**
	 * @param num_habitacion
	 *            el num_habitacion a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setNumHabitacion(Integer ID) {
		// begin-user-code
		this.num_habitacion = ID;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private double precio;

	/**
	 * @return el precio
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public double getPrecio() {
		// begin-user-code
		return precio;
		// end-user-code
	}

	/**
	 * @param precio
	 *            el precio a establecer
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void setPrecio(double precio) {
		// begin-user-code
		this.precio = precio;
		// end-user-code
	}

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
	
	@Override
	public String toString() {
		
		return getNumHabitacion() + " " + getTipohabitacion() + " " + getPrecio() + "€";
	}
}