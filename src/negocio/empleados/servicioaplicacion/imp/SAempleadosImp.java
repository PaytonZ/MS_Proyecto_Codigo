/**
 * 
 */
package negocio.empleados.servicioaplicacion.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;
import presentacion.principal.HotelManager;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAempleadosImp implements SAEmpleados {

    public Empleado anadirEmpleado(Empleado empleadoNuevo) throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	Empleado resultado = null;
	TypedQuery<Empleado> query = null;

	/*
	 * Se busca en la BD el empleado , si ya existia se le activa.
	 */
	empleadoNuevo.setActivo(true);
	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", empleadoNuevo.getDNI());
	    resultado = query.getSingleResult();

	    empleadoNuevo.setId(resultado.getId());

	} catch (NoResultException ex) {// No se encontro el empleado.
	    entityManager.persist(empleadoNuevo);

	    entityManager.getTransaction().commit();

	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", empleadoNuevo.getDNI());
	    resultado = query.getSingleResult();

	    empleadoNuevo.setId(resultado.getId());
	    entityManager.close();

	} finally // Se realizará en ambos casos
	{
	    entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();
	    entityManager.merge(empleadoNuevo);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}
	return empleadoNuevo;

    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#borrarEmpleado(String dniEmpleado)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean borrarEmpleado(String dniEmpleado) throws BSoDException {

	Boolean borradoCorrecto = true;
	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Empleado> query = null;
	Empleado resultado = null;
	/*
	 * Se realiza una baja logica del empleado Si no se encuentra o no se
	 * puede dar de baja , boolean a false.
	 */
	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", dniEmpleado);
	    resultado = query.getSingleResult();

	} catch (NoResultException ex) {
	    borradoCorrecto = false;
	}

	if (resultado != null) {
	    resultado.setActivo(false);
	    entityManager.merge(resultado);

	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}
	return borradoCorrecto;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#actualizarEmpleado(Integer empleado)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean actualizarEmpleado(Empleado empleadoActualizar)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Empleado> query = null;
	Empleado resultado = null;
	Boolean borradoCorrecto = true;
	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", empleadoActualizar.getDNI());
	    resultado = query.getSingleResult();

	} catch (NoResultException ex) {
	    borradoCorrecto = false;
	}
	if (resultado != null) {

	    entityManager.merge(empleadoActualizar);

	    entityManager.getTransaction().commit();
	    entityManager.close();
	    entityManagerFactory.close();
	}

	return borradoCorrecto;

    }

    /**
     * (sin Javadoc)
     * 
     * @throws BSoDException
     * 
     * @see SAEmpleados#obtenerEmpleado(String dniEmpleado)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Empleado obtenerEmpleado(String dniEmpleado) throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	TypedQuery<Empleado> query = null;
	Empleado resultado = null;

	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", dniEmpleado);
	    resultado = query.getSingleResult();

	} catch (NoResultException ex) {
	    throw new BSoDException("No se pudo encontrar el empleado con DNI "
		    + dniEmpleado);
	}
	entityManager.getTransaction().commit();
	entityManager.close();
	entityManagerFactory.close();

	return resultado;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#obtenerEmpleadosporTareas(Integer idTarea)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public List<Empleado> obtenerEmpleadosporTareas(Integer idTarea)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();
	TypedQuery<Empleado> query = null;
	Empleado resultado = null;

	return null;

    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#anadirTareaEmpleado(String dniEmpleado, Integer idTarea)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean anadirTareaEmpleado(String dniEmpleado,
	    List<Tarea> listaTareas) throws BSoDException {

	EntityManagerFactory entityManagerFactory = Persistence
		.createEntityManagerFactory(HotelManager.NOMBRE_CONEXION_ECLIPSELINK);
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	entityManager.getTransaction().begin();

	Empleado emp = entityManager.find(Empleado.class, dniEmpleado);
	// Tarea tar = entityManager.find(Tarea.class, idTarea);

	// emp.addTarea(tar);
	entityManager.merge(emp);
	entityManager.getTransaction().commit();
	entityManager.close();

	return true;
    }

}
