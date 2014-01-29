/**
 * 
 */
package negocio.empleados.servicioaplicacion.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.objetonegocio.EmpleadoParcial;
import negocio.empleados.objetonegocio.EmpleadoTotal;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.excepciones.BSoDException;
import negocio.jpa.EntityManagerFactoryS;
import negocio.tareas.objetonegocio.Tarea;

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
	    entityManager.lock(resultado,
		    LockModeType.OPTIMISTIC_FORCE_INCREMENT);

	    if (resultado.isActivo()) {
		throw new BSoDException("El empleado ya existe en la base de datos");

	    } else {
		
		if ( resultado.getTipo().equals(empleadoNuevo.getTipo())) {
        		resultado.setNombre(empleadoNuevo.getNombre());
        		resultado.setPrimerApellido(empleadoNuevo.getPrimerApellido());
        		resultado.setSegundoApellido(empleadoNuevo.getSegundoApellido());
        		resultado.setTipo(empleadoNuevo.getTipo());
        		resultado.setTarea(empleadoNuevo.getTarea());
        		resultado.setDepartamento(empleadoNuevo.getDepartamento());
        		resultado.setActivo(true);
        		
        		entityManager.getTransaction().commit();
		}
		else {
		    if ( empleadoNuevo instanceof EmpleadoTotal) {
			
			entityManager.remove(resultado);
			
			
			entityManager.getTransaction().commit();
		
			entityManager.getTransaction().begin();
			
			resultado = new EmpleadoTotal();
			resultado.setDNI(empleadoNuevo.getDNI());
        		resultado.setNombre(empleadoNuevo.getNombre());
        		resultado.setPrimerApellido(empleadoNuevo.getPrimerApellido());
        		resultado.setSegundoApellido(empleadoNuevo.getSegundoApellido());
        		resultado.setTipo(empleadoNuevo.getTipo());
        		resultado.setTarea(empleadoNuevo.getTarea());
        		resultado.setDepartamento(empleadoNuevo.getDepartamento());
        		((EmpleadoTotal)resultado).setPlazaAparcamiento(((EmpleadoTotal) empleadoNuevo).getPlazaAparcamiento());
        		
        		entityManager.persist(resultado);
        		
			entityManager.getTransaction().commit();
        		
		    }
		    else if ( empleadoNuevo instanceof EmpleadoParcial) {
			
			entityManager.remove(resultado);
			
			entityManager.getTransaction().commit();
			
			entityManager.getTransaction().begin();
			
			resultado = new EmpleadoParcial();
			resultado.setDNI(empleadoNuevo.getDNI());
        		resultado.setNombre(empleadoNuevo.getNombre());
        		resultado.setPrimerApellido(empleadoNuevo.getPrimerApellido());
        		resultado.setSegundoApellido(empleadoNuevo.getSegundoApellido());
        		resultado.setTipo(empleadoNuevo.getTipo());
        		resultado.setTarea(empleadoNuevo.getTarea());
        		resultado.setDepartamento(empleadoNuevo.getDepartamento());
        		((EmpleadoParcial)resultado).setHoras(((EmpleadoParcial) empleadoNuevo).getHoras());

        		entityManager.persist(resultado);
        		
			entityManager.getTransaction().commit();
		    }
		}
		

		empleadoNuevo.setId(resultado.getId());
	    }

	} catch (NoResultException ex) {// No se encontro el empleado.
	    entityManager.persist(empleadoNuevo);

	    entityManager.getTransaction().commit();
	    
	} catch (BSoDException be) {
	    entityManager.getTransaction().rollback();
	    
	    throw be;

	} catch (Exception ex) {
	    
	    entityManager.getTransaction().rollback();
	    throw new BSoDException(ex.getLocalizedMessage());

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
	    entityManager.lock(resultado,
		    LockModeType.OPTIMISTIC_FORCE_INCREMENT);

	    resultado.setActivo(false);
	    resultado.setTarea(new HashSet<Tarea>());
	    resultado.setDepartamento(null);

	    entityManager.getTransaction().commit();

	    borradoCorrecto = true;

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();
	    throw new BSoDException("El empleado no existe, no se puede borrar");

	} catch (Exception e) {

	    if (e instanceof BSoDException) {
		    entityManager.getTransaction().rollback();
		throw e;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(e.getLocalizedMessage());
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
	    entityManager.lock(resultado,
		    LockModeType.OPTIMISTIC_FORCE_INCREMENT);

	    resultado.setNombre(empleadoActualizar.getNombre());
	    resultado.setPrimerApellido(empleadoActualizar.getPrimerApellido());
	    resultado.setSegundoApellido(empleadoActualizar.getSegundoApellido());
	    resultado.setDepartamento(empleadoActualizar.getDepartamento());

	    if (resultado instanceof EmpleadoParcial) {
		((EmpleadoParcial) resultado)
			.setHoras(((EmpleadoParcial) empleadoActualizar)
				.getHoras());
	    }
	    if (resultado instanceof EmpleadoTotal) {
		((EmpleadoTotal) resultado)
			.setPlazaAparcamiento(((EmpleadoTotal) empleadoActualizar)
				.getPlazaAparcamiento());
	    }

	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException(
		    "No se ha podido actualizar el empleado, por que no existe");
	} catch (Exception ex) {

	    if (ex instanceof BSoDException) {

		    entityManager.getTransaction().rollback();
		throw ex;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
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
	    entityManager.lock(resultado, LockModeType.OPTIMISTIC);
	    
	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se pudo encontrar el empleado con DNI "
		    + dniEmpleado);
	} catch (Exception ex) {

	    if (ex instanceof BSoDException) {
		    entityManager.getTransaction().rollback();
		throw ex;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
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
	    for (Empleado emp : resultados) {
		entityManager.lock(emp, LockModeType.OPTIMISTIC);
	    }

	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {

	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se encontraron empleados");
	} catch (Exception ex) {

	    if (ex instanceof BSoDException) {
		    entityManager.getTransaction().rollback();
		throw ex;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
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
	    entityManager.getTransaction().begin();
	    query = entityManager.createNamedQuery(
		    Empleado.QUERY_BUSCAR_EMPLEADOS_POR_TAREA, Empleado.class);
	    query.setParameter("tarea", tarea);

	    resultados = query.getResultList();
	    for (Empleado e : resultados) {
		entityManager.lock(e, LockModeType.OPTIMISTIC);
		entityManager.detach(e);
	    }
	    entityManager.getTransaction().commit();

	} catch (NoResultException ex) {
	    entityManager.getTransaction().rollback();

	    throw new BSoDException("No se pudo encontrar la tarea  "
		    + tarea.toString());

	} catch (Exception ex) {

	    if (ex instanceof BSoDException) {
		    entityManager.getTransaction().rollback();
		throw ex;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
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
	    
	    entityManager.lock(resultado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
	    Set<Tarea> tareas = new HashSet<>();

	    for (Tarea tarea : listaTareas) {

		try {
		    TypedQuery<Tarea> tarQuery = entityManager
			    .createNamedQuery(
				    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE,
				    Tarea.class);
		    tarQuery.setParameter("nombre", tarea.getNombre());

		    tarea = tarQuery.getSingleResult();
		    entityManager.lock(tarea, LockModeType.OPTIMISTIC);
		    tareas.add(tarea);
		} catch (NoResultException nr) {

		}
	    }

	    resultado.setTarea(tareas);

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

	    if (ex instanceof BSoDException) {
		    entityManager.getTransaction().rollback();
		throw ex;
	    }
	    else {
		entityManager.getTransaction().rollback();
		throw new BSoDException(ex.getLocalizedMessage());
	    }
	}

	return asignadasCorrecto;
    }
}
