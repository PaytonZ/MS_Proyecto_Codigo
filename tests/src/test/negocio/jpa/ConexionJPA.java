package test.negocio.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.empleados.objetonegocio.Empleado;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
@RunWith(JUnit4.class)
public class ConexionJPA {
	@Test
	public void testAddEmpleado()
	{
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		Empleado e = new Empleado();
		e.setDNI("345345");
		
		EntityManager em = entityManagerFactory.createEntityManager() ;
		em.getTransaction().begin();
		
		em.persist(e);
		
		em.getTransaction().commit();
		
		entityManagerFactory.close();
		
		
		
		
		
		
	}
	
}
