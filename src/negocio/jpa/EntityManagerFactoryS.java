package negocio.jpa;

import javax.persistence.Persistence;

import presentacion.principal.HotelManager;

public class EntityManagerFactoryS {

    private static javax.persistence.EntityManagerFactory entityManagerFactoryInstance = null;

    public synchronized static javax.persistence.EntityManagerFactory getEntityManagerFactory() {

	if (entityManagerFactoryInstance == null)
	    entityManagerFactoryInstance = Persistence
		    .createEntityManagerFactory(HotelManager.UNIDAD_PERSISTENCIA_ECLIPSELINK);
//	entityManagerFactoryInstance = Persistence
//		.createEntityManagerFactory("$objectdb/db/hotelmanager.odb");
	return entityManagerFactoryInstance;

    }
    
    public synchronized static void closeEntityManagerFactory()
    {
	if (entityManagerFactoryInstance != null)
	{
	    entityManagerFactoryInstance.close();
	}
    }

}
