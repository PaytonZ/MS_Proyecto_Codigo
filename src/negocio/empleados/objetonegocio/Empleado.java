/**
 * 
 */
package negocio.empleados.objetonegocio;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.tareas.objetonegocio.Tarea;

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
@Table(name = "empleados", uniqueConstraints = { @UniqueConstraint(columnNames = "DNI") })
@OptimisticLocking(type = OptimisticLockingType.CHANGED_COLUMNS)
@NamedQueries({
    
@NamedQuery(name = "Empleado.BuscarDNI", query = "Select e FROM Empleado e WHERE e.DNI = :arg"),
@NamedQuery(name = "negocio.empleados.objetonegocio.Empleado.findBytarea", query = "select obj from Empleado obj where obj.tarea = :tarea") 

})

public class Empleado implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -361764100211108078L;
    /**
     * 
     */

    public static final String QUERY_BUSCAR_EMPLEADOS_POR_DNI = "Empleado.BuscarDNI";

    public Empleado() {
	DNI = "";
	nombre = "";
	primerApellido = "";
	segundoApellido = "";
	activo = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {

	return id;
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String DNI;

    /**
     * @return el DNI
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getDNI() {
	// begin-user-code
	return DNI;
	// end-user-code
    }

    /**
     * @param DNI
     *            el DNI a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDNI(String DNI) {
	// begin-user-code
	this.DNI = DNI;
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
    private String primerApellido;

    /**
     * @return el primerApellido
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getPrimerApellido() {
	// begin-user-code
	return primerApellido;
	// end-user-code
    }

    /**
     * @param primerApellido
     *            el primerApellido a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setPrimerApellido(String primerApellido) {
	// begin-user-code
	this.primerApellido = primerApellido;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private String segundoApellido;

    /**
     * @return el segundoApellido
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public String getSegundoApellido() {
	// begin-user-code
	return segundoApellido;
	// end-user-code
    }

    /**
     * @param segundoApellido
     *            el segundoApellido a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setSegundoApellido(String segundoApellido) {
	// begin-user-code
	this.segundoApellido = segundoApellido;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    private TipoEmpleado tipo;

    /**
     * @return el tipo
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public TipoEmpleado getTipo() {
	// begin-user-code
	return tipo;
	// end-user-code
    }

    /**
     * @param tipo
     *            el tipo a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setTipo(TipoEmpleado tipo) {
	// begin-user-code
	this.tipo = tipo;
	// end-user-code
    }

    /**
     * <!-- begin-UML-doc --> <!-- end-UML-doc -->
     * 
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    /**
     * @return el idDepartamento
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento getDepartamento() {
	// begin-user-code
	return departamento;
	// end-user-code
    }

    /**
     * @param idDepartamento
     *            el idDepartamento a establecer
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public void setDepartamento(Departamento departamento) {
	// begin-user-code
	this.departamento = departamento;
	// end-user-code
    }

    @ManyToMany
    private Set<Tarea> tarea;

    public enum TipoEmpleado {
	COMPLETO, HORAS
    };

    private boolean activo;

    public boolean isActivo() {
	return activo;
    }

    public void setActivo(boolean activo) {
	this.activo = activo;
    }

}