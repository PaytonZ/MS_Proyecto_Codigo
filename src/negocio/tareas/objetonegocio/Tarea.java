/**
 * 
 */
package negocio.tareas.objetonegocio;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import negocio.empleados.objetonegocio.Empleado;

import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "tareas")
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
public class Tarea {
    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @GeneratedValue
    @Id
    private Integer ID;

    /**
     * @return el ID
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getId() {
	// begin-user-code
	return ID;
	// end-user-code
    }

    /**
     * @param ID
     *            el ID a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setId(Integer ID) {
	// begin-user-code
	this.ID = ID;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String nombre;

    /**
     * @return el nombre
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getNombre() {
	// begin-user-code
	return nombre;
	// end-user-code
    }

    /**
     * @param nombre
     *            el nombre a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setNombre(String nombre) {
	// begin-user-code
	this.nombre = nombre;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String descripcion;

    /**
     * @return el descripcion
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getDescripcion() {
	// begin-user-code
	return descripcion;
	// end-user-code
    }

    /**
     * @param descripcion
     *            el descripcion a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDescripcion(String descripcion) {
	// begin-user-code
	this.descripcion = descripcion;
	// end-user-code
    }

    @Override
    public String toString() {

	return nombre + ", " + descripcion;
    }

    @ManyToMany(mappedBy = "tarea")
	private Set<Empleado> listaEmpleados;

    public boolean equals(Tarea t) {
	return ID == t.getId();
    }
}