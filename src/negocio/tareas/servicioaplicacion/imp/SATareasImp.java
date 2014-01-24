/**
 * 
 */
package negocio.tareas.servicioaplicacion.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
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
		TypedQuery<Tarea> query = null;

		/*
		 * Se busca en la BD el empleado , si ya existia se le activa.
		 */
		tareaNueva.setActivo(true);
		try {
		    entityManager.getTransaction().begin();
		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE, Tarea.class);
		    query.setParameter("nombre", tareaNueva.getNombre());
		    resultado = query.getSingleResult();

		    tareaNueva.setId(resultado.getId());

		} catch (NoResultException ex) {// No se encontro el empleado.
		    entityManager.persist(tareaNueva);

		    entityManager.getTransaction().commit();

		    query = entityManager.createNamedQuery(
			    Tarea.QUERY_BUSCAR_TAREA_POR_NOMBRE, Tarea.class);
		    query.setParameter("nombre", tareaNueva.getNombre());
		    resultado = query.getSingleResult();

		    tareaNueva.setId(resultado.getId());
		    entityManager.close();

		} finally // Se realizará en ambos casos
		{
		    entityManager = entityManagerFactory.createEntityManager();
		    entityManager.getTransaction().begin();
		    entityManager.merge(tareaNueva);
		    entityManager.getTransaction().commit();
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
		return null;
		// end-user-code
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

		// end-user-code
	    
	    return null;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SATareas#obternerTarea(Object idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Tarea obternerTarea(String nombreTarea) throws BSoDException {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
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

		// end-user-code
	    return null;
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
}