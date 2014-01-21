package test.negocio.jpa;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.empleados.objetonegocio.Empleado;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class TestJPAEmpleado {
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
		
		
		entityManagerFactory.close();
	}
	
}
