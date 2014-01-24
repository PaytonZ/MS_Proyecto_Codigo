package test.negocio.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import negocio.empleados.objetonegocio.Empleado;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import presentacion.principal.HotelManager;
@RunWith(JUnit4.class)
public class TestJPAEmpleado {
	@Test
	public void crearEmpleado()
	{
		
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
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
	@Test
	public void bajaEmpleado()
	{
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
		Empleado e = new Empleado();
		
		e.setDNI(String.valueOf(new Random().nextInt(99999)));
		e.setNombre("asdasd");
		e.setPrimerApellido("asdasd");
		e.setSegundoApellido("asdasd");
		
		
		EntityManager em = entityManagerFactory.createEntityManager() ;
		em.getTransaction().begin();
		
		em.persist(e);
				
		em.getTransaction().commit();
		
		
		em = entityManagerFactory.createEntityManager() ;
		
		em.getTransaction().begin();
		
		Query query = em.createQuery("Update Empleado e SET e.activo=false WHERE e.DNI = :arg");
		query.setParameter("arg",e.getDNI() );
		
		int j = query.executeUpdate();
		
		em.getTransaction().commit();
		
		Query query1 = em.createQuery("Select e FROM Empleado e WHERE e.DNI = :arg");
		query1.setParameter("arg",e.getDNI() );
		
		Empleado e1 = (Empleado) query1.getSingleResult();
		
		assertNotNull(e1);

		assertTrue(e.getDNI().equalsIgnoreCase(e1.getDNI()));
		
		assertTrue(e.getPrimerApellido().equalsIgnoreCase(e1.getPrimerApellido()));
		assertTrue(e.getSegundoApellido().equalsIgnoreCase(e1.getSegundoApellido()));
		assertTrue(!e1.isActivo());
		
	
		entityManagerFactory.close();
		
		
	}
	
	
}
