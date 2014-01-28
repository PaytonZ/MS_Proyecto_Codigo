/**
 * 
 */
package negocio.empleados.objetonegocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Daniel
 * @generated 
 *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
@Entity
@NamedQuery(name = "negocio.empleados.objetonegocio.EmpleadoParcial.findByid", query = "select obj from EmpleadoParcial obj where obj.id = :id")
public class EmpleadoParcial extends Empleado implements Serializable {
    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    private static final long serialVersionUID = 0;

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    public EmpleadoParcial() {
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    @Id
    private int id;

    private int horas;

    public int getHoras() {
	return horas;
    }

    public void setHoras(int horas) {
	this.horas = horas;
    }

    @Version
    private int version;

    @Override
    public String toString() {
	return getDNI() + " " + getNombre() + " " + getPrimerApellido() + " "
		+ getSegundoApellido() + " " + getTipo() + " " + horas;
    }

    @Override
    public boolean equals(Object o) {

	boolean iguales = false;

	if (o instanceof EmpleadoParcial ) {

	    iguales = this.getDNI().equals(((EmpleadoParcial) o).getDNI());
	}

	return iguales;
    }
}