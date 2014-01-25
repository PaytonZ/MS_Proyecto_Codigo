/**
 * 
 */
package negocio.departamentos.servicioaplicacion;

import java.util.List;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public interface SADepartamentos {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param departamentoNuevo
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Departamento anadirDepartamento(Departamento departamentoNuevo) throws BSoDException;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param datos
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarDepartamento(Departamento datos) throws BSoDException;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param departamento
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Departamento actualizarDepartamento(String nombreAnterior, Departamento departamento) throws BSoDException;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param idDepartamento
	 * @return
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Departamento obternerDepartamento(String nombreDepartamento) throws BSoDException;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Departamento> obtenerTodoslosDepartamentos() throws BSoDException;
}