/**
 * 
 */
package negocio.empleados.servicioaplicacion.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import negocio.jpa.EntityManagerFactoryS;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAempleadosImp implements SAEmpleados {

    public Empleado anadirEmpleado(Empleado empleadoNuevo) throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
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
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI_NOACTIVO,
		    Empleado.class);
	    query.setParameter("dni", empleadoNuevo.getDNI());
	    resultado = query.getSingleResult();

	    if (resultado.isActivo()) {

		entityManager.getTransaction().rollback();
		throw new BSoDException(
			"El empleado ya existe en la base de datos");

	    } else {
		empleadoNuevo.setId(resultado.getId());
		entityManager.merge(empleadoNuevo);
		entityManager.getTransaction().commit();
	    }

	} catch (NoResultException ex) {// No se encontro el empleado.
	    entityManager.persist(empleadoNuevo);

	    entityManager.getTransaction().commit();

	    // Después del persist la entidad esta mergeada no hace falta
	    // actualizar nada
	    /*
	     * query = entityManager.createNamedQuery(
	     * Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	     * query.setParameter("arg", empleadoNuevo.getDNI()); resultado =
	     * query.getSingleResult();
	     */
	    // empleadoNuevo.setId(resultado.getId());

	} catch (Exception ex) {
	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }

	} finally {
	    entityManager.detach(empleadoNuevo);
	    entityManager.close();

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

	Boolean borradoCorrecto = false;
	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
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

	    resultado.setActivo(false);
	    resultado.setTarea(new HashSet<Tarea>());

	    entityManager.merge(resultado);

	    entityManager.getTransaction().commit();

	    borradoCorrecto = true;

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();
	    throw new BSoDException("El empleado no existe, no se puede borrar");

	} catch (Exception e) {

	    if (e instanceof BSoDException)
		throw e;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(e.getMessage());
	    }
	} finally {

	    entityManager.close();

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
    public Empleado actualizarEmpleado(Empleado empleadoActualizar)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Empleado> query = null;
	Empleado resultado = null;

	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_DNI, Empleado.class);
	    query.setParameter("arg", empleadoActualizar.getDNI());

	    resultado = query.getSingleResult();
	    empleadoActualizar.setId(resultado.getId());
	    /*
	     * Vais a lo dificil, jpa esta para algo
	     * resultado.setNombre(empleadoActualizar.getNombre());
	     * resultado.setPrimerApellido
	     * (empleadoActualizar.getPrimerApellido());
	     * resultado.setSegundoApellido(empleadoActualizar
	     * .getSegundoApellido());
	     * resultado.setTipo(empleadoActualizar.getTipo());
	     * resultado.setDepartamento(empleadoActualizar.getDepartamento());
	     */

	    entityManager.merge(empleadoActualizar);

	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException(
		    "No se ha podido actualizar el empleado, por que no existe");
	} catch (Exception ex) {

	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }
	} finally {
	    entityManager.detach(empleadoActualizar);
	    entityManager.close();

	}

	return empleadoActualizar;

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

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
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

	    // Que necesidad hay para un commit?
	    // entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se pudo encontrar el empleado con DNI "
		    + dniEmpleado);
	} catch (Exception ex) {

	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }
	} finally {
	    if (resultado != null)
		entityManager.detach(resultado);

	    entityManager.close();

	}
	return resultado;
    }

    public List<Empleado> obtenerTodosEmpleados() throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Empleado> query = null;
	List<Empleado> resultados = null;

	try {
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_TODOS_LOS_EMPLEADOS_, Empleado.class);

	    resultados = query.getResultList();

	    // entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se encontraron empleados");
	} catch (Exception ex) {

	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }
	} finally {
	    for (Empleado emp : resultados) {
		entityManager.detach(emp);
	    }

	    entityManager.close();
	    
	}
	return resultados;

    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#obtenerEmpleadosporTareas(Integer idTarea)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public List<Empleado> obtenerEmpleadosporTareas(Tarea tarea)
	    throws BSoDException {

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
	EntityManager entityManager = entityManagerFactory
		.createEntityManager();

	TypedQuery<Empleado> query = null;
	List<Empleado> resultados = null;

	try {
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_TAREA, Empleado.class);
	    query.setParameter("tarea", tarea);

	    resultados = query.getResultList();
	    for (Empleado e : resultados) {
		entityManager.detach(e);
	    }

	} catch (NoResultException ex) {
	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se pudo encontrar la tarea  "
		    + tarea.toString());

	} catch (Exception ex) {

	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }
	} finally {

	    entityManager.close();

	}

	return resultados;
    }

    /**
     * (sin Javadoc)
     * 
     * @see SAEmpleados#anadirTareaEmpleado(String dniEmpleado, Integer idTarea)
     * @generated 
     *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
     */
    public Boolean anadirTareaEmpleado(String dniEmpleado,
	    Set<Tarea> listaTareas) throws BSoDException {

	Boolean asignadasCorrecto = false;

	EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
		.getEntityManagerFactory();
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

	    Set<Tarea> tareas = new HashSet<>();

	    for (Tarea tarea : listaTareas) {

		try {
		    TypedQuery<Tarea> tarQuery = entityManager
			    .createNamedQuery(
				    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE,
				    Tarea.class);
		    tarQuery.setParameter("nombre", tarea.getNombre());

		    tarea = tarQuery.getSingleResult();

		    tareas.add(tarea);
		} catch (NoResultException nr) {
		}
	    }

	    resultado.setTarea(tareas);

	    entityManager.merge(resultado);

	    entityManager.getTransaction().commit();
	    entityManager.close();
	    

	    asignadasCorrecto = true;

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    asignadasCorrecto = false;

	    throw new BSoDException("No se pudo encontrar el empleado con DNI "
		    + dniEmpleado);
	} catch (Exception ex) {

	    asignadasCorrecto = false;

	    if (ex instanceof BSoDException)
		throw ex;
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getMessage());
	    }
	}

	return asignadasCorrecto;
    }
}
