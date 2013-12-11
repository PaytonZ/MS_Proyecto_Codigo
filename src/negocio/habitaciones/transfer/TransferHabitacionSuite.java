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
public class TransferHabitacionSuite extends TransferHabitacion{
//	public TransferHabitacionSuite(){
//		tipohabitacion = TipoHabitacion.HABITACION_SUITE;
//	}
	
	public String toString() {
		
		return getNumHabitacion() + " " + TipoHabitacion.HABITACION_SUITE + " " + getPrecio() + "€";
	}
}