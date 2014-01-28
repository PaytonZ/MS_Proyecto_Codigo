/**
 * 
 */
package negocio.empleados.objetonegocio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
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
@NamedQueries({
	@NamedQuery(name = "negocio.empleados.objetonegocio.EmpleadoTotal.findByid", query = "select obj from EmpleadoTotal obj where obj.id = :id"),
	@NamedQuery(name = "negocio.empleados.objetonegocio.EmpleadoTotal.findByplazaAparcamiento", query = "select obj from EmpleadoTotal obj where obj.plazaAparcamiento = :plazaAparcamiento"),
})
public class EmpleadoTotal extends Empleado implements Serializable {
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
    public EmpleadoTotal() {
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    @Id
    private int id;

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    private TipoPlazaParking plazaAparcamiento;

    public TipoPlazaParking getPlazaAparcamiento() {
	return plazaAparcamiento;
    }

    public void setPlazaAparcamiento(TipoPlazaParking plaza) {
	this.plazaAparcamiento = plaza;
    }

    @Version
    private int version;

    public enum TipoPlazaParking {
	DOBLE, SIMPLE
    };

    @Override
    public String toString() {
	return getDNI() + " " + getNombre() + " " + getPrimerApellido() + " "
		+ getSegundoApellido() + " " + getTipo() + " "
		+ plazaAparcamiento;
    }

    @Override
    public boolean equals(Object o) {

	boolean iguales = false;

	if (o instanceof EmpleadoTotal) {

	    iguales = this.getDNI().equals(((EmpleadoTotal) o).getDNI());
	}

	return iguales;
    }
}