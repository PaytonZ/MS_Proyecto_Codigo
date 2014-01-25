/**
 * 
 */
package negocio.tareas.servicioaplicacion.imp;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import presentacion.principal.HotelManager;
import negocio.empleados.objetonegocio.Empleado;
import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;
import negocio.tareas.servicioaplicacion.SATareas;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author BSoD Software 
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SATareasImp implements SATareas {
	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#anadirTarea(Tarea tareaNueva)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
    	
	public Tarea anadirTarea(Tarea tareaNueva) throws BSoDException {
	    EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;

		try {
		    entityManager.getTransaction().begin();
		    resultado = obtenerTarea(tareaNueva.getNombre(),entityManager);
		    //Si no canta es que existe la tarea 
		    entityManager.getTransaction().rollback();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    entityManagerFactory.close();
		    throw new BSoDException("Ya existe la tarea en la base de datos");  
		    
		} catch (BSoDException ex) {// No se encontro la tarea.
		    if(ex.getMensaje().contains("transaccion")) throw ex;
		    entityManager.persist(tareaNueva);
		    
		    entityManager.getTransaction().commit();

		    resultado = obtenerTarea(tareaNueva.getNombre(),entityManager);

		    tareaNueva.setId(resultado.getId());
		    //No hace falta el merge, en principio basta con un refresh//
		    entityManager.refresh(tareaNueva);
		    entityManager.detach(tareaNueva);
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    entityManagerFactory.close();

		} 
		return tareaNueva;
	}
	

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#borrarTarea(Object idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarTarea(String nombreTarea) throws BSoDException {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
	    EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;
		
		try {
		    entityManager.getTransaction().begin();
		   
		    resultado = obtenerTarea(nombreTarea,entityManager);
		    
		    /*si existe la damos de baja*/
		    resultado.setActivo(false);
		    entityManager.getTransaction().commit();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    entityManagerFactory.close();
		    
		}catch(BSoDException e){
		    
		    if(e.getMensaje().contains("transaccion")) throw e;
		    entityManager.getTransaction().rollback();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    entityManagerFactory.close();
		    throw e;
		    
		}catch(RollbackException e){
		    
		    //Solo ocurre si falla el commit!
		    throw new BSoDException("Error en la transaccion");
		}
		// end-user-code
		return true;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#actualizarTarea(Tarea tarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Tarea actualizarTarea(Tarea tarea) throws BSoDException {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
	    EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;
		
		try {
		    entityManager.getTransaction().begin();
		   
		    resultado=obtenerTarea(tarea.getNombre(),entityManager);
		    
		   //Si existe hacemos un merge
		    tarea.setId(resultado.getId());
		    entityManager.getTransaction().commit();
		    entityManager.merge(tarea);
		    //No hace falta el detach pro el merge no linkea la entidad por parametro
		    //entityManager.detach(tarea);
		    entityManager.close();
		    entityManagerFactory.close();
		    
		}catch(BSoDException e){
		    
		    if(e.getMensaje().contains("transaccion")) throw e;
		    entityManager.getTransaction().rollback();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    entityManagerFactory.close();
		    throw e;
		    
		}catch(RollbackException e){
		    //Solo ocurre si falla el commit!
		    throw new BSoDException("Error en la transaccion");
		}
		// end-user-code
	    
	    return tarea;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#obtenerTarea(Object idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Tarea obtenerTarea(String nombreTarea) throws BSoDException {
	    EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado=null;
		try{
		    entityManager.getTransaction().begin();
		    resultado=obtenerTarea(nombreTarea,entityManager);
		}
		catch(BSoDException e){
		    throw e;
		}
		return resultado;
	}
	
	//SOBREESCRITURA Para reutilizarla dentro del SA y no replicar código
	// El entityManager debe llegar con la transaccion iniciada <<--------IMPORTANTE
	private Tarea obtenerTarea(String nombreTarea,EntityManager entityManager) throws BSoDException {
	    Tarea resultado = null;
	    TypedQuery<Tarea> query = null;

	    try {
	
		query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE, Tarea.class);
		query.setParameter("nombre", nombreTarea);
		resultado = query.getSingleResult();
		    
	    }catch(NoResultException ex){
		throw new BSoDException("No se ha podido encontrar la tarea en la base de datos");
	    }catch(IllegalStateException e){
		//Solo ocurre si la transaccion no llega inicializada! 
		throw  new BSoDException("No se ha podido realizar la transaccion");
	    }
		return resultado;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#obtenerTodaslasTareas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Tarea> obtenerTodaslasTareas() throws BSoDException {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
	    EntityManagerFactory entityManagerFactory = 
		    Persistence.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		
	    	EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Tarea> tareas = entityManager.createNamedQuery("Tarea.findAll", Tarea.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
	return tareas;
		// end-user-code
	    
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#obtenerTareasPorEmpleados(Object idEmpleado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Tarea> obtenerTareasPorEmpleados(String DNIEmpleado)
		throws BSoDException {
	    // TODO Auto-generated method stub
	    return null;
	}
	
	
	//CODIGO SUSTITUIDO TEMPORALMENTE
	/*
	public Tarea anadirTarea(Tarea tareaNueva) throws BSoDException {
	    EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;
		TypedQuery<Tarea> query = null;

		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE, Tarea.class);
		    query.setParameter("nombre", tareaNueva.getNombre());
		    resultado = query.getSingleResult();
		    
		    /*En caso de hacer rollback
		      entityManager.getTransaction().rollback();
		      entityManager.close();
		      entityManagerFactory.close();
		      throw new BSoDException("Ya existe la tarea en la base de datos");
		    
		    
		} catch (NoResultException ex) {// No se encontro la tarea.
		    entityManager.persist(tareaNueva);

		    entityManager.getTransaction().commit();

		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE, Tarea.class);
		    query.setParameter("nombre", tareaNueva.getNombre());
		    resultado = query.getSingleResult();

		    tareaNueva.setId(resultado.getId());
		    entityManager.merge(tareaNueva);
		    entityManager.getTransaction().commit();
		  
		    
		    /*En caso de usar las excepciones del persist
		     * 
		     *
		}catch(EntityExistsException ex){
		    entityManager.getTransaction().rollback();
		    throw new BSoDException("Ya existe la tarea en la base de datos");
		

		} finally // Se cierran las unidades de persistencia
		{		    
		    entityManager.close();
		    entityManagerFactory.close();
		}
		return tareaNueva;
	}*/
}