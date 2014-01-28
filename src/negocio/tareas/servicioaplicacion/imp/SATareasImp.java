/**
 * 
 */
package negocio.tareas.servicioaplicacion.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.sun.org.apache.regexp.internal.recompile;

import negocio.empleados.objetonegocio.Empleado;
import negocio.excepciones.BSoDException;
import negocio.jpa.EntityManagerFactoryS;
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
	    EntityManagerFactory entityManagerFactory = EntityManagerFactoryS
			.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;
		tareaNueva.setActivo(true);
		//Necesita su propia query porque debe buscar elementos dados de baja tambien
		TypedQuery<Tarea> query = null;
		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE_ALTA, Tarea.class);
		    query.setParameter("nombre", tareaNueva.getNombre());
		    resultado = query.getSingleResult();
		    //Lock del resultado
		    entityManager.lock(resultado,LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		    //Si no canta es que existe la tarea
		    if(resultado.getActivo()){
			entityManager.getTransaction().rollback();
			 //Cierre de entidades de persistencia
			 entityManager.close();
			 entityManagerFactory.close();
			 throw new BSoDException("Ya existe la tarea en la base de datos");
		    }
		    else{
			resultado.setActivo(true);
			resultado.setDescripcion(tareaNueva.getDescripcion());
			entityManager.merge(resultado);
			entityManager.getTransaction().commit();
			//Cierre de entidades de persistencia
			entityManager.detach(resultado);
			entityManager.close();
			
			return resultado;
		    }
		} catch (NoResultException ex) {// No se encontro la tarea.
		    entityManager.persist(tareaNueva);
		    
		    entityManager.getTransaction().commit();

		    resultado = obtenerTarea(tareaNueva.getNombre(),entityManager);

		    tareaNueva.setId(resultado.getId());
		    //No hace falta el merge, en principio basta con un refresh//
		    entityManager.refresh(tareaNueva);
		    entityManager.detach(tareaNueva);
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    
		}
		catch (Exception e) {
		    throw new BSoDException(e.getLocalizedMessage());
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
	public Boolean borrarTarea(Tarea tarea) throws BSoDException {

	    EntityManagerFactory entityManagerFactory =EntityManagerFactoryS.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		
		Boolean borrado = false;
		
		Tarea resultado = null;
		
		try {
		    entityManager.getTransaction().begin();
		   
		    //Cambiado de lugar para adecuarlo al lock
		    resultado = obtenerTarea(tarea.getNombre(),entityManager);
		    entityManager.lock(resultado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		    
		    TypedQuery<Empleado> empleadosQuery = entityManager.createNamedQuery(Empleado.QUERY_BUSCAR_EMPLEADOS_POR_TAREA, Empleado.class);
		    empleadosQuery.setParameter("tarea", tarea);
		    
		    List<Empleado> listaEmpleados = empleadosQuery.getResultList();
		    
		    if ( ! listaEmpleados.isEmpty() ) {
			throw new BSoDException("No se puede borrar una tarea con empleados asigandos");
		    }
		    
		    //resultado = obtenerTarea(tarea.getNombre(),entityManager);
		    
		    
		    /*si existe la damos de baja*/
		    resultado.setActivo(false);
		    entityManager.getTransaction().commit();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		    
		    borrado = true;
		    
		} catch(BSoDException e){
		    
		    if(e.getMensaje().contains("transaccion")) throw e;
		    entityManager.getTransaction().rollback();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		   
		    throw e;
		    
		}catch(RollbackException e){
		    
		    //Solo ocurre si falla el commit!
		    throw new BSoDException("Error en la transaccion");
		}
		catch (Exception e) {
		    throw new BSoDException(e.getLocalizedMessage());
		}

		return borrado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#actualizarTarea(Tarea tarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Tarea actualizarTarea(Tarea tarea) throws BSoDException {
	    
	    EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado = null;
		TypedQuery<Tarea> query = null;
		tarea.setActivo(true);
		
		try {
		    entityManager.getTransaction().begin();
		    //Busca la tarea por id, el entity por parámetro tiene el nombre modificado
		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_ID, Tarea.class);
		    query.setParameter("id", tarea.getId());
		    
		    resultado = query.getSingleResult();
		    entityManager.lock(resultado, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		
		    resultado.setNombre(tarea.getNombre());
		    resultado.setDescripcion(tarea.getDescripcion());
		    
		    entityManager.getTransaction().commit();
		    entityManager.close();
		   
		}catch(NoResultException e){
		    entityManager.getTransaction().rollback();
		    //Cierre de entidades de persistencia
		    entityManager.close();
		   
		    throw new BSoDException("Ya existe la tarea en la base de datos");
		    
		}catch(RollbackException e){
		    //Solo ocurre si falla el commit!
		    throw new BSoDException("Error en la transaccion");
		}
		catch (Exception e) {
		    throw new BSoDException(e.getLocalizedMessage());
		}
	    
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
	    EntityManagerFactory entityManagerFactory = EntityManagerFactoryS.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory
			.createEntityManager();
		Tarea resultado=null;
		try{
		    entityManager.getTransaction().begin();
		    resultado=obtenerTarea(nombreTarea,entityManager);
		    entityManager.lock(resultado,LockModeType.OPTIMISTIC);
		    entityManager.detach(resultado);
		    entityManager.close();
		    
		}
		catch(BSoDException e){
		    entityManager.getTransaction().rollback();
		    entityManager.close();
		   
		    throw e;
		}
		catch (Exception e) {
		    throw new BSoDException(e.getLocalizedMessage());
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
	    } catch (Exception e) {
		throw new BSoDException(e.getLocalizedMessage());
	    }
	
	    return resultado;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#obtenerTodaslasTareas()
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Tarea> obtenerTodaslasTareas() throws BSoDException {
		
	    EntityManagerFactory entityManagerFactory = 
		    EntityManagerFactoryS.getEntityManagerFactory();
		
	    	EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Tarea> tareas = new ArrayList<>();
		
		try {
        		tareas = entityManager.createNamedQuery("Tarea.findAll", Tarea.class).getResultList();
        		for(Tarea t : tareas){entityManager.detach(t);entityManager.lock(t, LockModeType.OPTIMISTIC);}
        		entityManager.getTransaction().commit();
        		entityManager.close();
        		
		} catch ( Exception e) {
		    
		    throw new BSoDException(e.getLocalizedMessage());
		}
		
		
		return tareas;
		
	}
}