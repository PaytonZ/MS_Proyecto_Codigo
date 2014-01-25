/**
 * 
 */
package negocio.departamentos.servicioaplicacion.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import presentacion.principal.HotelManager;
import negocio.departamentos.objetonegocio.Departamento;
import negocio.departamentos.servicioaplicacion.SADepartamentos;
import negocio.excepciones.BSoDException;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SADepartamentosImp implements SADepartamentos {

    public SADepartamentosImp() {
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#anadirDepartamento(Departamento departamentoNuevo)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento anadirDepartamento(Departamento departamentoNuevo)
	    throws BSoDException {
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);

	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	entityManager.getTransaction().begin();

	entityManager.persist(departamentoNuevo);

	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();

	return departamentoNuevo;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#borrarDepartamento(Object idDepartamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean borrarDepartamento(Departamento datos) throws BSoDException {
	// begin-user-code
	// TODO Ap�ndice de m�todo generado autom�ticamente
	return null;
	// end-user-code
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#actualizarDepartamento(Departamento departamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento actualizarDepartamento(Departamento departamento)
	    throws BSoDException {
	// begin-user-code
	// TODO Ap�ndice de m�todo generado autom�ticamente

	// end-user-code

	return departamento;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SADepartamentos#obternerDepartamento(Object idDepartamento)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Departamento obternerDepartamento(String nombreDepartamento)
	    throws BSoDException {
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
    public List<Departamento> obtenerTodoslosDepartamentos()
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);

	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	entityManager.getTransaction().begin();

	List<Departamento> departamentos = entityManager.createNamedQuery(
		"Departamento.findAll", Departamento.class).getResultList();

	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();

	return departamentos;
    }

}