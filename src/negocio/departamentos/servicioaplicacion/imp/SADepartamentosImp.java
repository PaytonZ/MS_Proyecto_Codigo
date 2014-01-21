/**
 * 
 */
package negocio.departamentos.servicioaplicacion.imp;

import integracion.factorias.factoriaDAO.FactoriaDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.departamentos.objetonegocio.Departamento;
import negocio.departamentos.servicioaplicacion.SADepartamentos;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SADepartamentosImp implements SADepartamentos {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public SADepartamentosImp() {
		entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
	}
	
	/**
	 * (sin Javadoc)
	 * 
	 * @see SADepartamentos#anadirDepartamento(Departamento
	 *      departamentoNuevo)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void anadirDepartamento(Departamento departamentoNuevo) {
		
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(departamentoNuevo);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SADepartamentos#borrarDepartamento(Object idDepartamento)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object borrarDepartamento(Object idDepartamento) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SADepartamentos#actualizarDepartamento(Departamento
	 *      departamento)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void actualizarDepartamento(Departamento departamento) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SADepartamentos#obternerDepartamento(Object idDepartamento)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Departamento obternerDepartamento(Object idDepartamento) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SADepartamentos#obtenerTodoslosDepartamentos()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void obtenerTodoslosDepartamentos() {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente

		// end-user-code
	}
}