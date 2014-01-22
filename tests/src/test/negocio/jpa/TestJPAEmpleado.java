package test.negocio.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.empleados.objetonegocio.Empleado;
import negocio.tareas.objetonegocio.Tarea;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class TestJPAEmpleado {
	private Empleado crearEmpleado()
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Empleado e = new Empleado();
		e.setDNI("54545454");
		e.setNombre("asdasd");
		e.setPrimerApellido("asdasd");
		e.setSegundoApellido("asdasd");
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
		
		assertNotNull(e);
		return e;
	}
	private Empleado buscarEmpleado(Integer id)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		Empleado e2 = em.find(Empleado.class, id);
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
		return e2;
	}
	private void modificarEmpleado(Empleado e2)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		e2.setDNI("60606060");
		em.getTransaction().begin();
		em.merge(e2);
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
	}
	private Tarea añadirTareaEmpleado(Empleado e2)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Tarea tarea = new Tarea();
		tarea.setId(100);
		tarea.setDescripcion("limpia lere lere");
		tarea.setNombre("Limpiar");
		e2.addTarea(tarea);
		
		em.getTransaction().begin();
		em.merge(e2);
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
		return tarea;
	}
	private void borrarTareaAEmpleado(Empleado e,Tarea t)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		Empleado e3 = em.find(Empleado.class, e.getId());
		e3.getTareas().remove(1);
		em.merge(e3);
		em.getTransaction().commit();
		//
		em.close();
		entityManagerFactory.close();
	}
	private void borrarEmpleado(Empleado e2)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(e2);
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
	}
	private List<Empleado> obtenerEmpleadosPorTarea(Tarea t)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("Select e FROM Tarea e WHERE e.ID = :arg");
		query.setParameter("arg",t.getId());
		
		
		em.getTransaction().begin();
		List<Empleado> empleado =  query.getResultList();
		em.getTransaction().commit();
		
		em.close();
		entityManagerFactory.close();
		return empleado;
	}
	@Test
	public void testModuloEmpleados()
	{
		//inicializar EntityManager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		EntityManager em = entityManagerFactory.createEntityManager();
		//Crear Empleado
		Empleado empleado1 = crearEmpleado(); 
		
		//obtener empleado
		Empleado empleado2 = buscarEmpleado(empleado1.getId());
		
		//Modificar Empleado
		modificarEmpleado(empleado2);
		
		//Añadir tarea a empleado
		Tarea tarea1 = añadirTareaEmpleado(empleado2);
		
		//Obtener Empleados por tarea
		List<Empleado> empleados = obtenerEmpleadosPorTarea(tarea1);

		
		//Borrar empleado a tarea
		borrarTareaAEmpleado(empleado2, tarea1);
		
		//Borrar Empleado
		borrarEmpleado(empleado2);
		//
	}
	/*
	@Test
	public void testAddEmpleado()
	{
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		Empleado e = new Empleado();
		
		e.setDNI(String.valueOf(new Random().nextInt(99999)));
		e.setNombre("asdasd");
		e.setPrimerApellido("asdasd");
		e.setSegundoApellido("asdasd");
		
		
		EntityManager em = entityManagerFactory.createEntityManager() ;
		em.getTransaction().begin();
		
		em.persist(e);
		
		
		
		em.getTransaction().commit();
		
			
		
		
		Query query = em.createQuery("Select e FROM Empleado e WHERE e.DNI = :arg");
		query.setParameter("arg",e.getDNI() );
		
		Empleado e1 = (Empleado) query.getSingleResult();
		
		assertNotNull(e1);

		assertTrue(e.getDNI().equalsIgnoreCase(e1.getDNI()));
		
		assertTrue(e.getPrimerApellido().equalsIgnoreCase(e1.getPrimerApellido()));
		assertTrue(e.getSegundoApellido().equalsIgnoreCase(e1.getSegundoApellido()));


		
		entityManagerFactory.close();
	}
	*/
}
