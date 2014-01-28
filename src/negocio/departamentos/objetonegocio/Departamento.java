/**
 * 
 */
package negocio.departamentos.objetonegocio;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import negocio.empleados.objetonegocio.Empleado;

import org.eclipse.persistence.annotations.OptimisticLocking;
import org.eclipse.persistence.annotations.OptimisticLockingType;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Entity
@Table(name = "departamentos", uniqueConstraints = { @UniqueConstraint(columnNames = "nombre") })
@NamedQueries({
	@NamedQuery(name = "negocio.departamentos.objetonegocio.Departamento.findByid", query = "select obj from Departamento obj where obj.id = :id and obj.activo = true"),
	@NamedQuery(name = "Departamento.findAll", query = "select obj from Departamento obj where obj.activo = true"),
	@NamedQuery(name = "negocio.departamentos.objetonegocio.Departamento.findBynombre", query = "select obj from Departamento obj where obj.nombre = :nombre and obj.activo = true"),
	@NamedQuery(name = "negocio.departamentos.objetonegocio.Departamento.findBynombreAlta", query = "select obj from Departamento obj where obj.nombre = :nombre"), })
public class Departamento {

    public static final String QUERY_BUSCAR_DEPARTAMENTO_POR_NOMBRE_ALTA = "negocio.departamentos.objetonegocio.Departamento.findBynombreAlta";

    public Departamento() {
	activo = true;
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * @return el ID
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Integer getID() {
	// begin-user-code
	return id;
	// end-user-code
    }

    /**
     * @param ID
     *            el ID a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setID(Integer ID) {
	// begin-user-code
	this.id = ID;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @uml.annotations for <code>empleado</code>
     *                  collection_type=
     *                  "negocio.empleados.objetonegocio.Empleado"
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    @OneToMany(mappedBy = "departamento")
    private Set<Empleado> empleado;

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
     */
    private boolean activo;

    public boolean getActivo() {
	return activo;
    }

    public void setActivo(boolean activo) {
	this.activo = activo;
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

    @Override
    public boolean equals(Object o) {

	Departamento dep = new Departamento();

	if (o != null && o instanceof Departamento) {

	    dep = (Departamento) o;
	}

	return nombre.equals(dep.getNombre());
    }

    public String toString() {
	return nombre;
    }

    @Version
    private int version;
}