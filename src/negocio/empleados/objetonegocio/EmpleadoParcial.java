/**
 * 
 */
package negocio.empleados.objetonegocio;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.NamedQuery;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Daniel
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQuery(name = "negocio.empleados.objetonegocio.EmpleadoParcial.findByid", query = "select obj from EmpleadoParcial obj where obj.id = :id")
public class EmpleadoParcial extends Empleado implements Serializable {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public EmpleadoParcial() {
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private Object id;
	
	private int horas;
	
	public int getHoras() {
	    return horas;
	}
	
	public void setHoras(int horas) {
	    this.horas = horas;
	}
	 
	@Override
	public String toString() {
	    return getDNI() + " " + getNombre() + " " + getPrimerApellido() + " " + getSegundoApellido() + " " + getTipo() + " " + horas;
	}
}