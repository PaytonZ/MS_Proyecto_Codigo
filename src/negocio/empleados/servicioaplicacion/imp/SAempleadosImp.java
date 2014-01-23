/**
 * 
 */
package negocio.empleados.servicioaplicacion.imp;

import negocio.empleados.objetonegocio.Empleado;
import negocio.empleados.servicioaplicacion.SAEmpleados;
import negocio.excepciones.BSoDException;
import negocio.tareas.objetonegocio.Tarea;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author NASAIII
 * @generated 
 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class SAempleadosImp implements SAEmpleados {
	
	
	
	public SAempleadosImp(){}
	
	public Empleado anadirEmpleado(Empleado empleadoNuevo) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(empleadoNuevo);
		
		entityManager.getTransaction().commit();
		
		Empleado emp = entityManager.find(Empleado.class, empleadoNuevo.getId());
		entityManager.close();
		
		return emp;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAEmpleados#borrarEmpleado(String dniEmpleado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarEmpleado(String dniEmpleado) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Empleado emp = entityManager.find(Empleado.class,dniEmpleado);
		
		entityManager.remove(emp);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return true;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAEmpleados#actualizarEmpleado(Integer empleado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Empleado actualizarEmpleado(Empleado empleadoActualizar) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Empleado emp = entityManager.find(Empleado.class,empleadoActualizar.getId());
		emp = empleadoActualizar;
		
		entityManager.persist(emp);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return emp;
		
	}

	/**
	 * (sin Javadoc)
	 * @throws BSoDException 
	 * 
	 * @see SAEmpleados#obtenerEmpleado(String dniEmpleado)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Empleado obtenerEmpleado(String dniEmpleado){
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Empleado emp = entityManager.find(Empleado.class,dniEmpleado);
		
		entityManager.getTransaction().commit();
		entityManager.close();

		return emp;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAEmpleados#obtenerEmpleadosporTareas(Integer idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public List<Empleado> obtenerEmpleadosporTareas(Integer idTarea) {
		// begin-user-code
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return null;
		// end-user-code
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAEmpleados#anadirTareaEmpleado(String dniEmpleado, Integer idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
public Boolean anadirTareaEmpleado(String dniEmpleado, Integer idTarea) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		entityManager.getTransaction().begin();
		
		Empleado emp = entityManager.find(Empleado.class,dniEmpleado);
		Tarea tar = entityManager.find(Tarea.class, idTarea);
		
		emp.addTarea(tar);
		entityManager.merge(emp);
		entityManager.getTransaction().commit();
		entityManager.close();

		return true;
	}

	/**
	 * (sin Javadoc)
	 * 
	 * @see SAEmpleados#borrarTareaEmpleado(String empleado, Integer idTarea)
	 * @generated 
	 *            "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Boolean borrarTareaEmpleado(String empleado, Integer idTarea) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Empleado emp = entityManager.find(Empleado.class,empleado);
		Tarea tar = entityManager.find(Tarea.class, idTarea);
		
		emp.removeTarea(tar);
		entityManager.merge(emp);
		entityManager.getTransaction().commit();
		entityManager.close();

		return true;
	}

}

