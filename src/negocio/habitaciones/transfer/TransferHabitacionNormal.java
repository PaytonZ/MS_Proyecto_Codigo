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
//	public TransferHabitacionNormal(){
//		tipohabitacion = TipoHabitacion.HABITACION_NORMAL;
//	}
	public String toString() {
		
		return getNumHabitacion() + " " + TipoHabitacion.HABITACION_NORMAL + " " + getPrecio() + "€";
	}
}