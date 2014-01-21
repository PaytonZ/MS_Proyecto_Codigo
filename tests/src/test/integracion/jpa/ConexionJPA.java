package test.integracion.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

	void testAddEmpleado()
	{
		EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("EclipseLink");
		entityManagerFactory.createEntityManager().getTransaction().begin();
		
		
	}
	
}
